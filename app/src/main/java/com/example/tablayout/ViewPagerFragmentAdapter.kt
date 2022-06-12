package com.example.tablayout

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    private var fragmentList: ArrayList<Fragment> = ArrayList()
    private var tabTitleList: ArrayList<String> = ArrayList()
    private var tabIcon: ArrayList<Int> = ArrayList()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String, icon: Int){
        fragmentList.add(fragment)
        tabTitleList.add(title)
        tabIcon.add(icon)
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun getPageTitle(position: Int): String {
          return tabTitleList[position]
    }

    fun getTabIcon(position: Int): Int {
        return tabIcon[position]
    }

}