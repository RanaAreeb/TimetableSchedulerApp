package com.example.timeatbleschedulerapp.data.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0010H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0013H\u00c6\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u000200H\u00d6\u0001J\t\u00101\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001d\u00a8\u00062"}, d2 = {"Lcom/example/timeatbleschedulerapp/data/models/TimetableInputData;", "", "dataId", "", "teachers", "", "Lcom/example/timeatbleschedulerapp/data/models/TeacherInput;", "subjects", "Lcom/example/timeatbleschedulerapp/data/models/SubjectInput;", "rooms", "Lcom/example/timeatbleschedulerapp/data/models/RoomInput;", "studentGroups", "Lcom/example/timeatbleschedulerapp/data/models/StudentGroupInput;", "timeSlots", "Lcom/example/timeatbleschedulerapp/data/models/TimeSlotInput;", "constraints", "Lcom/example/timeatbleschedulerapp/data/models/TimetableConstraints;", "createdBy", "createdAt", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/example/timeatbleschedulerapp/data/models/TimetableConstraints;Ljava/lang/String;J)V", "getConstraints", "()Lcom/example/timeatbleschedulerapp/data/models/TimetableConstraints;", "getCreatedAt", "()J", "getCreatedBy", "()Ljava/lang/String;", "getDataId", "getRooms", "()Ljava/util/List;", "getStudentGroups", "getSubjects", "getTeachers", "getTimeSlots", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class TimetableInputData {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dataId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput> teachers = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput> subjects = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput> rooms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput> studentGroups = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.timeatbleschedulerapp.data.models.TimeSlotInput> timeSlots = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.timeatbleschedulerapp.data.models.TimetableConstraints constraints = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String createdBy = null;
    private final long createdAt = 0L;
    
    public TimetableInputData(@org.jetbrains.annotations.NotNull()
    java.lang.String dataId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput> teachers, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput> subjects, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput> rooms, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput> studentGroups, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.TimeSlotInput> timeSlots, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TimetableConstraints constraints, @org.jetbrains.annotations.NotNull()
    java.lang.String createdBy, long createdAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDataId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput> getTeachers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput> getSubjects() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput> getRooms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput> getStudentGroups() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TimeSlotInput> getTimeSlots() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.timeatbleschedulerapp.data.models.TimetableConstraints getConstraints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreatedBy() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public TimetableInputData() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TimeSlotInput> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.timeatbleschedulerapp.data.models.TimetableConstraints component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.timeatbleschedulerapp.data.models.TimetableInputData copy(@org.jetbrains.annotations.NotNull()
    java.lang.String dataId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.TeacherInput> teachers, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.SubjectInput> subjects, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.RoomInput> rooms, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.StudentGroupInput> studentGroups, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.TimeSlotInput> timeSlots, @org.jetbrains.annotations.NotNull()
    com.example.timeatbleschedulerapp.data.models.TimetableConstraints constraints, @org.jetbrains.annotations.NotNull()
    java.lang.String createdBy, long createdAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}