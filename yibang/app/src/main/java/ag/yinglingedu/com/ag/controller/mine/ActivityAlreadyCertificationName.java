package ag.yinglingedu.com.ag.controller.mine;

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
 * Created by M 4700 on 2017/6/7.
 */

public class ActivityAlreadyCertificationName extends BaseActivity {

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
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.tv_tag2)
    TextView tvTag2;
    @BindView(R.id.rl_id)
    RelativeLayout rlId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_certification_name);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        ivBack.setVisibility(View.VISIBLE);
        title.setText("实名认证");
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
    }
}
