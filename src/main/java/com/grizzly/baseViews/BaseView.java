package com.grizzly.baseViews;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by FcoPardo on 7/6/16.
 */
public class BaseView {

    static View inflateLayout(int layout, Context context, ViewGroup group){
        return inflateLayout(layout, context, group, true);
    }

    static View inflateLayout(int layout, Context context, ViewGroup group, boolean attachToRoot){
        Log.e("BaseViews", "inflating layout:"+layout);
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(infService);
        return inflater.inflate(layout, group, attachToRoot);
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
