package ag.yinglingedu.com.ag.model.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.SPUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 个人认证
 * Created by M 4700 on 2017/6/7.
 */

public class ActivityPersonalCertification extends BaseActivity {


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
    @BindView(R.id.iv_smrz)
    ImageView ivSmrz;
    @BindView(R.id.tv_smrz)
    TextView tvSmrz;
    @BindView(R.id.tv_smrz_tag)
    TextView tvSmrzTag;
    @BindView(R.id.iv_right_arrow1)
    ImageView ivRightArrow1;
    @BindView(R.id.rl_type1)
    RelativeLayout rlType1;
    @BindView(R.id.iv_zmxy)
    ImageView ivZmxy;
    @BindView(R.id.tv_zmxy)
    TextView tvZmxy;
    @BindView(R.id.tv_zmxy_tag)
    TextView tvZmxyTag;
    @BindView(R.id.iv_right_arrow2)
    ImageView ivRightArrow2;
    @BindView(R.id.rl_type2)
    RelativeLayout rlType2;
    @BindView(R.id.iv_jnrz)
    ImageView ivJnrz;
    @BindView(R.id.tv_jnrz)
    TextView tvJnrz;
    @BindView(R.id.tv_jnrz_tag)
    TextView tvJnrzTag;
    @BindView(R.id.iv_right_arrow3)
    ImageView ivRightArrow3;
    @BindView(R.id.rl_type3)
    RelativeLayout rlType3;
    SPUtils spUtils = new SPUtils(Config.SP_NAME);
    private boolean isCertification_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_certification);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isCertification_name = spUtils.getBoolean(Config.IS_CERTIFICATION_NAME);//是否实名认证
        if (isCertification_name) {
            tvSmrz.setText("已实名认证");
        }
    }

    @Override
    public void init() {
        initStatus();
        ivBack.setVisibility(View.VISIBLE);
        title.setText("我的认证");
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        rlType1.setOnClickListener(this);
        rlType2.setOnClickListener(this);
        rlType3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_type1://实名认证
                if (isCertification_name) {//已认证
                    startActivity(new Intent(this, ActivityAlreadyCertificationName.class));
                } else {//未认证
                    startActivity(new Intent(this, ActivityCertification.class));
                }
                break;
            case R.id.rl_type2://芝麻信用认证

                break;
            case R.id.rl_type3://技能认证
                startActivity(new Intent(this, ActivitySkillCertification.class));
                break;

        }
    }
}
