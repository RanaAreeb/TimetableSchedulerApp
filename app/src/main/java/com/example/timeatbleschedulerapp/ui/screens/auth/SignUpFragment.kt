package com.example.timeatbleschedulerapp.ui.screens.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.timeatbleschedulerapp.R
import com.example.timeatbleschedulerapp.data.models.UserRole
import com.example.timeatbleschedulerapp.databinding.FragmentSignUpBinding
import kotlinx.coroutines.launch

private const val TAG = "SignUpFragment"

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRoleDropdown()
        setupSignUpButton()
        observeAuthState()

        Log.d(TAG, "SignUpFragment view created")
    }

    private fun setupRoleDropdown() {
        val roles = arrayOf("Student", "Teacher", "Batch Coordinator")
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, roles)
        binding.actvRole.setAdapter(adapter)
        binding.actvRole.setText(roles[0], false) // Default to Student

        Log.d(TAG, "Role dropdown setup complete")
    }

    private fun setupSignUpButton() {
        binding.btnSignUp.setOnClickListener {
            Log.d(TAG, "Sign up button clicked")

            // Clear previous errors
            binding.etSignUpName.error = null
            binding.etSignUpEmail.error = null
            binding.etSignUpPassword.error = null
            binding.actvRole.error = null

            val name = binding.etSignUpName.text.toString().trim()
            val email = binding.etSignUpEmail.text.toString().trim()
            val password = binding.etSignUpPassword.text.toString().trim()
            val roleText = binding.actvRole.text.toString()

            if (validateInput(name, email, password, roleText)) {
                showLoading(true)

                val role = when (roleText) {
                    "Student" -> UserRole.STUDENT
                    "Teacher" -> UserRole.TEACHER
                    "Batch Coordinator" -> UserRole.BATCH_COORDINATOR
                    else -> UserRole.STUDENT
                }

                Log.d(TAG, "Attempting to sign up with email: $email, role: $role")
                viewModel.signUp(email, password, name, role)
            } else {
                Log.d(TAG, "Input validation failed")
            }
        }
    }

    private fun observeAuthState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.authState.collect { state ->
                Log.d(TAG, "Auth state in SignUpFragment: $state")
                when (state) {
                    is AuthState.Loading -> {
                        showLoading(true)
                    }
                    is AuthState.Success -> {
                        showLoading(false)
                        Toast.makeText(
                            requireContext(),
                            "Account created successfully!",
                            Toast.LENGTH_SHORT
                        ).show()
                        // Navigation is handled in the Activity
                    }
                    is AuthState.Error -> {
                        showLoading(false)
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                        Log.e(TAG, "Sign up error: ${state.message}")
                    }
                    is AuthState.Idle -> {
                        showLoading(false)
                    }
                }
            }
        }
    }

    private fun validateInput(name: String, email: String, password: String, role: String): Boolean {
        var isValid = true

        if (name.isEmpty()) {
            binding.etSignUpName.error = "Name is required"
            isValid = false
        }

        if (email.isEmpty()) {
            binding.etSignUpEmail.error = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etSignUpEmail.error = "Please enter a valid email address"
            isValid = false
        }

        if (password.isEmpty()) {
            binding.etSignUpPassword.error = "Password is required"
            isValid = false
        } else if (password.length < 6) {
            binding.etSignUpPassword.error = "Password must be at least 6 characters"
            isValid = false
        }

        if (role.isEmpty()) {
            binding.actvRole.error = "Please select a role"
            isValid = false
        }

        return isValid
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.btnSignUp.isEnabled = false
            binding.btnSignUp.text = "Creating Account..."
        } else {
            binding.progressBar.visibility = View.GONE
            binding.btnSignUp.isEnabled = true
            binding.btnSignUp.text = "Create Account"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
