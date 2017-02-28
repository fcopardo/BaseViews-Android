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
        inflateBaseLayout();
    }

    public AbstractLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateBaseLayout();
    }

    public AbstractLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
