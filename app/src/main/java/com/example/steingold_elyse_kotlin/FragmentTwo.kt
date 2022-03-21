package com.example.steingold_elyse_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_two.*
import org.w3c.dom.Text


class FragmentTwo : Fragment() {

    lateinit var saveBtn2: Button
    lateinit var addressText: EditText
    lateinit var cityText: EditText
    lateinit var stateText: EditText
    lateinit var zipText: EditText
    var addressValid = false
    var cityValid = false
    var stateValid = false
    var zipValid = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        saveBtn2 = view.findViewById(R.id.saveBtn2)
        addressText = view.findViewById(R.id.addressInput)
        cityText = view.findViewById(R.id.cityInput)
        stateText = view.findViewById(R.id.stateInput)
        zipText = view.findViewById(R.id.zipInput)

        checkFrag2Empty()
        checkAddressValid()
        checkCityValid()
        checkStateValid()
        checkZipValid()


        saveBtn2.setOnClickListener{
            viewModel.setFragment2ModelData(
                    addressText.text.toString(),
                    cityText.text.toString(),
                    stateText.text.toString(),
                    zipText.text.toString()
                )
                swipe2.isVisible = true
            }
    }


    fun checkFrag2Empty(){
        addressText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                addressValid = true
                addressField.error = null
                checkAllValid2()
            }
        }
        cityText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                cityValid = true
                cityField.error = null
                checkAllValid2()
            }
        }
        stateText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                stateValid = true
                stateField.error = null
                checkAllValid2()
            }
        }
        zipText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                zipValid = true
                zipField.error = null
                checkAllValid2()
            }
        }
    }

    fun checkAddressValid() {
        addressText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && addressText.text.isNullOrBlank()) {
                addressField.error = "This field is required"
            } else {
                addressValid = true
            }
        }
    }

    fun checkCityValid() {
        cityText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && cityText.text.isNullOrBlank()) {
                cityField.error = "This field is required"
            } else {
                cityValid = true
            }
        }
    }

    fun checkStateValid() {
        stateText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && stateText.text.isNullOrBlank()) {
                stateField.error = "This field is required"
            } else {
                stateValid = true
            }
        }
    }

    fun checkZipValid() {
        zipText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && zipText.text.isNullOrBlank()) {
                zipField.error = "This field is required"
            } else if (!hasFocus && !zipText.text.matches(".*[0-9].*".toRegex())) {
                zipField.error = "Please enter a valid zip code"
            } else {
                zipValid = true
            }
        }
    }


    fun checkAllValid2() {
        if (addressValid && cityValid && stateValid && zipValid) {
            saveBtn2.isEnabled = true
        }
    }






}