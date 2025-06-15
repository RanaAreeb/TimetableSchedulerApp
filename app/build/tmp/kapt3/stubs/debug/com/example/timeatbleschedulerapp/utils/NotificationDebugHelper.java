package com.example.timeatbleschedulerapp.utils;

import android.util.Log;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import com.google.firebase.firestore.FirebaseFirestore;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/timeatbleschedulerapp/utils/NotificationDebugHelper;", "", "authRepository", "Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;", "notificationRepository", "Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;Lcom/example/timeatbleschedulerapp/data/repository/NotificationRepository;Lcom/google/firebase/firestore/FirebaseFirestore;)V", "TAG", "", "debugNotificationFlow", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NotificationDebugHelper {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "NotificationDebug";
    
    @javax.inject.Inject()
    public NotificationDebugHelper(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.NotificationRepository notificationRepository, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object debugNotificationFlow(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}