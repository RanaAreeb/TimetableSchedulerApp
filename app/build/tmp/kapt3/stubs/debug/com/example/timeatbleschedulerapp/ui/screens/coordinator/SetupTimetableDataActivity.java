package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.timeatbleschedulerapp.databinding.ActivitySetupTimetableDataBinding;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.TeacherInputAdapter;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.SubjectInputAdapter;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.RoomInputAdapter;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.StudentGroupInputAdapter;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/SetupTimetableDataActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ActivitySetupTimetableDataBinding;", "groupAdapter", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/adapters/StudentGroupInputAdapter;", "roomAdapter", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/adapters/RoomInputAdapter;", "subjectAdapter", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/adapters/SubjectInputAdapter;", "teacherAdapter", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/adapters/TeacherInputAdapter;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/SetupTimetableDataViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/SetupTimetableDataViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "setupClickListeners", "setupObservers", "setupRecyclerViews", "setupToolbar", "app_debug"})
public final class SetupTimetableDataActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.timeatbleschedulerapp.databinding.ActivitySetupTimetableDataBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.TeacherInputAdapter teacherAdapter;
    private com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.SubjectInputAdapter subjectAdapter;
    private com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.RoomInputAdapter roomAdapter;
    private com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.StudentGroupInputAdapter groupAdapter;
    
    public SetupTimetableDataActivity() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecyclerViews() {
    }
    
    private final void setupObservers() {
    }
    
    private final void setupClickListeners() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}