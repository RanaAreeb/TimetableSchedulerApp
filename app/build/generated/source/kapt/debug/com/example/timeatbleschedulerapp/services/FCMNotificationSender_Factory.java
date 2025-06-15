package com.example.timeatbleschedulerapp.services;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FCMNotificationSender_Factory implements Factory<FCMNotificationSender> {
  @Override
  public FCMNotificationSender get() {
    return newInstance();
  }

  public static FCMNotificationSender_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FCMNotificationSender newInstance() {
    return new FCMNotificationSender();
  }

  private static final class InstanceHolder {
    private static final FCMNotificationSender_Factory INSTANCE = new FCMNotificationSender_Factory();
  }
}
