package ag.yinglingedu.com.ag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ag.yinglingedu.com.ag.C;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanSYLB;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by M 4700 on 2017/6/16.
 */

public class HomepageAdapter extends BaseAdapter {
    Context mContext;
    List<BeanSYLB.ListBean> mList;
    private SimpleDraweeView sdvIcon2;
    private SimpleDraweeView sdvIcon3;

    public HomepageAdapter(Context context, List<BeanSYLB.ListBean> list) {
        mContext = context;
        ChangeUtil.initialize(context);
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
        ViewHolder holder;
        String[] service_photos = mList.get(position).getService_photos().split(",");
        int star_marks = Integer.valueOf(mList.get(position).getService_evaluatestar());
        if (service_photos.length == 1) {//一张图片
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_homepage_listview_one_pic, null, false);
        }else if(service_photos.length == 2){//两张图片
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_homepage_listview_two_pic, null, false);
            sdvIcon2 = (SimpleDraweeView) convertView.findViewById(R.id.sdv_icon2);
            sdvIcon2.setImageURI(C.PIC + service_photos[1]);
        }else if(service_photos.length == 3){//三张图片
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_homepage_listview, null, false);
            sdvIcon2 = (SimpleDraweeView) convertView.findViewById(R.id.sdv_icon2);
            sdvIcon3 = (SimpleDraweeView) convertView.findViewById(R.id.sdv_icon3);
            sdvIcon2.setImageURI(C.PIC + service_photos[1]);
            sdvIcon3.setImageURI(C.PIC + service_photos[2]);
        }
        holder = new ViewHolder(convertView);
        holder.sdvHeadIcon.setImageURI(C.PIC + mList.get(position).getUser_headpic());
        holder.sdvIcon1.setImageURI(C.PIC + service_photos[0]);
        holder.tvName.setText(mList.get(position).getUser_nickname());
        holder.tvName2.setText(mList.get(position).getService_title());
        holder.tvContent.setText(mList.get(position).getService_intro());
        holder.tvWay.setText(mList.get(position).getService_address());
        holder.tvLike.setText(mList.get(position).getService_favcount());
        holder.tvComment.setText(mList.get(position).getService_evaluatecount());
        holder.tvCheck.setText(mList.get(position).getService_clickcount());
        holder.tvPrice.setText(mList.get(position).getService_price()+"元/"+mList.get(position).getService_unit());
        holder.tvFs.setText(mList.get(position).getService_evaluatestar());
        showStars(holder,star_marks);
        return convertView;
    }

    private void showStars(ViewHolder holder,int star_marks) {
        switch (star_marks){
            case 0:
                ChangeUtil.setImageWithID(holder.ivStar1,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar2,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar3,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar4,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar5,R.drawable.star_empty);
                break;
            case 1:
                ChangeUtil.setImageWithID(holder.ivStar2,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar3,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar4,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar5,R.drawable.star_empty);
                break;
            case 2:
                ChangeUtil.setImageWithID(holder.ivStar3,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar4,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar5,R.drawable.star_empty);
                break;
            case 3:
                ChangeUtil.setImageWithID(holder.ivStar4,R.drawable.star_empty);
                ChangeUtil.setImageWithID(holder.ivStar5,R.drawable.star_empty);
                break;
            case 4:
                ChangeUtil.setImageWithID(holder.ivStar5,R.drawable.star_empty);
                break;
        }
    }

    static class ViewHolder {
        @BindView(R.id.sdv_headIcon)
        SimpleDraweeView sdvHeadIcon;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.iv_gz)
        ImageView ivGz;
        @BindView(R.id.tv_jl)
        TextView tvJl;
        @BindView(R.id.sdv_icon1)
        SimpleDraweeView sdvIcon1;
        @BindView(R.id.ll_icon)
        LinearLayout llIcon;
        @BindView(R.id.tv_name2)
        TextView tvName2;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.iv_like)
        ImageView ivLike;
        @BindView(R.id.tv_like)
        TextView tvLike;
        @BindView(R.id.iv_comment)
        ImageView ivComment;
        @BindView(R.id.tv_comment)
        TextView tvComment;
        @BindView(R.id.iv_check)
        ImageView ivCheck;
        @BindView(R.id.tv_check)
        TextView tvCheck;
        @BindView(R.id.tv_way)
        TextView tvWay;
        @BindView(R.id.iv_location)
        ImageView ivLocation;
        @BindView(R.id.line)
        View line;
        @BindView(R.id.tv_yssl)
        TextView tvYssl;
        @BindView(R.id.iv_star1)
        ImageView ivStar1;
        @BindView(R.id.iv_star2)
        ImageView ivStar2;
        @BindView(R.id.iv_star3)
        ImageView ivStar3;
        @BindView(R.id.iv_star4)
        ImageView ivStar4;
        @BindView(R.id.iv_star5)
        ImageView ivStar5;
        @BindView(R.id.ll_star)
        LinearLayout llStar;
        @BindView(R.id.tv_fs)
        TextView tvFs;
        @BindView(R.id.tv_price)
        TextView tvPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
