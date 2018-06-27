@file:JvmName("ViewUtils")
package com.grizzly.baseViews

import android.app.Activity
import android.content.ContextWrapper
import android.view.View
/**
 * Created by FcoPardo on 4/29/18.
 */

inline fun <T : View> with(obj: T, f: T.() -> Unit): T {
    obj.f()
    return obj
}

fun View.getActivity(): Activity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }
    return null
}
