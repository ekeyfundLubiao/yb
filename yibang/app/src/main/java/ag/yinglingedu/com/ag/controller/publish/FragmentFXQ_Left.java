package ag.yinglingedu.com.ag.controller.publish;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by M 4700 on 2017/6/8.
 */

public class FragmentFXQ_Left extends BaseFragment {

    @BindView(R.id.lv_show)
    ListView lvShow;
    Unbinder unbinder;
    private CommonAdapter<String> mAdapter;
    private List<String> mList;
    private int hasBeenChoosed;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fxq_left, null, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        setListener();

        return view;
    }

    @Override
    public void init() {

        hasBeenChoosed = 0;

        mList = new ArrayList<>();
        mList.add("休闲娱乐");
        mList.add("居家生活");
        mList.add("运动健康");
        mList.add("跑腿办事");
        mList.add("教育培训");
        mList.add("车务服务");
        mList.add("智慧校园");
        mList.add("技术服务");
        mList.add("丽人时尚");
        mList.add("咨询服务");
        lvShow.setAdapter(mAdapter = new CommonAdapter<String>(getContext(), mList, R.layout.item_fxq_left) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv_type, item);
                if (helper.getPosition() == 0) {
                    helper.getView(R.id.line).setVisibility(View.VISIBLE);
                    helper.getConvertView().setBackgroundColor(Color.WHITE);
                }
            }
        });
    }

    @Override
    public void setListener() {
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeColor(view, position);//改变选中及清除未选中的颜色
                ((ActivityPublishSentNeed) getActivity()).changeRight(position);
            }
        });
    }

    /*改变选中及清除未选中的颜色*/
    private void changeColor(View view, int position) {
        lvShow.getChildAt(hasBeenChoosed).findViewById(R.id.line).setVisibility(View.GONE);
        ((TextView) lvShow.getChildAt(hasBeenChoosed).findViewById(R.id.tv_type)).setTextColor(ContextCompat.getColor(getContext(), R.color.colorText333333));
        lvShow.getChildAt(hasBeenChoosed).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorBackground));
        hasBeenChoosed = position;
        view.findViewById(R.id.line).setVisibility(View.VISIBLE);
        ((TextView) view.findViewById(R.id.tv_type)).setTextColor(ContextCompat.getColor(getContext(), R.color.colorTextYellow));
        view.setBackgroundColor(Color.WHITE);
    }

    /**
     * 改变菜单
     *
     * @param position
     */
    public void changeLeft(int position) {
        View view = lvShow.getChildAt(position);
        changeColor(view, position);
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
