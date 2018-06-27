package com.grizzly.baseViews

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet

/**
 * Created by FcoPardo on 4/29/18.
 */
open abstract class BaseConstraintLayout : ConstraintLayout, BaseView.OnVariableView {

    override var layout = 0
    override var aParentType = BaseView.PARENT_UNKNOW

    constructor(context : Context) : super(context){
        inflateBaseLayout()
    }
    constructor(context : Context, attrs : AttributeSet) : super(context, attrs) {
        inflateBaseLayout()
    }
    constructor(context : Context, attrs : AttributeSet, styleAttr : Int) : super(context, attrs, styleAttr){
        inflateBaseLayout()
    }
}