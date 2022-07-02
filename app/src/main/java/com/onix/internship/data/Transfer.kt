package com.onix.internship.data

import com.onix.internship.ui.parser.DictionaryXmlParser

class Transfer(
    private val dictionaryXmlParser: DictionaryXmlParser,
    private val translationStorage: TranslationStorage
) {

    fun passDictionary() {
        translationStorage.saveDictionary(dictionaryXmlParser.parseDict())
    }
}