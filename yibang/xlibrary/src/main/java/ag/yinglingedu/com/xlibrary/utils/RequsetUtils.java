package ag.yinglingedu.com.xlibrary.utils;

import android.content.Context;
import android.text.TextUtils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.Map;

/**
 * Created by M 4700 on 2017/6/14.
 */

public class RequsetUtils {
    private static OnCompleteListener mOnCompleteListener;
    private final static String NET_EXCEPTION = "网络异常，请检查网络！";
    private static Context mContext = Utils.getContext();


    /**
     *
     * @param url   请求地址
     * @param map   请求参数
     * @param line  请求线路
     */
    public static void request(OnCompleteListener onCompleteListener,String url, Map<String,String> map, final int line) {
        if(NetWorkUtils.isNetworkConnected(mContext)){//有网
            setOnCompleteListener(onCompleteListener);
            HttpUtils httpUtils = new HttpUtils();
            httpUtils.configCurrentHttpCacheExpiry(1000*10);//设置超时时间
            RequestParams params = new RequestParams();

            for (Map.Entry entry : map.entrySet()) {
                params.addBodyParameter(entry.getKey().toString(),entry.getValue().toString() );//请求参数
            }
            httpUtils.send(HttpRequest.HttpMethod.POST, url,params, new RequestCallBack<String>() {
                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    String result = responseInfo.result.toString();
                    LogUtils.e("----------数据："+result);
                    if(!TextUtils.isEmpty(result))
                    {
                        mOnCompleteListener.success(result,line);
                    }
                }

                @Override
                public void onFailure(HttpException e, String s) {
                    ToastUtils.showLongToast("服务器故障"+e.toString());
                    mOnCompleteListener.failed(e,s,line);
                }
            });
        }else {
            ToastUtils.showShortToast(NET_EXCEPTION);
            mOnCompleteListener.failed(new HttpException(NET_EXCEPTION),NET_EXCEPTION,line);
        }
    }

    private static void setOnCompleteListener(OnCompleteListener onCompleteListener){
        mOnCompleteListener = onCompleteListener;
    }

    public  interface OnCompleteListener{
        public void success(String result,int line);
        public void failed(HttpException e,String s,int line);
    }
}
