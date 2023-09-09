package com.example.login.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("select * from user where email = :email and password = :password")
    suspend fun getUserByEmailAndPassword(email : String , password : String) : User?
}