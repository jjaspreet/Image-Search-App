package com.example.myapplication.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.myapplication.data.UnsplashRepository
import javax.inject.Inject


class GalleryViewModel @ViewModelInject constructor(
    repository: UnsplashRepository
) : ViewModel() {


    companion object{
        private const val DEFAULT_QUERY = "cats"
    }

    private val currentQuery= MutableLiveData(DEFAULT_QUERY)


    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchPhotosResult(queryString).cachedIn(viewModelScope)

    }

     fun getSearchPhotoResult(query: String){
       currentQuery.value = query
    }
}