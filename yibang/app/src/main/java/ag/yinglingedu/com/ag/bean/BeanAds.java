package ag.yinglingedu.com.ag.bean;

import java.util.List;

/**
 * Created by M 4700 on 2017/6/21.
 */

public class BeanAds {

    /**
     * cmd : getads
     * result : 1
     * totalcount : 2
     * list : [{"adendtime":"2017-07-20 12:10:00.0","adinfotitle":"亲亲口香糖","adinfopic":"4.png,5.png,6.png","adinfoaddtime":"2017-06-07 12:10:00.0","adinfourl":"","adbegintime":"2017-06-07 12:10:00.0","classid":"admidindex","adinfoid":"2"},{"adendtime":"2017-07-20 12:10:00.0","adinfotitle":"大白兔奶糖","adinfopic":"1.png,2.png,3.png","adinfoaddtime":"2017-06-07 12:10:00.0","adinfourl":"","adbegintime":"2017-06-07 12:10:00.0","classid":"adtopindex","adinfoid":"1"}]
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
         * adendtime : 2017-07-20 12:10:00.0
         * adinfotitle : 亲亲口香糖
         * adinfopic : 4.png,5.png,6.png
         * adinfoaddtime : 2017-06-07 12:10:00.0
         * adinfourl :
         * adbegintime : 2017-06-07 12:10:00.0
         * classid : admidindex
         * adinfoid : 2
         */

        private String adendtime;
        private String adinfotitle;
        private String adinfopic;
        private String adinfoaddtime;
        private String adinfourl;
        private String adbegintime;
        private String classid;
        private String adinfoid;

        public String getAdendtime() {
            return adendtime;
        }

        public void setAdendtime(String adendtime) {
            this.adendtime = adendtime;
        }

        public String getAdinfotitle() {
            return adinfotitle;
        }

        public void setAdinfotitle(String adinfotitle) {
            this.adinfotitle = adinfotitle;
        }

        public String getAdinfopic() {
            return adinfopic;
        }

        public void setAdinfopic(String adinfopic) {
            this.adinfopic = adinfopic;
        }

        public String getAdinfoaddtime() {
            return adinfoaddtime;
        }

        public void setAdinfoaddtime(String adinfoaddtime) {
            this.adinfoaddtime = adinfoaddtime;
        }

        public String getAdinfourl() {
            return adinfourl;
        }

        public void setAdinfourl(String adinfourl) {
            this.adinfourl = adinfourl;
        }

        public String getAdbegintime() {
            return adbegintime;
        }

        public void setAdbegintime(String adbegintime) {
            this.adbegintime = adbegintime;
        }

        public String getClassid() {
            return classid;
        }

        public void setClassid(String classid) {
            this.classid = classid;
        }

        public String getAdinfoid() {
            return adinfoid;
        }

        public void setAdinfoid(String adinfoid) {
            this.adinfoid = adinfoid;
        }
    }
}
