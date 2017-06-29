package ag.yinglingedu.com.xlibrary.base;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CC on 2017/5/25.
 */

public abstract class BaseFragmentActivity extends FragmentActivity implements View.OnClickListener{
    public Map<String,String> map= new HashMap<>();
    /*浸入式状态栏*/
    public void initStatus(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            /*//透明导航栏,如果有导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);*/
        }
    }
    public abstract void init();//初始化
    public abstract void setListener();//设置监听
}
