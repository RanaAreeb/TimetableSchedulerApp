package com.example.timeatbleschedulerapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import com.example.timeatbleschedulerapp.ui.screens.onboarding.OnboardingActivity;
import com.example.timeatbleschedulerapp.utils.NotificationPermissionHelper;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J-\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/example/timeatbleschedulerapp/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "handleNotificationIntent", "", "intent", "Landroid/content/Intent;", "initializeFCM", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestNotificationPermission", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final void requestNotificationPermission() {
    }
    
    private final void initializeFCM() {
    }
    
    private final void handleNotificationIntent(android.content.Intent intent) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
}