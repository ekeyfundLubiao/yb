package ag.yinglingedu.com.ag;

import java.util.ArrayList;
import java.util.List;

import ag.yinglingedu.com.ag.bean.TestBean;

/**
 * Created by M 4700 on 2017/6/2.
 */

public class Config {

    public static final String SP_NAME = "SP_NAME";    //SharedPrefrence名称
    public static final String IS_CERTIFICATION_NAME = "IS_CERTIFICATION_NAME";    //实名认证
    public static final String IS_CERTIFICATION_ZMXY = "IS_CERTIFICATION_ZMXY";    //芝麻信用认证
    public static final String IS_CERTIFICATION_SKILL = "IS_CERTIFICATION_SKILL";   //技能认证
    public static final String IS_RECEIVE_NOTIFICATION = "IS_RECEIVE_NOTIFICATION";   //是否接收通知
    public static final String IS_FIRST_LOGIN = "IS_FIRST_LOGIN";   //是否第一次登录

    public static final String TOKEN_TEST = "mCee2YsVzCqyM/7/7D1f70NMCsYvwW0R/DrVV4TlT/y1IhVHZtLouwDI4STTX4hIvYUFInL/REf5oKlNH0HL9g==";



    /*登陆成功，返回的字段名称*/
    public static final String USER_SUBSCRIBE = "user_subscribe";
    public static final String USER_FANS = "user_fans";
    public static final String USER_INTRO = "user_intro";
    public static final String USER_CITY = "user_city";
    public static final String USER_BIRTHDAY = "user_birthday";   //生日
    public static final String USER_WORKMOBILE = "user_workmobile";
    public static final String USER_REGMOBILE = "user_regmobile";
    public static final String USER_SEX = "user_sex";
    public static final String USER_HEADPIC = "user_headpic";
    public static final String USER_NICKNAME = "user_nickname";
    public static final String USER_NAME = "user_name";
    public static final String TOKEN = "token";
    public static final String USER_ID = "user_id";
    public static final String VERSION_CODE = "version_code";
    public static final String LAST_TIME = "last_time";
    public static final String JD = "jd";//经度
    public static final String WD = "wd";//纬度
    public static final String AD_TOP = "ad_top";//首页顶部广告
    public static final String MID_TOP = "mid_top";//首页顶部广告
    public static final String SERVICE_ID = "service_id";

    private static List<TestBean> list = new ArrayList<>();

    public static List<TestBean> getList(){
        if(list != null && list.size() > 0){
            return list;
        }
        for (int i=0;i<10;i++){
            list.add(new TestBean());
        }
        return list;
    }

    /*服务器地址*/
    public static final String HOST = "http://115.29.165.57:8080/anthelpserver/mobile";
    /*图片地址*/
    public static final String PIC = "http://anthelp.oss-cn-hangzhou.aliyuncs.com/";


    /*测试图片地址*/
    public static final String URL1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496991114&di=6cc23b28709c6236eba301f86eab1bcd&imgtype=jpg&er=1&src=http%3A%2F%2Ftupian.enterdesk.net%2F2013%2F0426%2F20130426013643408.jpg";
    public static final String URL2 ="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4248197044,2393670760&fm=23&gp=0.jpg";
    public static final String URL3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496991320&di=91b814fecea3ec7965754e058bef0b68&imgtype=jpg&er=1&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F176%2F12%2F14B37W7HHR22_1000x500.jpg";
    public static final String URL4 = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3400250439,1070225288&fm=23&gp=0.jpg";
    public static final String URL5 = "http://mpic.tiankong.com/25c/acb/25cacb1aa7d8763340429b01cf04d9ae/C1C7F619288CCE91E63AA87AE264704D.jpg";

    /*一级分类数据*/
    public static final String[] T_YJFL ={"休闲娱乐","居家生活" ,"跑腿办事","教育培训","车务服务","智慧校园","技术服务","丽人时尚","咨询服务"};
    /*二级分类数据*/
    public static final String[] T_XXYL = {"聊天交友" , "占卜算命" , "手绘签名" , "摄像摄影" , "语音娱乐" , "游戏陪玩" , "线下陪玩"};
    public static final String[] T_JJSH = {"智慧社区" , "家电维修" , "家政护理" , "买房装修" , "宴会派对" , "旅游服务" , "宠物" , "租赁服务"};
    public static final String[] T_YDJK = {"运动" , "健身" , "营养膳食"};
    public static final String[] T_PTBS = {"代跑腿" , "代办事"};
    public static final String[] T_JYPX = {"乐器" , "口语" , "舞蹈" , "家教" , "早教" , "绘画" , "书法"};
    public static final String[] T_CWFU = {"购车服务" , "二手车服务" , "车辆保养" , "车辆代办" , "拼租车服务"};
    public static final String[] T_ZHXY = {"校园生活" , "求职就业" , "特色校园"};
    public static final String[] T_JSFW = {"数码维修" , "设计服务" , "营销推广" , "其他外包服务"};
    public static final String[] T_LRSS = {"美甲" , "美容" , "美发"};
    public static final String[] T_ZXFW = {"专业咨询" , "情感咨询" , "法律咨询" , "职业咨询" , "旅游咨询" , "金融理财咨询"};

}
