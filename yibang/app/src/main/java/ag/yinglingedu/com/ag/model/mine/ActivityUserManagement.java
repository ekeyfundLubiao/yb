package ag.yinglingedu.com.ag.model.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import ag.yinglingedu.com.ag.model.message.FragmentMyMessage_Message;
import ag.yinglingedu.com.ag.model.message.FragmentMyMessage_Notify;
import ag.yinglingedu.com.xlibrary.adapter.CommonFragmentPagerAdapter;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.widget.VPSwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关注的人(用户管理)
 * Created by M 4700 on 2017/6/8.
 */

public class ActivityUserManagement extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{


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
    @BindView(R.id.iv_dd)
    ImageView ivDd;
    @BindView(R.id.ll_type1)
    LinearLayout llType1;
    @BindView(R.id.tv_type2)
    TextView tvType2;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.ll_type2)
    LinearLayout llType2;
    @BindView(R.id.ll_navigation)
    LinearLayout llNavigation;
    @BindView(R.id.vp_show)
    ViewPager vpShow;
    @BindView(R.id.refresh)
    VPSwipeRefreshLayout refresh;

    private CommonFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        ivBack.setVisibility(View.VISIBLE);
        title.setText("用户管理");
        ChangeUtil.initialize(this);
        ChangeUtil.setBasckgound(ivRight, R.mipmap.xx_search);
        EventBus.getDefault().register(this);
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new FragmentUserManagement_Fans());
        mFragmentList.add(new FragmentUserManagement_Follow());
        mPagerAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vpShow.setAdapter(mPagerAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvent(EventTwo eventTwo) {
        refresh.setViewGroup(eventTwo.getView());
    }


    @Override
    public void setListener() {
        llType1.setOnClickListener(this);//消息
        llType2.setOnClickListener(this);//通知
        ivRight.setOnClickListener(this);
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
            case R.id.iv_right://搜索

                break;
            case R.id.ll_type1://粉丝
                changeColor(0);
                vpShow.setCurrentItem(0);
                break;
            case R.id.ll_type2://关注
                changeColor(1);
                vpShow.setCurrentItem(1);
                break;
        }
    }


    /*改变颜色*/
    private void changeColor(int type) {
        switch (type) {
            case 0:
                ChangeUtil.changeTextColor(tvType2, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType1, R.color.colorTextYellow);
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.INVISIBLE);

                break;
            case 1:
                ChangeUtil.changeTextColor(tvType1, R.color.coloBlack);
                ChangeUtil.changeTextColor(tvType2, R.color.colorTextYellow);
                line1.setVisibility(View.INVISIBLE);
                line2.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onRefresh() {

        refresh.setRefreshing(false);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}