package com.grizzly.baseViews;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.IntDef;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by FcoPardo on 7/6/16.
 */
public class BaseView {

    public static final int PARENT_UNKNOW = 0x0000;
    public static final int PARENT_LISTVIEW = 0x0001;
    public static final int PARENT_RECYCLER = 0x0002;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({PARENT_UNKNOW, PARENT_LISTVIEW, PARENT_RECYCLER})
    public @interface ParentType{}


    public interface OnDataDrivenView<T>{
        void setData(T data);
        T getData();
    }

    static View inflateLayout(int layout, Context context, ViewGroup group){
        return inflateLayout(layout, context, group, true);
    }

    static View inflateLayout(int layout, Context context, ViewGroup group, boolean attachToRoot){
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
