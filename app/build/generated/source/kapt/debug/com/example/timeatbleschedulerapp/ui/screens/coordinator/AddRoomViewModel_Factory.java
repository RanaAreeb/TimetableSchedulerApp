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
public final class AddRoomViewModel_Factory implements Factory<AddRoomViewModel> {
  private final Provider<TimetableRepository> repositoryProvider;

  public AddRoomViewModel_Factory(Provider<TimetableRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddRoomViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static AddRoomViewModel_Factory create(Provider<TimetableRepository> repositoryProvider) {
    return new AddRoomViewModel_Factory(repositoryProvider);
  }

  public static AddRoomViewModel newInstance(TimetableRepository repository) {
    return new AddRoomViewModel(repository);
  }
}
