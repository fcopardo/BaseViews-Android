@file:JvmName("BaseView")
package com.grizzly.baseViews

import android.content.Context
import android.support.annotation.IntDef
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by FcoPardo on 4/29/18.
 */
class BaseView {

    companion object Instance{

        @JvmStatic
        internal fun inflateLayout(layout: Int, context: Context, group: ViewGroup): View {
            return inflateLayout(layout, context, group, true)
        }

        @JvmStatic
        internal fun inflateLayout(layout: Int, context: Context, group: ViewGroup, attachToRoot: Boolean): View {
            val infService = Context.LAYOUT_INFLATER_SERVICE
            val inflater = context.getSystemService(infService) as LayoutInflater
            return inflater.inflate(layout, group, attachToRoot)
        }
    }

    interface OnDataDrivenView<T> : OnVariableView {
        fun setData(aData : T)
        fun getData(): T?
    }

    interface OnVariableView {

        var layout : Int

        fun ViewGroup.inflateBaseLayout() {
            setContainer()
            if (layout > 0) BaseView.inflateLayout(layout, context, this)
            inflateComponents()
        }

        fun inflateComponents()

        fun setContainer()
    }
}