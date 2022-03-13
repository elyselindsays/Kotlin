package com.example.steingold_elyse_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {


    val listFragments = mutableListOf<Fragment>()
    val listTitles = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listFragments.add(FragmentOne())
        listFragments.add(FragmentTwo())
        listFragments.add(FragmentThree())

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listFragments, listTitles )
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = viewPagerAdapter





    }
}