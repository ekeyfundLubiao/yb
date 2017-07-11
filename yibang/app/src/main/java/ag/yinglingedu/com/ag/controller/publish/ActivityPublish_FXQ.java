package ag.yinglingedu.com.ag.controller.publish;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 发需求
 * Created by M 4700 on 2017/6/8.
 */

public class ActivityPublish_FXQ extends BaseActivity {


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
    private FragmentFXQ_Left fragmentLeft;
    private FragmentFXQ_Right fragmentRight;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_fxq);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        title.setText("发需求");
        ivBack.setVisibility(View.VISIBLE);
        ChangeUtil.initialize(this);
        ChangeUtil.setBasckgound(ivRight, R.mipmap.xx_search);
        fragmentLeft = (FragmentFXQ_Left) getSupportFragmentManager().findFragmentById(R.id.fragment_left);
        fragmentRight = (FragmentFXQ_Right) getSupportFragmentManager().findFragmentById(R.id.fragment_right);
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ivRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_right://搜索

                break;
        }
    }

    /**
     * 改变右边菜单
     *
     * @param position
     */
    public void changeRight(int position) {
//        fragmentRight.lvShow.smoothScrollToPosition(position);
        fragmentRight.lvShow.setSelection(position);
    }


    /**
     * 改变左边菜单
     *
     * @param position
     */
    public void changeLeft(int position) {
        fragmentLeft.changeLeft(position);
    }
}
