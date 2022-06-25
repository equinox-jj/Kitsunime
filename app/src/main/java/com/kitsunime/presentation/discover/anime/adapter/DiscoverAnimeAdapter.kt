package com.kitsunime.presentation.discover.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.databinding.ItemVerticalBinding
import com.kitsunime.domain.model.KitsuResult

class DiscoverAnimeAdapter :
    PagingDataAdapter<KitsuResult, DiscoverAnimeAdapter.DiscoverAnimeViewHolder>(ANIME_COMPARATOR) {

    class DiscoverAnimeViewHolder(private val binding: ItemVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(kitsuResult: KitsuResult) {
            binding.apply {
                val coverImage = kitsuResult.attributes?.coverImage
                val posterImage = kitsuResult.attributes?.posterImage
                val releaseDate = kitsuResult.attributes?.startDate
                val duration = kitsuResult.attributes?.episodeLength
                val totalEp = kitsuResult.attributes?.episodeCount
                val categoryMap = kitsuResult.relationships?.categories?.data?.size

                imageAnimeCover.load(coverImage?.small) {
                    crossfade(1000)
                    error(R.drawable.bg_placeholder)
                }
                imageAnimePoster.load(posterImage?.small) {
                    crossfade(1000)
                    error(R.drawable.bg_placeholder)
                }
                textAnimeTitle.isSelected = true
                textAnimeTitle.text = kitsuResult.attributes?.canonicalTitle
                textAnimeCategory.text = "Category : $categoryMap"
                textAnimeReleaseDate.text = if (releaseDate != null) "Release Date : $releaseDate" else "Release : Unknown"
                textAnimeDuration.text = if (duration != null) "Duration : $duration Minutes" else "Duration : Unknown"
                textAnimeTotalEp.text = if (totalEp != null) "Episode : $totalEp Episodes" else "Episodes : Unknown"
                textAnimeType.text = kitsuResult.attributes?.subtype?.replaceFirstChar { it.uppercase() }
                textAnimeStatus.text = kitsuResult.attributes?.status?.replaceFirstChar { it.uppercase() }
            }
        }
    }

    override fun onBindViewHolder(holder: DiscoverAnimeViewHolder, position: Int) {
        val currentData = getItem(position)
        if (currentData != null) {
            holder.bind(currentData)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverAnimeViewHolder {
        val binding = ItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiscoverAnimeViewHolder(binding)
    }

    companion object {
        private val ANIME_COMPARATOR = object : DiffUtil.ItemCallback<KitsuResult>() {
            override fun areItemsTheSame(oldItem: KitsuResult, newItem: KitsuResult) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: KitsuResult, newItem: KitsuResult) =
                oldItem == newItem
        }
    }
}