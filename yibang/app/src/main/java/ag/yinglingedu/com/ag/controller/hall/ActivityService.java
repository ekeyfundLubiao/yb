package ag.yinglingedu.com.ag.controller.hall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;

/**
 * Created by M 4700 on 2017/6/16.
 */

public class ActivityService extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        init();
        setListener();
    }

    @Override
    public void init() {
        initStatus();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
