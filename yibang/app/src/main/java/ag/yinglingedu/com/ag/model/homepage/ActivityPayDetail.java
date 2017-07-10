package ag.yinglingedu.com.ag.model.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.AppManager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 支付详情
 * Created by M 4700 on 2017/6/15.
 */

public class ActivityPayDetail extends BaseActivity {

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
    @BindView(R.id.tv_zfcg)
    TextView tvZfcg;
    @BindView(R.id.rl_tag)
    RelativeLayout rlTag;
    @BindView(R.id.tv_zfxx)
    TextView tvZfxx;
    @BindView(R.id.tv_ddje)
    TextView tvDdje;
    @BindView(R.id.tv_ddbh)
    TextView tvDdbh;
    @BindView(R.id.tv_zffs)
    TextView tvZffs;
    @BindView(R.id.rl_tag2)
    RelativeLayout rlTag2;
    @BindView(R.id.sdv_headIcon)
    SimpleDraweeView sdvHeadIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_gz)
    TextView tvGz;
    @BindView(R.id.iv_gz)
    ImageView ivGz;
    @BindView(R.id.rl_tag3)
    RelativeLayout rlTag3;
    @BindView(R.id.tv_ckdd)
    TextView tvCkdd;
    @BindView(R.id.tv_fhsy)
    TextView tvFhsy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zfxq);
        ButterKnife.bind(this);

        init();
        setListener();

    }

    @Override
    public void init() {
        title.setText("支付详情");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        tvCkdd.setOnClickListener(this);
        tvFhsy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_ckdd://查看订单
                startActivity(new Intent(this,ActivityOrderDetail.class));
                finish();
                break;
            case R.id.tv_fhsy://返回首页
                AppManager.getAppManager().finishActivity(ActivityPayOrder.class);
                AppManager.getAppManager().finishActivity(ActivityConfirmOrder.class);
                AppManager.getAppManager().finishActivity(ActivityServiceDetail.class);
                finish();
                break;
        }
    }
}
