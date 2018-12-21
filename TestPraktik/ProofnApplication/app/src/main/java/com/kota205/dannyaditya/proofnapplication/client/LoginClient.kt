package com.kota205.dannyaditya.proofnapplication.client

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException

import java.lang.reflect.Type
import java.net.CookieManager
import java.util.Date
import java.util.concurrent.TimeUnit

import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.JavaNetCookieJar
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson



class LoginClient {

    companion object {

        val BASE_URL = "https://beta.proofn.com/v1/"

        internal var retrofit: Retrofit? = null

        private fun checkClient(): Boolean {
            return retrofit != null
        }

        fun getRetrofit(): Retrofit? {
            return retrofit
        }

        fun getClient(): Retrofit? {

            if (checkClient()) {
                return getRetrofit()
            }

            val interceptor = HttpLoggingInterceptor()

            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val cookieHandler = CookieManager()
            val client = okhttp3.OkHttpClient.Builder().addNetworkInterceptor(interceptor)
                    .cookieJar(JavaNetCookieJar(cookieHandler))
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()

            val gson = GsonBuilder()
                    .setLenient()
                    .registerTypeAdapter(Date::class.java, JsonDeserializer { jsonElement, type, context -> Date(jsonElement.asJsonPrimitive.asLong) })
                    .create()

            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build()
            return retrofit
        }
    }
}
