package com.example.timeatbleschedulerapp;

import com.example.timeatbleschedulerapp.di.AppModule;
import com.example.timeatbleschedulerapp.services.FCMService_GeneratedInjector;
import com.example.timeatbleschedulerapp.services.NotificationService_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.auth.AuthViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddRoomActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddRoomViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddStudentGroupViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddSubjectActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddSubjectViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddTeacherActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.AddTeacherViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.CoordinatorDashboardViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.GenerateTimetableViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.coordinator.SetupTimetableDataViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.notifications.NotificationsViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.student.StudentDashboardViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.teacher.SendNotificationViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardActivity_GeneratedInjector;
import com.example.timeatbleschedulerapp.ui.screens.teacher.TeacherDashboardViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewModel_HiltModules;
import com.example.timeatbleschedulerapp.ui.screens.timetable.TimetableViewerActivity_GeneratedInjector;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.HiltWrapper_SavedStateHandleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.annotation.processing.Generated;
import javax.inject.Singleton;

@Generated("dagger.hilt.processor.internal.root.RootProcessor")
public final class TimetableSchedulerApplication_HiltComponents {
  private TimetableSchedulerApplication_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          AppModule.class,
          ApplicationContextModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements TimetableSchedulerApplication_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements FCMService_GeneratedInjector,
      NotificationService_GeneratedInjector,
      ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AddRoomViewModel_HiltModules.KeyModule.class,
          AddStudentGroupViewModel_HiltModules.KeyModule.class,
          AddSubjectViewModel_HiltModules.KeyModule.class,
          AddTeacherViewModel_HiltModules.KeyModule.class,
          AuthViewModel_HiltModules.KeyModule.class,
          CoordinatorDashboardViewModel_HiltModules.KeyModule.class,
          GenerateTimetableViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          HiltWrapper_SavedStateHandleModule.class,
          NotificationsViewModel_HiltModules.KeyModule.class,
          SendNotificationViewModel_HiltModules.KeyModule.class,
          SetupTimetableDataViewModel_HiltModules.KeyModule.class,
          StudentDashboardViewModel_HiltModules.KeyModule.class,
          TeacherDashboardViewModel_HiltModules.KeyModule.class,
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          TimetableViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class,
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements MainActivity_GeneratedInjector,
      AuthActivity_GeneratedInjector,
      AddRoomActivity_GeneratedInjector,
      AddStudentGroupActivity_GeneratedInjector,
      AddSubjectActivity_GeneratedInjector,
      AddTeacherActivity_GeneratedInjector,
      CoordinatorDashboardActivity_GeneratedInjector,
      GenerateTimetableActivity_GeneratedInjector,
      SetupTimetableDataActivity_GeneratedInjector,
      NotificationsActivity_GeneratedInjector,
      StudentDashboardActivity_GeneratedInjector,
      SendNotificationActivity_GeneratedInjector,
      TeacherDashboardActivity_GeneratedInjector,
      TimetableViewerActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AddRoomViewModel_HiltModules.BindsModule.class,
          AddStudentGroupViewModel_HiltModules.BindsModule.class,
          AddSubjectViewModel_HiltModules.BindsModule.class,
          AddTeacherViewModel_HiltModules.BindsModule.class,
          AuthViewModel_HiltModules.BindsModule.class,
          CoordinatorDashboardViewModel_HiltModules.BindsModule.class,
          GenerateTimetableViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          NotificationsViewModel_HiltModules.BindsModule.class,
          SendNotificationViewModel_HiltModules.BindsModule.class,
          SetupTimetableDataViewModel_HiltModules.BindsModule.class,
          StudentDashboardViewModel_HiltModules.BindsModule.class,
          TeacherDashboardViewModel_HiltModules.BindsModule.class,
          TimetableViewModel_HiltModules.BindsModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
