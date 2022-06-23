package com.kitsunime.presentation.favorite.manga

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kitsunime.R
import com.kitsunime.databinding.FragmentFavoriteMangaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMangaFragment : Fragment(R.layout.fragment_favorite_manga) {
    private var _binding: FragmentFavoriteMangaBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoriteMangaBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}