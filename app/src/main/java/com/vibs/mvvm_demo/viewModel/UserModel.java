package com.vibs.mvvm_demo.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.vibs.mvvm_demo.R;
import com.vibs.mvvm_demo.model.User;
import com.vibs.mvvm_demo.BR;

public class UserModel extends BaseObservable {

    private String userName;
    private String password;
    private String userNameHint;
    private String passwordHint;

    public UserModel(User user) {
        this.userNameHint = user.userNameHint;
        this.passwordHint = user.passwordHint;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(R.id.et_password);
    }

    public String getUserNameHint() {
        return userNameHint;
    }

    public void setUserNameHint(String userNameHint) {
        this.userNameHint = userNameHint;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }


}
