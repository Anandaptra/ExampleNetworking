package com.example.examplenetworking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examplenetworking.databinding.ItemNewsBinding
import com.example.examplenetworking.model.ResponseDataNews
import com.example.examplenetworking.model.ResponseDataNewsItem

class NewsAdapter(var listNews : List<ResponseDataNewsItem>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.binding.titleNews.text = listNews[position].title
        holder.binding.dateNews.text = listNews[position].createdAt
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}