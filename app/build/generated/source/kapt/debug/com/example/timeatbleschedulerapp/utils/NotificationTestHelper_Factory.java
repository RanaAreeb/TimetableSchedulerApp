package com.example.timeatbleschedulerapp.utils;

import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.services.FirebaseAdminService;
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
public final class NotificationTestHelper_Factory implements Factory<NotificationTestHelper> {
  private final Provider<FirebaseAdminService> firebaseAdminServiceProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public NotificationTestHelper_Factory(Provider<FirebaseAdminService> firebaseAdminServiceProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.firebaseAdminServiceProvider = firebaseAdminServiceProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public NotificationTestHelper get() {
    return newInstance(firebaseAdminServiceProvider.get(), authRepositoryProvider.get());
  }

  public static NotificationTestHelper_Factory create(
      Provider<FirebaseAdminService> firebaseAdminServiceProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new NotificationTestHelper_Factory(firebaseAdminServiceProvider, authRepositoryProvider);
  }

  public static NotificationTestHelper newInstance(FirebaseAdminService firebaseAdminService,
      AuthRepository authRepository) {
    return new NotificationTestHelper(firebaseAdminService, authRepository);
  }
}
