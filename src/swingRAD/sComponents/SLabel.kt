package swingRAD.sComponents

import swingRAD.darkWhite
import swingRAD.fontText
import java.awt.Color
import java.awt.Cursor
import java.awt.Font
import javax.swing.ImageIcon
import javax.swing.JLabel
import javax.swing.SwingConstants

class SLabel: JLabel {

    constructor (x: Int, y: Int, icon: ImageIcon, cursor: Cursor? = null) {
        setProperties(x, y, icon, cursor)
    }

    constructor (x: Int, y: Int, width: Int, height: Int, str: String? = "", font: Font? = fontText, fontColor: Color? = darkWhite,
                 hAlignment: String? = "LEFT", background: Color? = null) {
        setProperties(x , y, width, height, str, font, fontColor, hAlignment, background)
    }

    constructor()

    /**
     * icon label
     */
    fun setProperties(x: Int, y: Int, icon: ImageIcon, cursor: Cursor? = null) {
        this.setSize(icon.iconWidth, icon.iconHeight)
        this.setLocation(x, y)
        this.icon = icon
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        this.cursor = cursor
    }

    /**
     * text label
     */
    fun setProperties(x: Int, y: Int, width: Int, height: Int, str: String? = "", font: Font? = fontText, fontColor: Color? = darkWhite,
                             hAlignment: String? = "LEFT", background: Color? = null) {
        this.setBounds(x, y, width, height)
        this.foreground = fontColor
        this.background = background
        this.font = font
        this.text = str
        this.horizontalAlignment = when(hAlignment) {
            "CENTER" -> SwingConstants.CENTER
            "RIGHT" -> SwingConstants.RIGHT
            else -> SwingConstants.LEFT
        }
    }
}