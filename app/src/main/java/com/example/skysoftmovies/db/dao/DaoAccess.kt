package com.example.skysoftmovies.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.skysoftmovies.db.modelorient.User

@Dao
interface DaoAccess {


    @Insert
    fun insertUserData(user: User)  //   query is written above for insert all details of user

    @Query("select * from User")
    fun getDetails(): LiveData<List<User>> //   query is written above for fetching all details of user

    @Query("DELETE FROM User WHERE id = :id")
    fun deleteByUserId(id: Long)   //  do it by your own for practise  query is written above
}