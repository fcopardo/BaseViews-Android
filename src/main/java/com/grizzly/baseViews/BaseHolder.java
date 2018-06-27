package com.grizzly.baseViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by fco on 16-06-18.
 */
public class BaseHolder<T extends BaseView.OnDataDrivenView<X>, X> extends RecyclerView.ViewHolder{

    public BaseHolder(T itemView) {
        super((View) itemView);
    }

    public T getView(){
        return (T) this.itemView;
    }

    public void resetData(X data){
        getView().setData(data);
    }
}
