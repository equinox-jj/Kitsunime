package com.kitsunime.presentation.manga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kitsunime.R
import com.kitsunime.common.DiffUtils
import com.kitsunime.databinding.ItemHorizontalBinding
import com.kitsunime.domain.model.KitsuResult

class MangaTrendingAdapter : RecyclerView.Adapter<MangaTrendingAdapter.MangaTrendingVH>() {

    private var mangaResult = listOf<KitsuResult>()

    inner class MangaTrendingVH(private val binding: ItemHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mangaResult: KitsuResult) {
            binding.apply {
                val posterImage = mangaResult.attributes?.posterImage
                val chapter = mangaResult.attributes?.chapterCount

                imageAnimePoster.load(posterImage?.small) {
                    crossfade(1000)
                    error(R.drawable.color_gradient)
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
        val mangaDiffUtil = DiffUtils(mangaResult, newData)
        val diffUtil = DiffUtil.calculateDiff(mangaDiffUtil)
        mangaResult = newData
        diffUtil.dispatchUpdatesTo(this)
    }

}