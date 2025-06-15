package com.example.timeatbleschedulerapp.ui.screens.coordinator;

import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository;
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
public final class SetupTimetableDataViewModel_Factory implements Factory<SetupTimetableDataViewModel> {
  private final Provider<TimetableRepository> timetableRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public SetupTimetableDataViewModel_Factory(
      Provider<TimetableRepository> timetableRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.timetableRepositoryProvider = timetableRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public SetupTimetableDataViewModel get() {
    return newInstance(timetableRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static SetupTimetableDataViewModel_Factory create(
      Provider<TimetableRepository> timetableRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new SetupTimetableDataViewModel_Factory(timetableRepositoryProvider, authRepositoryProvider);
  }

  public static SetupTimetableDataViewModel newInstance(TimetableRepository timetableRepository,
      AuthRepository authRepository) {
    return new SetupTimetableDataViewModel(timetableRepository, authRepository);
  }
}
