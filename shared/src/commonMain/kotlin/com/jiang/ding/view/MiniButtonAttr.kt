package com.jiang.ding.view

import com.tencent.kuikly.core.base.ComposeAttr

internal class MiniButtonAttr : ComposeAttr() {
    /**
     * 设置按钮文本
     */
    fun text(text: String): MiniButtonAttr {
        "text" with text
        return this
    }

    /**
     * 设置按钮类型（primary/default/warn）
     */
    fun type(type: String): MiniButtonAttr {
        "type" with type
        return this
    }

    /**
     * 设置按钮尺寸（mini/default）
     */
    fun size(size: String): MiniButtonAttr {
        "size" with size
        return this
    }

    /**
     * 设置是否禁用
     */
    fun disabled(disabled: Boolean): MiniButtonAttr {
        "disabled" with disabled
        return this
    }

    /**
     * 设置open-type（contact/phoneNumber/email）
     */
    fun openType(openType: String): MiniButtonAttr {
        "openType" with openType
        return this
    }

     /**
      * 设置自定义样式
      */
     fun customStyle(customStyle: String): MiniButtonAttr {
         "customStyle" with customStyle
         return this
     }
}