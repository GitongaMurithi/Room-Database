package com.example.login.repository

import com.example.login.data.User

interface UserRepository {

    suspend fun insertUser(user: User)

    suspend fun getUserByEmailAndPassword(email : String , password : String) : User?
}