package com.example.re_find.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.re_find.Adapter.PostAdapter
import com.example.re_find.R
import com.example.re_find.RedditAPIService
import com.example.re_find.RedditResponse.Children
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var keyword : String = "basketball"
    private var posts = ArrayList<Children>()
    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postRecyclerView.layoutManager = LinearLayoutManager(this)

        compositeDisposable = CompositeDisposable()

        submitBtn.setOnClickListener {
            callRedditAPI(subredditSearchEditText.text.toString())
        }

     //   callRedditAPI(keyword)
    }

    fun setupAdapter(posts : ArrayList<Children>) {
        val adapter = PostAdapter(this, posts)
        postRecyclerView.adapter = adapter

    }

    fun callRedditAPI(keyword : String) {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val apiRedditPosts = retrofit.create(RedditAPIService::class.java)

        compositeDisposable.add(
            apiRedditPosts.getPosts(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    posts = it.data.children as ArrayList<Children>
                    setupAdapter(posts)
                    textView.text = "success"
                }, {
                    textView.text = "Failure " + it.message
                })
        )
    }
}
