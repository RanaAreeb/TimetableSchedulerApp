package com.example.timeatbleschedulerapp.ui.screens.notifications;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.timeatbleschedulerapp.R;
import com.example.timeatbleschedulerapp.databinding.ActivityNotificationsBinding;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0016\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006 "}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/notifications/NotificationsActivity;", "Landroidx/activity/ComponentActivity;", "()V", "adapter", "Lcom/example/timeatbleschedulerapp/ui/screens/notifications/NotificationsAdapter;", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ActivityNotificationsBinding;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/notifications/NotificationsViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/notifications/NotificationsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setupRecyclerView", "setupToolbar", "showEmptyState", "showNotifications", "notifications", "", "Lcom/example/timeatbleschedulerapp/data/models/Notification;", "app_debug"})
public final class NotificationsActivity extends androidx.activity.ComponentActivity {
    private com.example.timeatbleschedulerapp.databinding.ActivityNotificationsBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsAdapter adapter;
    
    public NotificationsActivity() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsViewModel getViewModel() {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void showNotifications(java.util.List<com.example.timeatbleschedulerapp.data.models.Notification> notifications) {
    }
    
    private final void showEmptyState() {
    }
}