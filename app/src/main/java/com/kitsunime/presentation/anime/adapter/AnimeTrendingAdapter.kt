package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.common.DiffUtils
import com.kitsunime.data.remote.dto.KitsuResults
import com.kitsunime.databinding.ItemAnimeTrendingListBinding

class AnimeTrendingAdapter : RecyclerView.Adapter<AnimeTrendingAdapter.AnimeTrendingVH>() {

    private var animeResult = listOf<KitsuResults>()

    inner class AnimeTrendingVH(private val binding: ItemAnimeTrendingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: KitsuResults) {
            binding.apply {
                val posterImage = animeResult.attributes.posterImage
                val totalEp = animeResult.attributes.episodeCount

                imageAnimePoster.load(posterImage?.small) {
                    crossfade(1000)
                    error(R.drawable.color_gradient)
                }
                textAnimeTitle.isSelected = true
                textAnimeTitle.text = animeResult.attributes.canonicalTitle
                textAnimeTotalEp.text = if (totalEp != null) "$totalEp Episodes" else "Unknown"
                textAnimeType.text = animeResult.attributes.subtype?.replaceFirstChar { it.uppercase() }
            }
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

    fun submitData(newData: List<KitsuResults>) {
        val animeDiffUtil = DiffUtils(animeResult, newData)
        val diffUtil = DiffUtil.calculateDiff(animeDiffUtil)
        animeResult = newData
        diffUtil.dispatchUpdatesTo(this)
    }

}