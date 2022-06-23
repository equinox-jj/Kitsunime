package com.kitsunime.presentation.manga

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kitsunime.R
import com.kitsunime.common.setVisibilityGone
import com.kitsunime.common.setVisibilityVisible
import com.kitsunime.databinding.FragmentMangaBinding
import com.kitsunime.presentation.manga.adapter.MangaAdapter
import com.kitsunime.presentation.manga.adapter.MangaTrendingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {

    private var _binding: FragmentMangaBinding? = null
    private val binding get() = _binding!!

    private val mangaVm: MangaViewModel by viewModels()
    private val mangaTrendingAdapter by lazy { MangaTrendingAdapter() }
    private val mangaAdapter by lazy { MangaAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMangaBinding.bind(view)

        initRecyclerView()
        observeMangaTrending()
        observeManga()
        setOnRefresh()
    }

    private fun setOnRefresh() {
        binding.mangaRefresh.setOnRefreshListener {
            mangaVm.refresh()
        }
    }

    private fun initRecyclerView() {
        binding.contMangaListTrend.rvMangaTrending.apply {
            adapter = mangaTrendingAdapter
            setHasFixedSize(true)
        }
        binding.contMangaList.rvMangaList.apply {
            adapter = mangaAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeMangaTrending() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mangaVm.mangaTrendingUiState.collect { uiState ->
                    when {
                        uiState.isLoading -> {
                            binding.contShimMangaListTrend.root.setVisibilityVisible()
                            binding.contMangaListTrend.root.setVisibilityGone()
                        }
                        uiState.data.isNotEmpty() -> {
                            binding.contShimMangaListTrend.root.stopShimmer()
                            binding.contShimMangaListTrend.root.setVisibilityGone()
                            binding.contMangaListTrend.root.setVisibilityVisible()
                            mangaTrendingAdapter.submitData(uiState.data)
                        }
                        uiState.error.isNotEmpty() -> {
                            binding.contShimMangaListTrend.root.stopShimmer()
                            binding.contShimMangaListTrend.root.setVisibilityGone()
                            binding.contMangaListTrend.root.setVisibilityGone()
                        }
                    }
                    binding.mangaRefresh.isRefreshing = uiState.isLoading
                }
            }
        }
    }

    private fun observeManga() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mangaVm.mangaUiState.collect { uiState ->
                    when {
                        uiState.isLoading -> {
                            binding.contShimMangaList.root.setVisibilityVisible()
                            binding.contMangaList.root.setVisibilityGone()
                        }
                        uiState.data.isNotEmpty() -> {
                            binding.contShimMangaList.root.stopShimmer()
                            binding.contShimMangaList.root.setVisibilityGone()
                            binding.contMangaList.root.setVisibilityVisible()
                            mangaAdapter.submitData(uiState.data)
                        }
                        uiState.error.isNotEmpty() -> {
                            binding.contShimMangaList.root.stopShimmer()
                            binding.contShimMangaList.root.setVisibilityGone()
                            binding.contMangaList.root.setVisibilityGone()
                        }
                    }
                    binding.mangaRefresh.isRefreshing = uiState.isLoading
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}