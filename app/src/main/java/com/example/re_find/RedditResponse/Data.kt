package com.example.re_find.RedditResponse


import com.google.gson.annotations.SerializedName

data class Data(
    val after: String,
    val before: Any,
    val children: List<Children>,
    val dist: Int,
    val modhash: String
)