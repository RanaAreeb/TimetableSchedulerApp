package com.example.timeatbleschedulerapp.ui.screens.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.example.timeatbleschedulerapp.data.models.UserRole;
import com.example.timeatbleschedulerapp.databinding.ActivityAuthBinding;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardActivity;
import com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardActivity;
import com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardActivity;
import com.google.android.material.tabs.TabLayoutMediator;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ActivityAuthBinding;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "navigateToDashboard", "", "role", "Lcom/example/timeatbleschedulerapp/data/models/UserRole;", "observeAuthState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupViewPager", "app_debug"})
public final class AuthActivity extends androidx.fragment.app.FragmentActivity {
    private com.example.timeatbleschedulerapp.databinding.ActivityAuthBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public AuthActivity() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.auth.AuthViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewPager() {
    }
    
    private final void observeAuthState() {
    }
    
    private final void navigateToDashboard(com.example.timeatbleschedulerapp.data.models.UserRole role) {
    }
}