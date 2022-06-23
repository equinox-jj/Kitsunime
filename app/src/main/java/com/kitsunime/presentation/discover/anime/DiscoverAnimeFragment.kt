package com.kitsunime.presentation.discover.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kitsunime.R
import com.kitsunime.databinding.FragmentDiscoverAnimeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverAnimeFragment : Fragment(R.layout.fragment_discover_anime) {

    private var _binding: FragmentDiscoverAnimeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDiscoverAnimeBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}