package com.example.homework_18_bottom_tab.main.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_18_bottom_tab.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        viewPager.adapter = adapter
        adapter.addFragment(FirstFragment(), "Первый фрагмент")
        adapter.addFragment(SecondFragment(), "Второй фрагмент")
        adapter.addFragment(ThirdFragment(), "Третий фрагмент")
        tabLayout.setupWithViewPager(viewPager)
    }
}