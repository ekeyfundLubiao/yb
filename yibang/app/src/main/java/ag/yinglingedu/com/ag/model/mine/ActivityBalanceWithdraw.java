package ag.yinglingedu.com.ag.model.mine;

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
 * 余额体现
 * Created by M 4700 on 2017/6/1.
 */

public class ActivityBalanceWithdraw extends BaseActivity {


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
    @BindView(R.id.tv_yhk)
    TextView tvYhk;
    @BindView(R.id.tv_remarks_wx)
    TextView tvRemarksWx;

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
    @BindView(R.id.tv_ktxje)
    TextView tvKtxje;
    @BindView(R.id.tv_qbtx)
    TextView tvQbtx;
    @BindView(R.id.rl_tx)
    RelativeLayout rlTx;
    @BindView(R.id.btn_withdraw_cash)
    Button btnWithdrawCash;
    @BindView(R.id.iv_xz_yhk)
    ImageView ivXzYhk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_withdraw);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("余额提现");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ivXzYhk.setOnClickListener(this);
        ivXzZfb.setOnClickListener(this);
        tvQbtx.setOnClickListener(this);
        btnWithdrawCash.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_xz_zfb://选择支付宝

                break;
            case R.id.iv_xz_yhk://选择银行卡

                break;
            case R.id.btn_withdraw_cash://立即提现
                startActivity(new Intent(this,ActivityWithdrawResult.class));
                break;
            case R.id.tv_qbtx:      //全部提现

                break;

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
