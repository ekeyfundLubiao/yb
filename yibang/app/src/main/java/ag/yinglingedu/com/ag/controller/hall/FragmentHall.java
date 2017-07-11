package ag.yinglingedu.com.ag.controller.hall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.lidroid.xutils.exception.HttpException;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.Hall_Demand_Entry;
import ag.yinglingedu.com.ag.bean.Hall_Service_Entry;
import ag.yinglingedu.com.ag.controller.homepage.ActivityServiceDetail;
import ag.yinglingedu.com.ag.util.net.HttpUtil;
import ag.yinglingedu.com.ag.util.net.NetBean;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.ToastUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 大厅
 * Created by CC on 2017/5/25.
 */

public class FragmentHall extends BaseFragment {


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

    Unbinder unbinder;

    @BindView(R.id.refreshlayout)
    TwinklingRefreshLayout refreshlayout;
    @BindView(R.id.listView)
    ListView listView;

    private CommonAdapter<Hall_Demand_Entry.ListBean> demandAdapter;
    private CommonAdapter<Hall_Service_Entry.ListBean> serviceAdapter;

    Hall_Demand_Entry demandEntry = new Hall_Demand_Entry();
    Hall_Service_Entry serviceEntry = new Hall_Service_Entry();

    int type = 0;


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

        refreshlayout.setHeaderView(new ProgressLayout(getContext()));
        refreshlayout.setBottomView(new LoadingView(getContext()));
        refreshlayout.setOverScrollRefreshShow(false);
        refreshlayout.setAutoLoadMore(true);
        refreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                if (type == 0) {
                    getDemand();
                } else {
                    getService();
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {

            }
        });

        refreshlayout.startRefresh();
    }

    private void getDemand() {
        NetBean netBean = new NetBean();
        netBean.setToken(Utils.getSpUtils().getString(Config.TOKEN, ""));
        netBean.setUid(Utils.getSpUtils().getString(Config.USER_ID, ""));
        netBean.setCmd("getuserdemand");
        netBean.setPagesize("20");
        netBean.setPageno("1");

        HttpUtil.post(netBean, new RequsetUtils.OnCompleteListener() {
            @Override
            public void success(String result, int line) {
                demandEntry = JSON.parseObject(result, Hall_Demand_Entry.class);
                if (demandEntry != null && demandEntry.getList() != null) {
                    if (demandAdapter == null) {
                        demandAdapter = new CommonAdapter<Hall_Demand_Entry.ListBean>(getContext(), demandEntry.getList(), R.layout.item_hall_xq) {
                            @Override
                            public void convert(ViewHolder helper, Hall_Demand_Entry.ListBean item) {

                            }
                        };
                        if (type == 0) {
                            listView.setAdapter(demandAdapter);
                        }
                    } else {
                        demandAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void failed(HttpException e, String s, int line) {
                ToastUtils.showShortToast(s);
            }

            @Override
            public void onFinish() {
                refreshlayout.onFinishRefresh();
            }
        });
    }

    private void getService() {
        NetBean netBean = new NetBean();
        netBean.setToken(Utils.getSpUtils().getString(Config.TOKEN, ""));
        netBean.setUid(Utils.getSpUtils().getString(Config.USER_ID, ""));
        netBean.setCmd("getuserservice");
        netBean.setPagesize("20");
        netBean.setPageno("1");

        HttpUtil.post(netBean, new RequsetUtils.OnCompleteListener() {
            @Override
            public void success(String result, int line) {
                serviceEntry = JSON.parseObject(result, Hall_Service_Entry.class);
                if (serviceEntry != null && serviceEntry.getList() != null) {
                    if (serviceAdapter == null) {
                        serviceAdapter = new CommonAdapter<Hall_Service_Entry.ListBean>(getContext(), serviceEntry.getList(), R.layout.item_hall_fw) {
                            @Override
                            public void convert(ViewHolder helper, Hall_Service_Entry.ListBean item) {

                            }
                        };
                        if (type == 1) {
                            listView.setAdapter(serviceAdapter);
                        }
                    } else {
                        serviceAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void failed(HttpException e, String s, int line) {

            }

            @Override
            public void onFinish() {
                refreshlayout.onFinishRefresh();
            }
        });
    }

    @Override
    public void setListener() {

        tvXq.setOnClickListener(this);
        tvFw.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (type == 0) {
                    startActivity(new Intent(getContext(), ActivityDemandDetail.class));
                } else {
                    startActivity(new Intent(getContext(), ActivityServiceDetail.class));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_xq://需求
                type = 0;
                if (demandAdapter != null) {
                    listView.setAdapter(demandAdapter);
                } else {
                    getDemand();
                }
                changeColor(0);//改变颜色
//                changeData(entry.getList(), R.layout.item_hall_xq);
                break;
            case R.id.tv_fw://服务
                type = 1;
                if (serviceAdapter != null) {
                    listView.setAdapter(serviceAdapter);
                } else {
                    getService();
                }
                changeColor(1);//改变颜色
//                changeData(entry.getList(), R.layout.item_hall_fw);
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
    public void onDestroy() {
        super.onDestroy();
    }
}
