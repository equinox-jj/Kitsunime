package com.kitsunime.presentation.discover

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.kitsunime.R
import com.kitsunime.databinding.FragmentDiscoverBinding
import com.kitsunime.presentation.discover.adapter.DiscoverPagerAdapter
import com.kitsunime.presentation.discover.anime.DiscoverAnimeFragment
import com.kitsunime.presentation.discover.manga.DiscoverMangaFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : Fragment(R.layout.fragment_discover) {

    private var _binding: FragmentDiscoverBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDiscoverBinding.bind(view)
        setupViewPager()
    }

    private fun setupViewPager() {
        val tabLayout = binding.tabLayoutDiscover
        val viewPager = binding.viewPagerDiscover

        val fragmentTabs = ArrayList<Fragment>()
        fragmentTabs.add(DiscoverAnimeFragment())
        fragmentTabs.add(DiscoverMangaFragment())

        val titles = ArrayList<String>()
        titles.add("Anime")
        titles.add("Manga")

        viewPager.adapter = DiscoverPagerAdapter(fragmentTabs, fragment = this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()

        viewPager.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position) {
                    0 -> binding.svDiscover.queryHint = "Search Anime..."
                    1 -> binding.svDiscover.queryHint = "Search Manga..."
                    else -> throw Exception("Invalid Position")
                }
            }
        })

        binding.imageDummy.setOnClickListener {
//            val action = when(tabLayout.selectedTabPosition) {
//                0 ->
//            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}