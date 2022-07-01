package com.example.mineralidentification.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.mineralidentification.R
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_identification, container, false)
        viewPager = root.findViewById(R.id.viewPager)
        val adapter = SliderAdapter(this, childFragmentManager)
        viewPager.adapter = adapter
        tabLayout = root.findViewById(R.id.sliding_tabs)

        tabLayout.post {
            tabLayout.setupWithViewPager(viewPager)
        }

        return root
    }

    private class SliderAdapter(ctx: HomeFragment, fm: FragmentManager) : FragmentPagerAdapter(fm) {

        val mineral = ctx.getString(R.string.mineral)
        val rock = ctx.getString(R.string.rock)

        override fun getItem(p0: Int): Fragment {
            return when(p0) {
                0 -> MineralIdentificationFragment()
                1 -> RockIdentificationFragment()
                else -> MineralIdentificationFragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position) {
                0 -> mineral
                1 -> rock
                else -> mineral
            }
        }

    }
}
