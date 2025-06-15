package com.example.timeatbleschedulerapp.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.timeatbleschedulerapp.MainActivity;
import com.example.timeatbleschedulerapp.R;
import com.example.timeatbleschedulerapp.data.repository.FCMRepository;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J,\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0016H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/example/timeatbleschedulerapp/services/FCMService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "fcmRepository", "Lcom/example/timeatbleschedulerapp/data/repository/FCMRepository;", "getFcmRepository", "()Lcom/example/timeatbleschedulerapp/data/repository/FCMRepository;", "setFcmRepository", "(Lcom/example/timeatbleschedulerapp/data/repository/FCMRepository;)V", "createNotificationChannel", "", "onCreate", "onMessageReceived", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "showNotification", "title", "body", "data", "", "app_debug"})
public final class FCMService extends com.google.firebase.messaging.FirebaseMessagingService {
    @javax.inject.Inject()
    public com.example.timeatbleschedulerapp.data.repository.FCMRepository fcmRepository;
    
    public FCMService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.timeatbleschedulerapp.data.repository.FCMRepository getFcmRepository() {
        return null;
    }
    
    public final void setFcmRepository(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.FCMRepository p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onMessageReceived(@org.jetbrains.annotations.NotNull()
    com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    @java.lang.Override()
    public void onNewToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    private final void showNotification(java.lang.String title, java.lang.String body, java.util.Map<java.lang.String, java.lang.String> data) {
    }
    
    private final void createNotificationChannel() {
    }
}