package com.example.timeatbleschedulerapp.ui.screens.coordinator;

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
public final class CoordinatorDashboardViewModel_Factory implements Factory<CoordinatorDashboardViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  public CoordinatorDashboardViewModel_Factory(Provider<AuthRepository> authRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public CoordinatorDashboardViewModel get() {
    return newInstance(authRepositoryProvider.get());
  }

  public static CoordinatorDashboardViewModel_Factory create(
      Provider<AuthRepository> authRepositoryProvider) {
    return new CoordinatorDashboardViewModel_Factory(authRepositoryProvider);
  }

  public static CoordinatorDashboardViewModel newInstance(AuthRepository authRepository) {
    return new CoordinatorDashboardViewModel(authRepository);
  }
}
