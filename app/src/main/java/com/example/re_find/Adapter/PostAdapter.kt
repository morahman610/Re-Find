package com.example.re_find.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.re_find.R
import com.example.re_find.RedditResponse.Children
import com.example.re_find.RedditResponse.DataX

class PostAdapter(val context : Context ,val posts : List<Children>) : RecyclerView.Adapter<PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subreddit_item_view, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {

        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.postName.text = posts[position].data.title
        holder.subCatName.text = posts[position].data.subreddit
    }
}