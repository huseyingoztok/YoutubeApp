package com.example.husgo.youtubeapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCZNZj3mkdCGJfCoKyl4bSYQ&maxResults=50&key={YOUR_API_KEY}
    @GET("playlists?part=snippet")
    fun tumListeleriGetir(@Query("channelId") channelId:String,@Query("key") key:String,@Query("maxResults") maxResults:Int):Call<PlayListData>
}