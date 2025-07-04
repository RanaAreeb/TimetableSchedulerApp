package com.example.timeatbleschedulerapp.ui.screens.auth;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.models.User;
import com.example.timeatbleschedulerapp.data.models.UserRole;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0004\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState;", "", "()V", "toString", "", "Error", "Idle", "Loading", "Success", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Error;", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Idle;", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Loading;", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Success;", "app_debug"})
public abstract class AuthState {
    
    private AuthState() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Error;", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Error extends com.example.timeatbleschedulerapp.ui.screens.auth.AuthState {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.timeatbleschedulerapp.ui.screens.auth.AuthState.Error copy(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Idle;", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState;", "()V", "app_debug"})
    public static final class Idle extends com.example.timeatbleschedulerapp.ui.screens.auth.AuthState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.timeatbleschedulerapp.ui.screens.auth.AuthState.Idle INSTANCE = null;
        
        private Idle() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Loading;", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState;", "()V", "app_debug"})
    public static final class Loading extends com.example.timeatbleschedulerapp.ui.screens.auth.AuthState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.timeatbleschedulerapp.ui.screens.auth.AuthState.Loading INSTANCE = null;
        
        private Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState$Success;", "Lcom/example/timeatbleschedulerapp/ui/screens/auth/AuthState;", "user", "Lcom/example/timeatbleschedulerapp/data/models/User;", "(Lcom/example/timeatbleschedulerapp/data/models/User;)V", "getUser", "()Lcom/example/timeatbleschedulerapp/data/models/User;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Success extends com.example.timeatbleschedulerapp.ui.screens.auth.AuthState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.timeatbleschedulerapp.data.models.User user = null;
        
        public Success(@org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.data.models.User user) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.timeatbleschedulerapp.data.models.User getUser() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.timeatbleschedulerapp.data.models.User component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.timeatbleschedulerapp.ui.screens.auth.AuthState.Success copy(@org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.data.models.User user) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}