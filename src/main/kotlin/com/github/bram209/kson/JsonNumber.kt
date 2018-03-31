package com.github.bram209.kson

data class JsonNumber<out T : Number>(val number: T) : JsonValue {
    override fun render(builder: StringBuilder, indent: String) {
        builder.indentIfNewLine(indent)
        builder.append(number.toString())
    }

}