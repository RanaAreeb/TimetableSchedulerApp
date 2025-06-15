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
public final class AddTeacherViewModel_Factory implements Factory<AddTeacherViewModel> {
  private final Provider<TimetableRepository> repositoryProvider;

  public AddTeacherViewModel_Factory(Provider<TimetableRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddTeacherViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static AddTeacherViewModel_Factory create(
      Provider<TimetableRepository> repositoryProvider) {
    return new AddTeacherViewModel_Factory(repositoryProvider);
  }

  public static AddTeacherViewModel newInstance(TimetableRepository repository) {
    return new AddTeacherViewModel(repository);
  }
}
