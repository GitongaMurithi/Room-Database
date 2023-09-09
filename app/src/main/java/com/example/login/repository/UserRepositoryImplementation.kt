package com.example.login.repository

import com.example.login.data.User
import com.example.login.data.UserDao

class UserRepositoryImplementation(
    private val dao: UserDao
) : UserRepository{
    override suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }

    override suspend fun getUserByEmailAndPassword(email: String, password: String): User? {
        return dao.getUserByEmailAndPassword(email, password)
    }

}