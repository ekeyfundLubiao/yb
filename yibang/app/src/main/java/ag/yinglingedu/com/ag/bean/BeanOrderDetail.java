package ag.yinglingedu.com.ag.bean;

import java.util.List;

/**
 * Created by M 4700 on 2017/6/25.
 */

public class BeanOrderDetail {
    /**
     * cmd : getorderdetail
     * result : 1
     * totalcount : 1
     * list : [{"order_id":"13","order_orderno":"47054c6f87749d5e2c51ac77d37f01cb","order_type":"1","order_userid":"3","order_productid":"1","order_producttitle":"乐器教学","order_price":"100.00","order_buynum":"5","order_preferential":"100.00","order_orderamount":"500.00","order_paytype":"0","order_status":"0","order_addip":"","order_addtime":"2017-06-25 13:01:28.0","order_servicetime":"2017-09-11 00:00:00.0","order_photos":"","order_message":"车库门保护环境那么好","order_tel":"13868092752","user_nickname":"test3","user_headpic":"jia_baba.png","user_visitcount":"0"}]
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
         * order_id : 13
         * order_orderno : 47054c6f87749d5e2c51ac77d37f01cb
         * order_type : 1
         * order_userid : 3
         * order_productid : 1
         * order_producttitle : 乐器教学
         * order_price : 100.00
         * order_buynum : 5
         * order_preferential : 100.00
         * order_orderamount : 500.00
         * order_paytype : 0
         * order_status : 0
         * order_addip :
         * order_addtime : 2017-06-25 13:01:28.0
         * order_servicetime : 2017-09-11 00:00:00.0
         * order_photos :
         * order_message : 车库门保护环境那么好
         * order_tel : 13868092752
         * user_nickname : test3
         * user_headpic : jia_baba.png
         * user_visitcount : 0
         */

        private String order_id;
        private String order_orderno;
        private String order_type;
        private String order_userid;
        private String order_productid;
        private String order_producttitle;
        private String order_price;
        private String order_buynum;
        private String order_preferential;
        private String order_orderamount;
        private String order_paytype;
        private String order_status;
        private String order_addip;
        private String order_addtime;
        private String order_servicetime;
        private String order_photos;
        private String order_message;
        private String order_tel;
        private String user_nickname;
        private String user_headpic;
        private String user_visitcount;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_orderno() {
            return order_orderno;
        }

        public void setOrder_orderno(String order_orderno) {
            this.order_orderno = order_orderno;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public String getOrder_userid() {
            return order_userid;
        }

        public void setOrder_userid(String order_userid) {
            this.order_userid = order_userid;
        }

        public String getOrder_productid() {
            return order_productid;
        }

        public void setOrder_productid(String order_productid) {
            this.order_productid = order_productid;
        }

        public String getOrder_producttitle() {
            return order_producttitle;
        }

        public void setOrder_producttitle(String order_producttitle) {
            this.order_producttitle = order_producttitle;
        }

        public String getOrder_price() {
            return order_price;
        }

        public void setOrder_price(String order_price) {
            this.order_price = order_price;
        }

        public String getOrder_buynum() {
            return order_buynum;
        }

        public void setOrder_buynum(String order_buynum) {
            this.order_buynum = order_buynum;
        }

        public String getOrder_preferential() {
            return order_preferential;
        }

        public void setOrder_preferential(String order_preferential) {
            this.order_preferential = order_preferential;
        }

        public String getOrder_orderamount() {
            return order_orderamount;
        }

        public void setOrder_orderamount(String order_orderamount) {
            this.order_orderamount = order_orderamount;
        }

        public String getOrder_paytype() {
            return order_paytype;
        }

        public void setOrder_paytype(String order_paytype) {
            this.order_paytype = order_paytype;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public String getOrder_addip() {
            return order_addip;
        }

        public void setOrder_addip(String order_addip) {
            this.order_addip = order_addip;
        }

        public String getOrder_addtime() {
            return order_addtime;
        }

        public void setOrder_addtime(String order_addtime) {
            this.order_addtime = order_addtime;
        }

        public String getOrder_servicetime() {
            return order_servicetime;
        }

        public void setOrder_servicetime(String order_servicetime) {
            this.order_servicetime = order_servicetime;
        }

        public String getOrder_photos() {
            return order_photos;
        }

        public void setOrder_photos(String order_photos) {
            this.order_photos = order_photos;
        }

        public String getOrder_message() {
            return order_message;
        }

        public void setOrder_message(String order_message) {
            this.order_message = order_message;
        }

        public String getOrder_tel() {
            return order_tel;
        }

        public void setOrder_tel(String order_tel) {
            this.order_tel = order_tel;
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
