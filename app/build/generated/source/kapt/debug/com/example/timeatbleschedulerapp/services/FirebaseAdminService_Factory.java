package com.example.timeatbleschedulerapp.services;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class FirebaseAdminService_Factory implements Factory<FirebaseAdminService> {
  private final Provider<Context> contextProvider;

  public FirebaseAdminService_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public FirebaseAdminService get() {
    return newInstance(contextProvider.get());
  }

  public static FirebaseAdminService_Factory create(Provider<Context> contextProvider) {
    return new FirebaseAdminService_Factory(contextProvider);
  }

  public static FirebaseAdminService newInstance(Context context) {
    return new FirebaseAdminService(context);
  }
}
