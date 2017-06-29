package ag.yinglingedu.com.ag.bean;

import java.util.List;

/**
 * Created by M 4700 on 2017/6/14.
 */

public class BeanUser {
    /**
     * cmd : login
     * retmsg :
     * result : 1
     * token : 84545680525466513878
     * time : 1497415565847
     * userinfo : [{"user_id":"3","user_name":"","user_nickname":"","user_headpic":"","user_sex":"0","user_regmobile":"13868092752","user_workmobile":"","user_birthday":"","user_city":"","user_intro":"","user_authen":"0","user_fans":"0","user_subscribe":"0"}]
     */

    private String cmd;
    private String retmsg;
    private String result;
    private String token;
    private String time;
    private List<UserinfoBean> userinfo;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<UserinfoBean> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(List<UserinfoBean> userinfo) {
        this.userinfo = userinfo;
    }

    public static class UserinfoBean {
        /**
         * user_id : 3
         * user_name :
         * user_nickname :
         * user_headpic :
         * user_sex : 0
         * user_regmobile : 13868092752
         * user_workmobile :
         * user_birthday :
         * user_city :
         * user_intro :
         * user_authen : 0
         * user_fans : 0
         * user_subscribe : 0
         */

        private String user_id;
        private String user_name;
        private String user_nickname;
        private String user_headpic;
        private String user_sex;
        private String user_regmobile;
        private String user_workmobile;
        private String user_birthday;
        private String user_city;
        private String user_intro;
        private String user_authen;
        private String user_fans;
        private String user_subscribe;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
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

        public String getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        public String getUser_regmobile() {
            return user_regmobile;
        }

        public void setUser_regmobile(String user_regmobile) {
            this.user_regmobile = user_regmobile;
        }

        public String getUser_workmobile() {
            return user_workmobile;
        }

        public void setUser_workmobile(String user_workmobile) {
            this.user_workmobile = user_workmobile;
        }

        public String getUser_birthday() {
            return user_birthday;
        }

        public void setUser_birthday(String user_birthday) {
            this.user_birthday = user_birthday;
        }

        public String getUser_city() {
            return user_city;
        }

        public void setUser_city(String user_city) {
            this.user_city = user_city;
        }

        public String getUser_intro() {
            return user_intro;
        }

        public void setUser_intro(String user_intro) {
            this.user_intro = user_intro;
        }

        public String getUser_authen() {
            return user_authen;
        }

        public void setUser_authen(String user_authen) {
            this.user_authen = user_authen;
        }

        public String getUser_fans() {
            return user_fans;
        }

        public void setUser_fans(String user_fans) {
            this.user_fans = user_fans;
        }

        public String getUser_subscribe() {
            return user_subscribe;
        }

        public void setUser_subscribe(String user_subscribe) {
            this.user_subscribe = user_subscribe;
        }
    }
}
