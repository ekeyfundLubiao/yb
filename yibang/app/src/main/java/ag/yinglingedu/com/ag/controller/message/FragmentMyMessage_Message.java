package ag.yinglingedu.com.ag.controller.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

import ag.yinglingedu.com.ag.APP;
import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.ag.R;
import ag.yinglingedu.com.ag.bean.TestBean;
import ag.yinglingedu.com.ag.event.EventTwo;
import ag.yinglingedu.com.xlibrary.adapter.CommonAdapter;
import ag.yinglingedu.com.xlibrary.adapter.ViewHolder;
import ag.yinglingedu.com.xlibrary.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/**
 * 消息列表
 * Created by M 4700 on 2017/6/2.
 */

public class FragmentMyMessage_Message extends BaseFragment {


    @BindView(R.id.lv_show)
    ListView lvShow;
    Unbinder unbinder;
    private CommonAdapter<Conversation> mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        connect(Utils.getSpUtils().getString(C.TOKEN));//链接服务器
        connect(Config.TOKEN_TEST);//链接服务器
    }

    /**
     * 建立与融云服务器的连接
     *
     * @param token
     */
    private void connect(String token) {
        if (getContext().getApplicationInfo().packageName.equals(APP.getCurProcessName(getContext().getApplicationContext()))) {
            /**
             * IMKit SDK调用第二步,建立与服务器的连接
             */
            RongIMClient.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
                 */
                @Override
                public void onTokenIncorrect() {

                    Log.e("LoginActivity", "------------onTokenIncorrect");
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token
                 */
                @Override
                public void onSuccess(String userid) {
                    Log.e("LoginActivity", "------------------onSuccess---" + userid);
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                    Log.e("LoginActivity", "------------------onError" + errorCode);
                }
            });
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_message_message, null, false);
        unbinder = ButterKnife.bind(this, view);

        init();
        setListener();

        return view;
    }

    @Override
    public void init() {
      /*  RongIMClient.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() {
            @Override
            public void onSuccess(List<Conversation> conversations) {
                LogUtils.e("----------IM"+conversations.toString());
                lvShow.setAdapter(mAdapter = new CommonAdapter<Conversation>(getContext(),conversations,R.layout.item_my_message) {
                    @Override
                    public void convert(ViewHolder helper, Conversation item) {
                        ((SimpleDraweeView)helper.getView(R.id.sdv_headIcon)).setImageURI(Uri.parse(item.getPortraitUrl()));
                        helper.setText(R.id.tv_name,item.getSenderUserName());
//                        helper.setText(R.id.tv_content,item.getLatestMessage().getJsonMentionInfo());
                    }
                });
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

            }
        });*/

        lvShow.setAdapter(new CommonAdapter<TestBean>(getContext(), Config.getList(), R.layout.item_my_message) {
            @Override
            public void convert(ViewHolder helper, TestBean item) {

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
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
