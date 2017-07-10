package ag.yinglingedu.com.ag.model.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanMine;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 我的
 * Created by CC on 2017/5/25.
 */

public class FragmentMine extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.sdv_headIcon)
    SimpleDraweeView sdvHeadIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_littleIcon1)
    ImageView ivLittleIcon1;
    @BindView(R.id.iv_littleIcon2)
    ImageView ivLittleIcon2;
    @BindView(R.id.iv_littleIcon3)
    ImageView ivLittleIcon3;
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    @BindView(R.id.view_background)
    View viewBackground;
    @BindView(R.id.gv_show)
    GridView gvShow;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        setListener();

        return view;
    }

    @Override
    public void init() {
        mContext = FragmentMine.this.getContext();
        title.setText("我的");
        ivRight.setVisibility(View.VISIBLE);
        ChangeUtil.setImageWithID(ivRight, R.mipmap.me_zl_sz);
        List<BeanMine> list = new ArrayList<>();
        list.add(new BeanMine("我的余额", R.mipmap.me_zl_wdye));
        list.add(new BeanMine("服务订单", R.mipmap.me_zl_fwdd));
        list.add(new BeanMine("需求订单", R.mipmap.me_zl_xqdd));
        list.add(new BeanMine("收藏服务", R.mipmap.me_zl_scfw));
        list.add(new BeanMine("关注的人", R.mipmap.me_zl_gzdr));
        list.add(new BeanMine("个人认证", R.mipmap.me_zl_grrz));
        list.add(new BeanMine("服务管理", R.mipmap.me_zl_fwgl));
        list.add(new BeanMine("联系客服", R.mipmap.me_zl_lxkf));
        gvShow.setAdapter(new CommonAdapter<BeanMine>(getContext(), list, R.layout.item_mine) {
            @Override
            public void convert(ViewHolder helper, BeanMine item) {
                helper.setText(R.id.tv_name, item.getName());
                helper.setImageResource(R.id.iv_icon, item.getImgId());
            }
        });

    }

    @Override
    public void setListener() {
        ivRight.setOnClickListener(this);
        gvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:         //我的余额
                        startActivity(new Intent(mContext, ActivityMyBalance.class));
                        break;
                    case 1:         //服务订单
                        startActivity(new Intent(mContext, ActivityServiceOrder.class));
                        break;
                    case 2:         //需求订单

                        break;
                    case 3:         //收藏服务
                        startActivity(new Intent(mContext, ActivityCollectionService.class));
                        break;
                    case 4:         //关注的人
                        startActivity(new Intent(mContext, ActivityUserManagement.class));
                        break;
                    case 5:         //个人认证
                        startActivity(new Intent(mContext, ActivityPersonalCertification.class));
                        break;
                    case 6:         //服务管理
                        startActivity(new Intent(mContext, ActivityManagementService.class));
                        break;
                    case 7:         //联系客服

                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_right://设置
                startActivity(new Intent(getContext(), ActivitySetting.class));
                break;

        }
    }
}
