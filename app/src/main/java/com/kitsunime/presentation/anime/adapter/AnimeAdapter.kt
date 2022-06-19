package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.common.DiffUtils
import com.kitsunime.data.remote.model.Data
import com.kitsunime.databinding.ItemAnimeListBinding

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeListVH>() {

    private var animeResult = listOf<Data>()

    inner class AnimeListVH(private val binding: ItemAnimeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: Data) {
            binding.apply {
                val coverImage = animeResult.attributes.coverImage
                val posterImage = animeResult.attributes.posterImage
                val releaseDate = animeResult.attributes.startDate
                val duration = animeResult.attributes.episodeLength
                val totalEp = animeResult.attributes.episodeCount
                val categoryMap = animeResult.relationships.categories?.data?.size

                imageAnimeCover.load(coverImage?.small) {
                    crossfade(800)
                    error(R.drawable.color_gradient)
                }
                imageAnimePoster.load(posterImage?.small) {
                    crossfade(800)
                    error(R.drawable.color_gradient)
                }
                textAnimeTitle.isSelected = true
                textAnimeTitle.text = animeResult.attributes.canonicalTitle
                textAnimeCategory.text = "Category : $categoryMap"
                textAnimeReleaseDate.text = if (releaseDate != null) "Release Date : $releaseDate" else "Release Unknown"
                textAnimeDuration.text = if (duration != null) "Duration : $duration Minutes" else "Duration Unknown"
                textAnimeTotalEp.text = if (totalEp != null) "Total Episode : $totalEp Episodes" else "Total EP Unknown"
                textAnimeType.text = animeResult.attributes.subtype?.replaceFirstChar { it.uppercase() }
                textAnimeStatus.text = animeResult.attributes.status?.replaceFirstChar { it.uppercase() }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListVH {
        val binding = ItemAnimeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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