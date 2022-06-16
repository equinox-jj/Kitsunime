package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kitsunime.common.DiffUtils
import com.kitsunime.data.remote.model.Data
import com.kitsunime.databinding.ItemAnimeTrendingListBinding

class AnimeTrendingAdapter : RecyclerView.Adapter<AnimeTrendingAdapter.AnimeTrendingVH>() {

    private var animeResult = listOf<Data>()

    inner class AnimeTrendingVH(private val binding: ItemAnimeTrendingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: Data) {
            binding.data = animeResult
            binding.executePendingBindings()
            binding.textAnimeTitle.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeTrendingVH {
        val binding = ItemAnimeTrendingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeTrendingVH(binding)
    }

    override fun onBindViewHolder(holder: AnimeTrendingVH, position: Int) {
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