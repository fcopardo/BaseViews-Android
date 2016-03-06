package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class BaseRelativeLayout extends RelativeLayout {

    protected int layout = 0;

    public BaseRelativeLayout(Context context) {
        super(context);
    }

    public BaseRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void inflateBaseLayout(){
        setContainer();
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(infService);
        inflater.inflate(layout, this, true);
        inflateComponents();
    }

    protected abstract void inflateComponents();

    protected abstract void setContainer();
}
