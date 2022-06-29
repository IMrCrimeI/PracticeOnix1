package com.onix.internship.ui.data

import com.onix.internship.ui.parser.DictionaryXmlParser

class Bind(
    private val dictionaryXmlParser: DictionaryXmlParser,
    private val translationStorage: TranslationStorage
) {

    fun bindData() {
        translationStorage.saveDictionary(dictionaryXmlParser.parseDict())
    }
}