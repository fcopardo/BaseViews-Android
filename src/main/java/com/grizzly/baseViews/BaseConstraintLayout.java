package com.grizzly.baseViews;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.AsyncLayoutInflater;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class BaseConstraintLayout extends ConstraintLayout {

    protected int layout = 0;

    public BaseConstraintLayout(Context context) {
        super(context);
        inflateBaseLayout();
    }

    public BaseConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateBaseLayout();
    }

    public BaseConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
