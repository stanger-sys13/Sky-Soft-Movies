package com.example.skysoftmovies.db.modelorient

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class User : Serializable {
    //declaration of user table columns
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


    var mobillogin: String? = null


    var password: String? = null


}