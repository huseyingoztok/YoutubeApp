package com.example.husgo.youtubeapp

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientApi {
    val BASE_URL="https://www.googleapis.com/youtube/v3/"

    private var retrofit:Retrofit?=null;

     val client: Retrofit?
         get() {
        if (retrofit==null){
            retrofit=Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        return this!!.retrofit
    }
}