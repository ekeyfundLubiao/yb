package ag.yinglingedu.com.ag.controller.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 余额充值
 * Created by M 4700 on 2017/6/1.
 */

public class ActivityBalanceRecharge extends BaseActivity {

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
    @BindView(R.id.iv_icon_zfb)
    ImageView ivIconZfb;
    @BindView(R.id.tv_zfb)
    TextView tvZfb;
    @BindView(R.id.tv_remarks_zfb)
    TextView tvRemarksZfb;
    @BindView(R.id.iv_xz_zfb)
    ImageView ivXzZfb;
    @BindView(R.id.rl_zfb)
    RelativeLayout rlZfb;
    @BindView(R.id.iv_icon_wx)
    ImageView ivIconWx;
    @BindView(R.id.tv_wx)
    TextView tvWx;
    @BindView(R.id.tv_remarks_wx)
    TextView tvRemarksWx;
    @BindView(R.id.iv_xz_wx)
    ImageView ivXzWx;
    @BindView(R.id.rl_wx)
    RelativeLayout rlWx;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.rl_je)
    RelativeLayout rlJe;
    @BindView(R.id.btn_recharge)
    Button btnRecharge;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_recharge);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        ivBack.setVisibility(View.VISIBLE);
        title.setText("余额充值");
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ivXzZfb.setOnClickListener(this);
        ivXzWx.setOnClickListener(this);
        btnRecharge.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_xz_zfb://选择支付宝

                break;
            case R.id.iv_xz_wx://选择微信

                break;
            case R.id.btn_recharge://充值
                startActivity(new Intent(this, ActivityRechargeSuccess.class));
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
