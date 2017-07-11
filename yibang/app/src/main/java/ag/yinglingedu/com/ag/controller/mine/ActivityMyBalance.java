package ag.yinglingedu.com.ag.controller.mine;

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
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/5/30.
 */

public class ActivityMyBalance extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.btn_recharge)
    Button btnRecharge;
    @BindView(R.id.btn_withdraw_cash)
    Button btnWithdrawCash;
    @BindView(R.id.iv_divider)
    ImageView ivDivider;
    @BindView(R.id.tv_xsjc)
    TextView tvXsjc;
    @BindView(R.id.tv_cjwt)
    TextView tvCjwt;
    @BindView(R.id.tv_right)
    TextView tvRight;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_balance);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("我的余额");
        tvRight.setText("收支明细");
        ivBack.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        tvRight.setOnClickListener(this);
        btnRecharge.setOnClickListener(this);
        btnWithdrawCash.setOnClickListener(this);
        tvXsjc.setOnClickListener(this);
        tvCjwt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:  //返回
                finish();
                break;
            case R.id.tv_right:  //收支明细
                startActivity(new Intent(this, ActivityPaymentsDetail.class));
                break;
            case R.id.btn_recharge: //充值
                startActivity(new Intent(this, ActivityBalanceRecharge.class));
                break;
            case R.id.btn_withdraw_cash: //提现
                startActivity(new Intent(this, ActivityBalanceWithdraw.class));
                break;
            case R.id.tv_xsjc:      //新手教程

                break;
            case R.id.tv_cjwt:      //常见问题

                break;
        }
    }
}
