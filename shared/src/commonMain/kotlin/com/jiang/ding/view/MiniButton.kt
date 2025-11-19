package com.jiang.ding.view

import com.tencent.kuikly.core.base.DeclarativeBaseView
import com.tencent.kuikly.core.base.ViewContainer

internal class MiniButton: DeclarativeBaseView<MiniButtonAttr, MiniButtonEvent>() {
    override fun createAttr(): MiniButtonAttr {
        return MiniButtonAttr()
    }

    override fun createEvent(): MiniButtonEvent {
        return MiniButtonEvent()
    }

    override fun viewName(): String {
        return "KRMiniButton"
    }

//    fun bindGetPhoneNumber() {
//        performTaskWhenRenderViewDidLoad {
//            renderView?.callMethod(MiniButtonEvent.GET_PHONE_NUMBER)
//        }
//    }
}
//
//internal fun ViewContainer<*, *>.MiniButton(init: MiniButton.() -> Unit) {
//    addChild(MiniButton(), init)
//}