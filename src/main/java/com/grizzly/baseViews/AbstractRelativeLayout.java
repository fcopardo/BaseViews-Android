package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.AsyncLayoutInflater.OnInflateFinishedListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class AbstractRelativeLayout<T> extends BaseRelativeLayout implements BaseView.OnDataDrivenView<T>{

    protected T data;
    protected Class<T> dataClass;

    public AbstractRelativeLayout(Context context) {
        super(context);
    }

    public AbstractRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AbstractRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(T data){
        this.data = data;
        if(data != null) setControls();
    }

    protected abstract void setControls();

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void inflateBaseLayout(){
        setContainer();
        if(layout>0){
            try{
                BaseView.inflateLayout(layout, getActivity(), this, new OnInflateFinishedListener() {
                    public void onInflateFinished(View view, int resid, ViewGroup parent) {
                        //addView(view);
                        inflateComponents();
                        inflated = true;
                        if(data != null) setData(data);
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
    }
}
