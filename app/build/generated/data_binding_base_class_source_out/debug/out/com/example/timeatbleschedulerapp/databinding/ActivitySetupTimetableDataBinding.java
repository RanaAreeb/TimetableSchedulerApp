// Generated by view binder compiler. Do not edit!
package com.example.timeatbleschedulerapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.timeatbleschedulerapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySetupTimetableDataBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final MaterialButton btnGenerateTimetable;

  @NonNull
  public final MaterialButton btnSaveData;

  @NonNull
  public final FloatingActionButton fabAddGroup;

  @NonNull
  public final FloatingActionButton fabAddRoom;

  @NonNull
  public final FloatingActionButton fabAddSubject;

  @NonNull
  public final FloatingActionButton fabAddTeacher;

  @NonNull
  public final RecyclerView rvRooms;

  @NonNull
  public final RecyclerView rvStudentGroups;

  @NonNull
  public final RecyclerView rvSubjects;

  @NonNull
  public final RecyclerView rvTeachers;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvGroupCount;

  @NonNull
  public final TextView tvRoomCount;

  @NonNull
  public final TextView tvSubjectCount;

  @NonNull
  public final TextView tvTeacherCount;

  private ActivitySetupTimetableDataBinding(@NonNull CoordinatorLayout rootView,
      @NonNull MaterialButton btnGenerateTimetable, @NonNull MaterialButton btnSaveData,
      @NonNull FloatingActionButton fabAddGroup, @NonNull FloatingActionButton fabAddRoom,
      @NonNull FloatingActionButton fabAddSubject, @NonNull FloatingActionButton fabAddTeacher,
      @NonNull RecyclerView rvRooms, @NonNull RecyclerView rvStudentGroups,
      @NonNull RecyclerView rvSubjects, @NonNull RecyclerView rvTeachers, @NonNull Toolbar toolbar,
      @NonNull TextView tvGroupCount, @NonNull TextView tvRoomCount,
      @NonNull TextView tvSubjectCount, @NonNull TextView tvTeacherCount) {
    this.rootView = rootView;
    this.btnGenerateTimetable = btnGenerateTimetable;
    this.btnSaveData = btnSaveData;
    this.fabAddGroup = fabAddGroup;
    this.fabAddRoom = fabAddRoom;
    this.fabAddSubject = fabAddSubject;
    this.fabAddTeacher = fabAddTeacher;
    this.rvRooms = rvRooms;
    this.rvStudentGroups = rvStudentGroups;
    this.rvSubjects = rvSubjects;
    this.rvTeachers = rvTeachers;
    this.toolbar = toolbar;
    this.tvGroupCount = tvGroupCount;
    this.tvRoomCount = tvRoomCount;
    this.tvSubjectCount = tvSubjectCount;
    this.tvTeacherCount = tvTeacherCount;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySetupTimetableDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySetupTimetableDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_setup_timetable_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySetupTimetableDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_generate_timetable;
      MaterialButton btnGenerateTimetable = ViewBindings.findChildViewById(rootView, id);
      if (btnGenerateTimetable == null) {
        break missingId;
      }

      id = R.id.btn_save_data;
      MaterialButton btnSaveData = ViewBindings.findChildViewById(rootView, id);
      if (btnSaveData == null) {
        break missingId;
      }

      id = R.id.fab_add_group;
      FloatingActionButton fabAddGroup = ViewBindings.findChildViewById(rootView, id);
      if (fabAddGroup == null) {
        break missingId;
      }

      id = R.id.fab_add_room;
      FloatingActionButton fabAddRoom = ViewBindings.findChildViewById(rootView, id);
      if (fabAddRoom == null) {
        break missingId;
      }

      id = R.id.fab_add_subject;
      FloatingActionButton fabAddSubject = ViewBindings.findChildViewById(rootView, id);
      if (fabAddSubject == null) {
        break missingId;
      }

      id = R.id.fab_add_teacher;
      FloatingActionButton fabAddTeacher = ViewBindings.findChildViewById(rootView, id);
      if (fabAddTeacher == null) {
        break missingId;
      }

      id = R.id.rv_rooms;
      RecyclerView rvRooms = ViewBindings.findChildViewById(rootView, id);
      if (rvRooms == null) {
        break missingId;
      }

      id = R.id.rv_student_groups;
      RecyclerView rvStudentGroups = ViewBindings.findChildViewById(rootView, id);
      if (rvStudentGroups == null) {
        break missingId;
      }

      id = R.id.rv_subjects;
      RecyclerView rvSubjects = ViewBindings.findChildViewById(rootView, id);
      if (rvSubjects == null) {
        break missingId;
      }

      id = R.id.rv_teachers;
      RecyclerView rvTeachers = ViewBindings.findChildViewById(rootView, id);
      if (rvTeachers == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tv_group_count;
      TextView tvGroupCount = ViewBindings.findChildViewById(rootView, id);
      if (tvGroupCount == null) {
        break missingId;
      }

      id = R.id.tv_room_count;
      TextView tvRoomCount = ViewBindings.findChildViewById(rootView, id);
      if (tvRoomCount == null) {
        break missingId;
      }

      id = R.id.tv_subject_count;
      TextView tvSubjectCount = ViewBindings.findChildViewById(rootView, id);
      if (tvSubjectCount == null) {
        break missingId;
      }

      id = R.id.tv_teacher_count;
      TextView tvTeacherCount = ViewBindings.findChildViewById(rootView, id);
      if (tvTeacherCount == null) {
        break missingId;
      }

      return new ActivitySetupTimetableDataBinding((CoordinatorLayout) rootView,
          btnGenerateTimetable, btnSaveData, fabAddGroup, fabAddRoom, fabAddSubject, fabAddTeacher,
          rvRooms, rvStudentGroups, rvSubjects, rvTeachers, toolbar, tvGroupCount, tvRoomCount,
          tvSubjectCount, tvTeacherCount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
