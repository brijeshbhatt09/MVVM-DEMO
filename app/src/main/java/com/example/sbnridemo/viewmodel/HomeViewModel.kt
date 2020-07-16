package com.example.sbnridemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sbnridemo.model.HomeResponse
import com.example.sbnridemo.repository.ProjectRepository

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private var viewResponse: MutableLiveData<HomeResponse?>? = null
    private val isLoading = MutableLiveData<Boolean>()


    fun getHomeResponse(page : Int, url: String): LiveData<HomeResponse?>? {
        if (viewResponse == null) {
            isLoading.setValue(true)
        }
        viewResponse = ProjectRepository.getHomeResponse(page, url, getApplication())

        return viewResponse

    }

    fun setLoading(loading: Boolean) {
        isLoading.value = false
    }

    fun isLoading(): MutableLiveData<Boolean>? {
        return isLoading
    }
}