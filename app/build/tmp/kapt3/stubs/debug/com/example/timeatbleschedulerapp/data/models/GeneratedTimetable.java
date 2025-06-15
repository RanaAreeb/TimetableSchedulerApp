package com.example.timeatbleschedulerapp.data.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\t\u0010&\u001a\u00020\u0010H\u00c6\u0003J_\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020\u0007H\u00d6\u0001J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015\u00a8\u0006,"}, d2 = {"Lcom/example/timeatbleschedulerapp/data/models/GeneratedTimetable;", "", "id", "", "generatedAt", "", "fitnessScore", "", "totalClasses", "generationsRun", "improvementPercentage", "", "entries", "", "Lcom/example/timeatbleschedulerapp/data/models/TimetableEntry;", "isActive", "", "(Ljava/lang/String;JIIIDLjava/util/List;Z)V", "getEntries", "()Ljava/util/List;", "getFitnessScore", "()I", "getGeneratedAt", "()J", "getGenerationsRun", "getId", "()Ljava/lang/String;", "getImprovementPercentage", "()D", "()Z", "getTotalClasses", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class GeneratedTimetable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    private final long generatedAt = 0L;
    private final int fitnessScore = 0;
    private final int totalClasses = 0;
    private final int generationsRun = 0;
    private final double improvementPercentage = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> entries = null;
    private final boolean isActive = false;
    
    public GeneratedTimetable(@org.jetbrains.annotations.NotNull()
    java.lang.String id, long generatedAt, int fitnessScore, int totalClasses, int generationsRun, double improvementPercentage, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> entries, boolean isActive) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final long getGeneratedAt() {
        return 0L;
    }
    
    public final int getFitnessScore() {
        return 0;
    }
    
    public final int getTotalClasses() {
        return 0;
    }
    
    public final int getGenerationsRun() {
        return 0;
    }
    
    public final double getImprovementPercentage() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> getEntries() {
        return null;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    public GeneratedTimetable() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.timeatbleschedulerapp.data.models.GeneratedTimetable copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, long generatedAt, int fitnessScore, int totalClasses, int generationsRun, double improvementPercentage, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.timeatbleschedulerapp.data.models.TimetableEntry> entries, boolean isActive) {
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