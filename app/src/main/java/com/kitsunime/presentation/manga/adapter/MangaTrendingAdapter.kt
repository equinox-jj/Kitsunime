package com.kitsunime.presentation.manga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.databinding.ItemHorizontalBinding
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.presentation.util.DiffUtils

class MangaTrendingAdapter : RecyclerView.Adapter<MangaTrendingAdapter.MangaTrendingVH>() {

    private var mangaResult = listOf<KitsuResult>()

    class MangaTrendingVH(private val binding: ItemHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mangaResult: KitsuResult) {
            binding.apply {
                val posterImage = mangaResult.attributes?.posterImage
                val chapter = mangaResult.attributes?.chapterCount

                imageAnimePoster.load(posterImage?.small) {
                    crossfade(1000)
                    error(R.drawable.bg_placeholder)
                }
                textAnimeTitle.isSelected = true
                textAnimeTitle.text = mangaResult.attributes?.canonicalTitle
                textAnimeTotalEp.text = if (chapter != null) "$chapter Chapters" else "Unknown"
                textAnimeType.text = mangaResult.attributes?.subtype?.replaceFirstChar { it.uppercase() }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaTrendingAdapter.MangaTrendingVH {
        val binding = ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaTrendingVH(binding)
    }

    override fun onBindViewHolder(holder: MangaTrendingAdapter.MangaTrendingVH, position: Int) {
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