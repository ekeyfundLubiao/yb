package ag.yinglingedu.com.ag.model.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;

import ag.yinglingedu.com.ag.C;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanOrderDetail;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.AppManager;
import ag.yinglingedu.com.xlibrary.utils.LogUtils;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 支付订单
 * Created by M 4700 on 2017/6/15.
 */

public class ActivityZFDD extends BaseActivity implements RequsetUtils.OnCompleteListener{

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_time_tag)
    TextView tvTimeTag;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_name_tag)
    TextView tvNameTag;
    @BindView(R.id.tv_ddmc)
    TextView tvDdmc;
    @BindView(R.id.rl_ddmc)
    RelativeLayout rlDdmc;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_name_tag1)
    TextView tvNameTag1;
    @BindView(R.id.tv_ddje)
    TextView tvDdje;
    @BindView(R.id.rl_ddje)
    RelativeLayout rlDdje;
    @BindView(R.id.tv_name_tag2)
    TextView tvNameTag2;
    @BindView(R.id.tv_kyye)
    TextView tvKyye;
    @BindView(R.id.rl_kyye)
    RelativeLayout rlKyye;
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
    @BindView(R.id.tv_price_int_total)
    TextView tvPriceIntTotal;
    @BindView(R.id.tv_decimal_total)
    TextView tvDecimalTotal;
    @BindView(R.id.rl_bottom)
    RelativeLayout rlBottom;
    @BindView(R.id.tv_ljfk)
    TextView tvLjfk;
    private int request_line;
    private String order_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zfdd);
        ButterKnife.bind(this);
        init();
        setListener();

    }

    @Override
    public void init() {
        AppManager.getAppManager().addActivity(this);
        initStatus();
        title.setText("支付订单");
        ivBack.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");
//        LogUtils.e("---------"+order_id);
        map.clear();
        map.put("sendmsg", "{ \"cmd\": \"getorderdetail\",\"uid\": \""+ Utils.getSpUtils().getString(C.USER_ID,"")+"\"," +
                "\"token\": \""+Utils.getSpUtils().getString(C.TOKEN,"")+"\",\"order_id\":\""+ order_id +"\"}");
        map.put("encrypt", "0");
        request_line = 0;
        RequsetUtils.request(this, C.HOST, map, request_line);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        tvLjfk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_ljfk:

                Intent intent = new Intent(this,ActivityZFXQ.class);
                intent.putExtra("order_id",order_id);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void success(String result, int line) {
        BeanOrderDetail beanOrderDetail = new Gson().fromJson(result,BeanOrderDetail.class);
        BeanOrderDetail.ListBean listBean = beanOrderDetail.getList().get(0);
        tvName.setText(listBean.getUser_nickname());
        tvPrice.setText("￥"+listBean.getOrder_orderamount());
        tvDdmc.setText(listBean.getOrder_producttitle());
        tvDdje.setText(listBean.getOrder_orderamount());
    }

    @Override
    public void failed(HttpException e, String s, int line) {

    }
}
