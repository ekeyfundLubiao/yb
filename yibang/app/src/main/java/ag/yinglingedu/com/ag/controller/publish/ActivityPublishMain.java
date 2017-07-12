package ag.yinglingedu.com.ag.controller.publish;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.controller.publish.need.ActivityPublishSentNeed;
import ag.yinglingedu.com.ag.controller.publish.service.ActivityPublishSentService;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CC on 2017/5/25.
 */

public class ActivityPublishMain extends BaseActivity {

    @BindView(R.id.iv_close)
    ImageView ivPublish;
    @BindView(R.id.rl_btn_l)
    RelativeLayout rlBtnL;
    @BindView(R.id.rl_btn_r)
    RelativeLayout rlBtnR;
    @BindView(R.id.tv_ffw)
    TextView tvFfw;
    @BindView(R.id.iv_ffw)
    ImageView ivFfw;
    @BindView(R.id.tv_fxq)
    TextView tvFxq;
    @BindView(R.id.iv_fxq)
    ImageView ivFxq;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
    }

    @Override
    public void setListener() {
        ivPublish.setOnClickListener(this);
        ivFxq.setOnClickListener(this);
        ivFfw.setOnClickListener(this);
        rlBtnL.setOnClickListener(this);
        rlBtnR.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close://关闭
                finish();
                break;
            case R.id.iv_fxq://发需求
                startActivity(new Intent(this, ActivityPublishSentNeed.class));
                break;
            case R.id.iv_ffw://发服务
                startActivity(new Intent(this, ActivityPublishSentService.class));
                break;
            case R.id.rl_btn_l://新手必读
                startActivity(new Intent(this, ActivityXSBD_FXQ.class));
                break;
            case R.id.rl_btn_r://新手必读-右边
                startActivity(new Intent(this, ActivityXSBD_FFW.class));
                break;
        }
    }
}
