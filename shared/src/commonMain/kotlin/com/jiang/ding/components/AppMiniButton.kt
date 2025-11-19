package com.jiang.ding.components

import androidx.compose.runtime.Composable
import com.jiang.ding.view.MiniButton
import com.jiang.ding.view.PhoneNumberResult
import com.tencent.kuikly.compose.extension.MakeKuiklyComposeNode
import com.tencent.kuikly.compose.foundation.layout.fillMaxWidth
import com.tencent.kuikly.compose.ui.Modifier

@Composable
fun AppMiniButton(callback: (PhoneNumberResult) -> Unit) {
    MakeKuiklyComposeNode<MiniButton>(
        factory = {
            MiniButton()
        },
        modifier = Modifier.fillMaxWidth(),
        viewInit = {
            getViewAttr().run {
                text("手机号一键登录")
                type("primary")
                size("default")
                disabled(true)
                openType("getPhoneNumber")
            }
        },
        viewUpdate = {
            it.getViewAttr().run {
                disabled(false)
            }
            it.getViewEvent().run {
                bindGetPhoneNumber { result ->
                    it.getViewAttr().disabled(true)
                    callback(result)
                }
            }
        }
    )
}