package com.example.skysoftmovies.db.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.skysoftmovies.db.modelorient.User
import com.example.skysoftmovies.db.repository2db.UserDetailsRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: UserDetailsRepository
    private var getAllDatas: LiveData<List<User>>

    init {

        repository = UserDetailsRepository(application)
        getAllDatas = repository.getAllData()!!
    }

    fun insert(data: User) {
        repository.insertData(data)
    }
    fun getGetAllData(): LiveData<List<User>> {
        return getAllDatas
    }
}