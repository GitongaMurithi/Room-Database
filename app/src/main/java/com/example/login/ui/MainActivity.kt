package com.example.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.login.data.User
import com.example.login.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding.signUpButton1.setOnClickListener {
            if (binding.username.text.toString().isEmpty()) {
                binding.username.error = "This field can't be empty"
                binding.username.requestFocus()
                return@setOnClickListener
            }
            if (binding.email.text.toString().isEmpty()) {
                binding.email.error = "This field can't be empty"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(binding.email.text.toString()).matches()) {
                binding.email.error = "Enter a valid email address"
                binding.email.requestFocus()
                return@setOnClickListener
            }
            if (binding.password.text.toString().isEmpty()) {
                binding.password.error = "This field can't be empty"
                binding.password.requestFocus()
                return@setOnClickListener
            }
            if (binding.password.text.toString().length < 4) {
                binding.password.error = "Password should be at least 4 characters"
                binding.password.requestFocus()
                return@setOnClickListener
            }
            viewModel.insertUser(
                User(
                    id = null,
                    username = binding.username.text.toString(),
                    email = binding.email.text.toString(),
                    password = binding.password.text.toString()
                )
            )
            startActivity(Intent(this, SignIn::class.java))
            Toast.makeText(this, "Signed up successfully", Toast.LENGTH_SHORT).show()
            binding.username.setText("")
            binding.email.setText("")
            binding.password.setText("")
        }

        binding.signInButton1.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }
    }
}