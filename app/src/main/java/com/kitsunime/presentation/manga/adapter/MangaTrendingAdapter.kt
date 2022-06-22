package com.kitsunime.presentation.manga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kitsunime.common.DiffUtils
import com.kitsunime.data.remote.dto.KitsuResults
import com.kitsunime.databinding.ItemAnimeTrendingListBinding

class MangaTrendingAdapter : RecyclerView.Adapter<MangaTrendingAdapter.MangaTrendingVH>() {

    private var mangaResult = listOf<KitsuResults>()

    class MangaTrendingVH(private val binding: ItemAnimeTrendingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mangaResult: KitsuResults) {
            binding.mangaType = mangaResult
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaTrendingAdapter.MangaTrendingVH {
        val binding = ItemAnimeTrendingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaTrendingVH(binding)
    }

    override fun onBindViewHolder(holder: MangaTrendingAdapter.MangaTrendingVH, position: Int) {
        holder.bind(mangaResult[position])
    }

    override fun getItemCount(): Int = mangaResult.size

    fun submitData(newData: List<KitsuResults>) {
        val mangaDiffUtil = DiffUtils(mangaResult, newData)
        val diffUtil = DiffUtil.calculateDiff(mangaDiffUtil)
        mangaResult = newData
        diffUtil.dispatchUpdatesTo(this)
    }

}