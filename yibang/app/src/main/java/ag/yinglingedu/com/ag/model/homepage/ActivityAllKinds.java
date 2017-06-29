package ag.yinglingedu.com.ag.model.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.model.publish.FragmentFXQ_Right;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 全部分类
 * Created by M 4700 on 2017/6/10.
 */

public class ActivityAllKinds extends BaseActivity {

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
    private FragmentAllKinds fragmentRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_kinds);
        ButterKnife.bind(this);


        init();
        setListener();
    }

    @Override
    public void init() {
        ivBack.setVisibility(View.VISIBLE);
        title.setText("全部分类");
        fragmentRight = (FragmentAllKinds)getSupportFragmentManager().findFragmentById(R.id.fragment_right);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       if (v.getId() == R.id.iv_back){
           finish();
       }
    }
}
