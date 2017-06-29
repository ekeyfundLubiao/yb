package ag.yinglingedu.com.ag;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;
import com.zaaach.citypicker.model.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ag.yinglingedu.com.ag.bean.BeanHeartBeat;
import ag.yinglingedu.com.ag.database.DatabaseHelper;
import ag.yinglingedu.com.xlibrary.utils.LogUtils;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;
import ag.yinglingedu.com.xlibrary.utils.SPUtils;
import ag.yinglingedu.com.xlibrary.utils.Utils;
import io.rong.imlib.RongIMClient;

/**
 * Created by CC on 2017/5/25.
 */

public class APP extends Application implements RequsetUtils.OnCompleteListener{
    private SPUtils spUtils;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;

    public Map<String,String> map = new HashMap<>();

    //声明定位回调监听器
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation location) {
            if (null != location) {

//                StringBuffer sb = new StringBuffer();
                //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
                if (location.getErrorCode() == 0) {
                    Utils.getSpUtils().put(C.JD, location.getLongitude()+"");
                    Utils.getSpUtils().put(C.WD, location.getLatitude()+"");
                    Utils.getSpUtils().put(C.USER_CITY, location.getCity());
                    LogUtils.e("---------"+Utils.getSpUtils().getString(C.USER_CITY));
                }
                   /* sb.append("定位成功" + "\n");
                    sb.append("定位类型: " + location.getLocationType() + "\n");
                    sb.append("经    度    : " + location.getLongitude() + "\n");
                    sb.append("纬    度    : " + location.getLatitude() + "\n");
                    sb.append("精    度    : " + location.getAccuracy() + "米" + "\n");
                    sb.append("提供者    : " + location.getProvider() + "\n");

                    sb.append("速    度    : " + location.getSpeed() + "米/秒" + "\n");
                    sb.append("角    度    : " + location.getBearing() + "\n");
                    // 获取当前提供定位服务的卫星个数
                    sb.append("星    数    : " + location.getSatellites() + "\n");
                    sb.append("国    家    : " + location.getCountry() + "\n");
                    sb.append("省            : " + location.getProvince() + "\n");
                    sb.append("市            : " + location.getCity() + "\n");
                    sb.append("城市编码 : " + location.getCityCode() + "\n");
                    sb.append("区            : " + location.getDistrict() + "\n");
                    sb.append("区域 码   : " + location.getAdCode() + "\n");
                    sb.append("地    址    : " + location.getAddress() + "\n");
                    sb.append("兴趣点    : " + location.getPoiName() + "\n");
                    //定位完成的时间
//                    sb.append("定位时间: " + Utils.formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
                } else {
                    //定位失败
                    sb.append("定位失败" + "\n");
                    sb.append("错误码:" + location.getErrorCode() + "\n");
                    sb.append("错误信息:" + location.getErrorInfo() + "\n");
                    sb.append("错误描述:" + location.getLocationDetail() + "\n");
                }
                //定位之后的回调时间
//                sb.append("回调时间: " + Utils.formatUTC(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + "\n");

                //解析定位结果，
                String result = sb.toString();
//                tvResult.setText(result);
                LogUtils.e("-----------"+result);*/
            } else {
//                tvResult.setText("定位失败，loc is null");
                LogUtils.e("-----------"+"定位失败");
            }
        }
    };
    private AMapLocationClientOption mLocationOption;
    public DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        Fresco.initialize(this);
        databaseHelper = new DatabaseHelper(this);

        Utils.getSpUtils().put(C.IS_CERTIFICATION_NAME, false);//实名认证-默认未认证
        Utils.getSpUtils().put(C.IS_CERTIFICATION_ZMXY, false);//芝麻信用-默认未认证
        Utils.getSpUtils().put(C.IS_CERTIFICATION_SKILL, false);//技能认证-默认未认证
        Utils.getSpUtils().put(C.IS_RECEIVE_NOTIFICATION, true);//技能认证-默认未认证
        /*融云初始化*/
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {
            RongIMClient.init(this);
        }

        /*高德地图定位配置*/
        mLocationClient = new AMapLocationClient(this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mLocationClient.setLocationListener(locationListener);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为10000ms
        mLocationOption.setInterval(10000);
        //设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

        map.put("sendmsg","{\"cmd\":\"heartbeat\",\"uid\":\""+ ""+"\",\"token\":\""
                +""+"\",\"version\":\""+""+
                "\",\"lastupatetime\":\""+""+"\",\"longitude\":\""+
                ""+"\",\"latitude\":\""+""+"\"}");
        map.put("encrypt","0");
        RequsetUtils.request(this,C.HOST,map,0);
    }

    /*获取进程名称*/
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }


    @Override
    public void success(String result, int line) {
        databaseHelper.cleanTab("tab_city");
        databaseHelper.cleanTab("tab_kinds_one");
        databaseHelper.cleanTab("tab_kinds_two");
        BeanHeartBeat beanHeartBeat = new Gson().fromJson(result,BeanHeartBeat.class);
        List<BeanHeartBeat.ListBean> list =  beanHeartBeat.getList();
        for (BeanHeartBeat.ListBean bean:list) {
            Utils.getSpUtils().put(bean.getClassname(),bean.getClassid());
            if(bean.getModule().equals("city") && bean.getParentname().equals("无")){//为城市的时候
                LogUtils.e("--------"+bean.getClassname()+"----"+bean.getClassid());
                databaseHelper.insertCity(new City(bean.getClassname(),bean.getClassid()));
            }else if(bean.getModule().equals("info")){
                if(bean.getParentname().equals("无")) {//一级分类

                }else{//二级分类

                }
            }
        }

    }

    @Override
    public void failed(HttpException e, String s, int line) {

    }
}
