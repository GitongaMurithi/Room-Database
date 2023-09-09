package com.example.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.data.User
import com.example.login.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    suspend fun getUserByEmailAndPassword(email: String, password: String): User? {
        return repository.getUserByEmailAndPassword(email, password)
    }
}