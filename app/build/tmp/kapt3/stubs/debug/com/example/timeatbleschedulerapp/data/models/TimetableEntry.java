package com.example.timeatbleschedulerapp.data.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0010H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\u008b\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\u0010H\u00d6\u0001J\t\u00103\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013\u00a8\u00064"}, d2 = {"Lcom/example/timeatbleschedulerapp/data/models/TimetableEntry;", "", "id", "", "groupId", "subjectId", "subjectName", "teacherId", "teacherName", "roomId", "day", "dayOfWeek", "startTime", "endTime", "type", "students", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDay", "()Ljava/lang/String;", "getDayOfWeek", "getEndTime", "getGroupId", "getId", "getRoomId", "getStartTime", "getStudents", "()I", "getSubjectId", "getSubjectName", "getTeacherId", "getTeacherName", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class TimetableEntry {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String groupId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String subjectId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String subjectName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String teacherId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String teacherName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String roomId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String day = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dayOfWeek = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String startTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String endTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String type = null;
    private final int students = 0;
    
    public TimetableEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String subjectId, @org.jetbrains.annotations.NotNull()
    java.lang.String subjectName, @org.jetbrains.annotations.NotNull()
    java.lang.String teacherId, @org.jetbrains.annotations.NotNull()
    java.lang.String teacherName, @org.jetbrains.annotations.NotNull()
    java.lang.String roomId, @org.jetbrains.annotations.NotNull()
    java.lang.String day, @org.jetbrains.annotations.NotNull()
    java.lang.String dayOfWeek, @org.jetbrains.annotations.NotNull()
    java.lang.String startTime, @org.jetbrains.annotations.NotNull()
    java.lang.String endTime, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int students) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGroupId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubjectId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubjectName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTeacherId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTeacherName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoomId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDayOfWeek() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStartTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEndTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final int getStudents() {
        return 0;
    }
    
    public TimetableEntry() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.timeatbleschedulerapp.data.models.TimetableEntry copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String subjectId, @org.jetbrains.annotations.NotNull()
    java.lang.String subjectName, @org.jetbrains.annotations.NotNull()
    java.lang.String teacherId, @org.jetbrains.annotations.NotNull()
    java.lang.String teacherName, @org.jetbrains.annotations.NotNull()
    java.lang.String roomId, @org.jetbrains.annotations.NotNull()
    java.lang.String day, @org.jetbrains.annotations.NotNull()
    java.lang.String dayOfWeek, @org.jetbrains.annotations.NotNull()
    java.lang.String startTime, @org.jetbrains.annotations.NotNull()
    java.lang.String endTime, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int students) {
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