package com.example.timeatbleschedulerapp.ui.screens.notifications;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.models.Notification;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import com.example.timeatbleschedulerapp.utils.NotificationDebugHelper;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0019R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/notifications/NotificationsViewModel;", "Landroidx/lifecycle/ViewModel;", "notificationRepository", "Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;", "authRepository", "Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;", "debugHelper", "Lcom/example/timeatbleschedulerapp/utils/NotificationDebugHelper;", "(Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;Lcom/example/timeatbleschedulerapp/utils/NotificationDebugHelper;)V", "_error", "Landroidx/lifecycle/MutableLiveData;", "", "_isLoading", "", "_notifications", "", "Lcom/example/timeatbleschedulerapp/data/models/Notification;", "error", "Landroidx/lifecycle/LiveData;", "getError", "()Landroidx/lifecycle/LiveData;", "isLoading", "notifications", "getNotifications", "debugNotifications", "", "loadNotifications", "markAsRead", "notification", "refreshNotifications", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NotificationsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.utils.NotificationDebugHelper debugHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.Notification>> _notifications = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.Notification>> notifications = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> error = null;
    
    @javax.inject.Inject()
    public NotificationsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.utils.NotificationDebugHelper debugHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.Notification>> getNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getError() {
        return null;
    }
    
    public final void loadNotifications() {
    }
    
    public final void markAsRead(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.Notification notification) {
    }
    
    public final void refreshNotifications() {
    }
    
    public final void debugNotifications() {
    }
}