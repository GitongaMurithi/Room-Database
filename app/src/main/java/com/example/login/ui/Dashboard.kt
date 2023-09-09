package com.example.login.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }
}