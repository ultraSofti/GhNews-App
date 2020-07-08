package com.ultrasoft.ghnewsapp.adapter

import android.content.Context
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ultrasoft.ghnewsapp.R
import com.ultrasoft.ghnewsapp.data.model.News
import java.util.Collections.addAll


class NewsAdapter (private val news:List<News>,
private var context:Context) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item,parent,false))
    }


    override fun getItemCount(): Int {
        Log.i("newsall","this is news size"+ news)
        return news.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       Glide.with(context).load(news[position].newsImage).into(holder.newsImage!!)
        var currentString = news[position].newsImage
        Log.i("currentImg","imageString"+currentString)
        holder.newsHeadline!!.text = news[position].newsHeadline
    }

    inner class MyViewHolder(itemViewHolder:View) : RecyclerView.ViewHolder(itemViewHolder){

        var newsHeadline : TextView?=null
        var newsImage : ImageView?=null

        init {
            newsHeadline = itemViewHolder.findViewById(R.id.newsHeadlines_tv) as TextView
            newsImage = itemViewHolder.findViewById(R.id.newsImage_view) as ImageView
        }

    }


}