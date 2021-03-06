package com.singhajit.rubygems.profile.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.singhajit.rubygems.BR;
import com.singhajit.rubygems.core.ViewVisibility;

public class LoginViewModel extends BaseObservable {
  private String username;
  private String password;
  private String name;
  private ViewVisibility loginFormVisibility = new ViewVisibility(true);
  private ViewVisibility loaderVisibility = new ViewVisibility(false);
  private ViewVisibility profileCardVisibility = new ViewVisibility(false);
  private ViewVisibility requiredFieldsWarningVisibility = new ViewVisibility(false);

  public LoginViewModel(String name, String username) {
    this.name = name;
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Bindable
  public ViewVisibility getLoginFormVisibility() {
    return loginFormVisibility;
  }

  @Bindable
  public ViewVisibility getProfileCardVisibility() {
    return profileCardVisibility;
  }

  public void setLoginFormVisibility(boolean isVisible) {
    this.loginFormVisibility = new ViewVisibility(isVisible);
    notifyPropertyChanged(BR.loginFormVisibility);
  }

  public void setProfileCardVisibility(boolean isVisible) {
    this.profileCardVisibility = new ViewVisibility(isVisible);
    notifyPropertyChanged(BR.profileCardVisibility);
  }

  @Bindable
  public ViewVisibility getLoaderVisibility() {
    return loaderVisibility;
  }

  public void setLoaderVisibility(boolean isVisible) {
    this.loaderVisibility = new ViewVisibility(isVisible);
    notifyPropertyChanged(BR.loaderVisibility);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Bindable
  public ViewVisibility getRequiredFieldsWarningVisibility() {
    return requiredFieldsWarningVisibility;
  }

  public void setRequiredFieldsWarningVisibility(boolean isVisible) {
    this.requiredFieldsWarningVisibility = new ViewVisibility(isVisible);
    notifyPropertyChanged(BR.requiredFieldsWarningVisibility);
  }

  public boolean isAllRequiredFieldsEntered() {
    return (username != null && !username.isEmpty()) && (password != null && !password.isEmpty());
  }
}
