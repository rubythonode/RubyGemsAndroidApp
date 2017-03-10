package com.singhajit.rubygems.core;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.singhajit.rubygems.R;

public class ErrorHandler {
  public static void showSnackBar(View rootView, String message, View.OnClickListener listener) {
    Context context = rootView.getContext();
    String msg = message == null || message.isEmpty() ? context.getString(R.string.generic_error_msg) : message;
    Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG).setAction(context.getString(R.string.retry), listener).show();
  }
}