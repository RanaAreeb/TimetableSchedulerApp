package com.example.timeatbleschedulerapp.ui.screens.auth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.timeatbleschedulerapp.R;
import com.example.timeatbleschedulerapp.data.models.UserRole;
import com.example.timeatbleschedulerapp.databinding.FragmentSignUpBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J(\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006&"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/auth/SignUpFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/timeatbleschedulerapp/databinding/FragmentSignUpBinding;", "binding", "getBinding", "()Lcom/example/timeatbleschedulerapp/databinding/FragmentSignUpBinding;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeAuthState", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupRoleDropdown", "setupSignUpButton", "showLoading", "isLoading", "", "validateInput", "name", "", "email", "password", "role", "app_debug"})
public final class SignUpFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.timeatbleschedulerapp.databinding.FragmentSignUpBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public SignUpFragment() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.databinding.FragmentSignUpBinding getBinding() {
        return null;
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.auth.AuthViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRoleDropdown() {
    }
    
    private final void setupSignUpButton() {
    }
    
    private final void observeAuthState() {
    }
    
    private final boolean validateInput(java.lang.String name, java.lang.String email, java.lang.String password, java.lang.String role) {
        return false;
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}