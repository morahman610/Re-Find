package com.example.re_find

import com.example.re_find.RedditResponse.RedditResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditAPIService {

    @GET("/r/{keyword}.json")
    fun getPosts(@Path("keyword") keyword : String) : Observable<RedditResponse>

    //
}