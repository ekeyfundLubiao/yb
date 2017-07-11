package ag.yinglingedu.com.ag.controller.hall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lidroid.xutils.exception.HttpException;

import java.util.HashMap;
import java.util.Map;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.Hall_Demand_Entry;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.ag.util.net.HttpUtil;
import ag.yinglingedu.com.ag.util.net.NetBean;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import ag.yinglingedu.com.xlibrary.widget.SListView;
import ag.yinglingedu.com.xlibrary.widget.StarBar;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 需求详情
 * Created by M 4700 on 2017/6/16.
 */

public class ActivityDemandDetail extends BaseActivity {

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
    @BindView(R.id.sdv_pic)
    SimpleDraweeView sdvPic;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.rl_tag)
    RelativeLayout rlTag;
    @BindView(R.id.tv_xq)
    TextView tvXq;
    @BindView(R.id.tv_xqsm)
    TextView tvXqsm;
    @BindView(R.id.tv_xqsm_content)
    TextView tvXqsmContent;
    @BindView(R.id.rl_tag1)
    RelativeLayout rlTag1;
    @BindView(R.id.tv_yysj_tag)
    TextView tvYysjTag;
    @BindView(R.id.tv_yysj)
    TextView tvYysj;
    @BindView(R.id.rl_tag2)
    RelativeLayout rlTag2;
    @BindView(R.id.tv_jssj_tag)
    TextView tvJssjTag;
    @BindView(R.id.tv_jssj)
    TextView tvJssj;
    @BindView(R.id.rl_tag3)
    RelativeLayout rlTag3;
    @BindView(R.id.tv_fwfs_tag)
    TextView tvFwfsTag;
    @BindView(R.id.tv_fwfs)
    TextView tvFwfs;
    @BindView(R.id.rl_tag4)
    RelativeLayout rlTag4;
    @BindView(R.id.tv_yysl)
    TextView tvYysl;
    @BindView(R.id.lv_show)
    SListView lvShow;

    Hall_Demand_Entry entry;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xqxq);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("需求详情");
        ivBack.setVisibility(View.VISIBLE);
        lvShow.setFocusable(false);
        lvShow.setAdapter(new CommonAdapter<TestBean>(getApplicationContext(), null, R.layout.item_xqxq) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {
                StarBar starBar = helper.getView(R.id.star_bar);
                starBar.setStarMark(5.0f);
                starBar.setCanChangeable(false);//不可改变
            }
        });
        getData();
    }

    private void getData() {
        NetBean netBean = new NetBean();
        netBean.setToken(Utils.getSpUtils().getString(Config.TOKEN, ""));
        netBean.setUid(Utils.getSpUtils().getString(Config.USER_ID, ""));
        netBean.setCmd("getuserdemand");
        netBean.setPagesize("20");
        netBean.setPageno("1");

        HttpUtil.post(netBean, new RequsetUtils.OnCompleteListener() {
            @Override
            public void success(String result, int line) {
                entry = JSON.parseObject(result, Hall_Demand_Entry.class);
            }

            @Override
            public void failed(HttpException e, String s, int line) {

            }

            @Override
            public void onFinish() {

            }
        });
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
