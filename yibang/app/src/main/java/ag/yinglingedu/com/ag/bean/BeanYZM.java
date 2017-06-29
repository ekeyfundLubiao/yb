package ag.yinglingedu.com.ag.bean;

/**
 * 验证码
 * Created by M 4700 on 2017/6/14.
 */

public class BeanYZM {

    /**
     * cmd : getsmscode
     * result : 10
     * retmsg : 处理成功
     */

    private String cmd;
    private String result;
    private String retmsg;

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

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }
}
