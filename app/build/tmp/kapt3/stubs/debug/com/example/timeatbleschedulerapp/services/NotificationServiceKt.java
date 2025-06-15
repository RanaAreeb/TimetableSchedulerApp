package com.example.timeatbleschedulerapp.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.timeatbleschedulerapp.MainActivity;
import com.example.timeatbleschedulerapp.R;
import com.example.timeatbleschedulerapp.data.repository.FCMRepository;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0003"}, d2 = {"CHANNEL_ID", "", "TAG", "app_debug"})
public final class NotificationServiceKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "NotificationService";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CHANNEL_ID = "timetable_notifications";
}