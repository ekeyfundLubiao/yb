package ag.yinglingedu.com.ag.model.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.APP;
import ag.yinglingedu.com.ag.C;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.utils.SPUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 通知与消息
 * Created by M 4700 on 2017/6/7.
 */

public class ActivityNotificationMessage extends BaseActivity {

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
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.rl_tzxx)
    RelativeLayout rlTzxx;
    @BindView(R.id.tv_tag1)
    TextView tvTag1;
    @BindView(R.id.rl_wrms)
    RelativeLayout rlWrms;
    @BindView(R.id.iv_btn)
    ImageView ivBtn;

    SPUtils spUtils = new SPUtils(C.SP_NAME);
    private boolean status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_message);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        ivBack.setVisibility(View.VISIBLE);
        title.setText("通知与消息");
        ChangeUtil.initialize(this);
        status = spUtils.getBoolean(C.IS_RECEIVE_NOTIFICATION);
        initButton(status);
    }

    /*初始化按钮*/
    private void initButton(boolean status) {
        if(status){//接收
            ChangeUtil.setImageWithID(ivBtn,R.mipmap.wd_btn_onfloat_highlighted);
        }else{//不接收
            ChangeUtil.setImageWithID(ivBtn,R.mipmap.wd_btn_offfloat_highlighted);
        }
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ivBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_btn:
                //是否接收
                status = spUtils.getBoolean(C.IS_RECEIVE_NOTIFICATION);
                changeButton(status);//改变按钮
                break;
        }
    }

    /**
     * 改变按钮
     * @param status
     */
    private void changeButton(boolean status) {
        if(status){//接收,改变状态
            ChangeUtil.setImageWithID(ivBtn,R.mipmap.wd_btn_offfloat_highlighted);
            spUtils.put(C.IS_RECEIVE_NOTIFICATION,false);
        }else{
            ChangeUtil.setImageWithID(ivBtn,R.mipmap.wd_btn_onfloat_highlighted);
            spUtils.put(C.IS_RECEIVE_NOTIFICATION,true);
        }
    }
}
