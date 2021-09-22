package com.android.kotlin.habittracker.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.android.kotlin.habittracker.MainActivity
import com.android.kotlin.habittracker.R
import com.android.kotlin.habittracker.data.models.IntroView
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    lateinit var introView: List<IntroView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        addIntroView()

        viewPager2.adapter = ViewPagerAdapter(introView)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        circleIndicator.setViewPager(viewPager2)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                if (position == 2) {
                    animateButton()
                }

                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })
    }

    private fun addIntroView() {
        introView = listOf(
            IntroView("Welcome to Habit Tracker", R.drawable.ic_beverage),
            IntroView("Track your habits with ease", R.drawable.ic_fastfood),
            IntroView("Keep enhancing on daily basis!", R.drawable.ic_smoking)
        )
    }

    private fun animateButton() {
        btn_start_app.visibility = View.VISIBLE
        btn_start_app.animate().apply {
            duration = 1400
            alpha(1f)
            btn_start_app.setOnClickListener {
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }.start()
    }

}