package com.kitsunime.presentation.discover.anime

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.kitsunime.R
import com.kitsunime.databinding.FragmentDiscoverAnimeBinding
import com.kitsunime.presentation.discover.DiscoverViewModel
import com.kitsunime.presentation.discover.adapter.DiscoverAnimeAdapter
import com.kitsunime.presentation.discover.adapter.DiscoverLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiscoverAnimeFragment : Fragment(R.layout.fragment_discover_anime) {

    private var _binding: FragmentDiscoverAnimeBinding? = null
    private val binding get() = _binding!!

    private val discVm by viewModels<DiscoverViewModel>()
    private val pagingAdapter by lazy { DiscoverAnimeAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDiscoverAnimeBinding.bind(view)
        initRecyclerView()
        observePagingAnime()
    }

    private fun initRecyclerView() {
        binding.apply {
            rvDiscoverAnime.setHasFixedSize(true)
            rvDiscoverAnime.adapter = pagingAdapter.withLoadStateHeaderAndFooter(
                header = DiscoverLoadStateAdapter { pagingAdapter.retry() },
                footer = DiscoverLoadStateAdapter { pagingAdapter.retry() }
            )
            discAnimeRefresh.setOnRefreshListener {
                pagingAdapter.retry()
                discAnimeRefresh.isRefreshing = false
            }
            pagingAdapter.addLoadStateListener { loadState ->
                shimDiscoverAnime.isVisible = loadState.source.refresh is LoadState.Loading
                if (loadState.source.refresh is LoadState.NotLoading && loadState.append.endOfPaginationReached) {
                    rvDiscoverAnime.isVisible = false
                }
            }
        }
    }

    private fun observePagingAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                discVm.discAnimeUiState.collect { uiState ->
                    uiState.data?.let { pagingAdapter.submitData(it) }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}