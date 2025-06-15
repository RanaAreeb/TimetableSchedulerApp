package com.example.timeatbleschedulerapp.ui.screens.timetable;

import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository;
import com.google.firebase.firestore.FirebaseFirestore;
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
public final class TimetableViewModel_Factory implements Factory<TimetableViewModel> {
  private final Provider<TimetableRepository> timetableRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  public TimetableViewModel_Factory(Provider<TimetableRepository> timetableRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    this.timetableRepositoryProvider = timetableRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public TimetableViewModel get() {
    return newInstance(timetableRepositoryProvider.get(), authRepositoryProvider.get(), firestoreProvider.get());
  }

  public static TimetableViewModel_Factory create(
      Provider<TimetableRepository> timetableRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    return new TimetableViewModel_Factory(timetableRepositoryProvider, authRepositoryProvider, firestoreProvider);
  }

  public static TimetableViewModel newInstance(TimetableRepository timetableRepository,
      AuthRepository authRepository, FirebaseFirestore firestore) {
    return new TimetableViewModel(timetableRepository, authRepository, firestore);
  }
}
