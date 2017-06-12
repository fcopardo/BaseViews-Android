package com.grizzly.baseViews;

import android.content.Context;
import android.util.AttributeSet;

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
        if(data != null)setControls();
    }

    protected abstract void setControls();
}
