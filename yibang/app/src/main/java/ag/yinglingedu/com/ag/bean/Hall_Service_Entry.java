package ag.yinglingedu.com.ag.bean;

import java.util.List;

/**
 * Created by cpf on 2017/7/11.
 */

public class Hall_Service_Entry {

    /**
     * cmd : getuserservice
     * result : 1
     * totalcount : 1
     * list : [{"service_id":"1","service_userid":"1","service_classid":"yqjx","service_title":"乐器教学","service_intro":"乐器教学乐器教学乐器教学乐器教学乐器教学乐器教学乐器教学乐器教学","service_message":"","service_photos":"","service_servicetime":"1","service_servicemode":"1","service_unit":"hour","service_price":"100","service_city":"huangpu","service_address":"上海市重庆北路208号","service_longitude":"121.4890761","service_latitude":"31.2108042","service_clickcount":"0","service_ordercount":"0","service_evaluatecount":"0","service_evaluatestar":"0","service_favcount":"0","service_status":"1","service_updatetime":"2017-06-05 20:00:00.0","service_addip":"210.1.1.1","service_addtime":"2017-06-05 20:00:00.0","user_nickname":"test","user_headpic":"icon.png","user_visitcount":"0"}]
     */

    private String cmd;
    private String result;
    private String totalcount;
    private List<ListBean> list;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * service_id : 1
         * service_userid : 1
         * service_classid : yqjx
         * service_title : 乐器教学
         * service_intro : 乐器教学乐器教学乐器教学乐器教学乐器教学乐器教学乐器教学乐器教学
         * service_message :
         * service_photos :
         * service_servicetime : 1
         * service_servicemode : 1
         * service_unit : hour
         * service_price : 100
         * service_city : huangpu
         * service_address : 上海市重庆北路208号
         * service_longitude : 121.4890761
         * service_latitude : 31.2108042
         * service_clickcount : 0
         * service_ordercount : 0
         * service_evaluatecount : 0
         * service_evaluatestar : 0
         * service_favcount : 0
         * service_status : 1
         * service_updatetime : 2017-06-05 20:00:00.0
         * service_addip : 210.1.1.1
         * service_addtime : 2017-06-05 20:00:00.0
         * user_nickname : test
         * user_headpic : icon.png
         * user_visitcount : 0
         */

        private String service_id;
        private String service_userid;
        private String service_classid;
        private String service_title;
        private String service_intro;
        private String service_message;
        private String service_photos;
        private String service_servicetime;
        private String service_servicemode;
        private String service_unit;
        private String service_price;
        private String service_city;
        private String service_address;
        private String service_longitude;
        private String service_latitude;
        private String service_clickcount;
        private String service_ordercount;
        private String service_evaluatecount;
        private String service_evaluatestar;
        private String service_favcount;
        private String service_status;
        private String service_updatetime;
        private String service_addip;
        private String service_addtime;
        private String user_nickname;
        private String user_headpic;
        private String user_visitcount;

        public String getService_id() {
            return service_id;
        }

        public void setService_id(String service_id) {
            this.service_id = service_id;
        }

        public String getService_userid() {
            return service_userid;
        }

        public void setService_userid(String service_userid) {
            this.service_userid = service_userid;
        }

        public String getService_classid() {
            return service_classid;
        }

        public void setService_classid(String service_classid) {
            this.service_classid = service_classid;
        }

        public String getService_title() {
            return service_title;
        }

        public void setService_title(String service_title) {
            this.service_title = service_title;
        }

        public String getService_intro() {
            return service_intro;
        }

        public void setService_intro(String service_intro) {
            this.service_intro = service_intro;
        }

        public String getService_message() {
            return service_message;
        }

        public void setService_message(String service_message) {
            this.service_message = service_message;
        }

        public String getService_photos() {
            return service_photos;
        }

        public void setService_photos(String service_photos) {
            this.service_photos = service_photos;
        }

        public String getService_servicetime() {
            return service_servicetime;
        }

        public void setService_servicetime(String service_servicetime) {
            this.service_servicetime = service_servicetime;
        }

        public String getService_servicemode() {
            return service_servicemode;
        }

        public void setService_servicemode(String service_servicemode) {
            this.service_servicemode = service_servicemode;
        }

        public String getService_unit() {
            return service_unit;
        }

        public void setService_unit(String service_unit) {
            this.service_unit = service_unit;
        }

        public String getService_price() {
            return service_price;
        }

        public void setService_price(String service_price) {
            this.service_price = service_price;
        }

        public String getService_city() {
            return service_city;
        }

        public void setService_city(String service_city) {
            this.service_city = service_city;
        }

        public String getService_address() {
            return service_address;
        }

        public void setService_address(String service_address) {
            this.service_address = service_address;
        }

        public String getService_longitude() {
            return service_longitude;
        }

        public void setService_longitude(String service_longitude) {
            this.service_longitude = service_longitude;
        }

        public String getService_latitude() {
            return service_latitude;
        }

        public void setService_latitude(String service_latitude) {
            this.service_latitude = service_latitude;
        }

        public String getService_clickcount() {
            return service_clickcount;
        }

        public void setService_clickcount(String service_clickcount) {
            this.service_clickcount = service_clickcount;
        }

        public String getService_ordercount() {
            return service_ordercount;
        }

        public void setService_ordercount(String service_ordercount) {
            this.service_ordercount = service_ordercount;
        }

        public String getService_evaluatecount() {
            return service_evaluatecount;
        }

        public void setService_evaluatecount(String service_evaluatecount) {
            this.service_evaluatecount = service_evaluatecount;
        }

        public String getService_evaluatestar() {
            return service_evaluatestar;
        }

        public void setService_evaluatestar(String service_evaluatestar) {
            this.service_evaluatestar = service_evaluatestar;
        }

        public String getService_favcount() {
            return service_favcount;
        }

        public void setService_favcount(String service_favcount) {
            this.service_favcount = service_favcount;
        }

        public String getService_status() {
            return service_status;
        }

        public void setService_status(String service_status) {
            this.service_status = service_status;
        }

        public String getService_updatetime() {
            return service_updatetime;
        }

        public void setService_updatetime(String service_updatetime) {
            this.service_updatetime = service_updatetime;
        }

        public String getService_addip() {
            return service_addip;
        }

        public void setService_addip(String service_addip) {
            this.service_addip = service_addip;
        }

        public String getService_addtime() {
            return service_addtime;
        }

        public void setService_addtime(String service_addtime) {
            this.service_addtime = service_addtime;
        }

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }

        public String getUser_headpic() {
            return user_headpic;
        }

        public void setUser_headpic(String user_headpic) {
            this.user_headpic = user_headpic;
        }

        public String getUser_visitcount() {
            return user_visitcount;
        }

        public void setUser_visitcount(String user_visitcount) {
            this.user_visitcount = user_visitcount;
        }
    }
}
