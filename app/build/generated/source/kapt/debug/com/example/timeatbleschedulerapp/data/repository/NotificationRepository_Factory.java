package com.example.timeatbleschedulerapp.data.repository;

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
public final class NotificationRepository_Factory implements Factory<NotificationRepository> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  public NotificationRepository_Factory(Provider<FirebaseFirestore> firestoreProvider) {
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public NotificationRepository get() {
    return newInstance(firestoreProvider.get());
  }

  public static NotificationRepository_Factory create(
      Provider<FirebaseFirestore> firestoreProvider) {
    return new NotificationRepository_Factory(firestoreProvider);
  }

  public static NotificationRepository newInstance(FirebaseFirestore firestore) {
    return new NotificationRepository(firestore);
  }
}
