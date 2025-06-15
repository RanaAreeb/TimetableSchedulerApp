package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.models.TeacherInput;
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/AddTeacherViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;", "(Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;)V", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_isLoading", "", "_saveSuccess", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "isLoading", "saveSuccess", "getSaveSuccess", "saveTeacher", "", "teacher", "Lcom/example/timeatbleschedulerapp/data/models/TeacherInput;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddTeacherViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.TimetableRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _saveSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> saveSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    
    @javax.inject.Inject()
    public AddTeacherViewModel(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.TimetableRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getSaveSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    public final void saveTeacher(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TeacherInput teacher) {
    }
}