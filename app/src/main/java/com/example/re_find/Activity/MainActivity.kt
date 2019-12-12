package com.example.re_find.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.re_find.Adapter.PostAdapter
import com.example.re_find.R
import com.example.re_find.Retrofit.RedditAPIService
import com.example.re_find.Model.Children
import com.example.re_find.Retrofit.RedditAPIRequest.callRedditAPI
import com.example.re_find.ViewModel.MainActivityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var keyword: String = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postRecyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.getPosts(keyword, this).observe(this, Observer {
            setupAdapter(it)
        })

        submitBtn.setOnClickListener {
            keyword = subredditSearchEditText.text.toString()
            viewModel.getPosts(keyword, this)
        }
    }

    fun setupAdapter(posts: ArrayList<Children>) {
        val adapter = PostAdapter(this, posts)
        postRecyclerView.adapter = adapter

    }


}
