package com.example.re_find.RedditResponse


import com.google.gson.annotations.SerializedName

data class Image(
    val id: String,
    val resolutions: List<Resolution>,
    val source: Source,
    val variants: Variants
)