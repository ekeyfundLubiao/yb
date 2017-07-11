package ag.yinglingedu.com.ag.controller.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/7.
 */

public class ActivityWithdrawResult extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_right1)
    ImageView ivRight1;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.wv_show)
    ImageView ivShow;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.iv_center)
    ImageView ivCenter;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_left_c)
    ImageView ivLeftC;
    @BindView(R.id.iv_right_c)
    ImageView ivRightC;
    @BindView(R.id.tv_time1)
    TextView tvTime1;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.tv_time3)
    TextView tvTime3;
    @BindView(R.id.ll_time)
    LinearLayout llTime;
    @BindView(R.id.btn_complete)
    Button btnComplete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_result);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("体现结果");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        btnComplete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_comlete:

                break;
        }
    }
}