package com.kitsunime.presentation.manga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kitsunime.data.remote.model.Data
import com.kitsunime.databinding.ItemAnimeListBinding

class MangaAdapter : RecyclerView.Adapter<MangaAdapter.MangaViewHolder>() {

    private var mangaResult = listOf<Data>()

    inner class MangaViewHolder(private val binding: ItemAnimeListBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(mangaResult: Data) {

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val binding = ItemAnimeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MangaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.bind(mangaResult[position])
    }

    override fun getItemCount(): Int = mangaResult.size


}