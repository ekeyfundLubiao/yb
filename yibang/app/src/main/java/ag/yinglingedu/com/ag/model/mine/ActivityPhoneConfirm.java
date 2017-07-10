package ag.yinglingedu.com.ag.model.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.event.EventOne;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/5/29.
 */

public class ActivityPhoneConfirm extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.iv_zh)
    ImageView ivZh;
    @BindView(R.id.et_zh)
    EditText etZh;
    @BindView(R.id.view_line1)
    View viewLine1;
    @BindView(R.id.iv_yzm)
    ImageView ivYzm;
    @BindView(R.id.et_yzm)
    EditText etYzm;
    @BindView(R.id.tv_yzm)
    TextView tvYzm;
    @BindView(R.id.view_line2)
    View viewLine2;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private int time = 60;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_confirm);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        title.setText("手机认证");
        EventBus.getDefault().register(this);
    }

    @Override
    public void setListener() {
        btnLogin.setOnClickListener(this);
        tvYzm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_yzm:
                changeTime();
                break;
            case R.id.btn_login:

                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvent(EventOne eventOne) {
        tvYzm.setText(eventOne.getMsg());
        if (eventOne.getMsg().equals("获取验证码")) {
            ChangeUtil.changeTextViewBackgroundColor(tvYzm, R.color.colorBackgroundYellow);
            tvYzm.setClickable(true);//可点击
            time = 60;
        }
    }

    /*改变获取验证码按钮上的时间*/
    private void changeTime() {
        ChangeUtil.changeTextViewBackgroundColor(tvYzm, R.color.colorBttonBackgroundGray);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (time > 0) {
                    EventBus.getDefault().post(new EventOne(String.valueOf(time) + "秒后重发"));
                    time--;
                } else {
                    EventBus.getDefault().post(new EventOne("获取验证码"));
                    cancel();//取消
                }
            }
        }, 0, 1000);
        tvYzm.setClickable(false);//不可点击
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
