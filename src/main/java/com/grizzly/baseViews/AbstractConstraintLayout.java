package com.grizzly.baseViews;

import android.content.Context;
import android.support.v4.view.AsyncLayoutInflater;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class AbstractConstraintLayout<T> extends BaseConstraintLayout {

    protected T data;
    protected Class<T> dataClass;

    public AbstractConstraintLayout(Context context) {
        super(context);
    }

    public AbstractConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(T data){
        this.data = data;
        if(inflated)setControls();
    }

    protected abstract void setControls();

    @Override
    protected void inflateBaseLayout(){
        setContainer();
        if(layout>0){
            try{
                BaseView.inflateLayout(layout, getActivity(), this, new AsyncLayoutInflater.OnInflateFinishedListener() {
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        addView(view);
                        inflateComponents();
                        inflated = true;
                        if(data != null) setData(data);
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
    }
}
