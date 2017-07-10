package ag.yinglingedu.com.ag.model.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.event.EventTwo;
import ag.yinglingedu.com.xlibrary.adapter.CommonFragmentPagerAdapter;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.widget.VPSwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/3.
 */

public class ActivityServiceOrder extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

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
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tv_type2)
    TextView tvType2;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.tv_type3)
    TextView tvType3;
    @BindView(R.id.line3)
    View line3;
    @BindView(R.id.tv_type4)
    TextView tvType4;
    @BindView(R.id.line4)
    View line4;
    @BindView(R.id.ll_navigation)
    LinearLayout llNavigation;
    @BindView(R.id.line5)
    View line5;
    @BindView(R.id.vp_show)
    ViewPager vpShow;
    @BindView(R.id.refresh)
    VPSwipeRefreshLayout refresh;

    private List<Fragment> mFragmentList;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_order);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvent(EventTwo eventTwo) {
        refresh.setViewGroup(eventTwo.getView());
    }


    @Override
    public void init() {
        ChangeUtil.initialize(this);
        initStatus();
        EventBus.getDefault().register(this);
        title.setText("服务订单");
        ivBack.setVisibility(View.VISIBLE);
        refresh.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorTextYellow));
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FragmentServiceOrder_all());//全部
        mFragmentList.add(new FragmentServiceOrder_ToBePaid());//待支付
        mFragmentList.add(new FragmentServiceOrder_ToBeSeviced());//待服务
        mFragmentList.add(new FragmentServiceOrder_ToBeComfirmed());//待确认
        mPagerAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vpShow.setAdapter(mPagerAdapter);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        tvType1.setOnClickListener(this);
        tvType2.setOnClickListener(this);
        tvType3.setOnClickListener(this);
        tvType4.setOnClickListener(this);
        refresh.setOnRefreshListener(this);
        vpShow.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                changeColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back://返回
                finish();
                break;
            case R.id.tv_type1://全部
                changeColor(0);//改变颜色
                vpShow.setCurrentItem(0);
                break;
            case R.id.tv_type2://待支付
                changeColor(1);
                vpShow.setCurrentItem(1);
                break;
            case R.id.tv_type3://待服务
                changeColor(2);
                vpShow.setCurrentItem(2);
                break;
            case R.id.tv_type4://待确认
                changeColor(3);
                vpShow.setCurrentItem(3);
                break;
        }
    }

    /*改变颜色*/
    private void changeColor(int type) {
        switch (type) {
            case 0:
                ChangeUtil.changeTextColor(tvType2, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType3, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType1, R.color.colorTextYellow);
                ChangeUtil.changeTextColor(tvType4, R.color.coloBlack);
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.INVISIBLE);
                line3.setVisibility(View.INVISIBLE);
                line4.setVisibility(View.INVISIBLE);
                break;
            case 1:
                ChangeUtil.changeTextColor(tvType1, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType3, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType4, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType2, R.color.colorTextYellow);
                line1.setVisibility(View.INVISIBLE);
                line2.setVisibility(View.VISIBLE);
                line3.setVisibility(View.INVISIBLE);
                line4.setVisibility(View.INVISIBLE);
                break;
            case 2:
                ChangeUtil.changeTextColor(tvType1, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType2, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType4, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType3, R.color.colorTextYellow);
                line1.setVisibility(View.INVISIBLE);
                line2.setVisibility(View.INVISIBLE);
                line4.setVisibility(View.INVISIBLE);
                line3.setVisibility(View.VISIBLE);
                break;
            case 3:
                ChangeUtil.changeTextColor(tvType1, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType2, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType3, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType4, R.color.colorTextYellow);
                line1.setVisibility(View.INVISIBLE);
                line2.setVisibility(View.INVISIBLE);
                line3.setVisibility(View.INVISIBLE);
                line4.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}