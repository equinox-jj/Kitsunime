package com.kitsunime.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kitsunime.R
import com.kitsunime.common.setVisibilityGone
import com.kitsunime.common.setVisibilityVisible
import com.kitsunime.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.detailFragment -> isBottomNavVisible(false)
                else -> isBottomNavVisible(true)
            }
        }
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.animeFragment,
                R.id.mangaFragment,
                R.id.discoverFragment,
                R.id.favoriteFragment
            )
        )
        binding.bottomNav.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        navController = this.findNavController(R.id.mainNavHost)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun isBottomNavVisible(show: Boolean) {
        if (show) {
            binding.bottomNav.setVisibilityVisible()
        } else {
            binding.bottomNav.setVisibilityGone()
        }
    }

}