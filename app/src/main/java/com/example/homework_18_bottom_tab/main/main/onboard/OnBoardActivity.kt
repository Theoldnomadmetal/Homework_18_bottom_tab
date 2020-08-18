package com.example.homework_18_bottom_tab.main.main.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.homework_18_bottom_tab.R
import com.example.homework_18_bottom_tab.data.OnBoardModel
import com.example.homework_18_bottom_tab.main.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : AppCompatActivity() {
    private val list = arrayListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        setupViewPager()
        setupListeners()
    }

    private fun setupListeners() {
        onBoardViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if(isLastPage(position)){
                    btn_onBoard.text = "Pass Anyway"
                }else {
                    btn_onBoard.text = "Next"
                }
            }

        })
        btn_onBoard.setOnClickListener {
            if (isLastPage(onBoardViewPager.currentItem)){
                startActivity(Intent(this, MainActivity::class.java))
            }else {
                onBoardViewPager.currentItem = onBoardViewPager.currentItem +1
            }
        }
    }
    private fun isLastPage(position:Int)= position == list.size -1

    private fun setupViewPager() {
        val adapter = OnBoardAdapter(supportFragmentManager)
        onBoardViewPager.adapter = adapter
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.gandalf1,"YOU")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.gandalf1,"SHALL")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.gandalf1,"NOT")))
        list.add(OnBoardFragment.getInstance(OnBoardModel(R.drawable.gandalf1,"PASS")))
        adapter.update(list)

        onBoardTabLayout.setupWithViewPager(onBoardViewPager)
    }

}