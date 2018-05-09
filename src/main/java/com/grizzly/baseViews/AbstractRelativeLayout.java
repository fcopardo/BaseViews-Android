package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

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

    public <X extends BaseView.OnDataDrivenView<T>> X setData(T aData) {
        this.data = data;
        if(data != null)setControls();
        return (X) this;
    }

    public T getData() {
        return data;
    }

    protected abstract void setControls();
}
