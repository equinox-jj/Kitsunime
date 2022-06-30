package com.kitsunime.presentation.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.databinding.ItemVerticalBinding
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.presentation.anime.AnimeFragmentDirections
import com.kitsunime.presentation.util.DiffUtils
import com.kitsunime.presentation.util.setVisibilityGone

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeListVH>() {

    private var animeResult = listOf<KitsuResult>()

    class AnimeListVH(private val binding: ItemVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animeResult: KitsuResult) {
            binding.apply {
                val coverImage = animeResult.attributes?.coverImage
                val posterImage = animeResult.attributes?.posterImage
                val releaseDate = animeResult.attributes?.startDate ?: textAnimeReleaseDate.setVisibilityGone()
                val duration = animeResult.attributes?.episodeLength ?: textAnimeDuration.setVisibilityGone()
                val totalEp = animeResult.attributes?.episodeCount ?: textAnimeTotalEp.setVisibilityGone()
                val categoryMap = animeResult.relationships?.categories?.data?.size

                imageAnimeCover.load(coverImage?.small) {
                    crossfade(1000)
                    error(R.drawable.bg_placeholder)
                }
                imageAnimePoster.load(posterImage?.small) {
                    crossfade(1000)
                    error(R.drawable.bg_placeholder)
                }
                textAnimeTitle.isSelected = true
                textAnimeTitle.text = animeResult.attributes?.canonicalTitle
                textAnimeCategory.text = "Category : $categoryMap"
                textAnimeReleaseDate.text = "Release Date : $releaseDate"
                textAnimeDuration.text = "Duration : $duration Minutes"
                textAnimeTotalEp.text = "Episode : $totalEp Episodes"
                textAnimeType.text = animeResult.attributes?.subtype?.replaceFirstChar { it.uppercase() }
                textAnimeStatus.text = animeResult.attributes?.status?.replaceFirstChar { it.uppercase() }

                materialCardView.setOnClickListener {
                    val action = AnimeFragmentDirections.actionAnimeFragmentToDetailFragment()
                    it.findNavController().navigate(action)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListVH {
        val binding = ItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeListVH(binding)
    }

    override fun onBindViewHolder(holder: AnimeListVH, position: Int) {
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