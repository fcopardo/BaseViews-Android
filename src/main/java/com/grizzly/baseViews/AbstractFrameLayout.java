package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class AbstractFrameLayout<T> extends BaseFrameLayout {

    protected T data;
    protected Class<T> dataClass;

    public AbstractFrameLayout(Context context) {
        super(context);
    }

    public AbstractFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(T data){
        this.data = data;
        setContainer();
    }

    protected abstract void setControls();
}
