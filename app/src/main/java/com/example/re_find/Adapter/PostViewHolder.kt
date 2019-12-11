package com.example.re_find.Adapter

import android.view.View
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.subreddit_item_view.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val postName = itemView.postName
    val subCatName = itemView.subCatName

    override fun onClick(v: View?) {

    }
}