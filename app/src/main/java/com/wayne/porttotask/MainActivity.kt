package com.wayne.porttotask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.wayne.porttotask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfig: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAppBar()
    }

    private fun setupAppBar() {
        appBarConfig = AppBarConfiguration(findNavController().graph)
        val toolbar = binding.toolbar
        binding.toolbar.setupWithNavController(findNavController(), appBarConfig)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(findNavController(), appBarConfig)
    }

    private fun findNavController(): NavController {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        return navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController().navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}