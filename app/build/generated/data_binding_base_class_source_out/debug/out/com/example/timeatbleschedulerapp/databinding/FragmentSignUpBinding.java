// Generated by view binder compiler. Do not edit!
package com.example.timeatbleschedulerapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.timeatbleschedulerapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSignUpBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AutoCompleteTextView actvRole;

  @NonNull
  public final MaterialButton btnSignUp;

  @NonNull
  public final TextInputEditText etSignUpEmail;

  @NonNull
  public final TextInputEditText etSignUpName;

  @NonNull
  public final TextInputEditText etSignUpPassword;

  @NonNull
  public final CircularProgressIndicator progressBar;

  private FragmentSignUpBinding(@NonNull LinearLayout rootView,
      @NonNull AutoCompleteTextView actvRole, @NonNull MaterialButton btnSignUp,
      @NonNull TextInputEditText etSignUpEmail, @NonNull TextInputEditText etSignUpName,
      @NonNull TextInputEditText etSignUpPassword, @NonNull CircularProgressIndicator progressBar) {
    this.rootView = rootView;
    this.actvRole = actvRole;
    this.btnSignUp = btnSignUp;
    this.etSignUpEmail = etSignUpEmail;
    this.etSignUpName = etSignUpName;
    this.etSignUpPassword = etSignUpPassword;
    this.progressBar = progressBar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.actvRole;
      AutoCompleteTextView actvRole = ViewBindings.findChildViewById(rootView, id);
      if (actvRole == null) {
        break missingId;
      }

      id = R.id.btnSignUp;
      MaterialButton btnSignUp = ViewBindings.findChildViewById(rootView, id);
      if (btnSignUp == null) {
        break missingId;
      }

      id = R.id.etSignUpEmail;
      TextInputEditText etSignUpEmail = ViewBindings.findChildViewById(rootView, id);
      if (etSignUpEmail == null) {
        break missingId;
      }

      id = R.id.etSignUpName;
      TextInputEditText etSignUpName = ViewBindings.findChildViewById(rootView, id);
      if (etSignUpName == null) {
        break missingId;
      }

      id = R.id.etSignUpPassword;
      TextInputEditText etSignUpPassword = ViewBindings.findChildViewById(rootView, id);
      if (etSignUpPassword == null) {
        break missingId;
      }

      id = R.id.progressBar;
      CircularProgressIndicator progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      return new FragmentSignUpBinding((LinearLayout) rootView, actvRole, btnSignUp, etSignUpEmail,
          etSignUpName, etSignUpPassword, progressBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
