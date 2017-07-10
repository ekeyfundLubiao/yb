package ag.yinglingedu.com.ag.model.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.DataCleanManager;
import ag.yinglingedu.com.xlibrary.utils.ToastUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/7.
 */

public class ActivitySetting extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.rl_grzl)
    RelativeLayout rlGrzl;
    @BindView(R.id.rl_tzxx)
    RelativeLayout rlTzxx;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.rl_qchc)
    RelativeLayout rlQchc;
    @BindView(R.id.rl_gygz)
    RelativeLayout rlGygz;
    @BindView(R.id.rl_gyyb)
    RelativeLayout rlGyyb;
    @BindView(R.id.btn_exit)
    Button btnExit;
    @BindView(R.id.tv_size)
    TextView tvSize;
    private final int CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("设置");
        ivBack.setVisibility(View.VISIBLE);
        String cacheSize = null;
        try {
            cacheSize = DataCleanManager.getTotalCacheSize(this);
        } catch (Exception e) {
            ToastUtils.showShortToast("获取缓存大小失败！" + e.toString());
            e.printStackTrace();
        }
        tvSize.setText(cacheSize);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        rlGrzl.setOnClickListener(this);//个人资料
        rlTzxx.setOnClickListener(this);//通知消息
        rlQchc.setOnClickListener(this);//清除缓存
        rlGygz.setOnClickListener(this);//给蚁帮一个赞
        rlGyyb.setOnClickListener(this);//关于蚁帮
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_grzl://个人资料

                break;
            case R.id.rl_tzxx://通知与消息
                startActivity(new Intent(this, ActivityNotificationMessage.class));
                break;
            case R.id.rl_qchc://清除缓存
                startActivityForResult(new Intent(this, ActivitySettingConfirm.class), CODE);
                break;
            case R.id.rl_gygz://给蚁帮一个赞
                startActivity(new Intent(this, ActivityFunctionIntroduction.class));
                break;
            case R.id.rl_gyyb://关于蚁帮
                startActivity(new Intent(this, ActivityAbout.class));
                break;
            case R.id.btn_exit://退出

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE) {
            boolean type = data.getBooleanExtra("type", false);
            if (type) {//清除缓存
                DataCleanManager.clearAllCache(this);
                tvSize.setText(0 + "K");
            } else {
                ToastUtils.showShortToast("取消清除缓存");
            }
        }
    }
}
