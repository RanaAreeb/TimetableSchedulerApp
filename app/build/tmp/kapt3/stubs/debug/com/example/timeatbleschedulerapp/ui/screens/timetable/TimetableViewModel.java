package com.example.timeatbleschedulerapp.ui.screens.timetable;

import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.models.TimetableEntry;
import com.example.timeatbleschedulerapp.data.models.User;
import com.example.timeatbleschedulerapp.data.models.UserRole;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010 \u001a\u00020\u000bJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010 \u001a\u00020\u000bJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\b\u0010#\u001a\u0004\u0018\u00010\u0011J\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100%J\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020\u001eJ\b\u0010*\u001a\u00020\u001eH\u0002J\u0006\u0010+\u001a\u00020\u001eJ\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/timetable/TimetableViewModel;", "Landroidx/lifecycle/ViewModel;", "timetableRepository", "Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;", "authRepository", "Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;Lcom/google/firebase/firestore/FirebaseFirestore;)V", "_errorMessage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isLoading", "", "_selectedDay", "_timetableEntries", "", "Lcom/example/timeatbleschedulerapp/data/models/TimetableEntry;", "currentUser", "Lcom/example/timeatbleschedulerapp/data/models/User;", "errorMessage", "Lkotlinx/coroutines/flow/StateFlow;", "getErrorMessage", "()Lkotlinx/coroutines/flow/StateFlow;", "isLoading", "selectedDay", "getSelectedDay", "timetableEntries", "getTimetableEntries", "clearError", "", "filterByDay", "day", "getEntriesForDay", "getEntriesForSelectedDay", "getNextClass", "getTimetableForWeek", "", "getTotalClassesForWeek", "", "hasClassesOnDay", "loadActiveTimetable", "loadCurrentUser", "refreshTimetable", "selectDay", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TimetableViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.TimetableRepository timetableRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> _timetableEntries = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> timetableEntries = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedDay = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedDay = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.timeatbleschedulerapp.data.models.User currentUser;
    
    @javax.inject.Inject()
    public TimetableViewModel(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.TimetableRepository timetableRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> getTimetableEntries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedDay() {
        return null;
    }
    
    private final void loadCurrentUser() {
    }
    
    public final void loadActiveTimetable() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> filterByDay(@org.jetbrains.annotations.NotNull()
    java.lang.String day) {
        return null;
    }
    
    public final void selectDay(@org.jetbrains.annotations.NotNull()
    java.lang.String day) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> getEntriesForSelectedDay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> getEntriesForDay(@org.jetbrains.annotations.NotNull()
    java.lang.String day) {
        return null;
    }
    
    public final void refreshTimetable() {
    }
    
    public final void clearError() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> getTimetableForWeek() {
        return null;
    }
    
    public final boolean hasClassesOnDay(@org.jetbrains.annotations.NotNull()
    java.lang.String day) {
        return false;
    }
    
    public final int getTotalClassesForWeek() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.timeatbleschedulerapp.data.models.TimetableEntry getNextClass() {
        return null;
    }
}