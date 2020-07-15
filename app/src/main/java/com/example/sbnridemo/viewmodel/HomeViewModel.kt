package com.example.sbnridemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.repository.ProjectRepository

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

class HomeViewModel : ViewModel() {

    private var viewResponse: MutableLiveData<HomeResponse?>? = null
    private val isLoading = MutableLiveData<Boolean>()


    fun getHomeResponse(url: String): LiveData<HomeResponse?>? {
        if (viewResponse == null) {
            isLoading.setValue(true)
            viewResponse = ProjectRepository.getHomeResponse(url)
        }
        return viewResponse
    }

    fun setLoading(loading: Boolean) {
        isLoading.value = false
    }

    fun isLoading(): MutableLiveData<Boolean>? {
        return isLoading
    }
}