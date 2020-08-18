package com.example.homework_18_bottom_tab.main.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_18_bottom_tab.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNav()
        setupListeners()
    }

    private fun setupBottomNav() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        adapter.addFragment(FirstFragment())
        adapter.addFragment(SecondFragment())
        adapter.addFragment(ThirdFragment())
    }

    private fun setupListeners() {
        bottomNav.setOnNavigationItemSelectedListener {

            when(it.itemId){
               R.id.firstFrag -> viewPager.currentItem = 0
               R.id.secondFrag -> viewPager.currentItem = 1
               R.id.thirdFrag -> viewPager.currentItem = 2
            }
            return@setOnNavigationItemSelectedListener true
        }
    }


}