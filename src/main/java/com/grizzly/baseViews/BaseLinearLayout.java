package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.AsyncLayoutInflater;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by FcoPardo on 3/6/16.
 *
 * Base class for creating custom views using a LinearLayout.
 */
public abstract class BaseLinearLayout extends LinearLayout {

    protected int layout = 0;

    public BaseLinearLayout(Context context) {
        super(context);
        inflateBaseLayout();
    }

    public BaseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateBaseLayout();
    }

    protected void inflateBaseLayout(){
        setContainer();
        if(layout>0){
            //BaseView.inflateLayout(layout, getContext(), this);
            BaseView.inflateLayout(layout, getContext(), this, new AsyncLayoutInflater.OnInflateFinishedListener() {
                public void onInflateFinished(View view, int resid, ViewGroup parent) {
                    inflateComponents();
                }
            });
        }
        //inflateComponents();
    }

    protected abstract void inflateComponents();

    protected abstract void setContainer();

    protected Activity getActivity(){
        return BaseView.getActivity(this);
    }
}
