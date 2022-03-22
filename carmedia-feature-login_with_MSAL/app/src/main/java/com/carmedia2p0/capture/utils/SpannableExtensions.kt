package com.carmedia2p0.capture.utils

import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.*

fun SpannableString.color(start: Int, end: Int, color: Int): SpannableString {
    this.setSpan(ForegroundColorSpan(color), start, end, 0)
    return this
}

fun SpannableString.bold(start: Int, end: Int): SpannableString {
    this.setSpan(StyleSpan(Typeface.BOLD), start, end, 0)
    return this
}

fun SpannableString.fontType(start: Int, end: Int, typeface: Typeface?): SpannableString {
    this.setSpan(FontSpan(typeface), start, end, 0)
    return this
}

fun SpannableString.fontSize(start: Int, end: Int, scaleBy: Float = 1.3F): SpannableString {
    this.setSpan(RelativeSizeSpan(scaleBy), start, end, 0)
    return this
}

fun SpannableString.underline(start: Int, end: Int): SpannableString {
    this.setSpan(UnderlineSpan(), start, end, 0)
    return this
}

fun SpannableString.italic(start: Int, end: Int): SpannableString {
    this.setSpan(StyleSpan(Typeface.ITALIC), start, end, 0)
    return this
}

fun SpannableString.strike(start: Int, end: Int): SpannableString {
    this.setSpan(StrikethroughSpan(), start, end, 0)
    return this
}
