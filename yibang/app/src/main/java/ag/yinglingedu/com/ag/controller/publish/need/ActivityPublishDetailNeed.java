package ag.yinglingedu.com.ag.controller.publish.need;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zzti.fengyongge.imagepicker.PhotoSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseActivity;
import ag.yinglingedu.com.xlibrary.utils.ChangeUtil;
import ag.yinglingedu.com.xlibrary.widget.SGridView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 发详情
 * Created by M 4700 on 2017/6/8.
 */

public class ActivityPublishDetailNeed extends BaseActivity {


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
    @BindView(R.id.tv_tag1)
    TextView tvTag1;
    @BindView(R.id.rl_yxlm)
    RelativeLayout rlYxlm;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tv_tag2)
    TextView tvTag2;
    @BindView(R.id.et_fwbt)
    EditText etFwbt;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.rl_fwbt)
    RelativeLayout rlFwbt;
    @BindView(R.id.gv_show)
    SGridView gvShow;
    @BindView(R.id.tv_tag3)
    TextView tvTag3;
    @BindView(R.id.et_fwjs)
    EditText etFwjs;
    @BindView(R.id.tv_total2)
    TextView tvTotal2;
    @BindView(R.id.tv_num2)
    TextView tvNum2;
    @BindView(R.id.rl_fwjs)
    RelativeLayout rlFwjs;
    @BindView(R.id.et_fwjg1)
    EditText etFwjg1;
    @BindView(R.id.tv_total3)
    TextView tvTotal3;
    @BindView(R.id.rl_fwjg1)
    RelativeLayout rlFwjg1;
    @BindView(R.id.tv_tag4)
    TextView tvTag4;
    @BindView(R.id.et_fwjg2)
    EditText etFwjg2;
    @BindView(R.id.tv_total4)
    TextView tvTotal4;
    @BindView(R.id.rl_fwjg2)
    RelativeLayout rlFwjg2;
    @BindView(R.id.tv_tag5)
    TextView tvTag5;
    @BindView(R.id.tv_xsfw)
    TextView tvXsfw;
    @BindView(R.id.tv_xxfw)
    TextView tvXxfw;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.tv_leimu)
    TextView tv_leimu;

    private int type = 0;//线下服务:1、线上服务：0
    private List<String> mList;
    private CommonAdapter<String> mAdapter;


    private String firstTypeMeaning;
    private String secondTypeCode;
    private String secondTypeMeaning;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_ffw);
        ButterKnife.bind(this);
        init();
        setListener();
    }


    @Override
    public void init() {
        initStatus();
        getDataFromBundle(getIntent().getExtras());
        ChangeUtil.initialize(this);
        title.setText("发服务");
        ivBack.setVisibility(View.VISIBLE);
        ChangeUtil.changeTextViewBackground(tvXsfw, R.drawable.round_button_border_yellow);
        ChangeUtil.changeTextColor(tvXsfw, R.color.colorWhite);
        tvRight.setText("发布");
        mList = new ArrayList<>();
        mList.add("");//初始化
        gvShow.setAdapter(mAdapter = new CommonAdapter<String>(this, mList, R.layout.item_ffw_pic) {
            @Override
            public void convert(ViewHolder helper, String item) {
                if (mList.size() == 1) {
                    helper.getView(R.id.iv_add).setVisibility(View.VISIBLE);
                    helper.getView(R.id.tv_tag).setVisibility(View.VISIBLE);
//                    ((SimpleDraweeView)helper.getView(R.id.sdv_pic)).setBackgroundResource(R.mipmap.me_rz);
                }/*else{
                    if(!item.equals("")){
                        ((SimpleDraweeView)helper.getView(R.id.sdv_pic)).setImageURI(Uri.parse(item));
                    }else{//最后一个
                        helper.getView(R.id.iv_add).setVisibility(View.VISIBLE);
                        helper.getView(R.id.tv_tag).setVisibility(View.VISIBLE);
                    }
                }*/
            }
        });
        tv_leimu.setText(firstTypeMeaning + " > " + secondTypeMeaning);
    }

    private void getDataFromBundle(Bundle bundle) {
        this.firstTypeMeaning = bundle.getString("firstTypeMeaning");
        this.secondTypeMeaning = bundle.getString("secondTypeMeaning");
        this.secondTypeCode = bundle.getString("secondTypeCode");
    }


    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
        ivRight.setOnClickListener(this);
        tvXsfw.setOnClickListener(this);
        tvXxfw.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        gvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == mList.size() - 1) {
                    Intent intent = new Intent(ActivityPublishDetailNeed.this, PhotoSelectorActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.putExtra("limit", 6);//number是选择图片的数量
                    startActivityForResult(intent, 0);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_xxfw://线下服务:1
                type = 1;
                changeColor(type);//改变颜色
                break;
            case R.id.tv_xsfw://线上服务:0
                type = 0;
                changeColor(type);
                break;
            case R.id.btn_submit://提交

                break;
        }
    }

    private void changeColor(int type) {
        if (type == 1) {
            ChangeUtil.changeTextViewBackground(tvXxfw, R.drawable.round_button_border_yellow);
            ChangeUtil.changeTextColor(tvXxfw, R.color.colorWhite);
            ChangeUtil.changeTextViewBackground(tvXsfw, R.drawable.round_button_border_gray2);
            ChangeUtil.changeTextColor(tvXsfw, R.color.colorTextGray);

        } else {
            ChangeUtil.changeTextViewBackground(tvXsfw, R.drawable.round_button_border_yellow);
            ChangeUtil.changeTextColor(tvXsfw, R.color.colorWhite);
            ChangeUtil.changeTextViewBackground(tvXxfw, R.drawable.round_button_border_gray2);
            ChangeUtil.changeTextColor(tvXxfw, R.color.colorTextGray);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0:
                if (data != null) {

                    List<String> paths = (List<String>) data.getExtras().getSerializable("photos");//path是选择拍照或者图片的地址数组
                    //处理代码
//                    if (paths.size() < 6 && mList.size() != 1){
                    mList.remove(mList.size() - 1);
                    mList.addAll(paths);
                    mList.add("");
                    gvShow.setAdapter(mAdapter = new CommonAdapter<String>(this, mList, R.layout.item_ffw_pic) {
                        @Override
                        public void convert(ViewHolder helper, String item) {
                            if (mList.size() == 1) {
                                helper.getView(R.id.iv_add).setVisibility(View.VISIBLE);
                                helper.getView(R.id.tv_tag).setVisibility(View.VISIBLE);
                            } else {
                                if (!item.equals("")) {
                                    ((SimpleDraweeView) helper.getView(R.id.sdv_pic)).setImageURI(Uri.fromFile(new File(item)));
                                } else {//最后一个
                                    helper.getView(R.id.iv_add).setVisibility(View.VISIBLE);
                                    helper.getView(R.id.tv_tag).setVisibility(View.VISIBLE);
                                }
                            }
                        }
                    });
                    mAdapter.notifyDataSetChanged();
                    /*}else if (mList.size() == 6){

                    }*/
                }
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
