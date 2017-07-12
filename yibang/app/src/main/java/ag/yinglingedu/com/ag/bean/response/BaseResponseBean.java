package ag.yinglingedu.com.ag.bean.response;

/**
 * Created by Administrator on 2017/7/11.
 */

public class BaseResponseBean {

    /**
     * cmd : publishservice
     * result : 2
     * retmsg : 处理成功
     */

    private String cmd;
    private int result;
    private String retmsg;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }
}
