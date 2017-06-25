package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.AsyncLayoutInflater;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class AbstractConstraintLayout<T> extends BaseConstraintLayout implements BaseView.OnDataDrivenView<T> {

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
        if(inflated && data != null)setControls();
    }

    public T getData(){
        return data;
    }

    protected abstract void setControls();

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void inflateBaseLayout(){
        setContainer();
        if(layout>0){
            if(async){
                if(this.getParent()!= null){
                    BaseView.inflateLayout(layout, getActivity(), (ViewGroup) this.getParent(), new AsyncLayoutInflater.OnInflateFinishedListener() {
                        public void onInflateFinished(View view, int resid, ViewGroup parent) {
                            inflateComponents();
                            inflated = true;
                            if(data != null) setData(data);
                        }
                    }, true);
                }else{
                    BaseView.inflateLayout(layout, getActivity(), this, new AsyncLayoutInflater.OnInflateFinishedListener() {
                        public void onInflateFinished(View view, int resid, ViewGroup parent) {
                            inflateComponents();
                            inflated = true;
                            if(data != null) setData(data);
                        }
                    }, true);
                }
            }else{
                BaseView.inflateLayout(layout, getContext(), this);
                inflateComponents();
                inflated = true;
            }
        }
    }
}
