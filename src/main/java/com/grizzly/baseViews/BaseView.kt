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

    companion object instance{
        const val PARENT_UNKNOW   : Int = 0x0000
        const val PARENT_LISTVIEW : Int = 0x0001
        const val PARENT_RECYCLER : Int = 0x0002

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

    @Retention(RetentionPolicy.SOURCE)
    @IntDef(PARENT_UNKNOW, PARENT_LISTVIEW, PARENT_RECYCLER)
    annotation class ParentType

    interface OnDataDrivenView<T> : OnVariableView {
        var data: T
    }

    interface OnVariableView {

        var layout : Int
        var aParentType : Int

        fun ViewGroup.inflateBaseLayout() {
            setContainer()
            if (layout > 0) BaseView.inflateLayout(layout, context, this)
            inflateComponents()
        }

        fun inflateComponents()

        fun setContainer()

        fun getParentType(): Int {
            return aParentType.toInt()
        }

        fun <T : OnVariableView> setParentType(@BaseView.ParentType parentType: Int): T {
            this.aParentType = parentType
            return this as T
        }
    }
}