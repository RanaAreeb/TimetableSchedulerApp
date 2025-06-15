package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.timeatbleschedulerapp.databinding.ActivityGenerateTimetableBinding;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.TimetablePreviewAdapter;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/GenerateTimetableActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ActivityGenerateTimetableBinding;", "timetableAdapter", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/adapters/TimetablePreviewAdapter;", "viewModel", "Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/GenerateTimetableViewModel;", "getViewModel", "()Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/GenerateTimetableViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "setupClickListeners", "setupRecyclerView", "setupToolbar", "showGenerationDialog", "showRegenerationDialog", "app_debug"})
public final class GenerateTimetableActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.timeatbleschedulerapp.databinding.ActivityGenerateTimetableBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.timeatbleschedulerapp.ui.screens.coordinator.adapters.TimetablePreviewAdapter timetableAdapter;
    
    public GenerateTimetableActivity() {
        super();
    }
    
    private final com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void showGenerationDialog() {
    }
    
    private final void showRegenerationDialog() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}