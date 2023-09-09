package com.example.login.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val id : Int?,
    @ColumnInfo(name = "Username") val username : String?,
    @ColumnInfo(name = "Email") val email : String?,
    @ColumnInfo(name = "Password") val password : String?
)
