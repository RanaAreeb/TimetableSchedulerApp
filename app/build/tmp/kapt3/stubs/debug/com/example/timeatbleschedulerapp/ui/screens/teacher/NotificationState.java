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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Error;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Idle;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Loading;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Success;", "app_debug"})
public abstract class NotificationState {
    
    private NotificationState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Error;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Error extends com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState {
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
        public final com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState.Error copy(@org.jetbrains.annotations.NotNull()
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Idle;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState;", "()V", "app_debug"})
    public static final class Idle extends com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState.Idle INSTANCE = null;
        
        private Idle() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Loading;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState;", "()V", "app_debug"})
    public static final class Loading extends com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState.Loading INSTANCE = null;
        
        private Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState$Success;", "Lcom/example/timeatbleschedulerapp/ui/screens/teacher/NotificationState;", "()V", "app_debug"})
    public static final class Success extends com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.timeatbleschedulerapp.ui.screens.teacher.NotificationState.Success INSTANCE = null;
        
        private Success() {
        }
    }
}