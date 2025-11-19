package com.jiang.ding.view

import com.tencent.kuikly.core.base.ComposeEvent
import com.tencent.kuikly.core.nvi.serialization.json.JSONObject

internal class MiniButtonEvent : ComposeEvent() {
    companion object Companion {
        const val GET_PHONE_NUMBER = "bindgetphonenumber"
    }

    /**
     * 获取用户手机号（对应小程序 bindgetphonenumber）
     */
    fun bindGetPhoneNumber(handler: (PhoneNumberResult) -> Unit) {
        register(GET_PHONE_NUMBER) { params ->
            handler(PhoneNumberResult.decode(params))
        }
    }
}


/**
 * 手机号获取结果数据结构
 * @property code 用户授权码，用于换取用户手机号
 * @property errno 错误码
 * @property errMsg 错误信息，成功时为 null
 */
data class PhoneNumberResult(
    val code: String? = null,
    val errno: String? = null,
    val errMsg: String? = null
) {
    val isSuccess: Boolean get() = !code.isNullOrEmpty()
    val isFailed: Boolean get() = !errMsg.isNullOrEmpty()

    companion object {
        fun decode(params: Any?): PhoneNumberResult {
            val json = params as? JSONObject ?: JSONObject()
            return PhoneNumberResult(
                code = json.optString("code", ""),
                errno = json.optString("errno", ""),
                errMsg = json.optString("errMsg", "")
            )
        }
    }
}