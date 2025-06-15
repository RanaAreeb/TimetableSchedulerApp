package com.example.timeatbleschedulerapp.ui.screens.teacher;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import com.example.timeatbleschedulerapp.services.NotificationManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/teacher/SendNotificationViewModel;", "Landroidx/lifecycle/ViewModel;", "notificationManager", "Lcom/example/timeatbleschedulerapp/services/NotificationManager;", "notificationRepository", "Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;", "authRepository", "Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;", "(Lcom/example/timeatbleschedulerapp/services/NotificationManager;Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;)V", "_notificationState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState;", "notificationState", "Landroidx/lifecycle/LiveData;", "getNotificationState", "()Landroidx/lifecycle/LiveData;", "sendNotification", "", "title", "", "message", "recipientType", "recipientId", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SendNotificationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.services.NotificationManager notificationManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState> _notificationState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState> notificationState = null;
    
    @javax.inject.Inject()
    public SendNotificationViewModel(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.services.NotificationManager notificationManager, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState> getNotificationState() {
        return null;
    }
    
    public final void sendNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String recipientType, @org.jetbrains.annotations.NotNull()
    java.lang.String recipientId) {
    }
}