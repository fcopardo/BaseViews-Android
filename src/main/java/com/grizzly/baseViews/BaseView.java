package com.grizzly.baseViews;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.AsyncLayoutInflater;

/**
 * Created by FcoPardo on 7/6/16.
 */
public class BaseView {

    interface OnInflationFinished{
        void onSuccess(boolean async);
    }

    static View inflateLayout(int layout, Context context, ViewGroup group){
        return inflateLayout(layout, context, group, true);
    }

    static View inflateLayout(int layout, Context context, ViewGroup group, boolean attachToRoot){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(infService);
        return inflater.inflate(layout, group, attachToRoot);
    }

    static void inflateLayout(int layout, Context context, ViewGroup group, AsyncLayoutInflater.OnInflateFinishedListener inflatedListener){
        AsyncLayoutInflater inflater = new AsyncLayoutInflater(context);
        inflater.inflate(layout, group, inflatedListener);
    }

    static void inflateLayout(int layout, Context context, ViewGroup group, final @NonNull OnInflationFinished onInflationFinished, boolean async){
        if(async) {
            AsyncLayoutInflater inflater = new AsyncLayoutInflater(context);
            inflater.inflate(layout, group, new AsyncLayoutInflater.OnInflateFinishedListener() {
                public void onInflateFinished(View view, int resid, ViewGroup parent) {
                    onInflationFinished.onSuccess(true);
                }
            });
        }else{
            inflateLayout(layout, context, group);
            onInflationFinished.onSuccess(false);
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
