package com.github.bram209.kson

class JsonObject : JsonElement() {
    infix fun String.eq(that: String) = this eq JsonString(that)
    infix fun String.eq(that: Number) = this eq JsonNumber(that)
    infix fun String.eq(that: JsonValue) {
        children.add(JsonObjectEntry(this, that))
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.indentIfNewLine(indent)
        builder.append("{\n")
        val newIndent = "$indent  "
        children.forEachIndexed { index, value ->
            value.render(builder, newIndent)
            if (index < children.size - 1) {
                builder.append(",\n")
            }
        }
        builder.append("\n$indent}")
    }
}