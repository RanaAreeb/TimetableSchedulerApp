package com.example.timeatbleschedulerapp.ui.screens.teacher;

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
public final class TeacherDashboardViewModel_Factory implements Factory<TeacherDashboardViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  public TeacherDashboardViewModel_Factory(Provider<AuthRepository> authRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public TeacherDashboardViewModel get() {
    return newInstance(authRepositoryProvider.get());
  }

  public static TeacherDashboardViewModel_Factory create(
      Provider<AuthRepository> authRepositoryProvider) {
    return new TeacherDashboardViewModel_Factory(authRepositoryProvider);
  }

  public static TeacherDashboardViewModel newInstance(AuthRepository authRepository) {
    return new TeacherDashboardViewModel(authRepository);
  }
}
