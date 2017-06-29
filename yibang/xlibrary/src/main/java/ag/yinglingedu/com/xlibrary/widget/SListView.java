package ag.yinglingedu.com.xlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by M 4700 on 2017/6/2.
 */

public class SListView extends ListView {
    public SListView(Context context) {
        super(context);
    }

    public SListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
