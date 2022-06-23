package com.kitsunime.presentation.favorite.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kitsunime.R
import com.kitsunime.databinding.FragmentFavoriteAnimeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteAnimeFragment : Fragment(R.layout.fragment_favorite_anime) {
    private var _binding: FragmentFavoriteAnimeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteAnimeBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}