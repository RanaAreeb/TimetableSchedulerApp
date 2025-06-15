package com.example.timeatbleschedulerapp.ui.screens.notifications;

import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import com.example.timeatbleschedulerapp.utils.NotificationDebugHelper;
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
public final class NotificationsViewModel_Factory implements Factory<NotificationsViewModel> {
  private final Provider<NotificationRepository> notificationRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<NotificationDebugHelper> debugHelperProvider;

  public NotificationsViewModel_Factory(
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<NotificationDebugHelper> debugHelperProvider) {
    this.notificationRepositoryProvider = notificationRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
    this.debugHelperProvider = debugHelperProvider;
  }

  @Override
  public NotificationsViewModel get() {
    return newInstance(notificationRepositoryProvider.get(), authRepositoryProvider.get(), debugHelperProvider.get());
  }

  public static NotificationsViewModel_Factory create(
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<NotificationDebugHelper> debugHelperProvider) {
    return new NotificationsViewModel_Factory(notificationRepositoryProvider, authRepositoryProvider, debugHelperProvider);
  }

  public static NotificationsViewModel newInstance(NotificationRepository notificationRepository,
      AuthRepository authRepository, NotificationDebugHelper debugHelper) {
    return new NotificationsViewModel(notificationRepository, authRepository, debugHelper);
  }
}
