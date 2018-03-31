package com.github.bram209.kson

abstract class JsonElement : JsonValue {
    val children = arrayListOf<JsonValue>()

    private fun <T : JsonElement, R> initElement(element: T, init: T.() -> R): T {
        element.init()
        if (this !is JsonObject) children.add(element)
        return element
    }

    fun emptyArray() = JsonArray()
    fun a(init: JsonArray.() -> JsonValue) = initElement(JsonArray(), init)
    fun o(init: JsonObject.() -> Unit) = initElement(JsonObject(), init)
}