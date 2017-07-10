package ag.yinglingedu.com.ag.model.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

import ag.yinglingedu.com.ag.ActivityMain;
import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanRegister;
import ag.yinglingedu.com.ag.bean.BeanYZM;
import ag.yinglingedu.com.ag.event.EventOne;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.utils.PhoneUtils;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.ToastUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 注册页面
 * Created by M 4700 on 2017/5/27.
 */

public class ActivityRegister extends BaseActivity implements RequsetUtils.OnCompleteListener {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
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
    @BindView(R.id.iv_mm)
    ImageView ivMm;
    @BindView(R.id.et_mm)
    EditText etMm;
    @BindView(R.id.iv_eye)
    ImageView ivEye;
    @BindView(R.id.view_line3)
    View viewLine3;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_xy)
    TextView tvXy;
    @BindView(R.id.tv_tag2)
    TextView tvTag2;
    @BindView(R.id.iv_ty)
    ImageView ivTy;
    private boolean flags = false;
    private int time = 60;
    private boolean ty = true;
    private String number;
    private int request_line;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    @Override
    public void init() {
        ChangeUtil.initialize(this);
        EventBus.getDefault().register(this);
        initStatus();
    }

    @Override
    public void setListener() {
        ivEye.setOnClickListener(this);
        tvYzm.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        ivTy.setOnClickListener(this);
        tvXy.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_eye:      //眼睛
                if (!flags) {
                    //明文
                    etMm.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    ChangeUtil.setBasckgound(ivEye, R.mipmap.me_dl_ycmm_pre);
                    flags = true;
                } else {
                    //密码 TYPE_CLASS_TEXT 和 TYPE_TEXT_VARIATION_PASSWORD 必须一起使用
                    etMm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    ChangeUtil.setBasckgound(ivEye, R.mipmap.me_dl_ycmm);
                    flags = false;
                }
                break;
            case R.id.tv_yzm:           //获取验证码
                number = etZh.getText().toString();
                if (!number.equals("")) {//不为空
                    if (PhoneUtils.isMobileNO(number)) { /*/是手机号*/
                        changeTime();//改变获取验证码按钮上的时间
                        map.clear();
                        map.put("sendmsg", "{\"cmd\":\"getsmscode\",\"mobile\":" + number + ",\"type\":\"reg\"}");
                        map.put("encrypt", "0");
                        request_line = 0;
                        RequsetUtils.request(this, Config.HOST, map, request_line);
                    } else {
                        ToastUtils.showShortToast("请输入正确的手机号！");
                    }
                } else {
                    ToastUtils.showShortToast("请输入手机号！");
                    return;
                }
                break;
            case R.id.btn_login:        //登录按钮
                String yzm = etYzm.getText().toString();
                if (!yzm.equals("")) {
                    String password = etMm.getText().toString();
                    if (!password.equals("")) {
                        map.clear();
                        map.put("sendmsg", "{\"cmd\":\"reg\",\"mobile\":" + number + ",\"password\":" + password + ",\"code\":" + yzm + "}");
                        map.put("encrypt", "0");
                        request_line = 1;
                        RequsetUtils.request(this, Config.HOST, map, request_line);
                    } else {
                        ToastUtils.showShortToast("请输入密码！");
                    }
                } else {
                    ToastUtils.showShortToast("请输入验证码！");
                }


                break;
            case R.id.tv_login:         //去登陆
                startActivity(new Intent(this, ActivityLogin.class));
                break;
            case R.id.tv_xy:            //协议

                break;
            case R.id.iv_ty:            //同意
                if (ty) {//同意
                    ChangeUtil.setImageWithID(ivTy, R.mipmap.me_dl_ty_pre);
                    ty = false;
                } else {//不同意
                    ChangeUtil.setImageWithID(ivTy, R.mipmap.me_dl_ty);
                    ty = true;
                }

                break;
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

    @Override
    public void success(String result, int line) {
        switch (line) {
            case 0://获取验证码
                BeanYZM yzm = new Gson().fromJson(result, BeanYZM.class);
                if (yzm.getRetmsg().equals("处理成功")) {
                    ToastUtils.showShortToast("验证码发送成功！");
                } else if (yzm.getRetmsg().equals("数据已存在")) {
                    ToastUtils.showShortToast("该手机号已注册！");
                } else {
                    ToastUtils.showShortToast(yzm.getRetmsg());
                }
                break;
            case 1://注册
                BeanRegister register = new Gson().fromJson(result, BeanRegister.class);
                if (register.getRetmsg().equals("注册成功")) {
                    ToastUtils.showShortToast("注册成功！");
                    startActivity(new Intent(this, ActivityMain.class));
                    finish();
                } else {
                    ToastUtils.showShortToast(register.getRetmsg());
                }
                break;
        }
    }

    @Override
    public void failed(HttpException e, String s, int line) {
        switch (line) {
            case 0://获取验证码
                ToastUtils.showShortToast("请求验证码失败：" + e.toString());
                break;
            case 1://注册
                ToastUtils.showShortToast("请求注册失败：" + e.toString());
                break;
        }
    }
}
