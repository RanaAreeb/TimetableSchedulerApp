package com.example.timeatbleschedulerapp;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.timeatbleschedulerapp.data.repository.AuthRepository;
import com.example.timeatbleschedulerapp.data.repository.FCMRepository;
import com.example.timeatbleschedulerapp.data.repository.NotificationRepository;
import com.example.timeatbleschedulerapp.data.repository.TimetableRepository;
import com.example.timeatbleschedulerapp.di.AppModule_ProvideFirebaseAuthFactory;
import com.example.timeatbleschedulerapp.di.AppModule_ProvideFirebaseFirestoreFactory;
import com.example.timeatbleschedulerapp.services.FCMService;
import com.example.timeatbleschedulerapp.services.FCMService_MembersInjector;
import com.example.timeatbleschedulerapp.services.FirebaseAdminService;
import com.example.timeatbleschedulerapp.services.NotificationManager;
import com.example.timeatbleschedulerapp.services.NotificationService;
import com.example.timeatbleschedulerapp.services.NotificationService_MembersInjector;
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthActivity;
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthViewModel;
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddRoomActivity;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddRoomViewModel;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddRoomViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupActivity;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupViewModel;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddSubjectActivity;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddSubjectViewModel;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddSubjectViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddTeacherActivity;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddTeacherViewModel;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddTeacherViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardActivity;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardViewModel;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableActivity;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableViewModel;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataActivity;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataViewModel;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsActivity;
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsViewModel;
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardActivity;
import com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardViewModel;
import com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationActivity;
import com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationViewModel;
import com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardActivity;
import com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardViewModel;
import com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewModel;
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewModel_HiltModules_KeyModule_ProvideFactory;
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewerActivity;
import com.example.timeatbleschedulerapp.utils.NotificationDebugHelper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerTimetableSchedulerApplication_HiltComponents_SingletonC {
  private DaggerTimetableSchedulerApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public TimetableSchedulerApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements TimetableSchedulerApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public TimetableSchedulerApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements TimetableSchedulerApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public TimetableSchedulerApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements TimetableSchedulerApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public TimetableSchedulerApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements TimetableSchedulerApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public TimetableSchedulerApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements TimetableSchedulerApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public TimetableSchedulerApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements TimetableSchedulerApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public TimetableSchedulerApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements TimetableSchedulerApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public TimetableSchedulerApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends TimetableSchedulerApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends TimetableSchedulerApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends TimetableSchedulerApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends TimetableSchedulerApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public void injectAuthActivity(AuthActivity arg0) {
    }

    @Override
    public void injectAddRoomActivity(AddRoomActivity arg0) {
    }

    @Override
    public void injectAddStudentGroupActivity(AddStudentGroupActivity arg0) {
    }

    @Override
    public void injectAddSubjectActivity(AddSubjectActivity arg0) {
    }

    @Override
    public void injectAddTeacherActivity(AddTeacherActivity arg0) {
    }

    @Override
    public void injectCoordinatorDashboardActivity(CoordinatorDashboardActivity arg0) {
    }

    @Override
    public void injectGenerateTimetableActivity(GenerateTimetableActivity arg0) {
    }

    @Override
    public void injectSetupTimetableDataActivity(SetupTimetableDataActivity arg0) {
    }

    @Override
    public void injectNotificationsActivity(NotificationsActivity arg0) {
    }

    @Override
    public void injectStudentDashboardActivity(StudentDashboardActivity arg0) {
    }

    @Override
    public void injectSendNotificationActivity(SendNotificationActivity arg0) {
    }

    @Override
    public void injectTeacherDashboardActivity(TeacherDashboardActivity arg0) {
    }

    @Override
    public void injectTimetableViewerActivity(TimetableViewerActivity arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return ImmutableSet.<String>of(AddRoomViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AddStudentGroupViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AddSubjectViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AddTeacherViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AuthViewModel_HiltModules_KeyModule_ProvideFactory.provide(), CoordinatorDashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide(), GenerateTimetableViewModel_HiltModules_KeyModule_ProvideFactory.provide(), NotificationsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SendNotificationViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SetupTimetableDataViewModel_HiltModules_KeyModule_ProvideFactory.provide(), StudentDashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide(), TeacherDashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide(), TimetableViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends TimetableSchedulerApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AddRoomViewModel> addRoomViewModelProvider;

    private Provider<AddStudentGroupViewModel> addStudentGroupViewModelProvider;

    private Provider<AddSubjectViewModel> addSubjectViewModelProvider;

    private Provider<AddTeacherViewModel> addTeacherViewModelProvider;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<CoordinatorDashboardViewModel> coordinatorDashboardViewModelProvider;

    private Provider<GenerateTimetableViewModel> generateTimetableViewModelProvider;

    private Provider<NotificationsViewModel> notificationsViewModelProvider;

    private Provider<SendNotificationViewModel> sendNotificationViewModelProvider;

    private Provider<SetupTimetableDataViewModel> setupTimetableDataViewModelProvider;

    private Provider<StudentDashboardViewModel> studentDashboardViewModelProvider;

    private Provider<TeacherDashboardViewModel> teacherDashboardViewModelProvider;

    private Provider<TimetableViewModel> timetableViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addRoomViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.addStudentGroupViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.addSubjectViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.addTeacherViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.coordinatorDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.generateTimetableViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.notificationsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.sendNotificationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.setupTimetableDataViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.studentDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
      this.teacherDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11);
      this.timetableViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12);
    }

    @Override
    public Map<String, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(13).put("com.example.timeatbleschedulerapp.ui.screens.coordinator.AddRoomViewModel", ((Provider) addRoomViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupViewModel", ((Provider) addStudentGroupViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.coordinator.AddSubjectViewModel", ((Provider) addSubjectViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.coordinator.AddTeacherViewModel", ((Provider) addTeacherViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.auth.AuthViewModel", ((Provider) authViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardViewModel", ((Provider) coordinatorDashboardViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableViewModel", ((Provider) generateTimetableViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsViewModel", ((Provider) notificationsViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationViewModel", ((Provider) sendNotificationViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataViewModel", ((Provider) setupTimetableDataViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardViewModel", ((Provider) studentDashboardViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardViewModel", ((Provider) teacherDashboardViewModelProvider)).put("com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewModel", ((Provider) timetableViewModelProvider)).build();
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<String, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.timeatbleschedulerapp.ui.screens.coordinator.AddRoomViewModel 
          return (T) new AddRoomViewModel(singletonCImpl.timetableRepositoryProvider.get());

          case 1: // com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupViewModel 
          return (T) new AddStudentGroupViewModel(singletonCImpl.timetableRepositoryProvider.get());

          case 2: // com.example.timeatbleschedulerapp.ui.screens.coordinator.AddSubjectViewModel 
          return (T) new AddSubjectViewModel(singletonCImpl.timetableRepositoryProvider.get());

          case 3: // com.example.timeatbleschedulerapp.ui.screens.coordinator.AddTeacherViewModel 
          return (T) new AddTeacherViewModel(singletonCImpl.timetableRepositoryProvider.get());

          case 4: // com.example.timeatbleschedulerapp.ui.screens.auth.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.authRepositoryProvider.get());

          case 5: // com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardViewModel 
          return (T) new CoordinatorDashboardViewModel(singletonCImpl.authRepositoryProvider.get());

          case 6: // com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableViewModel 
          return (T) new GenerateTimetableViewModel(singletonCImpl.timetableRepositoryProvider.get());

          case 7: // com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsViewModel 
          return (T) new NotificationsViewModel(singletonCImpl.notificationRepositoryProvider.get(), singletonCImpl.authRepositoryProvider.get(), singletonCImpl.notificationDebugHelperProvider.get());

          case 8: // com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationViewModel 
          return (T) new SendNotificationViewModel(singletonCImpl.notificationManagerProvider.get(), singletonCImpl.notificationRepositoryProvider.get(), singletonCImpl.authRepositoryProvider.get());

          case 9: // com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataViewModel 
          return (T) new SetupTimetableDataViewModel(singletonCImpl.timetableRepositoryProvider.get(), singletonCImpl.authRepositoryProvider.get());

          case 10: // com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardViewModel 
          return (T) new StudentDashboardViewModel(singletonCImpl.authRepositoryProvider.get());

          case 11: // com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardViewModel 
          return (T) new TeacherDashboardViewModel(singletonCImpl.authRepositoryProvider.get());

          case 12: // com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewModel 
          return (T) new TimetableViewModel(singletonCImpl.timetableRepositoryProvider.get(), singletonCImpl.authRepositoryProvider.get(), singletonCImpl.provideFirebaseFirestoreProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends TimetableSchedulerApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends TimetableSchedulerApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }

    @Override
    public void injectFCMService(FCMService arg0) {
      injectFCMService2(arg0);
    }

    @Override
    public void injectNotificationService(NotificationService arg0) {
      injectNotificationService2(arg0);
    }

    @CanIgnoreReturnValue
    private FCMService injectFCMService2(FCMService instance) {
      FCMService_MembersInjector.injectFcmRepository(instance, singletonCImpl.fCMRepositoryProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private NotificationService injectNotificationService2(NotificationService instance) {
      NotificationService_MembersInjector.injectFcmRepository(instance, singletonCImpl.fCMRepositoryProvider.get());
      return instance;
    }
  }

  private static final class SingletonCImpl extends TimetableSchedulerApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<FirebaseFirestore> provideFirebaseFirestoreProvider;

    private Provider<TimetableRepository> timetableRepositoryProvider;

    private Provider<FirebaseAuth> provideFirebaseAuthProvider;

    private Provider<AuthRepository> authRepositoryProvider;

    private Provider<NotificationRepository> notificationRepositoryProvider;

    private Provider<NotificationDebugHelper> notificationDebugHelperProvider;

    private Provider<FCMRepository> fCMRepositoryProvider;

    private Provider<FirebaseAdminService> firebaseAdminServiceProvider;

    private Provider<NotificationManager> notificationManagerProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideFirebaseFirestoreProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFirestore>(singletonCImpl, 1));
      this.timetableRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<TimetableRepository>(singletonCImpl, 0));
      this.provideFirebaseAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 3));
      this.authRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepository>(singletonCImpl, 2));
      this.notificationRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<NotificationRepository>(singletonCImpl, 4));
      this.notificationDebugHelperProvider = DoubleCheck.provider(new SwitchingProvider<NotificationDebugHelper>(singletonCImpl, 5));
      this.fCMRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<FCMRepository>(singletonCImpl, 7));
      this.firebaseAdminServiceProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAdminService>(singletonCImpl, 8));
      this.notificationManagerProvider = DoubleCheck.provider(new SwitchingProvider<NotificationManager>(singletonCImpl, 6));
    }

    @Override
    public void injectTimetableSchedulerApplication(TimetableSchedulerApplication arg0) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.example.timeatbleschedulerapp.data.repository.TimetableRepository 
          return (T) new TimetableRepository(singletonCImpl.provideFirebaseFirestoreProvider.get());

          case 1: // com.google.firebase.firestore.FirebaseFirestore 
          return (T) AppModule_ProvideFirebaseFirestoreFactory.provideFirebaseFirestore();

          case 2: // com.example.timeatbleschedulerapp.data.repository.AuthRepository 
          return (T) new AuthRepository(singletonCImpl.provideFirebaseAuthProvider.get(), singletonCImpl.provideFirebaseFirestoreProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.google.firebase.auth.FirebaseAuth 
          return (T) AppModule_ProvideFirebaseAuthFactory.provideFirebaseAuth();

          case 4: // com.example.timeatbleschedulerapp.data.repository.NotificationRepository 
          return (T) new NotificationRepository(singletonCImpl.provideFirebaseFirestoreProvider.get());

          case 5: // com.example.timeatbleschedulerapp.utils.NotificationDebugHelper 
          return (T) new NotificationDebugHelper(singletonCImpl.authRepositoryProvider.get(), singletonCImpl.notificationRepositoryProvider.get(), singletonCImpl.provideFirebaseFirestoreProvider.get());

          case 6: // com.example.timeatbleschedulerapp.services.NotificationManager 
          return (T) new NotificationManager(singletonCImpl.notificationRepositoryProvider.get(), singletonCImpl.fCMRepositoryProvider.get(), singletonCImpl.firebaseAdminServiceProvider.get());

          case 7: // com.example.timeatbleschedulerapp.data.repository.FCMRepository 
          return (T) new FCMRepository(singletonCImpl.provideFirebaseFirestoreProvider.get(), singletonCImpl.provideFirebaseAuthProvider.get());

          case 8: // com.example.timeatbleschedulerapp.services.FirebaseAdminService 
          return (T) new FirebaseAdminService(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
