package com.example.timeatbleschedulerapp.services;

import android.util.Log;
import com.example.timeatbleschedulerapp.data.repository.FCMRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJJ\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0018"}, d2 = {"Lcom/example/timeatbleschedulerapp/services/NotificationManager;", "", "notificationRepository", "Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;", "fcmRepository", "Lcom/example/timeatbleschedulerapp/data/repository/FCMRepository;", "firebaseAdminService", "Lcom/example/timeatbleschedulerapp/services/FirebaseAdminService;", "(Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;Lcom/example/timeatbleschedulerapp/data/repository/FCMRepository;Lcom/example/timeatbleschedulerapp/services/FirebaseAdminService;)V", "sendCompleteNotification", "Lkotlin/Result;", "", "title", "message", "senderId", "senderName", "recipientIds", "", "sendCompleteNotification-hUnOzRk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendTestNotification", "recipientId", "sendTestNotification-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NotificationManager {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.FCMRepository fcmRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.services.FirebaseAdminService firebaseAdminService = null;
    
    @javax.inject.Inject()
    public NotificationManager(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.FCMRepository fcmRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.services.FirebaseAdminService firebaseAdminService) {
        super();
    }
}