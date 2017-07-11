package ag.yinglingedu.com.ag.controller.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单动态
 * Created by M 4700 on 2017/6/2.
 */

public class ActivityOrderdynamics extends BaseActivity {

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dynamics);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        title.setText("订单动态");
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
