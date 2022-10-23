package com.example.codepath_bitfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import com.example.codepath_bitfit.databinding.ActivityMainBinding
import com.example.codepath_bitfit.fragments.AddFragment
import com.example.codepath_bitfit.fragments.DashFragment
import com.example.codepath_bitfit.fragments.LogFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val fragmentManager: FragmentManager = supportFragmentManager

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        val addFragment: Fragment = AddFragment()
        val dashFragment: Fragment = DashFragment()
        val logFragment: Fragment = LogFragment()


        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.addpostIcon -> fragment = addFragment
                R.id.menuListIcon -> fragment = logFragment
                R.id.menuDashboardIcon-> fragment = dashFragment
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.menuListIcon
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.logFrameLayout, fragment)
        fragmentTransaction.commit()
    }
}