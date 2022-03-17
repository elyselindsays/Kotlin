package com.example.steingold_elyse_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_one.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: FormViewModel
    val listFragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listFragments.add(FragmentOne())
        listFragments.add(FragmentTwo())
        listFragments.add(FragmentThree())

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listFragments)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = viewPagerAdapter

        viewModel = ViewModelProvider(this).get(FormViewModel::class.java)

    }
}