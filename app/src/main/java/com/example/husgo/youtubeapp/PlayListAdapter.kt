package com.example.husgo.youtubeapp

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_layout.view.*

class PlayListAdapter(var tumListe: List<PlayListData.Items>?) : RecyclerView.Adapter<PlayListAdapter.myViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): myViewHolder {
        var inflater = LayoutInflater.from(parent?.context)
        var tek_satir = inflater.inflate(R.layout.tek_satir_layout, parent, false)

        return myViewHolder(tek_satir)
    }

    override fun getItemCount(): Int {
        return tumListe?.size!!
    }

    override fun onBindViewHolder(holder: myViewHolder?, position: Int) {
        holder?.setData(tumListe?.get(position), position)
    }


    inner class myViewHolder(tek_satir: View?) : RecyclerView.ViewHolder(tek_satir) {


        var myCardView = tek_satir as CardView
        var currTitle = myCardView.tvTitle
        var currImg=myCardView.imgResim

        fun setData(get: PlayListData.Items?, position: Int) {
            currTitle.text=get?.snippet?.title
            Picasso.get().load(get?.snippet?.thumbnails?.high?.url).into(currImg);
        }


    }


}