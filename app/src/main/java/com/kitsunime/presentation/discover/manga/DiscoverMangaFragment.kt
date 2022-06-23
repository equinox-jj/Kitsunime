package com.kitsunime.presentation.discover.manga

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kitsunime.R
import com.kitsunime.databinding.FragmentDiscoverMangaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverMangaFragment : Fragment(R.layout.fragment_discover_manga) {

    private var _binding: FragmentDiscoverMangaBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDiscoverMangaBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}