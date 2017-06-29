package ag.yinglingedu.com.ag.model.mine;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;

import ag.yinglingedu.com.ag.ActivityMain;
import ag.yinglingedu.com.ag.C;
import ag.yinglingedu.com.ag.HeartBeatService;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanUser;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.utils.LogUtils;
import ag.yinglingedu.com.xlibrary.utils.PhoneUtils;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.ToastUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 登录页面
 * Created by M 4700 on 2017/5/26.
 */

public class ActivityLogin extends BaseActivity implements RequsetUtils.OnCompleteListener {


    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.iv_zh)
    ImageView ivZh;
    @BindView(R.id.et_zh)
    EditText etZh;
    @BindView(R.id.view_line1)
    View viewLine1;
    @BindView(R.id.iv_mm)
    ImageView ivMm;
    @BindView(R.id.et_mm)
    EditText etMm;
    @BindView(R.id.iv_eye)
    ImageView ivEye;
    @BindView(R.id.view_line2)
    View viewLine2;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    private boolean flags = false;
    private String number;
    private int request_line;
    private String password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        init();
        setListener();

    }


    @Override
    public void init() {
        initStatus();
        ChangeUtil.initialize(this);
    }

    @Override
    public void setListener() {
        ivEye.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvForget.setOnClickListener(this);
        ivLogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*-------------------------------------测试专用-------------------------------------------------*/
            case R.id.iv_logo:
                startActivity(new Intent(this, ActivityMain.class));
                break;
            /*-------------------------------------测试专用-------------------------------------   --------*/
            case R.id.iv_eye:
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
            case R.id.btn_login:
                number = etZh.getText().toString();
                password = etMm.getText().toString();
                if (!number.equals("")) {//不为空
                    if (PhoneUtils.isMobileNO(number)) { /*/是手机号*/
                        if (!password.equals("")) {//密码不为空
                            map.clear();
                            map.put("sendmsg", "{\"cmd\":\"login\",\"mobile\":" + number + ",\"password\":" + password + "}");
                            map.put("encrypt", "0");
                            request_line = 0;
                            RequsetUtils.request(this, C.HOST, map, request_line);
                        } else {//空密码
                            ToastUtils.showShortToast("请输入密码");
                        }

                    } else {
                        ToastUtils.showShortToast("请输入正确的手机号！");
                    }
                } else {
                    ToastUtils.showShortToast("请输入手机号！");
                    return;
                }
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, ActivityRegister.class));
                break;
            case R.id.tv_forget:

                break;
        }
    }

    @Override
    public void success(String result, int line) {
        BeanUser user = new Gson().fromJson(result, BeanUser.class);
        if (user.getResult().equals("1")) {//登陆成功
            ToastUtils.showShortToast("登陆成功！跳转中...");
            if (!Utils.getSpUtils().getBoolean(C.IS_FIRST_LOGIN)) {//第一次登录
                Utils.getSpUtils().put(C.IS_FIRST_LOGIN, true);
            }
            Utils.getSpUtils().put(C.TOKEN, user.getToken());
            Utils.getSpUtils().put(C.USER_ID, user.getUserinfo().get(0).getUser_id());
            Utils.getSpUtils().put(C.USER_NAME, user.getUserinfo().get(0).getUser_name());
            Utils.getSpUtils().put(C.USER_NICKNAME, user.getUserinfo().get(0).getUser_nickname());
            Utils.getSpUtils().put(C.USER_HEADPIC, user.getUserinfo().get(0).getUser_headpic());
            Utils.getSpUtils().put(C.USER_SEX, user.getUserinfo().get(0).getUser_headpic());
            Utils.getSpUtils().put(C.USER_REGMOBILE, user.getUserinfo().get(0).getUser_regmobile());
            Utils.getSpUtils().put(C.USER_WORKMOBILE, user.getUserinfo().get(0).getUser_workmobile());
            Utils.getSpUtils().put(C.USER_BIRTHDAY, user.getUserinfo().get(0).getUser_birthday());
            Utils.getSpUtils().put(C.USER_INTRO, user.getUserinfo().get(0).getUser_intro());
            Utils.getSpUtils().put(C.USER_FANS, user.getUserinfo().get(0).getUser_fans());
            Utils.getSpUtils().put(C.USER_SUBSCRIBE, user.getUserinfo().get(0).getUser_subscribe());
            Utils.getSpUtils().put(C.VERSION_CODE, getVersion());
            Utils.getSpUtils().put(C.LAST_TIME, user.getTime());

//            LogUtils.e("-----------" + getVersion());
            startService(new Intent(this, HeartBeatService.class));
            startActivity(new Intent(this, ActivityMain.class));
            finish();
        } else {//账号或者密码错误
            ToastUtils.showShortToast("账号或者密码错误!");
        }
    }

    @Override
    public void failed(HttpException e, String s, int line) {
        ToastUtils.showShortToast("请求登陆失败：" + e.toString());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "无法获取版本号！";
        }
    }

}
