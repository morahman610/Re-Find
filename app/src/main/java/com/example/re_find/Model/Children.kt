package com.example.re_find.Model

import com.google.gson.annotations.SerializedName


data class Children(
    @SerializedName("data")
    val postData: DataX,
    val kind: String
)