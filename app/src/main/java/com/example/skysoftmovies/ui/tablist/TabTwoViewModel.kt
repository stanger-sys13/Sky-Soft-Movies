package com.example.skysoftmovies.ui.tablist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skysoftmovies.model.ListFilmes
import com.example.skysoftmovies.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class TabTwoViewModel : ViewModel() {

    val listFilmesLiveData = MutableLiveData<ListFilmes>()
    val repository = RepositoryApi()
    val errorMessage = MutableLiveData<String>()

    fun baseListDeFilmesCoroutines(){
        CoroutineScope(Dispatchers.IO).launch {

            try {
                repository.baseListDeFilmesApi().let {
                    listFilmesLiveData.postValue(it)
                }
            }

            catch (error: Throwable) {
                Erroor(error)
            }
        }
    }

    private fun Erroor(error: Throwable) {
        when(error){
            is UnknownHostException -> errorMessage.postValue("check your connections")
        }
    }
}