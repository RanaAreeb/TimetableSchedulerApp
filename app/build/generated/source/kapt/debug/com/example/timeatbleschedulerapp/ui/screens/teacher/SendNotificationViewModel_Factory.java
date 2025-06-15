package com.example.timeatbleschedulerapp.ui.screens.teacher;

import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import com.example.timeatbleschedulerapp.services.NotificationManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SendNotificationViewModel_Factory implements Factory<SendNotificationViewModel> {
  private final Provider<NotificationManager> notificationManagerProvider;

  private final Provider<NotificationRepository> notificationRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public SendNotificationViewModel_Factory(
      Provider<NotificationManager> notificationManagerProvider,
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.notificationManagerProvider = notificationManagerProvider;
    this.notificationRepositoryProvider = notificationRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public SendNotificationViewModel get() {
    return newInstance(notificationManagerProvider.get(), notificationRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static SendNotificationViewModel_Factory create(
      Provider<NotificationManager> notificationManagerProvider,
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new SendNotificationViewModel_Factory(notificationManagerProvider, notificationRepositoryProvider, authRepositoryProvider);
  }

  public static SendNotificationViewModel newInstance(NotificationManager notificationManager,
      NotificationRepository notificationRepository, AuthRepository authRepository) {
    return new SendNotificationViewModel(notificationManager, notificationRepository, authRepository);
  }
}
