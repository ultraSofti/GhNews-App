package com.ultrasoft.ghnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ultrasoft.ghnewsapp.R
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)



        val newsImage: String? = intent.getStringExtra("newsImage")
        Glide.with(this).load(newsImage).into(news_detail_image!!)
        news_headline_tv.text = intent.getStringExtra("newsHeadline")
        news_date_tv.text = intent.getStringExtra("newsDate")
        news_category_tv.text = intent.getStringExtra("newsCategory")
        news_content_tv.text = intent.getStringExtra("newsBody")
    }
}