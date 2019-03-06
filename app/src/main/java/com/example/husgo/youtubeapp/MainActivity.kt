package com.example.husgo.youtubeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val KEY = "AIzaSyCTcK5_0iiMU861e1Kw6x_qVYH5qnJqmgs"
    val CHANNEL_ID = "UCZNZj3mkdCGJfCoKyl4bSYQ"


    var tumListe: List<PlayListData.Items>?=null
    var gelenVeri:PlayListData?=null
    var myAdapter:PlayListAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        var apiInterface = ClientApi.client?.create(ApiInterface::class.java)
        var getCall = apiInterface?.tumListeleriGetir(CHANNEL_ID, KEY,50)

        getCall?.enqueue(object : Callback<PlayListData> {
            override fun onFailure(call: Call<PlayListData>?, t: Throwable?) {
                Log.e("HATA",""+t?.printStackTrace().toString())
            }

            override fun onResponse(call: Call<PlayListData>?, response: Response<PlayListData>?) {

                gelenVeri=response?.body()
                tumListe=gelenVeri?.items

                myAdapter=PlayListAdapter(tumListe)
                myRecylerView.adapter=myAdapter

                myRecylerView.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)


            }

        })





    }
}
