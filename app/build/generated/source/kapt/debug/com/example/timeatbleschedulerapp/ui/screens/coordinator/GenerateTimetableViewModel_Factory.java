package com.example.timeatbleschedulerapp.ui.screens.coordinator;

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
public final class GenerateTimetableViewModel_Factory implements Factory<GenerateTimetableViewModel> {
  private final Provider<TimetableRepository> timetableRepositoryProvider;

  public GenerateTimetableViewModel_Factory(
      Provider<TimetableRepository> timetableRepositoryProvider) {
    this.timetableRepositoryProvider = timetableRepositoryProvider;
  }

  @Override
  public GenerateTimetableViewModel get() {
    return newInstance(timetableRepositoryProvider.get());
  }

  public static GenerateTimetableViewModel_Factory create(
      Provider<TimetableRepository> timetableRepositoryProvider) {
    return new GenerateTimetableViewModel_Factory(timetableRepositoryProvider);
  }

  public static GenerateTimetableViewModel newInstance(TimetableRepository timetableRepository) {
    return new GenerateTimetableViewModel(timetableRepository);
  }
}
