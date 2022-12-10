package com.mustafa.codechallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.codechallenge.data.model.StoryContent
import com.mustafa.codechallenge.data.repository.MainRepository
import com.mustafa.codechallenge.utils.NetworkHelper
import com.mustafa.codechallenge.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _brochures = MutableLiveData<Resource<List<StoryContent>>>()
    val brochures: LiveData<Resource<List<StoryContent>>>
        get() = _brochures

    init {
        fetchStoryBrochures()
    }

     fun fetchStoryBrochures() {
        viewModelScope.launch {
            _brochures.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getBrochures().let {
                    if (it.isSuccessful) {
                        val list = it.body()?.embedded?.contents?.filter { storyContent ->
                            storyContent.contentType.contains("brochure")
                        }
                        _brochures.postValue(Resource.success(list))
                    } else _brochures.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _brochures.postValue(Resource.error("No internet connection", null))
        }
    }
}