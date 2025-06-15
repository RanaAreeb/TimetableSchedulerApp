package com.example.timeatbleschedulerapp.ui.screens.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import com.example.timeatbleschedulerapp.R;
import com.example.timeatbleschedulerapp.databinding.ActivityDashboardStudentBinding;
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthActivity;
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsActivity;
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewerActivity;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/student/StudentDashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ActivityDashboardStudentBinding;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/student/StudentDashboardViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/student/StudentDashboardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "logout", "", "observeData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setupClickListeners", "setupToolbar", "showLogoutDialog", "app_debug"})
public final class StudentDashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.timeatbleschedulerapp.databinding.ActivityDashboardStudentBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public StudentDashboardActivity() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeData() {
    }
    
    private final void showLogoutDialog() {
    }
    
    private final void logout() {
    }
}