package com.example.re_find.ViewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.re_find.Adapter.PostAdapter
import com.example.re_find.Model.Children
import com.example.re_find.Retrofit.RedditAPIRequest
import com.example.re_find.Retrofit.RedditAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.create

class MainActivityViewModel() : ViewModel() {

    var postsList : MutableLiveData<ArrayList<Children>> = MutableLiveData()
    val redditAPIRequest = RedditAPIRequest
    val compositeDisposable : CompositeDisposable = CompositeDisposable()

    fun getPosts(keyword : String, context: Context): MutableLiveData<ArrayList<Children>> {
        val apiRedditPosts = redditAPIRequest.callRedditAPI(keyword).create(RedditAPIService::class.java)

        compositeDisposable.add(
            apiRedditPosts.getPosts(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    postsList.value = it.data.children as ArrayList<Children>
                }, {
                })
        )

        return postsList
    }

}