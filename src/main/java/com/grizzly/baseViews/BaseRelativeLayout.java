package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.AsyncLayoutInflater;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class BaseRelativeLayout extends RelativeLayout {

    protected int layout = 0;
    protected boolean inflated = false;

    public BaseRelativeLayout(Context context) {
        super(context);
        inflateBaseLayout();
    }

    public BaseRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateBaseLayout();
    }

    public BaseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    protected void inflateBaseLayout(){
        setContainer();
        if(layout>0){
            //BaseView.inflateLayout(layout, getContext(), this);
            try{
                BaseView.inflateLayout(layout, getActivity(), this, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        //addView(view);
                        inflateComponents();
                        inflated = true;
                    }
                }, true);
            }catch (InflateException e){
                Log.e("BaseViews", "View inflation failing for class "+getClass().getSimpleName()+" with layout "+layout
                        +"\nresorting to regular inflation ");
                e.printStackTrace();
                BaseView.inflateLayout(layout, getContext(), this);
                inflateComponents();
                inflated = true;
            }
        }
        //inflateComponents();
    }

    protected abstract void inflateComponents();

    protected abstract void setContainer();

    protected Activity getActivity(){
        return BaseView.getActivity(this);
    }
}
