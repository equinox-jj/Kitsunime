package com.kitsunime.presentation.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.kitsunime.R
import com.kitsunime.databinding.FragmentAnimeBinding
import com.kitsunime.presentation.anime.adapter.HorizontalAdapter
import com.kitsunime.presentation.anime.adapter.VerticalAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!

    private val animeVm: AnimeViewModel by viewModels()
    private val horizontalAdapter by lazy { HorizontalAdapter() }
    private val verticalAdapter by lazy { VerticalAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimeBinding.bind(view)

        initRecyclerView()
        observeAnimeTrending()
        observeAnime()
    }

    private fun initRecyclerView() {
        binding.contAnimeListTrend.rvAnimeTrending.apply {
            adapter = horizontalAdapter
            setHasFixedSize(true)
        }
        binding.contAnimeList.rvAnimeList.apply {
            adapter = verticalAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeAnimeTrending() {
        lifecycleScope.launchWhenStarted {
            animeVm.trendingAnimeUiState.collect { uiState ->
                when {
                    uiState.data?.data?.isNotEmpty() == true -> {
                        horizontalAdapter.submitData(uiState.data)
                        binding.contAnimeListTrend.root.visibility = View.VISIBLE
                    }
                    uiState.isLoading -> {

                    }
                    uiState.error.isNotEmpty() -> {

                    }
                }
            }
        }
    }

    private fun observeAnime() {
        lifecycleScope.launchWhenStarted {
            animeVm.animeUiState.collect { uiState ->
                when {
                    uiState.data?.data?.isNotEmpty() == true -> {
                        verticalAdapter.submitData(uiState.data)
                        binding.contAnimeList.root.visibility = View.VISIBLE
                    }
                    uiState.isLoading -> {

                    }
                    uiState.error.isNotEmpty() -> {

                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}