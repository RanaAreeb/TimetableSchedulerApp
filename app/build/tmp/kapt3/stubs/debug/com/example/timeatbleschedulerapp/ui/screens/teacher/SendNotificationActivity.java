package com.example.timeatbleschedulerapp.ui.screens.teacher;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import com.example.timeatbleschedulerapp.R;
import com.example.timeatbleschedulerapp.databinding.ActivitySendNotificationBinding;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/teacher/SendNotificationActivity;", "Landroidx/activity/ComponentActivity;", "()V", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ActivitySendNotificationBinding;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/SendNotificationViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/teacher/SendNotificationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadBatches", "", "loadStudents", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupRecipientDropdown", "setupSendButton", "setupToolbar", "showLoading", "isLoading", "", "validateInput", "title", "", "message", "app_debug"})
public final class SendNotificationActivity extends androidx.activity.ComponentActivity {
    private com.example.timeatbleschedulerapp.databinding.ActivitySendNotificationBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public SendNotificationActivity() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecipientDropdown() {
    }
    
    private final void loadBatches() {
    }
    
    private final void loadStudents() {
    }
    
    private final void setupSendButton() {
    }
    
    private final boolean validateInput(java.lang.String title, java.lang.String message) {
        return false;
    }
    
    private final void observeViewModel() {
    }
    
    private final void showLoading(boolean isLoading) {
    }
}