package com.example.timeatbleschedulerapp.services;

import com.example.timeatbleschedulerapp.data.repository.FCMRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class NotificationService_MembersInjector implements MembersInjector<NotificationService> {
  private final Provider<FCMRepository> fcmRepositoryProvider;

  public NotificationService_MembersInjector(Provider<FCMRepository> fcmRepositoryProvider) {
    this.fcmRepositoryProvider = fcmRepositoryProvider;
  }

  public static MembersInjector<NotificationService> create(
      Provider<FCMRepository> fcmRepositoryProvider) {
    return new NotificationService_MembersInjector(fcmRepositoryProvider);
  }

  @Override
  public void injectMembers(NotificationService instance) {
    injectFcmRepository(instance, fcmRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.example.timeatbleschedulerapp.services.NotificationService.fcmRepository")
  public static void injectFcmRepository(NotificationService instance,
      FCMRepository fcmRepository) {
    instance.fcmRepository = fcmRepository;
  }
}
