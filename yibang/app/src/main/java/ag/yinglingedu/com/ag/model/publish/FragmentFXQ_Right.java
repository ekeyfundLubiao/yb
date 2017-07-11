package ag.yinglingedu.com.ag.model.publish;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanFXQ;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import ag.yinglingedu.com.xlibrary.utils.ToastUtils;
import ag.yinglingedu.com.xlibrary.widget.SGridView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by M 4700 on 2017/6/8.
 */

public class FragmentFXQ_Right extends BaseFragment {

    @BindView(R.id.lv_show)
    ListView lvShow;
    Unbinder unbinder;
    private List<BeanFXQ> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fxq_right, null, false);
        unbinder = ButterKnife.bind(this, view);

        init();
        setListener();
        return view;
    }

    @Override
    public void init() {
        initData();//初始化数据

        lvShow.setAdapter(new CommonAdapter<BeanFXQ>(getContext(), mList, R.layout.item_fxq_right) {
            @Override
            public void convert(ViewHolder helper, BeanFXQ item) {
                helper.setText(R.id.tv_title, item.getType());//类型
                SGridView gvshow = ((SGridView) helper.getView(R.id.gv_show));
                gvshow.setAdapter(new CommonAdapter<Integer>(getContext(), item.getListBeen(), R.layout.item_fxq_right_gridview) {
                    @Override
                    public void convert(ViewHolder helper, Integer item) {
                        helper.setImageResource(R.id.iv_pic, item.intValue());
                    }
                });
                gvshow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        ToastUtils.showShortToast("111"+view.getId()+"::"+position);
                        Toast.makeText(mContext,"111"+view.getId()+"::"+position,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

    }

    /**
     * 初始化数据
     */
    private void initData() {
        mList = new ArrayList<>();
        List<Integer> listBeen1 = new ArrayList<>();
        listBeen1.add(R.mipmap.ltjy);
        listBeen1.add(R.mipmap.zbsm);
        listBeen1.add(R.mipmap.shqm);
        listBeen1.add(R.mipmap.sxsy);
        listBeen1.add(R.mipmap.yyyl);
        listBeen1.add(R.mipmap.yxpw);
        listBeen1.add(R.mipmap.xxpw);
        mList.add(new BeanFXQ("休闲娱乐", listBeen1));

        List<Integer> listBeen2 = new ArrayList<>();
        listBeen2.add(R.mipmap.zhsq);
        listBeen2.add(R.mipmap.jdwx);
        listBeen2.add(R.mipmap.jzhl);
        listBeen2.add(R.mipmap.mfzx);
        listBeen2.add(R.mipmap.yhpd);
        listBeen2.add(R.mipmap.lyfw);
        listBeen2.add(R.mipmap.cw);
        listBeen2.add(R.mipmap.zlfw);
        mList.add(new BeanFXQ("居家生活", listBeen2));

        List<Integer> listBeen3 = new ArrayList<>();
        listBeen3.add(R.mipmap.yd);
        listBeen3.add(R.mipmap.js);
        listBeen3.add(R.mipmap.yyss);
        mList.add(new BeanFXQ("运动健康", listBeen3));

        List<Integer> listBeen4 = new ArrayList<>();
        listBeen4.add(R.mipmap.dpt);
        listBeen4.add(R.mipmap.dbs);
        mList.add(new BeanFXQ("跑腿办事", listBeen4));

        List<Integer> listBeen5 = new ArrayList<>();
        listBeen5.add(R.mipmap.yq);
        listBeen5.add(R.mipmap.ky);
        listBeen5.add(R.mipmap.wd);
        listBeen5.add(R.mipmap.jj);
        listBeen5.add(R.mipmap.zj);
        listBeen5.add(R.mipmap.hh);
        listBeen5.add(R.mipmap.sf);
        mList.add(new BeanFXQ("教育培训", listBeen5));

        List<Integer> listBeen6 = new ArrayList<>();
        listBeen6.add(R.mipmap.gcfw);
        listBeen6.add(R.mipmap.escfw);
        listBeen6.add(R.mipmap.clby);
        listBeen6.add(R.mipmap.cldb);
        listBeen6.add(R.mipmap.pzcfw);
        mList.add(new BeanFXQ("车务服务", listBeen6));

        List<Integer> listBeen7 = new ArrayList<>();
        listBeen7.add(R.mipmap.xysh);
        listBeen7.add(R.mipmap.qzjy);
        listBeen7.add(R.mipmap.tsxy);
        mList.add(new BeanFXQ("智慧校园", listBeen7));

        List<Integer> listBeen8 = new ArrayList<>();
        listBeen8.add(R.mipmap.smwx);
        listBeen8.add(R.mipmap.sjfw);
        listBeen8.add(R.mipmap.yxtg);
        listBeen8.add(R.mipmap.qtwbfw);
        mList.add(new BeanFXQ("技术服务", listBeen8));

        List<Integer> listBeen9 = new ArrayList<>();
        listBeen9.add(R.mipmap.mj);
        listBeen9.add(R.mipmap.mr);
        listBeen9.add(R.mipmap.mf);
        mList.add(new BeanFXQ("丽人时尚", listBeen9));

        List<Integer> listBeen10 = new ArrayList<>();
        listBeen10.add(R.mipmap.zyzx);
        listBeen10.add(R.mipmap.qgzx);
        listBeen10.add(R.mipmap.flzx);
        listBeen10.add(R.mipmap.zhiyzx);
        listBeen10.add(R.mipmap.lyzx);
        listBeen10.add(R.mipmap.jrlczx);
        mList.add(new BeanFXQ("咨询服务", listBeen10));


    }

    @Override
    public void setListener() {
        lvShow.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                ((ActivityPublish_FXQ) getActivity()).changeLeft(lvShow.getFirstVisiblePosition());
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
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
