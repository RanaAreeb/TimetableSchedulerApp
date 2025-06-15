package com.example.timeatbleschedulerapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JG\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/timeatbleschedulerapp/utils/NotificationPermissionHelper;", "", "()V", "NOTIFICATION_PERMISSION_REQUEST_CODE", "", "TAG", "", "handlePermissionResult", "", "requestCode", "permissions", "", "grantResults", "", "onGranted", "Lkotlin/Function0;", "onDenied", "(I[Ljava/lang/String;[ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "hasNotificationPermission", "", "context", "Landroid/content/Context;", "requestNotificationPermission", "activity", "Landroid/app/Activity;", "app_debug"})
public final class NotificationPermissionHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "NotificationPermission";
    private static final int NOTIFICATION_PERMISSION_REQUEST_CODE = 1001;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.timeatbleschedulerapp.utils.NotificationPermissionHelper INSTANCE = null;
    
    private NotificationPermissionHelper() {
        super();
    }
    
    public final boolean hasNotificationPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void requestNotificationPermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void handlePermissionResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onGranted, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDenied) {
    }
}