package ag.yinglingedu.com.ag.controller.publish.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.BeanFXQ;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import ag.yinglingedu.com.xlibrary.widget.SGridView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by M 4700 on 2017/6/8.
 */

public class FragmentService_Right extends BaseFragment {

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
            public void convert(ViewHolder helper, final BeanFXQ item) {
                helper.setText(R.id.tv_title, item.getType());//类型
                SGridView gvshow = ((SGridView) helper.getView(R.id.gv_show));
                gvshow.setAdapter(new CommonAdapter<Integer>(getContext(), item.getListBeen(), R.layout.item_fxq_right_gridview) {
                    @Override
                    public void convert(ViewHolder helper, final Integer integer) {
                        helper.setImageResource(R.id.iv_pic, integer.intValue());

                        ImageView iv = helper.getView(R.id.iv_pic);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String firstTypeMeaning = item.getType();
                                Item i = FragmentService_Right.this.getItemByResourceId(integer.intValue());
                                String secondTypeMeaning = i.getMeaning();
                                String secondTypeCode = i.getCode();
                                Intent intent = new Intent(FragmentService_Right.this.getContext(), ActivityPublishServiceDetail.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("firstTypeMeaning", firstTypeMeaning);
                                bundle.putString("secondTypeMeaning", secondTypeMeaning);
                                bundle.putString("secondTypeCode", secondTypeCode);
                                intent.putExtras(bundle);
                                FragmentService_Right.this.startActivity(intent);
                            }
                        });


                    }
                });

                gvshow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        ToastUtils.showShortToast("111"+view.getId()+"::"+position);
                        Toast.makeText(mContext, "111" + view.getId() + "::" + position, Toast.LENGTH_SHORT).show();
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
                ((ActivityPublishSentService) getActivity()).changeLeft(lvShow.getFirstVisiblePosition());
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

    // TODO:
    // 根据资源id得到相应的描述
    private Item getItemByResourceId(int resourceId) {
        String meaning = null;
        String code = null;
        if (resourceId == R.mipmap.ltjy) {
            meaning = "聊天交友";
            code = "ltjy";
        } else if (resourceId == R.mipmap.zbsm) {
            meaning = "占卜算命";
            code = "zbsm";
        } else if (resourceId == R.mipmap.shqm) {
            meaning = "手绘签名";
            code = "shqm";
        } else if (resourceId == R.mipmap.sxsy) {
            meaning = "摄像摄影";
            code = "sxsy";
        } else if (resourceId == R.mipmap.yyyl) {
            meaning = "语音娱乐";
            code = "yyyl";
        } else if (resourceId == R.mipmap.yxpw) {
            meaning = "游戏陪玩";
            code = "yxpw";
        } else if (resourceId == R.mipmap.xxpw) {
            meaning = "线下陪玩";
            code = "xxpw";
        } else if (resourceId == R.mipmap.zhsq) {
            meaning = "智慧社区";
            code = "zhsq";
        } else if (resourceId == R.mipmap.jdwx) {
            meaning = "家电维修";
            code = "jdwx";
        } else if (resourceId == R.mipmap.jzhl) {
            meaning = "家政护理";
            code = "jzhl";
        } else if (resourceId == R.mipmap.mfzx) {
            meaning = "买房装修";
            code = "mfzx";
        } else if (resourceId == R.mipmap.yhpd) {
            meaning = "聚会派对";
            code = "yhpd";
        } else if (resourceId == R.mipmap.lyfw) {
            meaning = "旅游服务";
            code = "lyfw";
        } else if (resourceId == R.mipmap.cw) {
            meaning = "宠物";
            code = "cw";
        } else if (resourceId == R.mipmap.zlfw) {
            meaning = "租赁服务";
            code = "zlfw";
        } else if (resourceId == R.mipmap.yd) {
            meaning = "运动";
            code = "yd";
        } else if (resourceId == R.mipmap.js) {
            meaning = "健身";
            code = "js";
        } else if (resourceId == R.mipmap.yyss) {
            meaning = "营养膳食";
            code = "yyss";
        } else if (resourceId == R.mipmap.dpt) {
            meaning = "代跑腿";
            code = "dpt";
        } else if (resourceId == R.mipmap.dbs) {
            meaning = "代办事";
            code = "dbs";
        } else if (resourceId == R.mipmap.yq) {
            meaning = "乐器";
            code = "yq";
        } else if (resourceId == R.mipmap.ky) {
            meaning = "口语";
            code = "ky";
        } else if (resourceId == R.mipmap.wd) {
            meaning = "舞蹈";
            code = "wd";
        } else if (resourceId == R.mipmap.jj) {
            meaning = "家教";
            code = "jj";
        } else if (resourceId == R.mipmap.zj) {
            meaning = "早教";
            code = "zj";
        } else if (resourceId == R.mipmap.hh) {
            meaning = "绘画";
            code = "hh";
        } else if (resourceId == R.mipmap.sf) {
            meaning = "书法";
            code = "sf";
        } else if (resourceId == R.mipmap.gcfw) {
            meaning = "购车服务";
            code = "gcfw";
        } else if (resourceId == R.mipmap.escfw) {
            meaning = "二手车服务";
            code = "escfw";
        } else if (resourceId == R.mipmap.clby) {
            meaning = "车辆保养";
            code = "clby";
        } else if (resourceId == R.mipmap.cldb) {
            meaning = "车辆代办";
            code = "cldb";
        } else if (resourceId == R.mipmap.pzcfw) {
            meaning = "拼租车服务";
            code = "pzcfw";
        } else if (resourceId == R.mipmap.xysh) {
            meaning = "校园生活";
            code = "xysh";
        } else if (resourceId == R.mipmap.qzjy) {
            meaning = "求职就业";
            code = "qzjy";
        } else if (resourceId == R.mipmap.tsxy) {
            meaning = "特色校园";
            code = "tsxy";
        } else if (resourceId == R.mipmap.smwx) {
            meaning = "数码维修";
            code = "smwx";
        } else if (resourceId == R.mipmap.sjfw) {
            meaning = "设计服务";
            code = "sjfw";
        } else if (resourceId == R.mipmap.yxtg) {
            meaning = "营销推广";
            code = "yxtg";
        } else if (resourceId == R.mipmap.qtwbfw) {
            meaning = "其他外包服务";
            code = "qtwbfw";
        } else if (resourceId == R.mipmap.mj) {
            meaning = "美甲";
            code = "mj";
        } else if (resourceId == R.mipmap.mr) {
            meaning = "美容";
            code = "mr";
        } else if (resourceId == R.mipmap.mf) {
            meaning = "美发";
            code = "mf";
        } else if (resourceId == R.mipmap.zyzx) {
            meaning = "专业咨询";
            code = "zyzx";
        } else if (resourceId == R.mipmap.qgzx) {
            meaning = "情感咨询";
            code = "qgzx";
        } else if (resourceId == R.mipmap.flzx) {
            meaning = "法律咨询";
            code = "flzx";
        } else if (resourceId == R.mipmap.zyzx) {
            meaning = "职业咨询";
            code = "zyzx";
        } else if (resourceId == R.mipmap.lyzx) {
            meaning = "旅游咨询";
            code = "lyzx";
        } else if (resourceId == R.mipmap.jrlczx) {
            meaning = "金融理财咨询";
            code = "jrlczx";
        }

        Item item = new Item();
        item.setCode(code);
        item.setMeaning(meaning);
        return item;
    }

    class Item {
        private String code;
        private String meaning;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMeaning() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }
    }
}
