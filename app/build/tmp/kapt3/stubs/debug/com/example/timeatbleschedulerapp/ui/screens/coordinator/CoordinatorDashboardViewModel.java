package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.models.User;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/CoordinatorDashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;", "(Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;)V", "_currentUser", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/timeatbleschedulerapp/data/models/User;", "currentUser", "Landroidx/lifecycle/LiveData;", "getCurrentUser", "()Landroidx/lifecycle/LiveData;", "loadCurrentUser", "", "logout", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CoordinatorDashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.timeatbleschedulerapp.data.models.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.timeatbleschedulerapp.data.models.User> currentUser = null;
    
    @javax.inject.Inject()
    public CoordinatorDashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.timeatbleschedulerapp.data.models.User> getCurrentUser() {
        return null;
    }
    
    private final void loadCurrentUser() {
    }
    
    public final void logout() {
    }
}