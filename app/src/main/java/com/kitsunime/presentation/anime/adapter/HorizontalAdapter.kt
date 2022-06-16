package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kitsunime.common.DiffUtils
import com.kitsunime.data.remote.model.AnimeListResponse
import com.kitsunime.data.remote.model.Data
import com.kitsunime.databinding.ItemHorizontalListBinding

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    private var animeResult = listOf<Data>()

    inner class HorizontalViewHolder(private val binding: ItemHorizontalListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: Data) {
            binding.data = animeResult
            binding.executePendingBindings()
            binding.textAnimeTitle.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val binding = ItemHorizontalListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HorizontalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
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