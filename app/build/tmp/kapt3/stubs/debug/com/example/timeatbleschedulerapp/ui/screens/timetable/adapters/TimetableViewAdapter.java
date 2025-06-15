package com.example.timeatbleschedulerapp.ui.screens.timetable.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.timeatbleschedulerapp.R;
import com.example.timeatbleschedulerapp.data.models.TimetableEntry;
import com.example.timeatbleschedulerapp.databinding.ItemTimetableViewBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/timetable/adapters/TimetableViewAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/timeatbleschedulerapp/data/models/TimetableEntry;", "Lcom/example/timeatbleschedulerapp/ui/screens/timetable/adapters/TimetableViewAdapter$TimetableViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TimetableDiffCallback", "TimetableViewHolder", "app_debug"})
public final class TimetableViewAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.timeatbleschedulerapp.data.models.TimetableEntry, com.example.timeatbleschedulerapp.ui.screens.timetable.adapters.TimetableViewAdapter.TimetableViewHolder> {
    
    public TimetableViewAdapter() {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.timeatbleschedulerapp.ui.screens.timetable.adapters.TimetableViewAdapter.TimetableViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.ui.screens.timetable.adapters.TimetableViewAdapter.TimetableViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/timetable/adapters/TimetableViewAdapter$TimetableDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/timeatbleschedulerapp/data/models/TimetableEntry;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    static final class TimetableDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.timeatbleschedulerapp.data.models.TimetableEntry> {
        
        public TimetableDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.data.models.TimetableEntry oldItem, @org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.data.models.TimetableEntry newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.data.models.TimetableEntry oldItem, @org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.data.models.TimetableEntry newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/timetable/adapters/TimetableViewAdapter$TimetableViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/timeatbleschedulerapp/databinding/ItemTimetableViewBinding;", "(Lcom/example/timeatbleschedulerapp/databinding/ItemTimetableViewBinding;)V", "bind", "", "entry", "Lcom/example/timeatbleschedulerapp/data/models/TimetableEntry;", "app_debug"})
    public static final class TimetableViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.timeatbleschedulerapp.databinding.ItemTimetableViewBinding binding = null;
        
        public TimetableViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.databinding.ItemTimetableViewBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.timeatbleschedulerapp.data.models.TimetableEntry entry) {
        }
    }
}