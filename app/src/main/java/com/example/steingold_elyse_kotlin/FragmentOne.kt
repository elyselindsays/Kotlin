package com.example.steingold_elyse_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_one.firstNameField
import kotlinx.android.synthetic.main.fragment_two.*


class FragmentOne : Fragment() {

    lateinit var nextButton: Button
    lateinit var firstNameText: EditText
    lateinit var lastNameText: EditText
    lateinit var emailText: EditText
    lateinit var phoneNumber: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        nextButton = view.findViewById(R.id.nextButton)
        firstNameText = view.findViewById(R.id.firstNameInput)
        lastNameText = view.findViewById(R.id.lastNameInput)
        emailText = view.findViewById(R.id.emailInput)
        phoneNumber = view.findViewById(R.id.phoneInput)

        firstNameText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && firstNameText.text.isNullOrBlank()) {
                firstNameText.error = "This field is required"
            }
        }

        lastNameText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && lastNameText.text.isNullOrBlank()) {
                lastNameText.error = "This field is required"
            }
        }

        emailText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && emailText.text.isNullOrBlank()) {
                emailText.error = "This field is required"
            } else if (!hasFocus && !emailText.text.contains('@')) {
                emailText.error = "Please enter a valid email address"
            } else if (!hasFocus && !emailText.text.contains('.')) {
                emailText.error = "Please enter a valid email address"
            }
        }

        phoneNumber.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && phoneNumber.text.isNullOrBlank()) {
                phoneNumber.error = "This field is required"
            } else if (!hasFocus && phoneNumber.length() < 10) {
                phoneNumber.error = "Please enter a 10-digit phone number"
            } else if (!hasFocus && !phoneNumber.text.matches(".*[0-9].*".toRegex())) {
                phoneNumber.error = "Please enter a valid phone number"
            }
        }



        nextButton.setOnClickListener{
            viewModel.setFragment1ModelData(
                firstNameText.text.toString(),
                lastNameText.text.toString(),
                emailText.text.toString(),
                phoneNumber.text.toString()

            )

            swipe.isVisible = true

        }
    }

}