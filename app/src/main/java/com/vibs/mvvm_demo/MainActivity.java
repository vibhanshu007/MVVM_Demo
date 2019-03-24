package com.vibs.mvvm_demo;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.vibs.mvvm_demo.commands.UserLogin;
import com.vibs.mvvm_demo.databinding.ActivityMainBinding;
import com.vibs.mvvm_demo.model.User;
import com.vibs.mvvm_demo.viewModel.UserModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserModel userModel = new UserModel(new User(getString(R.string.username), getString(R.string.password)));
        activityMainBinding.setLogin(userModel);

        activityMainBinding.setLoginEvent(new UserLogin() {
            @Override
            public void userLoginEvent() {
                Toast.makeText(MainActivity.this,activityMainBinding.getLogin().getUserName(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
