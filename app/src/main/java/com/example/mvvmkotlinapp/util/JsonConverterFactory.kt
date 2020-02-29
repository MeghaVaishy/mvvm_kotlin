package com.example.mvvmkotlinapp.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

class JsonConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        return JsonConverter<Any>(
            type
        )
    }

    internal class JsonConverter<T>(var type: Type?) :
        Converter<ResponseBody, T> {
        @Throws(IOException::class)
        override fun convert(responseBody: ResponseBody): T {
            val response = responseBody.string()
            val gson = Gson()
            //for List need to check
            if (type is List<*>) {
                type = object : TypeToken<T>() {}.type
            }
            return gson.fromJson("{\"gitRepo\":$response}", type)
        }

    }
}