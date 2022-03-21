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
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_one.firstNameField
import kotlinx.android.synthetic.main.fragment_two.*


class FragmentOne : Fragment() {

    lateinit var saveButton: Button
    lateinit var firstNameText: EditText
    lateinit var lastNameText: EditText
    lateinit var emailText: EditText
    lateinit var phoneNumber: EditText
    var firstNameValid = false
    var lastNameValid = false
    var emailValid = false
    var phoneValid = false

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

        saveButton = view.findViewById(R.id.saveButton)
        firstNameText = view.findViewById(R.id.firstNameInput)
        lastNameText = view.findViewById(R.id.lastNameInput)
        emailText = view.findViewById(R.id.emailInput)
        phoneNumber = view.findViewById(R.id.phoneInput)

        checkEmpty()
        checkNameValid()
        checkLastNameValid()
        checkEmailValid()
        checkPhoneValid()


        saveButton.setOnClickListener{
                viewModel.setFragment1ModelData(
                    firstNameText.text.toString(),
                    lastNameText.text.toString(),
                    emailText.text.toString(),
                    phoneNumber.text.toString()
                )
                swipe.isVisible = true
            }
       }


    fun checkEmpty(){
        firstNameText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                firstNameValid = true
                firstNameField.error = null
                checkAllValid()
            }
        }
        lastNameText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                lastNameValid = true
                lastNameField.error = null
                checkAllValid()
            }
        }
        emailText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                emailValid = true
                emailField.error = null
                checkAllValid()
            }
        }
        phoneNumber.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                phoneValid = true
                phoneField.error = null
                checkAllValid()
            }
        }

    }

    fun checkNameValid() {
        firstNameText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && firstNameText.text.isNullOrBlank()) {
                firstNameField.error = "This field is required"
            } else {
                firstNameValid = true
            }
        }
    }

    fun checkLastNameValid(){
        lastNameText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && lastNameText.text.isNullOrBlank()) {
                lastNameField.error = "This field is required"
            } else {
                lastNameValid = true
            }
        }
    }

    fun checkEmailValid(){
        emailText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && emailText.text.isNullOrBlank()) {
                emailText.error = "This field is required"
            } else if (!hasFocus && !emailText.text.contains('@')) {
                emailText.error = "Please enter a valid email address"
            } else if (!hasFocus && !emailText.text.contains('.')) {
                emailText.error = "Please enter a valid email address"
            } else {
                emailValid = true
            }
        }
    }

    fun checkPhoneValid(){
        phoneNumber.doOnTextChanged { text, start, before, count ->
            if (text.isNullOrBlank()) {
                phoneNumber.error = "This field is required"
            } else if (text.length < 10) {
                phoneNumber.error = "Please enter a 10-digit phone number"
            } else if (!text.matches(".*[0-9].*".toRegex())) {
                phoneNumber.error = "Please enter a valid phone number"
            } else {
                phoneValid = true
            }
        }
    }

    fun checkAllValid() {
        if (firstNameValid && lastNameValid && emailValid && phoneValid) {
            saveButton.isEnabled = true
        }
    }

}