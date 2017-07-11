package ag.yinglingedu.com.ag.controller.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.widget.StarBar;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 管理服务
 * Created by M 4700 on 2017/6/8.
 */

public class ActivityManagementService extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


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
    @BindView(R.id.lv_show)
    ListView lvShow;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_management_service);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        ivBack.setVisibility(View.VISIBLE);
        title.setText("管理服务");
    }

    @Override
    public void setListener() {
        refresh.setOnRefreshListener(this);
        ivBack.setOnClickListener(this);
        lvShow.setAdapter(new CommonAdapter<TestBean>(this, Config.getList(), R.layout.item_management_service) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {
                StarBar starBar = (StarBar) (helper.getView(R.id.star_bar));
                starBar.setStarMark(5.0f);
                starBar.setCanChangeable(false);//不可改变
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false);
    }
}
