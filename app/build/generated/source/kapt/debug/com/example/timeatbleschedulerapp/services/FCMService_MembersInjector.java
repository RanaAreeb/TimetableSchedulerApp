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
public final class FCMService_MembersInjector implements MembersInjector<FCMService> {
  private final Provider<FCMRepository> fcmRepositoryProvider;

  public FCMService_MembersInjector(Provider<FCMRepository> fcmRepositoryProvider) {
    this.fcmRepositoryProvider = fcmRepositoryProvider;
  }

  public static MembersInjector<FCMService> create(Provider<FCMRepository> fcmRepositoryProvider) {
    return new FCMService_MembersInjector(fcmRepositoryProvider);
  }

  @Override
  public void injectMembers(FCMService instance) {
    injectFcmRepository(instance, fcmRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.example.timeatbleschedulerapp.services.FCMService.fcmRepository")
  public static void injectFcmRepository(FCMService instance, FCMRepository fcmRepository) {
    instance.fcmRepository = fcmRepository;
  }
}
