package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by FcoPardo on 3/6/16.
 *
 * Base class for creating custom views using a FrameLayout.
 */
public abstract class BaseFrameLayout extends FrameLayout {

    protected int layout = 0;
    protected int parentType = BaseView.PARENT_UNKNOW;

    public BaseFrameLayout(Context context) {
        super(context);
        inflateBaseLayout();
    }

    public BaseFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public BaseFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateBaseLayout();
    }

    protected void inflateBaseLayout(){
        setContainer();
        if(layout>0)BaseView.inflateLayout(layout, getContext(), this);
        inflateComponents();
    }

    protected abstract void inflateComponents();

    protected abstract void setContainer();

    protected Activity getActivity(){
        return BaseView.getActivity(this);
    }

    public int getParentType() {
        return parentType;
    }

    public <T extends BaseFrameLayout> T setParentType(@BaseView.ParentType int parentType) {
        this.parentType = parentType;
        return (T) this;
    }
}
