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
public final class TimetableRepository_Factory implements Factory<TimetableRepository> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  public TimetableRepository_Factory(Provider<FirebaseFirestore> firestoreProvider) {
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public TimetableRepository get() {
    return newInstance(firestoreProvider.get());
  }

  public static TimetableRepository_Factory create(Provider<FirebaseFirestore> firestoreProvider) {
    return new TimetableRepository_Factory(firestoreProvider);
  }

  public static TimetableRepository newInstance(FirebaseFirestore firestore) {
    return new TimetableRepository(firestore);
  }
}
