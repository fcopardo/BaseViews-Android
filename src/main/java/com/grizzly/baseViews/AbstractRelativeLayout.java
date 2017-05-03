package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class AbstractRelativeLayout<T> extends BaseRelativeLayout {

    protected T data;
    protected Class<T> dataClass;

    public AbstractRelativeLayout(Context context) {
        super(context);
        inflateBaseLayout();
    }

    public AbstractRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateBaseLayout();
    }

    public AbstractRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateBaseLayout();
    }

    public void setData(T data){
        this.data = data;
        setControls();
    }

    protected abstract void inflateComponents();

    protected abstract void setContainer();

    protected abstract void setControls();

    protected Activity getActivity(){
        return BaseView.getActivity(this);
    }
}
