package ag.yinglingedu.com.ag.model.homepage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;

import ag.yinglingedu.com.ag.C;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanOrder;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.AppManager;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.ToastUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import ag.yinglingedu.com.xlibrary.widget.SGridView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 确认订单
 * Created by M 4700 on 2017/6/15.
 */

public class ActivityQRDD extends BaseActivity implements RequsetUtils.OnCompleteListener{

    @BindView(R.id.tag)
    View tag;
    @BindView(R.id.sdv_headIcon)
    SimpleDraweeView sdvHeadIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.sdv_pic)
    SimpleDraweeView sdvPic;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_goods_content)
    TextView tvGoodsContent;
    @BindView(R.id.tv_xsfw)
    TextView tvXsfw;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.tv_price_int)
    TextView tvPriceInt;
    @BindView(R.id.tv_decimal)
    TextView tvDecimal;
    @BindView(R.id.numbers)
    TextView numbers;
    @BindView(R.id.tv_jian)
    TextView tvJian;
    @BindView(R.id.tv_jia)
    TextView tvJia;
    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.rl_numbers)
    RelativeLayout rlNumbers;
    @BindView(R.id.line3)
    View line3;
    @BindView(R.id.tv_ffsj)
    TextView tvFfsj;
    @BindView(R.id.iv_right_arrow1)
    ImageView ivRightArrow1;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.rl_time)
    RelativeLayout rlTime;
    @BindView(R.id.tv_lxdh)
    TextView tvLxdh;
    @BindView(R.id.et_lldh)
    EditText etLldh;
    @BindView(R.id.tv_mjll)
    TextView tvMjll;
    @BindView(R.id.et_mjll)
    EditText etMjll;
    @BindView(R.id.tv_xt)
    TextView tvXt;
    @BindView(R.id.gv_show)
    SGridView gvShow;
    @BindView(R.id.tv_stats)
    TextView tvStats;
    @BindView(R.id.tv_price_int_total)
    TextView tvPriceIntTotal;
    @BindView(R.id.tv_decimal_total)
    TextView tvDecimalTotal;
    @BindView(R.id.tv_tjdd)
    TextView tvTjdd;
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
    private int request_line;
    private String service_id;
    private String order_id;
    private String price;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrdd);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    @Override
    public void init() {
        AppManager.getAppManager().addActivity(this);
        initStatus();
        title.setText("确认订单");
        ivBack.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        service_id = intent.getStringExtra("service_id");
        String user_icon_url = intent.getStringExtra("user_icon");
        String product_icon_url = intent.getStringExtra("product_icon");
        String user_name = intent.getStringExtra("user_name");
        String product_name = intent.getStringExtra("service_title");
        price = intent.getStringExtra("service_price");

        sdvHeadIcon.setImageURI(Uri.parse(user_icon_url));
        sdvPic.setImageURI(Uri.parse(product_icon_url));
        tvName.setText(user_name);
        tvGoodsName.setText(product_name);
        tvPriceInt.setText("￥"+price );
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        tvTjdd.setOnClickListener(this);
        etNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = etNum.getText().toString();
                int num = Integer.valueOf(str);
                if(!str.equals("") &&  num >= 0){
                    int total = num * (int)Integer.valueOf(price);
                    tvPriceIntTotal.setText("￥"+total);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_tjdd://提交订单
                String buy_num = etNum.getText().toString();
                String tel = etLldh.getText().toString();
                if(buy_num.equals("") || Integer.valueOf(buy_num) < 0){
                    ToastUtils.showShortToast("请输入正确的购买数量！");
                    return;
                }
                if(tel.equals("")){
                    ToastUtils.showShortToast("请输入正确的手机号！");
                    return;
                }

                map.clear();
                map.put("sendmsg", "{ \"cmd\": \"appointmentservice\",\"uid\": \""+Utils.getSpUtils().getString(C.USER_ID,"")+"\"," +
                        "\"token\": \""+Utils.getSpUtils().getString(C.TOKEN,"")+"\",\"productid\": \""+service_id+"\",\"buynum\": " +
                        "\""+buy_num+"\",\"servicetime\": " + "\"2017-09-11\",\"tel\": \""+tel+"\",\"message\": \""+
                        etMjll.getText().toString()+"\",\"photos\": \"\"}");
                map.put("encrypt", "0");
                request_line = 0;
                RequsetUtils.request(this, C.HOST, map, request_line);
                break;
        }
    }

    @Override
    public void success(String result, int line) {
        BeanOrder order = new Gson().fromJson(result,BeanOrder.class);
        if(Integer.valueOf(order.getResult()) > 0){
            order_id = order.getResult();
            Intent intent = new Intent(this,ActivityZFDD.class);
            intent.putExtra("order_id",order_id);
            startActivity(intent);
        }
    }

    @Override
    public void failed(HttpException e, String s, int line) {

    }
}
