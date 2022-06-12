package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayout.fragments.FavFragment
import com.example.tablayout.fragments.HomeFragment
import com.example.tablayout.fragments.SettingsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var fragmentAdapter: ViewPagerFragmentAdapter
    lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)
        tabs = findViewById(R.id.tabs)
        fragmentAdapter = ViewPagerFragmentAdapter(this)


        fragmentAdapter.addFragment(HomeFragment(), "Home", R.drawable.ic_home)
        fragmentAdapter.addFragment(FavFragment(), "Favourite", R.drawable.ic_favorite)
        fragmentAdapter.addFragment(SettingsFragment(), "Settings", R.drawable.ic_settings)

        viewPager.adapter = fragmentAdapter
        TabLayoutMediator(tabs,viewPager){tabs,position ->
            tabs.text = fragmentAdapter.getPageTitle(position)
            tabs.setIcon(fragmentAdapter.getTabIcon(position))
        }.attach()

    }


}