package ag.yinglingedu.com.ag.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

import ag.yinglingedu.com.ag.Config;
import ag.yinglingedu.com.xlibrary.utils.RequsetUtils;

/**
 * Created by cpf on 2017/7/10.
 */

public class HttpUtil {

    public static void post(Map value, RequsetUtils.OnCompleteListener listener){

        value.put("token","");

        Map<String, String> map = new HashMap<>();
        map.put("sendmsg", JSON.toJSONString(value));
        map.put("encrypt", "0");
        RequsetUtils.request(listener, Config.HOST,map,0);
    }

}
