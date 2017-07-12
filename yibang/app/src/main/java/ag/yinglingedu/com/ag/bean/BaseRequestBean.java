package ag.yinglingedu.com.ag.bean;

/**
 * Created by Administrator on 2017/7/11.
 */

public abstract class BaseRequestBean {
    private String uid;
    private String token;
    private String cmd;

    public BaseRequestBean(String uid, String token, String cmd) {
        this.uid = uid;
        this.token = token;
        this.cmd = cmd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

   // public abstract String ToJsonString();
}
