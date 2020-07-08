package com.ultrasoft.ghnewsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ultrasoft.ghnewsapp.data.api.ApiHelper
import com.ultrasoft.ghnewsapp.repository.MainRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

