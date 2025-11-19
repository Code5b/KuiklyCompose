package dom

import com.tencent.kuikly.core.render.web.runtime.miniapp.dom.MiniElement
import com.tencent.kuikly.core.render.web.runtime.miniapp.dom.MiniElementUtil

class MiniButtonElement : MiniElement(NODE_NAME, MiniElementUtil.ELEMENT_NODE) {

    companion object {
        const val NODE_NAME = "button" // 小程序原生标签名

        val componentsAlias = js(
            "{_num: '75',text: 'p0',type: 'p1',size: 'p2',disabled: 'p3',openType: 'p4',customStyle: 'p5'}"
        )
    }

    var text: String = ""
        set(value) {
            field = value
            setAttribute("text", value)
        }

    var type: String = "default"
        set(value) {
            field = value
            setAttribute("type", value)
        }

    var size: String = "default"
        set(value) {
            field = value
            setAttribute("size", value)
        }

    var disabled: Boolean = false
        set(value) {
            field = value
            setAttribute("disabled", value.toString())
        }

    var openType: String = ""
        set(value) {
            field = value
            setAttribute("open-type", value) // 对应小程序 open-type 属性
        }

    var customStyle: Map<String, String> = emptyMap()
        set(value) {
            field = value
            val styleStr = value.entries.joinToString(";") { "${it.key}:${it.value}" }
            setAttribute("style", styleStr)
        }

    var getPhoneNumberCallback: ((Any?) -> Unit)? = null

    init {
        bindNativeEvents()
    }

    private fun bindNativeEvents() {
        addEventListener("bindgetphonenumber", { event ->
            getPhoneNumberCallback?.invoke(event.detail)
        })
    }
}