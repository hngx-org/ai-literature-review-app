package com.example.literaturereview.ui.signup

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.literaturereview.R
import com.example.literaturereview.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpClickListeners()
        setUpTextChangeListeners()
    }

    private fun setUpClickListeners() {
        binding.createAccountButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        binding.termsText.setOnClickListener {
            // navigates to terms screen, could be a dialog
        }

        binding.loginTextView.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        binding.googleSignupButton.setOnClickListener {

        }
    }

    private fun setUpTextChangeListeners() {

        binding.nameEditText.doOnTextChanged { _, _, _, _ ->
            binding.nameInputLayout.error = validName()
        }

        binding.emailEditText.doOnTextChanged { _, _, _, _ ->
            binding.emailInputLayout.error = validEmail()
            validateButton()
        }

        binding.passwordEditText.doOnTextChanged { _, _, _, _ ->
            binding.passwordInputLayout.error = validPassword()
            validateButton()
        }
    }

    private fun validName(): String? {
        val name = binding.nameEditText.text.toString()
        return when {
            name.isBlank() -> "Name cannot be empty"
            else -> null
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
        val validName = validName() == null
        val validEmail = validEmail() == null
        val validPassword = validPassword() == null

        if (validName && validEmail && validPassword) {
            binding.createAccountButton.alpha = 1f
            binding.createAccountButton.isEnabled = true
        } else {
            binding.createAccountButton.alpha = 0.5f
            binding.createAccountButton.isEnabled = false
        }
    }
}