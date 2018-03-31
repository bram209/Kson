package com.github.bram209.kson

data class JsonObjectEntry(val name: String, val value: JsonValue) : JsonValue {
    override fun render(builder: StringBuilder, indent: String) {
        builder.indentIfNewLine(indent)
        builder.append("\"$name\": ")
        value.render(builder, indent)
    }

}