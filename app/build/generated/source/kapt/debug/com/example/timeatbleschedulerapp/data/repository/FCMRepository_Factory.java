package com.example.timeatbleschedulerapp.data.repository;

import com.google.firebase.auth.FirebaseAuth;
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
public final class FCMRepository_Factory implements Factory<FCMRepository> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<FirebaseAuth> authProvider;

  public FCMRepository_Factory(Provider<FirebaseFirestore> firestoreProvider,
      Provider<FirebaseAuth> authProvider) {
    this.firestoreProvider = firestoreProvider;
    this.authProvider = authProvider;
  }

  @Override
  public FCMRepository get() {
    return newInstance(firestoreProvider.get(), authProvider.get());
  }

  public static FCMRepository_Factory create(Provider<FirebaseFirestore> firestoreProvider,
      Provider<FirebaseAuth> authProvider) {
    return new FCMRepository_Factory(firestoreProvider, authProvider);
  }

  public static FCMRepository newInstance(FirebaseFirestore firestore, FirebaseAuth auth) {
    return new FCMRepository(firestore, auth);
  }
}
