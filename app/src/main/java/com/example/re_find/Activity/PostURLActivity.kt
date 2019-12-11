package com.example.re_find.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.re_find.R
import kotlinx.android.synthetic.main.activity_post_url.*

class PostURLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_url)

        val intent = intent
        val postURL = intent.getStringExtra("Post")

        urlTxt.text = postURL
    }
}
