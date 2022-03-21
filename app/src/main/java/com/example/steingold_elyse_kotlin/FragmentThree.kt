package com.example.steingold_elyse_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_three.*
import org.w3c.dom.Text


class FragmentThree : Fragment() {

    lateinit var displayRes: TextView
    lateinit var submitButton: Button
    lateinit var bioText: EditText
    lateinit var interestsText: EditText
    var bioValid = false
    var interestsValid = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        submitButton = view.findViewById(R.id.submitButton)
        bioText = view.findViewById(R.id.bioInput)
        interestsText = view.findViewById(R.id.interestsInput)

        checkEmpty3()
        checkBioValid()
        checkInterestsValid()

        submitButton.setOnClickListener {
            viewModel.setFragment3ModelData(
                bioText.text.toString(),
                interestsText.text.toString()
            )
            viewModel.firstName.observe(viewLifecycleOwner, Observer {
                firstNameRes.text = it
            })
            viewModel.lastName.observe(viewLifecycleOwner, Observer {
                lastNameRes.text = it
            })
            viewModel.email.observe(viewLifecycleOwner, Observer {
                emailRes.text = it
            })
            viewModel.phone.observe(viewLifecycleOwner, Observer {
                phoneRes.text = it
            })
            viewModel.address.observe(viewLifecycleOwner, Observer {
                streetRes.text = it
            })
            viewModel.city.observe(viewLifecycleOwner, Observer {
                cityRes.text = it
            })
            viewModel.state.observe(viewLifecycleOwner, Observer {
                stateRes.text = it
            })
            viewModel.zip.observe(viewLifecycleOwner, Observer {
                zipRes.text = it
            })
            viewModel.bio.observe(viewLifecycleOwner, Observer {
                bioRes.text = it
            })
            viewModel.interests.observe(viewLifecycleOwner, Observer {
                interestsRes.text = it
            })
            resultsContainer.isVisible = true

        }
    }


    fun checkEmpty3() {
        bioText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                bioValid = true
                bioField.error = null
                checkAllValid3()
            }
        }
        interestsText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrBlank()) {
                interestsValid = true
                interestsField.error = null
                checkAllValid3()
            }
        }
    }

    fun checkAllValid3() {
        if (bioValid && interestsValid) {
            submitButton.isEnabled = true
        }
    }

    fun checkBioValid() {
        bioText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && bioText.text.isNullOrBlank()) {
                bioField.error = "This field is required"
            } else {
                bioValid = true
            }
        }
    }

    fun checkInterestsValid() {
        interestsText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus && interestsText.text.isNullOrBlank()) {
                interestsField.error = "This field is required"
            } else {
                interestsValid = true
            }
        }
    }



}