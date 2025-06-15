package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.timeatbleschedulerapp.databinding.ActivityAddStudentGroupBinding;
import com.example.timeatbleschedulerapp.data.models.StudentGroupInput;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J6\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001e"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/AddStudentGroupActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ActivityAddStudentGroupBinding;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/AddStudentGroupViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/AddStudentGroupViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "saveStudentGroup", "setupClickListeners", "setupObservers", "setupToolbar", "validateInput", "name", "", "code", "semester", "", "studentCount", "subjects", "", "app_debug"})
public final class AddStudentGroupActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.timeatbleschedulerapp.databinding.ActivityAddStudentGroupBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public AddStudentGroupActivity() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupObservers() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void saveStudentGroup() {
    }
    
    private final boolean validateInput(java.lang.String name, java.lang.String code, int semester, int studentCount, java.util.List<java.lang.String> subjects) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}