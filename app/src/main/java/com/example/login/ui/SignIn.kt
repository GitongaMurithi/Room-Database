package com.example.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.login.databinding.ActivitySignInBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignIn : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding.signInButton2.setOnClickListener {
            if (binding.signInEmail.text.isEmpty()) {
                binding.signInEmail.error = "This field can't be empty"
                binding.signInEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(binding.signInEmail.text.toString()).matches()) {
                binding.signInEmail.error = "Enter a valid email address"
                binding.signInEmail.requestFocus()
                return@setOnClickListener
            }
            if (binding.signInPassword.text.isEmpty()) {
                binding.signInPassword.error = "This field can't be empty"
                binding.signInPassword.requestFocus()
                return@setOnClickListener
            }
            lifecycleScope.launch {
                val user = viewModel.getUserByEmailAndPassword(
                    binding.signInEmail.text.toString(),
                    binding.signInPassword.text.toString()
                )
                if (user != null) {
                    startActivity(Intent(this@SignIn,Dashboard::class.java))
                    Toast.makeText(this@SignIn,"Signed in successfully",Toast.LENGTH_LONG).show()
                    binding.signInEmail.setText("")
                    binding.signInPassword.setText("")
                    finish()
                } else {
                    Toast.makeText(this@SignIn,"User with these credentials does not exist!",Toast.LENGTH_LONG).show()
                }
            }

        }

        binding.signUpButton2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}