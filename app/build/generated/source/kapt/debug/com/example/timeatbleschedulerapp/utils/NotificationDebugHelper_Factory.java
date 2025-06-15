package com.example.timeatbleschedulerapp.utils;

import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import com.google.firebase.firestore.FirebaseFirestore;
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
public final class NotificationDebugHelper_Factory implements Factory<NotificationDebugHelper> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<NotificationRepository> notificationRepositoryProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  public NotificationDebugHelper_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.notificationRepositoryProvider = notificationRepositoryProvider;
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public NotificationDebugHelper get() {
    return newInstance(authRepositoryProvider.get(), notificationRepositoryProvider.get(), firestoreProvider.get());
  }

  public static NotificationDebugHelper_Factory create(
      Provider<AuthRepository> authRepositoryProvider,
      Provider<NotificationRepository> notificationRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    return new NotificationDebugHelper_Factory(authRepositoryProvider, notificationRepositoryProvider, firestoreProvider);
  }

  public static NotificationDebugHelper newInstance(AuthRepository authRepository,
      NotificationRepository notificationRepository, FirebaseFirestore firestore) {
    return new NotificationDebugHelper(authRepository, notificationRepository, firestore);
  }
}
