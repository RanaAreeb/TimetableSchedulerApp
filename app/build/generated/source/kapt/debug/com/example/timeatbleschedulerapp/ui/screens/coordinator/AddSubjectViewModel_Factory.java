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
public final class AddSubjectViewModel_Factory implements Factory<AddSubjectViewModel> {
  private final Provider<TimetableRepository> repositoryProvider;

  public AddSubjectViewModel_Factory(Provider<TimetableRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddSubjectViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static AddSubjectViewModel_Factory create(
      Provider<TimetableRepository> repositoryProvider) {
    return new AddSubjectViewModel_Factory(repositoryProvider);
  }

  public static AddSubjectViewModel newInstance(TimetableRepository repository) {
    return new AddSubjectViewModel(repository);
  }
}
