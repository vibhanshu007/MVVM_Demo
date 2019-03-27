package com.vibs.mvvm_demo.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import com.vibs.mvvm_demo.BR;
import com.vibs.mvvm_demo.R;
import com.vibs.mvvm_demo.activity.RecyclerViewDemo;
import com.vibs.mvvm_demo.model.LoginResponse;
import com.vibs.mvvm_demo.model.User;
import com.vibs.mvvm_demo.network.ApiInterface;
import com.vibs.mvvm_demo.network.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModel extends BaseObservable {

    private String userName;
    private String password;
    private String userNameHint;
    private String passwordHint;
    private Context context;
    //private ObservableInt progressBar;

    public UserModel(Context context, User user) {
        this.userNameHint = user.userNameHint;
        this.passwordHint = user.passwordHint;
        this.context = context;
        //progressBar = new ObservableInt(View.GONE);
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

    /*
    * {
    "email": "peter@klaven",
    "password": "cityslicka"
    }*/

    public void loginRequest() {
        ApiInterface apiInterface = ApiUtil.getAPIService();

        //progressBar.set(View.VISIBLE);
        apiInterface.loginRequest("peter@klaven", "cityslicka").enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(context.getApplicationContext(), RecyclerViewDemo.class);
                    context.startActivity(intent);
                    Toast.makeText(context, response.body().getToken(), Toast.LENGTH_LONG).show();
                }
                //progressBar.set(View.GONE);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                //progressBar.set(View.GONE);
            }
        });


    }
}