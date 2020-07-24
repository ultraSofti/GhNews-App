package com.ultrasoft.ghnewsapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ultrasoft.ghnewsapp.Callback.NewsRecyclerItemClickListener
import com.ultrasoft.ghnewsapp.R
import com.ultrasoft.ghnewsapp.data.model.News
import com.ultrasoft.ghnewsapp.ui.NewsDetail


class NewsAdapter (private val news:List<News>,
private var mContext:Context)
    : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.news_item,parent,false))
    }


    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       Glide.with(mContext).load(news[position].newsImage).into(holder.newsImage!!)
        holder.newsHeadline!!.text = news[position].newsHeadline
        holder.newsCategory!!.text = news[position].newsCategory

        holder.setListener(object : NewsRecyclerItemClickListener{
            override fun onItemClick(view: View, pos: Int) {
                //Toast.makeText(context,"Clicked"+pos,Toast.LENGTH_SHORT).show()
                val newsDetailIntent = Intent(mContext,NewsDetail::class.java)
                newsDetailIntent.putExtra("newsImage", news[pos].newsImage)
                newsDetailIntent.putExtra("newsHeadline",news[pos].newsHeadline)
                newsDetailIntent.putExtra("newsCategory",news[pos].newsCategory)
                newsDetailIntent.putExtra("newsBody",news[pos].newsContent)
                newsDetailIntent.putExtra("newsDate",news[pos].newsDate)
                mContext.startActivity(newsDetailIntent)

            }

        })


    }

    inner class MyViewHolder(itemViewHolder:View) : RecyclerView.ViewHolder(itemViewHolder),
    View.OnClickListener{

        private var listener:NewsRecyclerItemClickListener?=null

        fun setListener(listener: NewsRecyclerItemClickListener) {
            this.listener = listener
        }

        var newsHeadline : TextView?=null
        var newsImage : ImageView?=null
        var newsCategory: TextView?=null

        init {
            newsHeadline = itemViewHolder.findViewById(R.id.newsHeadline) as TextView
            newsImage = itemViewHolder.findViewById(R.id.newsImageView) as ImageView
            newsCategory = itemViewHolder.findViewById(R.id.category_tv) as TextView
            itemViewHolder.setOnClickListener(this)

        }

        override fun onClick(view: View?) {
            listener!!.onItemClick(view!!,adapterPosition)
        }

    }


}