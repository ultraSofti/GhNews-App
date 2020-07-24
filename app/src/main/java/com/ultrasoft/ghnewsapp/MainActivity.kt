package com.ultrasoft.ghnewsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ultrasoft.ghnewsapp.adapter.NewsAdapter
import com.ultrasoft.ghnewsapp.data.api.ApiHelper
import com.ultrasoft.ghnewsapp.data.api.RetrofitBuilder
import com.ultrasoft.ghnewsapp.data.model.News
import com.ultrasoft.ghnewsapp.util.Status
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUI()
        setupObservers()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NewsAdapter(arrayListOf(),this)
        mainRecyclerView.addItemDecoration(
            DividerItemDecoration(
                mainRecyclerView.context,
               (mainRecyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        mainRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getCurrentNews().observe(this, Observer { it ->
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        mainRecyclerView.visibility = View.VISIBLE
                        progressbar.visibility = View.GONE
                        resource.data?.let {
                            val listData = it
                            val adapter = NewsAdapter(listData,this)
                            mainRecyclerView.adapter = adapter
                        }
                    }
                    Status.ERROR -> {
                        mainRecyclerView.visibility = View.VISIBLE
                        progressbar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressbar.visibility = View.VISIBLE
                        mainRecyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    companion object{
        const val INTENT_NEWS_KEY = "news"
    }



}