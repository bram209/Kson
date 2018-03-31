package com.github.bram209.kson

interface JsonValue {
    fun render(builder: StringBuilder, indent: String)
}