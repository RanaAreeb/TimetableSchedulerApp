package com.example.timeatbleschedulerapp.services;

import com.example.timeatbleschedulerapp.data.repository.FCMRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NotificationManager_Factory implements Factory<NotificationManager> {
  private final Provider<NotificationRepository> notificationRepositoryProvider;

  private final Provider<FCMRepository> fcmRepositoryProvider;

  private final Provider<FirebaseAdminService> firebaseAdminServiceProvider;

  public NotificationManager_Factory(
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<FCMRepository> fcmRepositoryProvider,
      Provider<FirebaseAdminService> firebaseAdminServiceProvider) {
    this.notificationRepositoryProvider = notificationRepositoryProvider;
    this.fcmRepositoryProvider = fcmRepositoryProvider;
    this.firebaseAdminServiceProvider = firebaseAdminServiceProvider;
  }

  @Override
  public NotificationManager get() {
    return newInstance(notificationRepositoryProvider.get(), fcmRepositoryProvider.get(), firebaseAdminServiceProvider.get());
  }

  public static NotificationManager_Factory create(
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<FCMRepository> fcmRepositoryProvider,
      Provider<FirebaseAdminService> firebaseAdminServiceProvider) {
    return new NotificationManager_Factory(notificationRepositoryProvider, fcmRepositoryProvider, firebaseAdminServiceProvider);
  }

  public static NotificationManager newInstance(NotificationRepository notificationRepository,
      FCMRepository fcmRepository, FirebaseAdminService firebaseAdminService) {
    return new NotificationManager(notificationRepository, fcmRepository, firebaseAdminService);
  }
}
