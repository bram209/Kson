package com.github.bram209.kson

open class JsonArray : JsonElement() {
    operator fun String.not() = children.addAndReturn(JsonString(this))
    operator fun <T : Number> T.not() = children.addAndReturn(JsonNumber(this))
    operator fun JsonValue.not() = children.addAndReturn(this)

//    operator fun String.plus(that: String): JsonValue = JsonString(this) + JsonString(that)
//    operator fun String.plus(that: Number): JsonValue = JsonString(this) + JsonNumber(that)
//    operator fun String.plus(that: JsonValue): JsonValue = JsonString(this) + that
//
//    operator fun Number.plus(that: String): JsonValue = JsonNumber(this) + JsonString(that)
//    operator fun Number.plus(that: Number): JsonValue = JsonNumber(this) + JsonNumber(that)
//    operator fun Number.plus(that: JsonValue): JsonValue = JsonNumber(this) + that

    operator fun JsonValue.plus(that: String): JsonValue = this + JsonString(that)
    operator fun JsonValue.plus(that: Number): JsonValue = this + JsonNumber(that)
    operator fun JsonValue.plus(other: JsonValue): JsonValue {
        if (children.isEmpty() && this !is JsonElement) {
            children.add(this)
        }

        if (other !is JsonElement) {
            children.add(other)
        }
        return other
    }

    private fun MutableList<JsonValue>.addAndReturn(value: JsonValue): JsonValue {
        add(value)
        return value
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.indentIfNewLine(indent)
        builder.append("[\n")
        val newIndent = "$indent  "
        children.forEachIndexed { index, value ->
            value.render(builder, newIndent)
            if (index < children.size - 1) {
                builder.append(",\n")
            }
        }
        builder.append("\n$indent]")
    }
}