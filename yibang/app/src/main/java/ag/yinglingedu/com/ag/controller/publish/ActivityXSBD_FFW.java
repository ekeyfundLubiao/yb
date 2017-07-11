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
 * 新手必读-发服务
 * Created by M 4700 on 2017/6/1.
 */

public class ActivityXSBD_FFW extends BaseActivity {


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
    @BindView(R.id.wv_show)
    ImageView wvShow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xsbd);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
        ivBack.setVisibility(View.VISIBLE);
        title.setText("新手必读");
        ChangeUtil.initialize(this);
        ChangeUtil.setBasckgound(wvShow, R.drawable.xsbd_ffw);

    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
