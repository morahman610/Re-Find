package com.example.re_find.RedditResponse


import com.google.gson.annotations.SerializedName

data class Preview(
    val enabled: Boolean,
    val images: List<Image>
)