package com.mustafa.codechallenge.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mustafa.codechallenge.R
import com.mustafa.codechallenge.data.model.Content
import com.mustafa.codechallenge.data.model.StoryContent
import com.mustafa.codechallenge.databinding.ItemBinding

class MainAdapter(
    private var items: ArrayList<StoryContent> = arrayListOf()
) : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StoryContent) {

            val contentLinkedTreeMap = item.content
            val contentToJson = Gson().toJson(contentLinkedTreeMap)
            val content = Gson().fromJson(contentToJson, Content::class.java)

            binding.tvName.text = content.retailer?.name
            Glide.with(context).load(content.brochureImage)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivImage)
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(items[position])

    fun addData(storyContent: List<StoryContent>) {
        items.addAll(storyContent)
    }
}