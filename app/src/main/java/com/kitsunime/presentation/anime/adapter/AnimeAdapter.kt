package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kitsunime.common.DiffUtils
import com.kitsunime.data.remote.model.Data
import com.kitsunime.databinding.ItemAnimeListBinding

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeListVH>() {

    private var animeResult = listOf<Data>()

    inner class AnimeListVH(private val binding: ItemAnimeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: Data) {
            binding.data = animeResult
            binding.executePendingBindings()
            binding.textAnimeTitle.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListVH {
        val binding =
            ItemAnimeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeListVH(binding)
    }

    override fun onBindViewHolder(holder: AnimeListVH, position: Int) {
        holder.bind(animeResult[position])
    }

    override fun getItemCount(): Int = animeResult.size

    fun submitData(newData: List<Data>) {
        val animeDiffUtil = DiffUtils(animeResult, newData)
        val diffUtil = DiffUtil.calculateDiff(animeDiffUtil)
        animeResult = newData
        diffUtil.dispatchUpdatesTo(this)
    }

}