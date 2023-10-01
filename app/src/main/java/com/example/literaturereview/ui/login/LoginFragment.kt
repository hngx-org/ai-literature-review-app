package com.example.literaturereview.ui.login

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.literaturereview.R
import com.example.literaturereview.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        setupTextChangeListeners()
    }

    private fun setupClickListeners() {
        binding.signupTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        binding.forgotPasswordTextView.setOnClickListener {
            // Navigate to the forgot password screen (e.g., using a bottom sheet)
        }

        binding.googleLoginButton.setOnClickListener {
            // Implement Google Sign-In functionality
        }

        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_promptFragment)
        }
    }

    private fun setupTextChangeListeners() {
        binding.emailEditText.doOnTextChanged { _, _, _, _ ->
            binding.emailInputLayout.error = validEmail()
            validateButton()
        }

        binding.passwordEditText.doOnTextChanged { _, _, _, _ ->
            binding.passwordInputLayout.error = validPassword()
            validateButton()
        }
    }

    private fun validEmail(): String? {
        val email = binding.emailEditText.text.toString()

        return when {
            email.isBlank() -> null
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Please enter a valid email address"
            else -> null
        }
    }

    private fun validPassword(): String? {
        val password = binding.passwordEditText.text.toString()

        val containsLowercase = password.any { it.isLowerCase() }
        val containsUppercase = password.any { it.isUpperCase() }
        val containsDigit = password.any { it.isDigit() }
        val containsSpecialCharacter = password.any { !it.isLetterOrDigit() }

        return when {
            password.isBlank() -> "Password cannot be empty"
            password.length < 8 -> "Password must be at least 8 characters long"
            !containsLowercase -> "Password must contain at least one lowercase letter"
            !containsUppercase -> "Password must contain at least one uppercase letter"
            !containsDigit -> "Password must contain at least one digit"
            !containsSpecialCharacter -> "Password must contain at least one special character"
            else -> null
        }
    }

    private fun validateButton() {
        val validEmail = validEmail() == null
        val validPassword = validPassword() == null

        if (validEmail && validPassword) {
            binding.loginButton.alpha = 1f
            binding.loginButton.isEnabled = true
        } else {
            binding.loginButton.alpha = 0.5f
            binding.loginButton.isEnabled = false
        }
    }

}