package com.example.steingold_elyse_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {
    val firstName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val lastName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val email: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val phone: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val address: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val city: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val state: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val zip: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val bio: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val interests: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    fun setFragment1ModelData(firstNameText: String, lastNameText: String, emailText: String, phoneText: String){
        firstName.value = firstNameText
        lastName.value = lastNameText
        email.value = emailText
        phone.value = phoneText
    }

    fun setFragment2ModelData(addressText: String, cityText: String, stateText: String, zipText: String){
        address.setValue(addressText)
        city.setValue(cityText)
        state.setValue(stateText)
        zip.setValue(zipText)
    }

    fun setFragment3ModelData(bioText: String, interestsText: String){
        bio.setValue(bioText)
        interests.setValue(interestsText)
    }

}