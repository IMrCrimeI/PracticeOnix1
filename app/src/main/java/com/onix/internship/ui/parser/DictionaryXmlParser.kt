package com.onix.internship.ui.parser

import android.content.Context
import com.onix.internship.ui.data.DictionaryItem
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

class DictionaryXmlParser(val context: Context) {

    fun parseDict(): List<DictionaryItem> {
        val list = arrayListOf<DictionaryItem>()
        var key = ""
        var value: String

        val inputStream = context.assets.open("dict.xdxf")
        val parserFactory: XmlPullParserFactory = XmlPullParserFactory.newInstance()
        val parser: XmlPullParser = parserFactory.newPullParser()
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true)
        parser.setInput(inputStream, null)
        var tag: String?
        var text = ""
        var event = parser.eventType
        while (event != XmlPullParser.END_DOCUMENT) {
            tag = parser.name
            when (event) {
                XmlPullParser.START_TAG -> if (tag == "ar") {
                    key = ""
                }
                XmlPullParser.TEXT -> {
                    text = parser.text
                    text = text
                        .replace("\"", "")
                        .replace("\n", "")
                        .replace("  ", " - ")
                }
                XmlPullParser.END_TAG -> when (tag) {
                    "k" -> key = text
                    "ar" -> {
                        value = text
                        list.add(DictionaryItem(key, value))
                    }
                }
            }
            event = parser.next()
        }
        return list
    }
}