package com.kitsunime.presentation.anime

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kitsunime.R
import com.kitsunime.common.setVisibilityGone
import com.kitsunime.common.setVisibilityVisible
import com.kitsunime.databinding.FragmentAnimeBinding
import com.kitsunime.presentation.anime.adapter.AnimeAdapter
import com.kitsunime.presentation.anime.adapter.AnimeTrendingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!

    private val animeVm: AnimeViewModel by viewModels()
    private val animeTrendingAdapter by lazy { AnimeTrendingAdapter() }
    private val animeAdapter by lazy { AnimeAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimeBinding.bind(view)
        binding.animeVm = animeVm
        binding.lifecycleOwner = viewLifecycleOwner

        initRecyclerView()
        observeAnimeTrending()
        observeAnime()
        setOnRefresh()
    }

    private fun setOnRefresh() {
        binding.animeRefresh.setOnRefreshListener {
            animeVm.refresh()
        }
    }

    private fun initRecyclerView() {
        binding.contAnimeListTrend.rvAnimeTrending.apply {
            adapter = animeTrendingAdapter
            setHasFixedSize(true)
        }
        binding.contAnimeList.rvAnimeList.apply {
            adapter = animeAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeAnimeTrending() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                Log.d("Lifecycle :", this.toString())
                animeVm.animeTrendingUiState.collect { uiState ->
                    when {
                        uiState.isLoading -> {
                            binding.contShimAnimeListTrend.root.setVisibilityVisible()
                            binding.contAnimeListTrend.root.setVisibilityGone()
                        }
                        uiState.data.isNotEmpty() -> {
                            binding.contShimAnimeListTrend.root.stopShimmer()
                            binding.contShimAnimeListTrend.root.setVisibilityGone()
                            binding.contAnimeListTrend.root.setVisibilityVisible()
                            animeTrendingAdapter.submitData(uiState.data)
                        }
                        uiState.error.isNotEmpty() -> {
                            binding.contShimAnimeListTrend.root.stopShimmer()
                            binding.contShimAnimeListTrend.root.setVisibilityGone()
                            binding.contAnimeListTrend.root.setVisibilityGone()
                        }
                    }
                    binding.animeRefresh.isRefreshing = uiState.isLoading
                }
            }
        }
//        viewLifecycleOwner.lifecycleScope.launch {
//            animeVm.animeTrendingUiState.collect {
//                binding.animeRefresh.isRefreshing = it.isLoading
//            }
//        }
    }

    private fun observeAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                animeVm.animeUiState.collect { uiState ->
                    when {
                        uiState.isLoading -> {
                            binding.contShimAnimeList.root.setVisibilityVisible()
                            binding.contAnimeList.root.setVisibilityGone()
                        }
                        uiState.data.isNotEmpty() -> {
                            binding.contShimAnimeList.root.stopShimmer()
                            binding.contShimAnimeList.root.setVisibilityGone()
                            binding.contAnimeList.root.setVisibilityVisible()
                            animeAdapter.submitData(uiState.data)
                        }
                        uiState.error.isNotEmpty() -> {
                            binding.contShimAnimeList.root.stopShimmer()
                            binding.contShimAnimeList.root.setVisibilityGone()
                            binding.contAnimeList.root.setVisibilityGone()
                        }
                    }
                    binding.animeRefresh.isRefreshing = uiState.isLoading
                }
            }
        }
//        viewLifecycleOwner.lifecycleScope.launch {
//            animeVm.animeUiState.collect {
//                binding.animeRefresh.isRefreshing = it.isLoading
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("onDestroy :", this.toString())
    }

}