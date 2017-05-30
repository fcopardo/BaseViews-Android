package com.grizzly.baseViews;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.AsyncLayoutInflater;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class BaseConstraintLayout extends ConstraintLayout {

    protected int layout = 0;
    protected boolean inflated = false;

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
            try{
                BaseView.inflateLayout(layout, getActivity(), this, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        addView(view);
                        inflateComponents();
                        inflated = true;
                    }
                });
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
