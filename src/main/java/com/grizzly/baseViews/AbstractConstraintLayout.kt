package com.grizzly.baseViews

import android.content.Context
import android.util.AttributeSet

abstract class AbstractConstraintLayout<T> : BaseConstraintLayout, BaseView.OnDataDrivenView<T> {

    constructor(context : Context) : super(context)
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs)
    constructor(context : Context, attrs : AttributeSet, styleAttr : Int) : super(context, attrs, styleAttr)

    @JvmField
    protected var myData: T? = null
    @JvmField
    protected var dataClass: Class<T>? = null

    override fun <X : BaseView.OnDataDrivenView<T>> setData(aData: T): X {
        this.myData = aData
        if (myData != null) setControls()
        return this as X
    }

    override fun getData(): T? {
        return myData
    }

    protected abstract fun setControls()
}