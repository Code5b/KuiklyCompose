package components

import com.tencent.kuikly.core.render.web.export.IKuiklyRenderViewExport
import dom.MiniButtonElement
import org.w3c.dom.Element

class KRMiniButton : IKuiklyRenderViewExport {
    companion object {
        const val TEXT = "text"
        const val TYPE = "type"
        const val SIZE = "size"
        const val DISABLED = "disabled"
        const val OPEN_TYPE = "openType"
        const val CUSTOM_STYLE = "customStyle"
        const val VIEW_NAME = "KRMiniButton"
    }

    private val element = MiniButtonElement()
    override val ele: Element
        get() = element.unsafeCast<Element>()

    override fun setProp(propKey: String, propValue: Any): Boolean {
        return when (propKey) {
            TEXT -> {
                element.text = propValue.unsafeCast<String>()
                true
            }

            TYPE -> {
                element.type = propValue.unsafeCast<String>()
                true
            }

            SIZE -> {
                element.size = propValue.unsafeCast<String>()
                true
            }

            DISABLED -> {
                element.disabled = propValue.unsafeCast<Boolean>()
                true
            }

            OPEN_TYPE -> {
                element.openType = propValue.unsafeCast<String>()
                true
            }

            CUSTOM_STYLE -> {
                element.customStyle = propValue.unsafeCast<Map<String, String>>()
                true
            }

            else -> super.setProp(propKey, propValue)
        }
    }
}