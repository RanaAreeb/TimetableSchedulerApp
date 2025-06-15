package com.example.timeatbleschedulerapp.ui.screens.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.timeatbleschedulerapp.databinding.FragmentSignInBinding
import kotlinx.coroutines.launch

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSignInButton()
        observeAuthState()

        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(requireContext(), "Forgot password functionality coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupSignInButton() {
        binding.btnSignIn.setOnClickListener {
            val email = binding.etSignInEmail.text.toString().trim()
            val password = binding.etSignInPassword.text.toString().trim()

            if (validateInput(email, password)) {
                showLoading(true)
                viewModel.signIn(email, password)
            }
        }
    }

    private fun observeAuthState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.authState.collect { state ->
                when (state) {
                    is AuthState.Loading -> {
                        showLoading(true)
                    }
                    is AuthState.Success -> {
                        showLoading(false)
                        // Navigation is handled in the Activity
                    }
                    is AuthState.Error -> {
                        showLoading(false)
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                        Log.e("SignInFragment", "Sign in error: ${state.message}")
                    }
                    is AuthState.Idle -> {
                        showLoading(false)
                    }
                }
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        var isValid = true

        if (email.isEmpty()) {
            binding.etSignInEmail.error = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etSignInEmail.error = "Please enter a valid email address"
            isValid = false
        }

        if (password.isEmpty()) {
            binding.etSignInPassword.error = "Password is required"
            isValid = false
        }

        return isValid
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.btnSignIn.isEnabled = !isLoading
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
