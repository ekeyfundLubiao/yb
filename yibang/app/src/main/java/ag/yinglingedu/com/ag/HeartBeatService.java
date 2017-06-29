package ag.yinglingedu.com.ag;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ag.yinglingedu.com.ag.bean.BeanHeartBeat;
import ag.yinglingedu.com.xlibrary.utils.LogUtils;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.SPUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;

/**
 * Created by M 4700 on 2017/6/20.
 */

public class HeartBeatService extends Service implements Runnable ,RequsetUtils.OnCompleteListener{
    private Thread mThread;
    public int count = 0;
    private static String KEY_REST_MSG = "KEY_REST_MSG";
    public Map<String,String> map = new HashMap<>();//存放访问网络所需参数

    @Override
    public void run() {
        while (true) {
            try {
                if (count > 1) {
                    Log.i("@qi", "offline");
                    count = 1;
                }
                //向服务器发送心跳包
                map.clear();
                //请求数据
                map.put("sendmsg","{\"cmd\":\"heartbeat\",\"uid\":\""+ Utils.getSpUtils().getString(C.USER_ID,"")+"\",\"token\":\""
                        +Utils.getSpUtils().getString(C.TOKEN,"")+"\",\"version\":\""+Utils.getSpUtils().getString(C.VERSION_CODE,"")+
                        "\",\"lastupatetime\":\""+Utils.getSpUtils().getString(C.LAST_TIME,"")+"\",\"longitude\":\""+
                        Utils.getSpUtils().getString(C.JD,"")+"\",\"latitude\":\""+Utils.getSpUtils().getString(C.WD,"")+"\"}");
                map.put("encrypt","0");
                RequsetUtils.request(this,C.HOST,map,count);
                count += 1;
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mThread.interrupt();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mThread = new Thread(this);
        mThread.start();
        count = 0;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void success(String result, int line) {
//        Utils.getSpUtils().put(C.LAST_TIME,);
        BeanHeartBeat beanHeartBeat = new Gson().fromJson(result,BeanHeartBeat.class);

        if(beanHeartBeat.getTime() != null && !beanHeartBeat.getTime().equals("")){
            //上次心跳包时间
            Utils.getSpUtils().put(C.LAST_TIME,beanHeartBeat.getTime());
        }

        String retmsg = beanHeartBeat.getRetmsg();//数据及安装包更新状态标志
        if(result!= null && !retmsg.equals("")){
            String[] split = retmsg.split("\\|");
            if(split[0].equals("1")){//List数据有更新

            }
            if(Integer.valueOf(split[1]) > 0){//有系统消息

            }
            if(split[2].equals("1")){//有更新包

            }
        }

    }

    @Override
    public void failed(HttpException e, String s, int line) {

    }
}

