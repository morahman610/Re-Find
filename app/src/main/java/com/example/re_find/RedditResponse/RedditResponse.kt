package com.example.re_find.RedditResponse


import com.google.gson.annotations.SerializedName

data class RedditResponse(
    val `data`: Data,
    val kind: String
)