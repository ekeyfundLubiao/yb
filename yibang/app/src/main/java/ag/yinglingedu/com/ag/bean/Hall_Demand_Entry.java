package ag.yinglingedu.com.ag.bean;

import java.util.List;

/**
 * Created by cpf on 2017/7/10.
 */

public class Hall_Demand_Entry {

    /**
     * cmd : getuserdemand
     * result : 1
     * totalcount : 1
     * list : [{"demand_id":"1","demand_title":"我需要一个小提琴老师","demand_intro":"我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师","demand_status":"0","demand_addtime":"2017-06-24 10:00:00.0","demand_validity":"15"}]
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
         * demand_id : 1
         * demand_title : 我需要一个小提琴老师
         * demand_intro : 我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师我需要一个小提琴老师
         * demand_status : 0
         * demand_addtime : 2017-06-24 10:00:00.0
         * demand_validity : 15
         */

        private String demand_id;
        private String demand_title;
        private String demand_intro;
        private String demand_status;
        private String demand_addtime;
        private String demand_validity;

        public String getDemand_id() {
            return demand_id;
        }

        public void setDemand_id(String demand_id) {
            this.demand_id = demand_id;
        }

        public String getDemand_title() {
            return demand_title;
        }

        public void setDemand_title(String demand_title) {
            this.demand_title = demand_title;
        }

        public String getDemand_intro() {
            return demand_intro;
        }

        public void setDemand_intro(String demand_intro) {
            this.demand_intro = demand_intro;
        }

        public String getDemand_status() {
            return demand_status;
        }

        public void setDemand_status(String demand_status) {
            this.demand_status = demand_status;
        }

        public String getDemand_addtime() {
            return demand_addtime;
        }

        public void setDemand_addtime(String demand_addtime) {
            this.demand_addtime = demand_addtime;
        }

        public String getDemand_validity() {
            return demand_validity;
        }

        public void setDemand_validity(String demand_validity) {
            this.demand_validity = demand_validity;
        }
    }
}
