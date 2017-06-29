package ag.yinglingedu.com.ag.model.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/8.
 */

public class ActivityAbout extends BaseActivity {

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
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.iv_name)
    ImageView ivName;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.tv_edition)
    TextView tvEdition;
    @BindView(R.id.rl_edition)
    RelativeLayout rlEdition;
    @BindView(R.id.rl_function)
    RelativeLayout rlFunction;
    @BindView(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    @BindView(R.id.tv_edition_tag)
    TextView tvEditionTag;
    @BindView(R.id.tv_company)
    TextView tvCompany;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        init();
        setListener();
    }

    @Override
    public void init() {
        title.setText("关于蚁帮");
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        rlFunction.setOnClickListener(this);//功能介绍
        rlFeedback.setOnClickListener(this);//意见反馈
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_function://功能介绍
                startActivity(new Intent(this,ActivityFunctionIntroduction.class));
                break;
            case R.id.rl_feedback://意见反馈
                startActivity(new Intent(this,ActivityFeedback.class));
                break;
        }
    }
}
