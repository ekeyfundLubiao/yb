package ag.yinglingedu.com.xlibrary.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;

import ag.yinglingedu.com.xlibrary.utils.LogUtils;

/**
 * Created by M 4700 on 2017/6/1.
 */

public class VPSwipeRefreshLayout extends SwipeRefreshLayout {

    private float startY;
    private float startX;
    // 记录viewPager是否拖拽的标记
    private boolean mIsVpDragger;
    private final int mTouchSlop;
    private View view;

    public VPSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 记录手指按下的位置
                startY = ev.getY();
                startX = ev.getX();
                // 初始化标记
                mIsVpDragger = false;
                break;
            case MotionEvent.ACTION_MOVE:
                // 如果viewpager正在拖拽中，那么不拦截它的事件，直接return false；
                if(mIsVpDragger) {
                    return false;
                }

                // 获取当前手指位置
                float endY = ev.getY();
                float endX = ev.getX();
                float distanceX = Math.abs(endX - startX);
                float distanceY = Math.abs(endY - startY);
                // 如果X轴位移大于Y轴位移，那么将事件交给viewPager处理。
                if(distanceX > mTouchSlop && distanceX > distanceY) {
                    mIsVpDragger = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // 初始化标记
                mIsVpDragger = false;
                break;
        }
        // 如果是Y轴位移大于X轴，事件交给swipeRefreshLayout处理。
        return super.onInterceptTouchEvent(ev);
    }

    public void setViewGroup(View view) {
        this.view = view;
    }

    /**
     * 子布局是否可以下滑
     * @return
     */
    @Override
    public boolean canChildScrollUp() {

        if (view != null && view instanceof ListView) {
            final ListView listView = (ListView) view;

            if(listView.getFirstVisiblePosition() != 0 || listView.getChildAt(0).getTop() < listView.getPaddingTop()){ //第一个不可见，不刷新
                return true;
            }
        }else if(view != null && view instanceof SScrollView){
            SScrollView sScrollView = (SScrollView)view;
            if(sScrollView.getScrollY() != 0){
                return true;
            }
        }
        return super.canChildScrollUp();
    }
}
