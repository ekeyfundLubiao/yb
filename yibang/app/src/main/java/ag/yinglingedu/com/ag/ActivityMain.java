package ag.yinglingedu.com.ag;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ag.yinglingedu.com.ag.controller.hall.FragmentHall;
import ag.yinglingedu.com.ag.controller.homepage.FragmentHomePage;
import ag.yinglingedu.com.ag.controller.message.FragmentMyMessage;
import ag.yinglingedu.com.ag.controller.mine.FragmentMine;
import ag.yinglingedu.com.ag.controller.publish.ActivityPublish;
import ag.yinglingedu.com.xlibrary.base.BaseFragmentActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ActivityMain extends BaseFragmentActivity {
    @BindView(R.id.fl_show)
    FrameLayout flShow;
    @BindView(R.id.iv_homepage)
    ImageView ivHomepage;
    @BindView(R.id.tv_homepage)
    TextView tvHomepage;
    @BindView(R.id.ll_homepage)
    LinearLayout llHomepage;
    @BindView(R.id.iv_hall)
    ImageView ivHall;
    @BindView(R.id.tv_hall)
    TextView tvHall;
    @BindView(R.id.ll_hall)
    LinearLayout llHall;
    @BindView(R.id.ll_size_seat)
    LinearLayout llSizeSeat;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.iv_mine)
    ImageView ivMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    @BindView(R.id.ly_bottom)
    LinearLayout lyBottom;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    private Fragment currentFragment;//当前显示的fragment
    private FragmentHomePage fragmentHomePage = new FragmentHomePage();
    private FragmentMyMessage fragmentMessage = new FragmentMyMessage();
    private FragmentHall fragmentHall = new FragmentHall();
    private FragmentMine fragmentMine = new FragmentMine();
    private long exitTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();                                 //1.初始化
        setListener();                          //2.设置监听
    }

    @Override
    public void init() {
        initStatus();
        ButterKnife.bind(this);
        ChangeUtil.initialize(this);
        showFragment(fragmentHomePage);
    }

    @Override
    public void setListener() {
        llHomepage.setOnClickListener(this);
        llHall.setOnClickListener(this);
        ivAdd.setOnClickListener(this);
        llMessage.setOnClickListener(this);
        llMine.setOnClickListener(this);
    }

    /*默认显示fragment*/
    private void showFragment(Fragment showFrgment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (currentFragment != null) {
            ft.hide(currentFragment);
        }
        if (showFrgment == null && !showFrgment.isAdded()) {
            ft.add(R.id.fl_show, showFrgment);
        } else if (showFrgment.isAdded()) {
            ft.show(showFrgment);
        } else {
            ft.add(R.id.fl_show, showFrgment);
            ft.show(showFrgment);
        }
        ft.commit();//提交
        currentFragment = showFrgment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_homepage:
                changeTab(0, ivHomepage, tvHomepage);
                showFragment(fragmentHomePage);
                break;
            case R.id.ll_hall:
                changeTab(1, ivHall, tvHall);
                showFragment(fragmentHall);
                break;
            case R.id.iv_add:
                startActivity(new Intent(this, ActivityPublish.class));
                break;
            case R.id.ll_message:
                changeTab(2, ivMessage, tvMessage);
                showFragment(fragmentMessage);
                break;
            case R.id.ll_mine:
                changeTab(3, ivMine, tvMine);
                showFragment(fragmentMine);
                break;
        }
    }

    /*改变导航栏状态*/
    private void changeTab(int positon, ImageView imageView, TextView textView) {
        clearTabColor();
        ChangeUtil.changeTextColor(textView, R.color.colorTextYellow);
        switch (positon) {
            case 0:
                ChangeUtil.setImageWithID(imageView, R.mipmap.tab_hone_pre);
                break;
            case 1:
                ChangeUtil.setImageWithID(imageView, R.mipmap.tab_dt_pre);
                break;
            case 2:
                ChangeUtil.setImageWithID(imageView, R.mipmap.tab_xx_pre);
                break;
            case 3:
                ChangeUtil.setImageWithID(imageView, R.mipmap.tab_wd_pre);
                break;
        }
    }

    /*清空导航栏颜色*/
    private void clearTabColor() {
        ChangeUtil.setImageWithID(ivHomepage, R.mipmap.tab_hone);
        ChangeUtil.setImageWithID(ivHall, R.mipmap.tab_dt);
        ChangeUtil.setImageWithID(ivMessage, R.mipmap.tab_xx);
        ChangeUtil.setImageWithID(ivMine, R.mipmap.tab_wd);
        ChangeUtil.changeTextColor(tvHomepage, R.color.colorTextGray);
        ChangeUtil.changeTextColor(tvHall, R.color.colorTextGray);
        ChangeUtil.changeTextColor(tvMessage, R.color.colorTextGray);
        ChangeUtil.changeTextColor(tvMine, R.color.colorTextGray);
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //不做处理，解决fragment重叠问题
    }

    @Override
    public void onBackPressed() {
        if (fragmentHomePage.isShowing()) {
            fragmentHomePage.dismiss();
        } else {
            exit();
        }
    }

    private void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            stopService(new Intent(this, HeartBeatService.class));//心跳包
            ((APP) getApplication()).mLocationClient.stopLocation();//停止定位
            finish();
            System.exit(0);
        }
    }
}
