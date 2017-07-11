package ag.yinglingedu.com.ag.controller.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/7.
 */

public class ActivitySkillCertification extends BaseActivity {


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
    @BindView(R.id.tv_tag1)
    TextView tvTag1;
    @BindView(R.id.et_zsch)
    EditText etZsch;
    @BindView(R.id.rl_rzch)
    RelativeLayout rlRzch;
    @BindView(R.id.tv_tag2)
    TextView tvTag2;
    @BindView(R.id.et_id)
    EditText etId;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.tv_tag4)
    TextView tvTag4;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.rl_number)
    RelativeLayout rlNumber;
    @BindView(R.id.tv_tag5)
    TextView tvTag5;
    @BindView(R.id.et_remarks)
    EditText etRemarks;
    @BindView(R.id.rl_remarks)
    RelativeLayout rlRemarks;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.iv_pic_z)
    ImageView ivPicZ;
    @BindView(R.id.iv_add_z)
    ImageView ivAddZ;
    @BindView(R.id.tv_z)
    TextView tvZ;
    @BindView(R.id.iv_pic_f)
    ImageView ivPicF;
    @BindView(R.id.iv_add_f)
    ImageView ivAddF;
    @BindView(R.id.tv_f)
    TextView tvF;
    @BindView(R.id.id_pic)
    RelativeLayout idPic;
    @BindView(R.id.tv_tag3)
    TextView tvTag3;
    @BindView(R.id.iv_pic_z_h)
    ImageView ivPicZH;
    @BindView(R.id.iv_add_z_h)
    ImageView ivAddZH;
    @BindView(R.id.tv_z_h)
    TextView tvZH;
    @BindView(R.id.iv_pic_f_h)
    ImageView ivPicFH;
    @BindView(R.id.iv_add_f_h)
    ImageView ivAddFH;
    @BindView(R.id.tv_f_h)
    TextView tvFH;
    @BindView(R.id.id_pic_with_hand)
    RelativeLayout idPicWithHand;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_certification);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("技能认证");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ivPicZ.setOnClickListener(this);
        ivPicF.setOnClickListener(this);
        ivPicZH.setOnClickListener(this);
        ivPicFH.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_pic_z://身份证正面

                break;
            case R.id.iv_pic_f://身份证反面

                break;
            case R.id.iv_pic_z_h://手持正面照

                break;
            case R.id.iv_pic_f_h://手持反面照

                break;
            case R.id.btn_submit://提交

                break;
        }
    }
}
