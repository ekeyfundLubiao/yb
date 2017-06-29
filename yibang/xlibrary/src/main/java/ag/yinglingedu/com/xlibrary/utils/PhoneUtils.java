package ag.yinglingedu.com.xlibrary.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by M 4700 on 2017/6/14.
 */

public class PhoneUtils {


    public static boolean isMobileNO(String mobiles) {

//        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
//
//        Matcher m = p.matcher(mobiles);
//        return m.matches();


        if (TextUtils.isEmpty(mobiles)) {
            return false;
        }
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(mobiles);
        b = m.matches();
        return b;

    }
}
