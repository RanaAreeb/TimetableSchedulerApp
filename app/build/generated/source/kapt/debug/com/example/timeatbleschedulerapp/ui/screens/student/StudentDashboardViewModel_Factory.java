package com.example.timeatbleschedulerapp.ui.screens.student;

import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
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
public final class StudentDashboardViewModel_Factory implements Factory<StudentDashboardViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  public StudentDashboardViewModel_Factory(Provider<AuthRepository> authRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public StudentDashboardViewModel get() {
    return newInstance(authRepositoryProvider.get());
  }

  public static StudentDashboardViewModel_Factory create(
      Provider<AuthRepository> authRepositoryProvider) {
    return new StudentDashboardViewModel_Factory(authRepositoryProvider);
  }

  public static StudentDashboardViewModel newInstance(AuthRepository authRepository) {
    return new StudentDashboardViewModel(authRepository);
  }
}
