package com.vibs.mvvm_demo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vibs.mvvm_demo.R;
import com.vibs.mvvm_demo.adapter.RxJavaAdapter;
import com.vibs.mvvm_demo.commands.UserLogin;
import com.vibs.mvvm_demo.databinding.ActivityMainBinding;
import com.vibs.mvvm_demo.model.Data;
import com.vibs.mvvm_demo.model.DataList;
import com.vibs.mvvm_demo.model.User;
import com.vibs.mvvm_demo.network.ApiInterface;
import com.vibs.mvvm_demo.network.ApiUtil;
import com.vibs.mvvm_demo.viewModel.UserModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    UserModel userModel;
    ActivityMainBinding activityMainBinding;
    Button btn_getData;
    List<Data> dataLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final UserModel userModel = new UserModel(this,new User(getString(R.string.username), getString(R.string.password)));
        activityMainBinding.setLogin(userModel);
        btn_getData = findViewById(R.id.btn_getData);

        activityMainBinding.setLoginEvent(new UserLogin() {
            @Override
            public void userLoginEvent() {
                //login();
                userModel.loginRequest();
            }
        });
        btn_getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });

    }

    public void login(){
        Toast.makeText(MainActivity.this,activityMainBinding.getLogin().getUserName(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, RecyclerViewDemo.class);
        startActivity(intent);
    }

    private void loadData() {
        ApiInterface apiInterface = ApiUtil.getAPIService();
        Observable<DataList> dataListObservable = apiInterface.getDataList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        dataListObservable.subscribe(new Observer<DataList>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DataList dataList) {

                dataLists = dataList.getData();
                ArrayList<Data> dataArrayList = new ArrayList<>(dataLists);
                Intent intent = new Intent(MainActivity.this,RxJavaDemoActivity.class);
                intent.putParcelableArrayListExtra("listData",dataArrayList);
                startActivity(intent);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
