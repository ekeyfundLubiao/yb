package ag.yinglingedu.com.ag.model.homepage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanOrderDetail;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单详情
 * Created by M 4700 on 2017/6/15.
 */

public class ActivityOrderDetail extends BaseActivity implements RequsetUtils.OnCompleteListener {

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
    @BindView(R.id.tv_tag1)
    TextView tvTag1;
    @BindView(R.id.tv_tag2)
    TextView tvTag2;
    @BindView(R.id.tv_sysj)
    TextView tvSysj;
    @BindView(R.id.tv_tag3)
    TextView tvTag3;
    @BindView(R.id.rl_tag)
    RelativeLayout rlTag;
    @BindView(R.id.sdv_headIcon)
    SimpleDraweeView sdvHeadIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.sdv_icon)
    SimpleDraweeView sdvIcon;
    @BindView(R.id.tv_icon_name)
    TextView tvIconName;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_price_int)
    TextView tvPriceInt;
    @BindView(R.id.tv_decimal)
    TextView tvDecimal;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.tv_sqtk)
    TextView tvSqtk;
    @BindView(R.id.line3)
    View line3;
    @BindView(R.id.tv_fwzj)
    TextView tvFwzj;
    @BindView(R.id.tv_price_int_total)
    TextView tvPriceIntTotal;
    @BindView(R.id.tv_decimal_total)
    TextView tvDecimalTotal;
    @BindView(R.id.line4)
    View line4;
    @BindView(R.id.tv_xgjg)
    TextView tvXgjg;
    @BindView(R.id.tv_price_int_total_xgjg)
    TextView tvPriceIntTotalXgjg;
    @BindView(R.id.tv_decimal_total_xgjg)
    TextView tvDecimalTotalXgjg;
    @BindView(R.id.tv_ddzj_int)
    TextView tvDdzjInt;
    @BindView(R.id.tv_ddzj_decimal)
    TextView tvDdzjDecimal;
    @BindView(R.id.tv_wxzf)
    TextView tvWxzf;
    @BindView(R.id.tv_wxzf_int)
    TextView tvWxzfInt;
    @BindView(R.id.tv_wxzf_decimal)
    TextView tvWxzfDecimal;
    @BindView(R.id.rl_tag2)
    RelativeLayout rlTag2;
    @BindView(R.id.tv_qrfw)
    TextView tvQrfw;
    @BindView(R.id.tv_zjfk)
    TextView tvZjfk;
    @BindView(R.id.tv_ycfw)
    TextView tvYcfw;
    @BindView(R.id.rl_user)
    RelativeLayout rlUser;
    @BindView(R.id.tv_num)
    TextView tvNum;
    private int request_line;
    private String order_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddxq);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("订单详情");
        ivBack.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");
        map.clear();
        map.put("sendmsg", "{ \"cmd\": \"getorderdetail\",\"uid\": \"" + Utils.getSpUtils().getString(Config.USER_ID, "") + "\"," +
                "\"token\": \"" + Utils.getSpUtils().getString(Config.TOKEN, "") + "\",\"order_id\":\"" + order_id + "\"}");
        map.put("encrypt", "0");
        request_line = 0;
        RequsetUtils.request(this, Config.HOST, map, request_line);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        tvSqtk.setOnClickListener(this);
        tvYcfw.setOnClickListener(this);
        tvZjfk.setOnClickListener(this);
        tvQrfw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sqtk://申请退款

                break;
            case R.id.tv_ycfw://延长服务

                break;
            case R.id.tv_zjfk://追加付款

                break;
            case R.id.tv_qrfw://确认服务

                break;
        }
    }

    @Override
    public void success(String result, int line) {
        BeanOrderDetail beanOrderDetail = new Gson().fromJson(result, BeanOrderDetail.class);
        BeanOrderDetail.ListBean listBean = beanOrderDetail.getList().get(0);
        sdvHeadIcon.setImageURI(Uri.parse(Config.PIC + listBean.getUser_headpic()));
        tvName.setText(listBean.getUser_nickname());
        tvIconName.setText(listBean.getOrder_producttitle());
        sdvIcon.setImageURI(Uri.parse(Config.PIC + listBean));
        tvPriceInt.setText("￥" + listBean.getOrder_price());
        tvNum.setText("× "+listBean.getOrder_buynum());
        tvPriceIntTotal.setText("￥"+listBean.getOrder_orderamount());
    }

    @Override
    public void failed(HttpException e, String s, int line) {

    }
}
