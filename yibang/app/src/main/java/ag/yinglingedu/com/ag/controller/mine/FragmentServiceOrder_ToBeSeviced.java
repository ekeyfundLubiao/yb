package ag.yinglingedu.com.ag.controller.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.ag.event.EventTwo;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 订单服务-全部
 * Created by M 4700 on 2017/5/31.
 */

public class FragmentServiceOrder_ToBeSeviced extends BaseFragment {


    @BindView(R.id.lv_show)
    ListView lvShow;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service_order, null, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        setListener();

        return view;
    }

    @Override
    public void init() {
        List<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new TestBean());
        }
        lvShow.setAdapter(new CommonAdapter<TestBean>(getContext(), list, R.layout.item_service_order) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {
                helper.setText(R.id.tv_type, "待服务");
            }
        });
        lvShow.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                EventBus.getDefault().post(new EventTwo(lvShow));
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
