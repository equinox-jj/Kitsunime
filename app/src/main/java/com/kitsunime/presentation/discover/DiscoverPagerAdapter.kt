package com.kitsunime.presentation.discover

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DiscoverPagerAdapter(
    private val fragmentTabs: ArrayList<Fragment>,
    fragment: Fragment,
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragmentTabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentTabs[position]
    }
}