package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kitsunime.common.DiffUtils
import com.kitsunime.data.remote.model.AnimeListResponse
import com.kitsunime.data.remote.model.Data
import com.kitsunime.databinding.ItemVerticalListBinding

class VerticalAdapter : RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>() {

    private var animeResult = listOf<Data>()

    inner class VerticalViewHolder(private val binding: ItemVerticalListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: Data) {
            binding.data = animeResult
            binding.executePendingBindings()
            binding.textAnimeTitle.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        val binding = ItemVerticalListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VerticalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bind(animeResult[position])
    }

    override fun getItemCount(): Int = animeResult.size

    fun submitData(newData: AnimeListResponse) {
        val animeDiffUtil = DiffUtils(animeResult, newData.data)
        val diffUtil = DiffUtil.calculateDiff(animeDiffUtil)
        animeResult = newData.data
        diffUtil.dispatchUpdatesTo(this)
    }

}