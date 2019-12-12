package com.example.re_find.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.re_find.Activity.PostURLActivity
import com.example.re_find.R
import com.example.re_find.Model.Children
import com.squareup.picasso.Picasso

class PostAdapter(val context: Context, val posts: List<Children>) :
    RecyclerView.Adapter<PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subreddit_item_view, parent, false)

        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {

        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val postData = posts[position].postData

        holder.postName.text = postData.title
        holder.subCatName.text = postData.subreddit

        if (postData.thumbnail.isNotEmpty()) {
            Picasso.get().load(postData.thumbnail).into(holder.postImage)
        }

        holder.itemView.setOnClickListener {

            val postURL = "http://reddit.com" + postData.permalink
            val intent = Intent(context, PostURLActivity::class.java)
            intent.putExtra("PostURL", postURL)
            context.startActivity(intent)
        }
    }
}