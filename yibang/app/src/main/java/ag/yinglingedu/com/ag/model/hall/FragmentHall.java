package ag.yinglingedu.com.ag.model.hall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.ag.event.EventTwo;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.widget.StarBar;
import ag.yinglingedu.com.xlibrary.widget.VPSwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 大厅
 * Created by CC on 2017/5/25.
 */

public class FragmentHall extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


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
    @BindView(R.id.tv_xq)
    TextView tvXq;
    @BindView(R.id.tv_fw)
    TextView tvFw;
    @BindView(R.id.ll_tag)
    LinearLayout llTag;
    @BindView(R.id.lv_show)
    ListView lvShow;
    Unbinder unbinder;
    @BindView(R.id.refresh)
    VPSwipeRefreshLayout refresh;
    private List<TestBean> mList;
    private CommonAdapter<TestBean> mAdapter;
    private int type = 0;//类型


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hall, null, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        setListener();
        return view;
    }

    @Override
    public void init() {
        title.setText("大厅");
        ChangeUtil.initialize(getContext());
        EventBus.getDefault().register(this);
        mList = Config.getList();
        int layoutId = R.layout.item_hall_xq;
        changeData(mList, layoutId);//改变数据
    }

    /*改变数据*/
    private void changeData(final List<TestBean> list, final int layoutId) {
        lvShow.setAdapter(mAdapter = new CommonAdapter<TestBean>(getContext(), list, layoutId) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {
                if (layoutId == R.layout.item_hall_fw) {
                    StarBar starBar = (StarBar) (helper.getView(R.id.star_bar));
                    starBar.setStarMark(5.0f);
                    starBar.setCanChangeable(false);//不可改变
                } else if (layoutId == R.layout.item_hall_xq) {

                }
            }
        });
    }

    /*listview滑动时发过来消息，在VPSwipeRefreshLayout中判断是否滑动到顶部，是的就刷新*/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowMessageEvent(EventTwo eventTwo) {
        refresh.setViewGroup(eventTwo.getView());
    }

    @Override
    public void setListener() {
        tvXq.setOnClickListener(this);
        tvFw.setOnClickListener(this);
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (type == 0) {//需求的item
                    startActivity(new Intent(getContext(), ActivityDemandDetail.class));
                } else {//服务的item

                }
            }
        });
        refresh.setOnRefreshListener(this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_xq://需求
                type = 0;
                changeColor(0);//改变颜色
                changeData(mList, R.layout.item_hall_xq);
                break;
            case R.id.tv_fw://服务
                type = 1;
                changeColor(1);//改变颜色
                changeData(mList, R.layout.item_hall_fw);
                break;
        }
    }

    private void changeColor(int i) {
        if (i == 0) {//点击了需求
            ChangeUtil.changeTextViewBackground(tvFw, R.drawable.right_round_button_yellow_border);
            ChangeUtil.changeTextColor(tvFw, R.color.colorTextYellow);
            ChangeUtil.changeTextViewBackground(tvXq, R.drawable.left_round_button_yellow);
            ChangeUtil.changeTextColor(tvXq, R.color.colorWhite);
        } else if (i == 1) {
            ChangeUtil.changeTextViewBackground(tvFw, R.drawable.right_round_button_yellow);
            ChangeUtil.changeTextColor(tvFw, R.color.colorWhite);
            ChangeUtil.changeTextViewBackground(tvXq, R.drawable.left_round_button_yellow_border);
            ChangeUtil.changeTextColor(tvXq, R.color.colorTextYellow);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        refresh.setRefreshing(false);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
