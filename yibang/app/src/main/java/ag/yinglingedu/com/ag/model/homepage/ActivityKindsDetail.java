package ag.yinglingedu.com.ag.model.homepage;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanHomePageGridViewItem;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.ag.event.EventOne;
import ag.yinglingedu.com.ag.event.EventTwo;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.widget.SListView;
import ag.yinglingedu.com.xlibrary.widget.SScrollView;
import ag.yinglingedu.com.xlibrary.widget.VPSwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 分类详情页面
 * Created by M 4700 on 2017/6/10.
 */

public class ActivityKindsDetail extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SScrollView.OnScrollListener {

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
    @BindView(R.id.tv_type1)
    TextView tvType1;
    @BindView(R.id.iv_arrow1)
    ImageView ivArrow1;
    @BindView(R.id.rl_type1)
    RelativeLayout rlType1;
    @BindView(R.id.tv_type2)
    TextView tvType2;
    @BindView(R.id.iv_arrow2)
    ImageView ivArrow2;
    @BindView(R.id.rl_type2)
    RelativeLayout rlType2;
    @BindView(R.id.tv_type3)
    TextView tvType3;
    @BindView(R.id.iv_arrow3)
    ImageView ivArrow3;
    @BindView(R.id.rl_type3)
    RelativeLayout rlType3;
    @BindView(R.id.ll_choose)
    LinearLayout llChoose;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.lv_show)
    SListView lvShow;
    @BindView(R.id.scrollView)
    SScrollView scrollView;
    @BindView(R.id.refresh)
    VPSwipeRefreshLayout refresh;
    @BindView(R.id.tv_type1_top)
    TextView tvType1Top;
    @BindView(R.id.iv_arrow1_top)
    ImageView ivArrow1Top;
    @BindView(R.id.tv_type2_top)
    TextView tvType2Top;
    @BindView(R.id.iv_arrow2_top)
    ImageView ivArrow2Top;
    @BindView(R.id.tv_type3_top)
    TextView tvType3Top;
    @BindView(R.id.iv_arrow3_top)
    ImageView ivArrow3Top;
    @BindView(R.id.ll_choose_top)
    LinearLayout llChooseTop;
    @BindView(R.id.line_top)
    View lineTop;
    @BindView(R.id.rl_top1)
    RelativeLayout rlTop1;
    @BindView(R.id.rl_top2)
    RelativeLayout rlTop2;
    @BindView(R.id.rl_top3)
    RelativeLayout rlTop3;
    private CommonAdapter<TestBean> mAdapter;
    private List<TestBean> mList;
    private List<BeanHomePageGridViewItem> beanHomePageGridViewItemList;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private CommonAdapter<String> mAdapter_left;
    private CommonAdapter<String> mAdapter_right;
    private boolean isShowing;
    private PopupWindow pop;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinds_details);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        ivBack.setVisibility(View.VISIBLE);
        EventBus.getDefault().register(this);
        refresh.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorTextYellow));
        Config.getList().clear();
        mList = Config.getList();

        int layoutId = R.layout.item_homepage_listview;
        changeData(mList, layoutId);//改变数据
    }


    /*改变数据*/
    private void changeData(final List<TestBean> list, final int layoutId) {
        lvShow.setAdapter(mAdapter = new CommonAdapter<TestBean>(this, list, layoutId) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {

            }
        });
        mAdapter.notifyDataSetChanged();
    }

    /**
     * EventBus接收事件方法
     *
     * @param eventTwo
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvent(EventTwo eventTwo) {
        refresh.setViewGroup(eventTwo.getView());
    }

    /**
     * EventBus接收事件方法
     *
     * @param eventOne
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN) //这种写法达到粘性的目的
    public void onShowMessageEvent(EventOne eventOne) {
        title.setText(eventOne.getMsg());
    }

    @Override
    public void setListener() {
        refresh.setOnRefreshListener(this);
        scrollView.setOnScrollListener(this);
        rlTop1.setOnClickListener(this);
        rlTop2.setOnClickListener(this);
        rlTop3.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        scrollView.scrollTo(0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_top1://智能排序
                isShowing = true;
//                scrollView.scrollTo(0, banner.getHeight());
                showMenu();
                break;
            case R.id.rl_top2://筛选
                isShowing = true;
//                scrollView.scrollTo(0, banner.getHeight());
                showMenu();
                break;
            case R.id.rl_top3://服务方式
                isShowing = true;
//                scrollView.scrollTo(0, banner.getHeight());
                showMenu();
                break;
            case R.id.tv_search://搜索

                break;
        }
    }

    @Override
    public void onRefresh() {
        //刷新监听
        refresh.setRefreshing(false);
    }

    @Override
    public void onScroll(int scrollY) {
        //Scrollview滑动监听
        EventBus.getDefault().post(new EventTwo(scrollView));

    /*    if (banner.getHeight() <= scrollY) {
            //显示悬浮窗
            llChooseTop.setVisibility(View.VISIBLE);
            lineTop.setVisibility(View.VISIBLE);
        } else {
            //隐藏悬浮窗
            llChooseTop.setVisibility(View.GONE);
            lineTop.setVisibility(View.GONE);
        }*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    /*显示菜单-全部*/
    private void showMenu() {
        if (null != pop && pop.isShowing()) {
            pop.dismiss();
        }
        View contentView;
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        contentView = mLayoutInflater.inflate(R.layout.layout_kinds, null);
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        pop = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ListView listView_left = (ListView) contentView.findViewById(R.id.lv_left);
        ListView listView_right = (ListView) contentView.findViewById(R.id.lv_right);
        View pop_back = contentView.findViewById(R.id.ll_back);
        List<String> mList_l = new ArrayList<>();
        mList_l.addAll(Arrays.asList(Config.T_YJFL));
        /**/
        listView_left.setAdapter(mAdapter_left = new CommonAdapter<String>(this, mList_l, R.layout.item_fxq_left) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_type, item);
                if (helper.getPosition() == 0) {
                    helper.getView(R.id.line).setVisibility(View.VISIBLE);
                    helper.getConvertView().setBackgroundColor(Color.WHITE);
                }
            }
        });
        List<String> mList_r = new ArrayList<>();
        mList_r.addAll(Arrays.asList(Config.T_XXYL));
        mList_r.addAll(Arrays.asList(Config.T_JJSH));
        mList_r.addAll(Arrays.asList(Config.T_YDJK));
        mList_r.addAll(Arrays.asList(Config.T_PTBS));
        mList_r.addAll(Arrays.asList(Config.T_JYPX));
        mList_r.addAll(Arrays.asList(Config.T_CWFU));
        mList_r.addAll(Arrays.asList(Config.T_ZHXY));
        mList_r.addAll(Arrays.asList(Config.T_JSFW));
        mList_r.addAll(Arrays.asList(Config.T_LRSS));
        mList_r.addAll(Arrays.asList(Config.T_ZXFW));
        listView_right.setAdapter(mAdapter_right = new CommonAdapter<String>(this, mList_r, R.layout.item_kinds_right) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_name, item);
            }
        });
        pop_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                pop.update();
            }
        });
        pop_back.setFocusable(true);
//        pop.showAtLocation(contentView, Gravity.BOTTOM, 0, llChooseTop.getTop());
        pop.showAsDropDown(llChoose, 0, 0);
        pop.update();
    }

    /*显示菜单-智能排序*/
    private void showMenu2() {
        if (null != pop && pop.isShowing()) {
            pop.dismiss();
        }
        View contentView;
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        contentView = mLayoutInflater.inflate(R.layout.layout_znpx, null);
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        pop = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ListView listView_right = (ListView) contentView.findViewById(R.id.lv_right);
        View pop_back = contentView.findViewById(R.id.ll_back);
        List<String> mList_l = new ArrayList<>();
        mList_l.addAll(Arrays.asList(Config.T_YJFL));

        List<String> mList_r = new ArrayList<>();
        mList_r.addAll(Arrays.asList(Config.T_XXYL));
        mList_r.addAll(Arrays.asList(Config.T_JJSH));
        mList_r.addAll(Arrays.asList(Config.T_YDJK));
        mList_r.addAll(Arrays.asList(Config.T_PTBS));
        mList_r.addAll(Arrays.asList(Config.T_JYPX));
        mList_r.addAll(Arrays.asList(Config.T_CWFU));
        mList_r.addAll(Arrays.asList(Config.T_ZHXY));
        mList_r.addAll(Arrays.asList(Config.T_JSFW));
        mList_r.addAll(Arrays.asList(Config.T_LRSS));
        mList_r.addAll(Arrays.asList(Config.T_ZXFW));
        listView_right.setAdapter(mAdapter_right = new CommonAdapter<String>(this, mList_r, R.layout.item_kinds_right) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_name, item);
            }
        });
        pop_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                pop.update();
            }
        });
        pop_back.setFocusable(true);
//        pop.showAtLocation(contentView, Gravity.BOTTOM, 0, llChooseTop.getTop());
        pop.showAsDropDown(llChoose, 0, 0);
        pop.update();
    }

    @Override
    public void onBackPressed() {
        if (isShowing) {
            pop.dismiss();
            pop.update();
            isShowing = false;
        } else {
            finish();
        }

    }
}