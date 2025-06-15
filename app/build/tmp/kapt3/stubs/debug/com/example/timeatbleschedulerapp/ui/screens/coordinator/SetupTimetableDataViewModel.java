package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.models.*;
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0011J\u000e\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0013J\u000e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0015J\u000e\u00100\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0011J\u000e\u00102\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0013J\u000e\u00103\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0015J\u000e\u00104\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000eJ\u000e\u00105\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0011J\u000e\u00106\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0013J\u000e\u00107\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0015J\u000e\u00108\u001a\b\u0012\u0004\u0012\u0002090\rH\u0002J\b\u0010:\u001a\u0004\u0018\u00010\u0017J\u0006\u0010;\u001a\u00020(J\u0006\u0010<\u001a\u00020(J\u0006\u0010=\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/example/timeatbleschedulerapp/ui/screens/coordinator/SetupTimetableDataViewModel;", "Landroidx/lifecycle/ViewModel;", "timetableRepository", "Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;", "authRepository", "Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;", "(Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;Lcom/example/timeatbleschedulerapp/data/repository/AuthRepository;)V", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_isLoading", "", "_rooms", "", "Lcom/example/timeatbleschedulerapp/data/models/RoomInput;", "_saveSuccess", "_studentGroups", "Lcom/example/timeatbleschedulerapp/data/models/StudentGroupInput;", "_subjects", "Lcom/example/timeatbleschedulerapp/data/models/SubjectInput;", "_teachers", "Lcom/example/timeatbleschedulerapp/data/models/TeacherInput;", "currentTimetableData", "Lcom/example/timeatbleschedulerapp/data/models/TimetableInputData;", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "isLoading", "rooms", "getRooms", "saveSuccess", "getSaveSuccess", "studentGroups", "getStudentGroups", "subjects", "getSubjects", "teachers", "getTeachers", "addRoom", "", "room", "addStudentGroup", "group", "addSubject", "subject", "addTeacher", "teacher", "deleteRoom", "deleteStudentGroup", "deleteSubject", "deleteTeacher", "editRoom", "editStudentGroup", "editSubject", "editTeacher", "generateDefaultTimeSlots", "Lcom/example/timeatbleschedulerapp/data/models/TimeSlotInput;", "getTimetableInputData", "loadTimetableData", "saveTimetableData", "validateData", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SetupTimetableDataViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.TimetableRepository timetableRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput>> _teachers = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput>> teachers = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput>> _subjects = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput>> subjects = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput>> _rooms = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput>> rooms = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput>> _studentGroups = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput>> studentGroups = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _saveSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> saveSuccess = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.timeatbleschedulerapp.data.models.TimetableInputData currentTimetableData;
    
    @javax.inject.Inject()
    public SetupTimetableDataViewModel(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.TimetableRepository timetableRepository, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput>> getTeachers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput>> getSubjects() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput>> getRooms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput>> getStudentGroups() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
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
    
    public final void loadTimetableData() {
    }
    
    public final void addTeacher(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TeacherInput teacher) {
    }
    
    public final void editTeacher(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TeacherInput teacher) {
    }
    
    public final void deleteTeacher(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TeacherInput teacher) {
    }
    
    public final void addSubject(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.SubjectInput subject) {
    }
    
    public final void editSubject(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.SubjectInput subject) {
    }
    
    public final void deleteSubject(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.SubjectInput subject) {
    }
    
    public final void addRoom(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.RoomInput room) {
    }
    
    public final void editRoom(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.RoomInput room) {
    }
    
    public final void deleteRoom(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.RoomInput room) {
    }
    
    public final void addStudentGroup(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.StudentGroupInput group) {
    }
    
    public final void editStudentGroup(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.StudentGroupInput group) {
    }
    
    public final void deleteStudentGroup(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.StudentGroupInput group) {
    }
    
    public final boolean validateData() {
        return false;
    }
    
    public final void saveTimetableData() {
    }
    
    private final java.util.List<com.example.timeatbleschedulerapp.data.models.TimeSlotInput> generateDefaultTimeSlots() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.timeatbleschedulerapp.data.models.TimetableInputData getTimetableInputData() {
        return null;
    }
}