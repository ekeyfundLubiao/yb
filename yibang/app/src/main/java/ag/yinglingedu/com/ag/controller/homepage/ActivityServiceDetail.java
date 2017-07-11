package ag.yinglingedu.com.ag.controller.homepage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanServiceDetail;
import ag.yinglingedu.com.xlibrary.adapter.BannerImageLoader;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.AppManager;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import ag.yinglingedu.com.xlibrary.widget.SListView;
import ag.yinglingedu.com.xlibrary.widget.SScrollView;
import ag.yinglingedu.com.xlibrary.widget.StarBar;
import ag.yinglingedu.com.xlibrary.widget.VPSwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 服务详情
 * Created by M 4700 on 2017/6/12.
 */

public class ActivityServiceDetail extends BaseActivity implements RequsetUtils.OnCompleteListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.scrollView)
    SScrollView scrollView;
    @BindView(R.id.refresh)
    VPSwipeRefreshLayout refresh;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tv_yssl)
    TextView tvYssl;
    @BindView(R.id.star_bar)
    StarBar starBar;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.rl_good_intro)
    RelativeLayout rlGoodIntro;
    @BindView(R.id.sdv_headIcon)
    SimpleDraweeView sdvHeadIcon;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.iv_gz)
    ImageView ivGz;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.tv_user_content)
    TextView tvUserContent;
    @BindView(R.id.rl_user)
    RelativeLayout rlUser;
    @BindView(R.id.tv_plsl)
    TextView tvPlsl;
    @BindView(R.id.lv_show)
    SListView lvShow;
    @BindView(R.id.iv_chat)
    ImageView ivChat;
    @BindView(R.id.tv_chat)
    TextView tvChat;
    @BindView(R.id.line3)
    View line3;
    @BindView(R.id.iv_shoucang)
    ImageView ivShoucang;
    @BindView(R.id.tv_shoucang)
    TextView tvShoucang;
    @BindView(R.id.tv_ljyy)
    TextView tvLjyy;
    private int request_line;
    private String service_id;
    private List<BeanServiceDetail.ListBean> list;
    private int service_mode;
    private List<String> list_pic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwxq);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        AppManager.getAppManager().addActivity(this);

        Intent intent = getIntent();
        service_id = intent.getStringExtra(Config.SERVICE_ID);
        String user_id = intent.getStringExtra("user_id");
        map.clear();
        map.put("sendmsg", "{\"cmd\": \"getservicedetail\",\"uid\": \"" + user_id + "\",\"token\": \"" + Utils.getSpUtils().getString(Config.TOKEN, "") + "\",\"id\": \"" + service_id + "\"}");
        map.put("encrypt", "0");
        request_line = 0;
        RequsetUtils.request(this, Config.HOST, map, request_line);

        starBar.setCanChangeable(false);

        refresh.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorTextYellow));
        //设置图片加载器
        refresh.setOnRefreshListener(this);
    }

    @Override
    public void setListener() {
        tvLjyy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_ljyy:
                Intent intent = new Intent(this, ActivityConfirmOrder.class);
                intent.putExtra("service_id", service_id);
                intent.putExtra("user_name", list.get(0).getUser_nickname());
                intent.putExtra("service_title", list.get(0).getService_title());
                intent.putExtra("service_price", list.get(0).getService_price());
                intent.putExtra("user_icon", Config.PIC + list.get(0).getUser_headpic());
                intent.putExtra("product_icon", list_pic.get(0));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void success(String result, int line) {
        switch (line) {
            case 0://服务详情
                BeanServiceDetail serviceDetail = new Gson().fromJson(result, BeanServiceDetail.class);
                list = serviceDetail.getList();
                String[] split = list.get(0).getService_photos().split(",");
                list_pic = new ArrayList<>();
                for (String bean : split) {
                    list_pic.add(Config.PIC + bean);
                }
                banner.setImageLoader(new BannerImageLoader());
                //设置图片集合
                banner.setImages(list_pic);
                //banner设置方法全部调用完毕时最后调用
                banner.start();
                tvName.setText(list.get(0).getService_title());
                tvContent.setText(list.get(0).getService_intro());
                tvPrice.setText(list.get(0).getService_price() + "/" + list.get(0).getService_unit());
                tvYssl.setText("[已售" + list.get(0).getService_ordercount() + "]");
                starBar.setStarMark(Float.parseFloat(list.get(0).getService_evaluatestar()));
                sdvHeadIcon.setImageURI(Uri.parse(Config.PIC + list.get(0).getUser_headpic()));
                tvUserName.setText(list.get(0).getUser_nickname());
                tvUserContent.setText(list.get(0).getService_message());
                service_mode = Integer.valueOf(list.get(0).getService_servicemode());
                break;
        }
    }

    @Override
    public void failed(HttpException e, String s, int line) {

    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false);
    }
}
