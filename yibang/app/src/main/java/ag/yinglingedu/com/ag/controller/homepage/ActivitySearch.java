package ag.yinglingedu.com.ag.controller.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/19.
 */

public class ActivitySearch extends BaseActivity {

    @BindView(R.id.back_search)
    View backSearch;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_rmss)
    TextView tvRmss;
    @BindView(R.id.gv_show1)
    GridView gvShow1;
    @BindView(R.id.tv_lsss)
    TextView tvLsss;
    @BindView(R.id.gv_show2)
    GridView gvShow2;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        init();
        setListener();
    }

    @Override
    public void init() {
        gvShow1.setAdapter(new CommonAdapter<TestBean>(this, Config.getList(), R.layout.item_search) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {

            }
        });
        gvShow2.setAdapter(new CommonAdapter<TestBean>(this, Config.getList(), R.layout.item_search) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {

            }
        });
    }

    @Override
    public void setListener() {
        tvCancel.setOnClickListener(this);
        ivDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel://取消
                finish();
                break;
            case R.id.iv_delete://删除

                break;
        }
    }
}
