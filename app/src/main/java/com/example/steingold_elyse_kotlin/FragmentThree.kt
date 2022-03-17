package com.example.steingold_elyse_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_three.*


class FragmentThree : Fragment() {

    lateinit var displayRes: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayRes = view.findViewById(R.id.result)

        val model = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)
        model.firstName.observe(viewLifecycleOwner, Observer {
            displayRes.text = it
        })
    }



//    private lateinit var viewModel: FormViewModel
//
//        override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_three, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        activity?.let {
//            ViewModelProviders.of(it)[FormViewModel::class.java]
//        } ?: throw Exception("Activity is null")
//
//
//        viewModel.firstName.observe(viewLifecycleOwner, Observer<String>{name1 ->
//            result.text = name1
//        })
//    }


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_three, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        var viewModel = ViewModelProvider(this).get(FormViewModel::class.java)
//
//        result.text = viewModel.firstName.value.toString()
//
//    }

}