package com.example.timeatbleschedulerapp.data.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.util.Log;
import com.example.timeatbleschedulerapp.data.models.User;
import com.example.timeatbleschedulerapp.data.models.UserRole;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001e"}, d2 = {"Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "context", "Landroid/content/Context;", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/firestore/FirebaseFirestore;Landroid/content/Context;)V", "getCurrentUser", "Lcom/example/timeatbleschedulerapp/data/models/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUserId", "", "isNetworkAvailable", "", "signIn", "Lkotlin/Result;", "email", "password", "signIn-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "signUp", "name", "role", "Lcom/example/timeatbleschedulerapp/data/models/UserRole;", "signUp-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/timeatbleschedulerapp/data/models/UserRole;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public AuthRepository(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final boolean isNetworkAvailable() {
        return false;
    }
    
    public final void signOut() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.timeatbleschedulerapp.data.models.User> $completion) {
        return null;
    }
}