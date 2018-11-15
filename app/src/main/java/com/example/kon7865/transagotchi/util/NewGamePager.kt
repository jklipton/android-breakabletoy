package com.example.kon7865.transagotchi.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.kon7865.transagotchi.NewGameFragment1
import com.example.kon7865.transagotchi.NewGameFragment2

class NewGamePager(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> NewGameFragment1()
            else -> NewGameFragment2()
        }
    }

    override fun getCount(): Int {
        return 2
    }

}
