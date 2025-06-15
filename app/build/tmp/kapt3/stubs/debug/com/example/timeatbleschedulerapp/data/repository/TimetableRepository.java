package com.example.timeatbleschedulerapp.data.repository;

import com.example.timeatbleschedulerapp.data.models.*;
import com.google.firebase.firestore.FirebaseFirestore;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011H\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011H\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011H\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0011H\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0011H\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010%\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\'H\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u00101J\u0016\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u00104J\u0016\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u00107J\u0016\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\'H\u0086@\u00a2\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/example/timeatbleschedulerapp/data/repository/TimetableRepository;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "entriesCollection", "Lcom/google/firebase/firestore/CollectionReference;", "inputDataCollection", "roomsCollection", "studentGroupsCollection", "subjectsCollection", "teachersCollection", "timetablesCollection", "getActiveTimetable", "Lcom/example/timeatbleschedulerapp/data/models/GeneratedTimetable;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTimetables", "", "Lcom/example/timeatbleschedulerapp/data/models/TimetableEntry;", "getEntriesForTimetable", "timetableId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRooms", "Lcom/example/timeatbleschedulerapp/data/models/RoomInput;", "getStudentGroups", "Lcom/example/timeatbleschedulerapp/data/models/StudentGroupInput;", "getSubjects", "Lcom/example/timeatbleschedulerapp/data/models/SubjectInput;", "getTeachers", "Lcom/example/timeatbleschedulerapp/data/models/TeacherInput;", "getTimeSlots", "Lcom/example/timeatbleschedulerapp/data/models/TimeSlotInput;", "getTimetable", "getTimetableForBatch", "batchId", "getTimetableForTeacher", "teacherId", "getTimetableInputData", "Lcom/example/timeatbleschedulerapp/data/models/TimetableInputData;", "saveRoom", "", "room", "(Lcom/example/timeatbleschedulerapp/data/models/RoomInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStudentGroup", "group", "(Lcom/example/timeatbleschedulerapp/data/models/StudentGroupInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSubject", "subject", "(Lcom/example/timeatbleschedulerapp/data/models/SubjectInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTeacher", "teacher", "(Lcom/example/timeatbleschedulerapp/data/models/TeacherInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTimetable", "timetable", "(Lcom/example/timeatbleschedulerapp/data/models/GeneratedTimetable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTimetableInputData", "data", "(Lcom/example/timeatbleschedulerapp/data/models/TimetableInputData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setActiveTimetable", "app_debug"})
public final class TimetableRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference timetablesCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference entriesCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference teachersCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference subjectsCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference roomsCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference studentGroupsCollection = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference inputDataCollection = null;
    
    @javax.inject.Inject()
    public TimetableRepository(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveTimetable(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.GeneratedTimetable timetable, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTimetable(@org.jetbrains.annotations.NotNull()
    java.lang.String timetableId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.timeatbleschedulerapp.data.models.GeneratedTimetable> $completion) {
        return null;
    }
    
    private final java.lang.Object getEntriesForTimetable(java.lang.String timetableId, kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTimetableForBatch(@org.jetbrains.annotations.NotNull()
    java.lang.String batchId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTimetableForTeacher(@org.jetbrains.annotations.NotNull()
    java.lang.String teacherId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllTimetables(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveTeacher(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TeacherInput teacher, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveSubject(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.SubjectInput subject, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveRoom(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.RoomInput room, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveStudentGroup(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.StudentGroupInput group, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTimetableInputData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.timeatbleschedulerapp.data.models.TimetableInputData> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveTimetableInputData(@org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TimetableInputData data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object getTeachers(kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput>> $completion) {
        return null;
    }
    
    private final java.lang.Object getSubjects(kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput>> $completion) {
        return null;
    }
    
    private final java.lang.Object getRooms(kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput>> $completion) {
        return null;
    }
    
    private final java.lang.Object getStudentGroups(kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput>> $completion) {
        return null;
    }
    
    private final java.lang.Object getTimeSlots(kotlin.coroutines.Continuation<? super java.util.List<com.example.timeatbleschedulerapp.data.models.TimeSlotInput>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getActiveTimetable(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.timeatbleschedulerapp.data.models.GeneratedTimetable> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setActiveTimetable(@org.jetbrains.annotations.NotNull()
    java.lang.String timetableId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}