package com.github.bram209.kson

//    kson {
//        o {
//            "test" to 9
//            !"lok"
//        }
//    }
//
//    kson { !"test" }
//
//    kson { !5 }

class Kson(private val jsonArray: JsonArray) : JsonValue {

    override fun render(builder: StringBuilder, indent: String) {
        return if (jsonArray.children.size == 1) {
            jsonArray.children.first().render(builder, indent)
        } else {
            jsonArray.render(builder, indent)
        }
    }

}

fun kson(init: JsonArray.() -> Unit): String {
    val jsonArray = JsonArray()
    jsonArray.init()
    val json = Kson(jsonArray)
    val builder = StringBuilder()
    json.render(builder, "")
    return builder.toString()
}

fun StringBuilder.indentIfNewLine(indent: String) {
    if (isNotEmpty() && last() == '\n') {
        append(indent)
    }
}
