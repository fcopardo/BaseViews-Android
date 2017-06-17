package com.grizzly.baseViews;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.AsyncLayoutInflater.OnInflateFinishedListener;

/**
 * Created by FcoPardo on 7/6/16.
 */
public class BaseView {

    interface OnInflationFinished {
        void onSuccess(boolean async, View view);
    }

    public interface OnDataDrivenView<T>{
        void setData(T data);
    }

    static View inflateLayout(int layout, Context context, ViewGroup group){
        return inflateLayout(layout, context, group, true);
    }

    static View inflateLayout(int layout, Context context, ViewGroup group, boolean attachToRoot){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(infService);
        return inflater.inflate(layout, group, attachToRoot);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    static void inflateLayout(int layout, Context context, ViewGroup group, OnInflateFinishedListener inflatedListener){
        AsyncLayoutInflater inflater = new AsyncLayoutInflater(context);
        inflater.inflate(layout, group, inflatedListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    static void inflateLayout(int layout, Context context, ViewGroup group, final @NonNull OnInflationFinished onInflationFinished, boolean async){
        if(async) {
            AsyncLayoutInflater inflater = new AsyncLayoutInflater(context);
            inflater.inflate(layout, group, new OnInflateFinishedListener() {
                public void onInflateFinished(View view, int resid, ViewGroup parent) {
                    onInflationFinished.onSuccess(true, view);
                }
            });
        }else{
            onInflationFinished.onSuccess(false, inflateLayout(layout, context, group));
        }
    }

    static Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

}
