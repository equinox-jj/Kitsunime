package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.databinding.ItemHorizontalBinding
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.presentation.util.DiffUtils
import com.kitsunime.presentation.util.setVisibilityGone

class AnimeTrendingAdapter : RecyclerView.Adapter<AnimeTrendingAdapter.AnimeTrendingVH>() {

    private var animeResult = listOf<KitsuResult>()

    class AnimeTrendingVH(private val binding: ItemHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: KitsuResult) {
            binding.apply {
                val posterImage = animeResult.attributes?.posterImage
                val totalEp = animeResult.attributes?.episodeCount ?: textAnimeTotalEp.setVisibilityGone()

                imageAnimePoster.load(posterImage?.small) {
                    crossfade(1000)
                    error(R.drawable.bg_placeholder)
                }
                textAnimeTitle.isSelected = true
                textAnimeTitle.text = animeResult.attributes?.canonicalTitle
                textAnimeTotalEp.text = "$totalEp Episodes"
                textAnimeType.text = animeResult.attributes?.subtype?.replaceFirstChar { it.uppercase() }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeTrendingVH {
        val binding = ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeTrendingVH(binding)
    }

    override fun onBindViewHolder(holder: AnimeTrendingVH, position: Int) {
        holder.bind(animeResult[position])
    }

    override fun getItemCount(): Int = animeResult.size

    fun submitData(newData: List<KitsuResult>) {
        val oldData = DiffUtils(animeResult, newData)
        val result = DiffUtil.calculateDiff(oldData)
        animeResult = newData
        result.dispatchUpdatesTo(this)
    }

}