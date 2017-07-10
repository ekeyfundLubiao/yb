package ag.yinglingedu.com.ag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.TestBean;

/**
 * Created by M 4700 on 2017/6/16.
 */

public class AdapterDemandDetail extends BaseAdapter {
    Context mContext;
    List<TestBean> mList;

    public AdapterDemandDetail(Context context, List<TestBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        if (mList != null)
            return mList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mList != null) {
            return mList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_xqxq, null, false);
        return view;
    }
}
