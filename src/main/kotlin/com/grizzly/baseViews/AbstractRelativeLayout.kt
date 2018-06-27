package com.grizzly.baseViews

import android.content.Context
import android.util.AttributeSet

abstract class AbstractRelativeLayout<T> : BaseRelativeLayout, BaseView.OnDataDrivenView<T> {

    constructor(context : Context) : super(context)
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs)
    constructor(context : Context, attrs : AttributeSet, styleAttr : Int) : super(context, attrs, styleAttr)

    @JvmField
    protected var myData: T? = null
    @JvmField
    protected var dataClass: Class<T>? = null

    override fun setData(aData: T) {
        this.myData = aData
        if (myData != null) setControls()
    }

    override fun getData(): T? {
        return myData
    }

    protected abstract fun setControls()
}