package ag.yinglingedu.com.ag.controller.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/7.
 */

public class ActivitySettingConfirm extends BaseActivity {


    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.back)
    View back;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    private final int CODE = 1;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setting_popupwindow);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
    }

    @Override
    public void setListener() {
        tvCancel.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel://取消清除缓存
                intent = getIntent();
                intent.putExtra("type", false);
                setResult(CODE, intent);
                finish();
                break;
            case R.id.tv_confirm://清除缓存
                intent = getIntent();
                intent.putExtra("type", true);
                setResult(CODE, intent);
                finish();
                break;
        }
    }
}
