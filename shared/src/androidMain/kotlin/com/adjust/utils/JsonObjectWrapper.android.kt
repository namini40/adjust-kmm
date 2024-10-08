package com.adjust.utils

import org.json.JSONObject

class JSONObjectWrapperAndroid(private val jsonObject: JSONObject) : JSONObjectWrapper{
    override fun toString(): String {
        return jsonObject.toString()
    }
}
