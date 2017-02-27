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

    public AbstractRelativeLayout(Context context, Class<T> dataClass) {
        super(context);
        this.dataClass = dataClass;
        inflateBaseLayout();
    }

    public AbstractRelativeLayout(Context context, AttributeSet attrs, Class<T> dataClass) {
        super(context, attrs);
        this.dataClass = dataClass;
        inflateBaseLayout();
    }

    public AbstractRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, Class<T> dataClass) {
        super(context, attrs, defStyleAttr);
        this.dataClass = dataClass;
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, Class<T> dataClass) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.dataClass = dataClass;
        inflateBaseLayout();
    }

    public void setData(T data){
        this.data = data;
        setContainer();
    }

    protected abstract void inflateComponents();

    protected abstract void setContainer();

    protected Activity getActivity(){
        return BaseView.getActivity(this);
    }
}
