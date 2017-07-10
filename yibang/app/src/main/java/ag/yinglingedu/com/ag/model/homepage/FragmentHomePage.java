package ag.yinglingedu.com.ag.model.homepage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;
import com.youth.banner.Banner;
import com.zaaach.citypicker.CityPickerActivity;
import com.zaaach.citypicker.model.City;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ag.yinglingedu.com.ag.APP;
import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.adapter.HomepageAdapter;
import ag.yinglingedu.com.ag.bean.BeanAds;
import ag.yinglingedu.com.ag.bean.BeanHomePageGridViewItem;
import ag.yinglingedu.com.ag.bean.BeanSYLB;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.ag.database.DatabaseHelper;
import ag.yinglingedu.com.ag.event.EventOne;
import ag.yinglingedu.com.ag.event.EventTwo;
import ag.yinglingedu.com.xlibrary.adapter.BannerImageLoader;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.ToastUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import ag.yinglingedu.com.xlibrary.widget.SGridView;
import ag.yinglingedu.com.xlibrary.widget.SListView;
import ag.yinglingedu.com.xlibrary.widget.SScrollView;
import ag.yinglingedu.com.xlibrary.widget.VPSwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * 首页
 * Created by CC on 2017/5/25.
 */

public class FragmentHomePage extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, SScrollView.OnScrollListener, RequsetUtils.OnCompleteListener {

    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;

    @BindView(R.id.sdv_ads)
    SimpleDraweeView sdvAds;
    @BindView(R.id.gv_show)
    SGridView gvShow;
    @BindView(R.id.tv_type1)
    TextView tvType1;
    @BindView(R.id.iv_arrow1)
    ImageView ivArrow1;
    @BindView(R.id.tv_type2)
    TextView tvType2;
    @BindView(R.id.iv_arrow2)
    ImageView ivArrow2;
    @BindView(R.id.tv_type3)
    TextView tvType3;
    @BindView(R.id.iv_arrow3)
    ImageView ivArrow3;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.lv_show)
    SListView lvShow;
    @BindView(R.id.scrollView)
    SScrollView scrollView;
    @BindView(R.id.ll_choose)
    LinearLayout llChoose;
    @BindView(R.id.refresh)
    VPSwipeRefreshLayout refresh;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.iv_location)
    ImageView ivLocation;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.title)
    RelativeLayout title;
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
    @BindView(R.id.rl_type1)
    RelativeLayout rlType1;
    @BindView(R.id.rl_type2)
    RelativeLayout rlType2;
    @BindView(R.id.rl_type3)
    RelativeLayout rlType3;
    @BindView(R.id.tv_search)
    TextView tvSearch;

    private HomepageAdapter mAdapter;
    private List<TestBean> mList;
    private List<BeanHomePageGridViewItem> beanHomePageGridViewItemList;
    private static final int REQUEST_CODE_PICK_CITY = 0;

    private CommonAdapter<String> mAdapter_left;
    private CommonAdapter<String> mAdapter_right;
    private boolean isShowing;
    private PopupWindow pop;
    private int hasBeenChoosed;
    private ListView listView_left;
    private ListView listView_right;
    private ListView listView_right1;
    private int request_line;
    private int pageNum = 1;
    private List<BeanSYLB.ListBean> fwlbList;
    private DatabaseHelper databaseHelper;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, null, false);
        unbinder = ButterKnife.bind(this, view);

        init();
        setListener();

        return view;
    }


    @Override
    public void init() {
        databaseHelper = ((APP) getActivity().getApplication()).databaseHelper;
        String location = Utils.getSpUtils().getString(Config.USER_CITY);
        if (null != location) {
            tvLocation.setText(location);
        }
        /*请求服务列表   Utils.getSpUtils().getString(C.USER_CITY)*/
        map.clear();
        map.put("sendmsg", "{\"cmd\": \"getservicelist\",\"uid\": \"" + Utils.getSpUtils().getString(Config.USER_ID) + "\",\"token\": \""
                + Utils.getSpUtils().getString(Config.TOKEN) + "\"," + "\"longitude\":\"" + Utils.getSpUtils().getString(Config.JD) +
                "\",\"latitude\":\"" + Utils.getSpUtils().getString(Config.WD) + "\",\"pagesize\": \"20\"," + "\"pageno\":\"" + pageNum +
                "\",\"classid\": \"\",\"sortby\": \"1\",\"filter\":\"{}\",\"isrec\": \"0\"," +
                "\"city\":\"" + "shanghai" + "\",}");
        map.put("encrypt", "0");
        request_line = 1;
        RequsetUtils.request(this, Config.HOST, map, request_line);

        /*请求广告*/
        map.clear();
        map.put("sendmsg", "{\"cmd\":\"getads\",\"uid\":\"" + Utils.getSpUtils().getString(Config.USER_ID) + "\"," +
                "\"token\":\"" + Utils.getSpUtils().getString(Config.TOKEN) + "\",\"classid\":\"" + Utils.getSpUtils().getString("首页广告") + "\"}");
        map.put("encrypt", "0");
        request_line = 0;
        RequsetUtils.request(this, Config.HOST, map, request_line);
        refresh.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorTextYellow));
      /*  //设置图片加载器
        sdvAds.setImageURI(Uri.parse(C.URL5));*/

        beanHomePageGridViewItemList = new ArrayList<>();
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("占卜算命", R.mipmap.home_icon_zbsm_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("手绘签名", R.mipmap.home_icon_shqm_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("聊天交互", R.mipmap.home_icon_ltjy_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("专业咨询", R.mipmap.home_icon_zyzx_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("教育培训", R.mipmap.home_icon_jypx_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("运动健身", R.mipmap.home_icon_ydjs_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("车务服务", R.mipmap.home_icon_cwfw_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("租赁服务", R.mipmap.home_icon_zlfw_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("跑腿代办", R.mipmap.home_icon_ptdb_normal));
        beanHomePageGridViewItemList.add(new BeanHomePageGridViewItem("全部分类", R.mipmap.home_icon_qbfl_normal));

        gvShow.setAdapter(new CommonAdapter<BeanHomePageGridViewItem>(getContext(), beanHomePageGridViewItemList, R.layout.item_homepage_gridview) {
            @Override
            public void convert(ViewHolder helper, BeanHomePageGridViewItem item) {
                helper.setImageResource(R.id.iv_icon, item.getImageId());
                helper.setText(R.id.tv_name, item.getName());
            }
        });
    }


    /*改变数据*/
  /*  private void changeData(final List<TestBean> list, final int layoutId) {
        lvShow.setAdapter(mAdapter = new CommonAdapter<TestBean>(getContext(), list, layoutId) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {

            }
        });
        mAdapter.notifyDataSetChanged();
    }*/

    /**
     * EventBus接收事件方法
     *
     * @param eventTwo
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvent(EventTwo eventTwo) {
        refresh.setViewGroup(eventTwo.getView());
    }

    @Override
    public void setListener() {
        tvSearch.setOnClickListener(this);
        refresh.setOnRefreshListener(this);
        scrollView.setOnScrollListener(this);
        rlType1.setOnClickListener(this);
        rlType2.setOnClickListener(this);
        rlType3.setOnClickListener(this);
        gvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == beanHomePageGridViewItemList.size() - 1) {//全部分类
                    startActivity(new Intent(FragmentHomePage.this.getContext(), ActivityKindsDetail.class));
                } else {//其他分类
                    startActivity(new Intent(FragmentHomePage.this.getContext(), ActivityKindsDetail.class));
                    EventBus.getDefault().postSticky(new EventOne(beanHomePageGridViewItemList.get(position).getName()));
                }
            }
        });
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String service_id = fwlbList.get(position).getService_id();
                Intent intent = new Intent(getActivity(), ActivityServiceDetail.class);
                intent.putExtra(Config.SERVICE_ID, service_id);
                intent.putExtra("user_id", fwlbList.get(position).getService_userid());
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(this);
        tvLocation.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_type1://智能排序
                scrollView.scrollTo(0, llChoose.getTop() - title.getHeight());
                title.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackgroundYellow));
                showMenu();
                break;
            case R.id.rl_type2://筛选
                scrollView.scrollTo(0, llChoose.getTop() - title.getHeight());
                title.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackgroundYellow));
                showMenu();
                break;
            case R.id.rl_type3://服务方式
                scrollView.scrollTo(0, llChoose.getTop() - title.getHeight());
                title.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackgroundYellow));
                showMenu();
                break;
            case R.id.tv_search://搜索
                startActivity(new Intent(getContext(), ActivitySearch.class));
                break;
            case R.id.iv_location:
            case R.id.tv_location:
                DatabaseHelper databaseHelper = ((APP) getActivity().getApplication()).databaseHelper;
                List<City> allCitys = databaseHelper.getAllCitys();
                Intent intent = new Intent(getActivity(), CityPickerActivity.class);
                intent.putExtra("city", (Serializable) allCitys);
                //启动
                startActivityForResult(intent, REQUEST_CODE_PICK_CITY);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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

        if (llChoose.getTop() - title.getHeight() <= scrollY) {
            //显示悬浮窗
            llChooseTop.setVisibility(View.VISIBLE);
            lineTop.setVisibility(View.VISIBLE);
        } else {
            //隐藏悬浮窗
            llChooseTop.setVisibility(View.GONE);
            lineTop.setVisibility(View.GONE);
        }

        if (scrollY > 0) { //开始滑动
            ivLocation.setBackgroundResource(R.mipmap.home_navbtn_location_disable);
            if (scrollY > 125) {
                title.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackgroundYellow));
                title.getBackground().mutate().setAlpha(255);
                return;
            }
            title.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackgroundYellow));
            title.getBackground().mutate().setAlpha(scrollY * 2);
        } else {//到顶部
            title.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.title));
            ivLocation.setBackgroundResource(R.mipmap.home_btn_location_disable);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tvLocation.setText(city);
                Utils.getSpUtils().put(Config.USER_CITY, city);
                map.clear();
                map.put("sendmsg", "{\"cmd\": \"getservicelist\",\"uid\": \"" + Utils.getSpUtils().getString(Config.USER_ID) + "\",\"token\": \""
                        + Utils.getSpUtils().getString(Config.TOKEN) + "\"," + "\"longitude\":\"" + Utils.getSpUtils().getString(Config.JD) +
                        "\",\"latitude\":\"" + Utils.getSpUtils().getString(Config.WD) + "\",\"pagesize\": \"20\"," + "\"pageno\":\"" + pageNum +
                        "\",\"classid\": \"\",\"sortby\": \"1\",\"filter\":\"{}\",\"isrec\": \"0\"," +
                        "\"city\":\"" + databaseHelper.search_city(city) + "\",}");
                map.put("encrypt", "0");
                request_line = 1;
                RequsetUtils.request(this, Config.HOST, map, request_line);
            }
        }
    }

    /*显示菜单*/
    private void showMenu() {
        if (null != pop && pop.isShowing()) {
            pop.dismiss();
        }
        hasBeenChoosed = 0;
        View contentView;
        LayoutInflater mLayoutInflater = LayoutInflater.from(getContext());
        contentView = mLayoutInflater.inflate(R.layout.layout_kinds,
                null);
        WindowManager manager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
//        int ypos=manager.getDefaultDisplay().getHeight()/2;
        pop = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        listView_left = (ListView) contentView.findViewById(R.id.lv_left);
        listView_right1 = (ListView) contentView.findViewById(R.id.lv_right);
        View pop_back = contentView.findViewById(R.id.ll_back);
        listView_left.setAdapter(mAdapter_left = new CommonAdapter<String>(getContext(), Arrays.asList(Config.T_YJFL), R.layout.item_fxq_left) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_type, item);
                if (helper.getPosition() == 0) {
                    helper.getView(R.id.line).setVisibility(View.VISIBLE);
                    helper.getConvertView().setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackground));
                }
            }
        });
        List<String> mList_r = new ArrayList<>();
        mList_r.addAll(Arrays.asList(Config.T_JJSH));
        mList_r.addAll(Arrays.asList(Config.T_YDJK));
        mList_r.addAll(Arrays.asList(Config.T_PTBS));
        mList_r.addAll(Arrays.asList(Config.T_JYPX));
        mList_r.addAll(Arrays.asList(Config.T_CWFU));
        mList_r.addAll(Arrays.asList(Config.T_ZHXY));
        mList_r.addAll(Arrays.asList(Config.T_JSFW));
        mList_r.addAll(Arrays.asList(Config.T_LRSS));
        mList_r.addAll(Arrays.asList(Config.T_ZXFW));
        listView_right1.setAdapter(mAdapter_right = new CommonAdapter<String>(getContext(), mList_r, R.layout.item_kinds_right) {
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

        listView_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeColor(view, position);//改变选中及清除未选中的颜色

            }
        });

        pop_back.setFocusable(true);
//        pop.showAtLocation(contentView, Gravity.BOTTOM, 0, llChooseTop.getTop());
        pop.showAsDropDown(llChoose, 0, 0);
        pop.update();
        isShowing = true;
    }

    /*改变选中及清除未选中的颜色*/
    private void changeColor(View view, int position) {
        listView_left.getChildAt(hasBeenChoosed).findViewById(R.id.line).setVisibility(View.GONE);
        ((TextView) listView_left.getChildAt(hasBeenChoosed).findViewById(R.id.tv_type)).setTextColor(ContextCompat.getColor(getContext(), R.color.colorText333333));
        listView_left.getChildAt(hasBeenChoosed).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackground));
        hasBeenChoosed = position;
        view.findViewById(R.id.line).setVisibility(View.VISIBLE);
        ((TextView) view.findViewById(R.id.tv_type)).setTextColor(ContextCompat.getColor(getContext(), R.color.colorTextYellow));
        view.setBackgroundColor(Color.WHITE);
    }


    public boolean isShowing() {
        return isShowing;
    }

    public void dismiss() {
        if (isShowing())
            pop.dismiss();
        pop.update();
        isShowing = false;
    }

    @Override
    public void success(String result, int line) {
        switch (line) {
            case 0://顶部和中间广告
                List<String> adsTopList = new ArrayList<>();
                List<String> adsMidList = new ArrayList<>();
                BeanAds beanAds = new Gson().fromJson(result, BeanAds.class);
                List<BeanAds.ListBean> beanAdsList = beanAds.getList();
                for (BeanAds.ListBean bean : beanAdsList) {
                    if (bean.getClassid().equals("admidindex")) {//中间广告
                        String[] adsMidArr = bean.getAdinfopic().split(",");
//                        adsMidList.addAll(Arrays.asList(adsMidArr));
                        sdvAds.setImageURI(Uri.parse(Config.PIC + adsMidArr[0]));
                    } else if (bean.getClassid().equals("adtopindex")) {//顶部广告
                        String[] adsTopArr = bean.getAdinfopic().split(",");
                        adsTopList.addAll(Arrays.asList(adsTopArr));
                    }
                }

                List<String> imgList = new ArrayList<>();
                for (int i = 0; i < adsTopList.size(); i++) {
                    imgList.add(Config.PIC + adsTopList.get(i));
//                    LogUtils.e("--------"+adsMidList.get(i));
                }
                banner.setImageLoader(new BannerImageLoader());
                //设置图片集合
                banner.setImages(imgList);
                //banner设置方法全部调用完毕时最后调用
                banner.start();
//                sdvAds.setImageURI(Uri.parse(C.PIC+adsMidList.get(0)));
                break;
            case 1://服务列表
                BeanSYLB beanSYLB = new Gson().fromJson(result, BeanSYLB.class);
                fwlbList = beanSYLB.getList();
                if (fwlbList.size() != 0) {
                    lvShow.setAdapter(mAdapter = new HomepageAdapter(getContext(), fwlbList));
                } else {
                    ToastUtils.showShortToast("暂无数据！");
                }
                break;
        }
    }

    @Override
    public void failed(HttpException e, String s, int line) {

    }
}
