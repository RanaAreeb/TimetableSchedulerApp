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
public final class AddStudentGroupViewModel_Factory implements Factory<AddStudentGroupViewModel> {
  private final Provider<TimetableRepository> repositoryProvider;

  public AddStudentGroupViewModel_Factory(Provider<TimetableRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddStudentGroupViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static AddStudentGroupViewModel_Factory create(
      Provider<TimetableRepository> repositoryProvider) {
    return new AddStudentGroupViewModel_Factory(repositoryProvider);
  }

  public static AddStudentGroupViewModel newInstance(TimetableRepository repository) {
    return new AddStudentGroupViewModel(repository);
  }
}
