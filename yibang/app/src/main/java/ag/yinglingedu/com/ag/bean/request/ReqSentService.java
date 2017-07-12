package ag.yinglingedu.com.ag.bean.request;

import ag.yinglingedu.com.ag.bean.BaseRequestBean;

/**
 * Created by Administrator on 2017/7/11.
 */

public class ReqSentService extends BaseRequestBean {

    public String typeid;//  1添加   2编辑 3删除

    //    当typeid=1时，
//    该值为0 当typeid = 2
//    和3时，该值为需求ID值
    public String demand_id;// 需求ID


    public String classid;// 需求分类
    public String title;// 需求标题
    public String intro;// 需求说明;
    public String validity;// 有效期
    public String appointtime;// 预约时间
    //         线下   = 1
    //         线上   =2
    public int servicemode;// 服务方式
    public String longitude;// 进度
    public String latitude;// 纬度
    public String city;// 所在区
    public String address;// 地址

    public ReqSentService(String uid, String token, String cmd,
                          String typeid, String demand_id, String classid,
                          String title, String intro, String validity,
                          String appointtime, int servicemode, String longitude, String latitude, String city, String address) {
        super(uid, token, cmd);
        this.typeid = typeid;
        this.demand_id = demand_id;
        this.classid = classid;
        this.title = title;
        this.intro = intro;
        this.validity = validity;
        this.appointtime = appointtime;
        this.servicemode = servicemode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.address = address;
    }
}
