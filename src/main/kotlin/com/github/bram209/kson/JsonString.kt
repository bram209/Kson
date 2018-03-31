package com.github.bram209.kson

data class JsonString(val string: String) : JsonValue {
    override fun render(builder: StringBuilder, indent: String) {
        builder.indentIfNewLine(indent)
        builder.append("\"$string\"")
    }
}