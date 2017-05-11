package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class AbstractLinearLayout<T> extends BaseLinearLayout {

    protected T data;
    protected Class<T> dataClass;

    public AbstractLinearLayout(Context context) {
        super(context);
    }

    public AbstractLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(T data){
        this.data = data;
        setControls();
    }

    protected abstract void setControls();
}
