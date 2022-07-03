package com.kitsunime.presentation.discover.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kitsunime.databinding.ItemLoadStateDiscoverBinding

class DiscoverLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<DiscoverLoadStateAdapter.LoadStateViewHolder>() {

    inner class LoadStateViewHolder(private val binding: ItemLoadStateDiscoverBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnErrorLoadState.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {
            binding.apply {
                shimmerLoadStateDiscover.isVisible = loadState is LoadState.Loading
                btnErrorLoadState.isVisible = loadState is LoadState.Error
                tvErrorLoadState.isVisible = loadState is LoadState.Error
            }
        }
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = ItemLoadStateDiscoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(binding)
    }
}