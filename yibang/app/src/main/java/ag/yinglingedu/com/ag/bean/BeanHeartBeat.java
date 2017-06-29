package ag.yinglingedu.com.ag.bean;

import java.util.List;

/**
 * Created by M 4700 on 2017/6/20.
 */

public class BeanHeartBeat {


    /**
     * cmd : heartbeat
     * result : 1
     * time : 1497943419618
     * retmsg :
     * list : [{"classidlist":"","parentnamelist":"","module":"unit","classmemo":"","classname":"小时","sortid":"0","parentid":"","parentname":"无","pic":"","classid":"hour"},{"classidlist":"","parentnamelist":"","module":"unit","classmemo":"","classname":"天","sortid":"0","parentid":"","parentname":"无","pic":"","classid":"day"},{"classidlist":"","parentnamelist":"","module":"unit","classmemo":"","classname":"个","sortid":"0","parentid":"","parentname":"无","pic":"","classid":"piece"},{"classidlist":"","parentnamelist":"","module":"unit","classmemo":"","classname":"节","sortid":"0","parentid":"","parentname":"无","pic":"","classid":"section"},{"classidlist":"adindex,","parentnamelist":"","module":"ads","classmemo":"","classname":"首页广告","sortid":"1","parentid":"","parentname":"无","pic":"","classid":"adindex"},{"classidlist":"adindex,admidindex,","parentnamelist":"首页广告,","module":"ads","classmemo":"","classname":"首页中间广告","sortid":"2","parentid":"adindex","parentname":"首页广告","pic":"","classid":"admidindex"},{"classidlist":"adindex,adtopindex,","parentnamelist":"首页广告,","module":"ads","classmemo":"","classname":"首页顶部广告","sortid":"1","parentid":"adindex","parentname":"首页广告","pic":"","classid":"adtopindex"},{"classidlist":"jypx,","parentnamelist":"","module":"info","classmemo":"","classname":"教育培训","sortid":"1","parentid":"","parentname":"无","pic":"","classid":"jypx"},{"classidlist":"jypx,xiaoshengchu,","parentnamelist":"","module":"","classmemo":"","classname":"小升初","sortid":"0","parentid":"jypx","parentname":"无","pic":"","classid":"xiaoshengchu"},{"classidlist":"jypx,yqjx,","parentnamelist":"教育培训,","module":"info","classmemo":"","classname":"乐器教学","sortid":"1","parentid":"jypx","parentname":"教育培训","pic":"","classid":"yqjx"},{"classidlist":"shanghai,","parentnamelist":"","module":"city","classmemo":"","classname":"上海市","sortid":"0","parentid":"","parentname":"无","pic":"","classid":"shanghai"},{"classidlist":"shanghai,huangpu,","parentnamelist":"","module":"city","classmemo":"","classname":"黄浦区","sortid":"0","parentid":"","parentname":"无","pic":"","classid":"huangpu"}]
     */

    private String cmd;
    private String result;
    private String time;
    private String retmsg;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * classidlist :
         * parentnamelist :
         * module : unit
         * classmemo :
         * classname : 小时
         * sortid : 0
         * parentid :
         * parentname : 无
         * pic :
         * classid : hour
         */

        private String classidlist;
        private String parentnamelist;
        private String module;
        private String classmemo;
        private String classname;
        private String sortid;
        private String parentid;
        private String parentname;
        private String pic;
        private String classid;

        public String getClassidlist() {
            return classidlist;
        }

        public void setClassidlist(String classidlist) {
            this.classidlist = classidlist;
        }

        public String getParentnamelist() {
            return parentnamelist;
        }

        public void setParentnamelist(String parentnamelist) {
            this.parentnamelist = parentnamelist;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public String getClassmemo() {
            return classmemo;
        }

        public void setClassmemo(String classmemo) {
            this.classmemo = classmemo;
        }

        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        public String getSortid() {
            return sortid;
        }

        public void setSortid(String sortid) {
            this.sortid = sortid;
        }

        public String getParentid() {
            return parentid;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
        }

        public String getParentname() {
            return parentname;
        }

        public void setParentname(String parentname) {
            this.parentname = parentname;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getClassid() {
            return classid;
        }

        public void setClassid(String classid) {
            this.classid = classid;
        }
    }
}
