package com.kitsunime.presentation.manga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.databinding.ItemVerticalBinding
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.presentation.util.DiffUtils
import com.kitsunime.presentation.util.setVisibilityGone
import okhttp3.internal.immutableListOf

class MangaAdapter : RecyclerView.Adapter<MangaAdapter.MangaViewHolder>() {

    private var mangaResult = immutableListOf<KitsuResult>()

    class MangaViewHolder(private val binding: ItemVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(mangaResult: KitsuResult) {
                binding.apply {
                    val coverImage = mangaResult.attributes?.coverImage
                    val posterImage = mangaResult.attributes?.posterImage
                    val releaseDate = mangaResult.attributes?.startDate ?: textAnimeReleaseDate.setVisibilityGone()
                    val chapter = mangaResult.attributes?.chapterCount ?: textAnimeDuration.setVisibilityGone()
                    val volume = mangaResult.attributes?.volumeCount ?: textAnimeTotalEp.setVisibilityGone()
                    val categoryMap = mangaResult.relationships?.categories?.data?.size

                    imageAnimeCover.load(coverImage?.small) {
                        crossfade(1000)
                        error(R.drawable.bg_placeholder)
                    }
                    imageAnimePoster.load(posterImage?.small) {
                        crossfade(1000)
                        error(R.drawable.bg_placeholder)
                    }
                    textAnimeTitle.isSelected = true
                    textAnimeTitle.text = mangaResult.attributes?.canonicalTitle
                    textAnimeCategory.text = "Category : $categoryMap"
                    textAnimeReleaseDate.text = "Release Date : $releaseDate"
                    textAnimeDuration.text = "Chapters : $chapter Chapters"
                    textAnimeTotalEp.text = "Volume : $volume"
                    textAnimeType.text = mangaResult.attributes?.subtype?.replaceFirstChar { it.uppercase() }
                    textAnimeStatus.text = mangaResult.attributes?.status?.replaceFirstChar { it.uppercase() }
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val binding = ItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.bind(mangaResult[position])
    }

    override fun getItemCount(): Int = mangaResult.size

    fun submitData(newData: List<KitsuResult>) {
        val oldData = DiffUtils(mangaResult, newData)
        val result = DiffUtil.calculateDiff(oldData)
        mangaResult = newData
        result.dispatchUpdatesTo(this)
    }

}