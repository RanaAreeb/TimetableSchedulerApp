package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.models.GeneratedTimetable;
import com.example.timeatbleschedulerapp.data.models.TimetableEntry;
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0082@\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0017J\b\u0010\u001d\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/GenerateTimetableViewModel;", "Landroidx/lifecycle/ViewModel;", "timetableRepository", "Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;", "(Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;)V", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_generatedTimetable", "Lcom/example/timeatbleschedulerapp/data/models/GeneratedTimetable;", "_isGenerating", "", "_saveSuccess", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "generatedTimetable", "getGeneratedTimetable", "isGenerating", "saveSuccess", "getSaveSuccess", "generateTimetable", "", "parseGeneticAlgorithmResult", "jsonResult", "runGeneticAlgorithm", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTimetable", "simulateGeneticAlgorithmExecution", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GenerateTimetableViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.TimetableRepository timetableRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isGenerating = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isGenerating = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.timeatbleschedulerapp.data.models.GeneratedTimetable> _generatedTimetable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.timeatbleschedulerapp.data.models.GeneratedTimetable> generatedTimetable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _saveSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> saveSuccess = null;
    
    @javax.inject.Inject()
    public GenerateTimetableViewModel(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.TimetableRepository timetableRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isGenerating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.timeatbleschedulerapp.data.models.GeneratedTimetable> getGeneratedTimetable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getSaveSuccess() {
        return null;
    }
    
    public final void generateTimetable() {
    }
    
    private final java.lang.Object runGeneticAlgorithm(kotlin.coroutines.Continuation<? super com.example.timeatbleschedulerapp.data.models.GeneratedTimetable> $completion) {
        return null;
    }
    
    private final java.lang.String simulateGeneticAlgorithmExecution() {
        return null;
    }
    
    private final com.example.timeatbleschedulerapp.data.models.GeneratedTimetable parseGeneticAlgorithmResult(java.lang.String jsonResult) {
        return null;
    }
    
    public final void saveTimetable() {
    }
}