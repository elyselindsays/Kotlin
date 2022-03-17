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

    val street: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val city: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val state: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val zip: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val bio: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val interests: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setFirstName(firstNameText: String) {
        firstName.setValue(firstNameText)
    }

    fun setLastName(lastNameText: String) {
        lastName.setValue(lastNameText)
    }





    fun setFragment1ModelData(firstNameText: String, lastNameText: String, emailText: String, phoneText: String){
        firstName.setValue(firstNameText)
        lastName.setValue(lastNameText)
        email.setValue(emailText)
        phone.setValue(phoneText)
    }

    fun setFragment2ModelData(firstNameText: String, lastNameText: String, emailText: String, phoneText: String){
        firstName.setValue(firstNameText)
        lastName.setValue(lastNameText)
        email.setValue(emailText)
        phone.setValue(phoneText)
    }

    fun setFragment3ModelData(firstNameText: String, lastNameText: String, emailText: String, phoneText: String){
        firstName.setValue(firstNameText)
        lastName.setValue(lastNameText)
        email.setValue(emailText)
        phone.setValue(phoneText)
    }




}