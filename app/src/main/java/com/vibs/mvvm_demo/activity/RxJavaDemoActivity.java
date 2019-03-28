package com.vibs.mvvm_demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vibs.mvvm_demo.R;
import com.vibs.mvvm_demo.adapter.RxJavaAdapter;
import com.vibs.mvvm_demo.model.Data;
import com.vibs.mvvm_demo.model.DataList;
import com.vibs.mvvm_demo.network.ApiInterface;
import com.vibs.mvvm_demo.network.ApiUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaDemoActivity extends AppCompatActivity {

    List<Data> dataLists;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo);

        recyclerView = findViewById(R.id.recyclerViewRx);

        Bundle data = getIntent().getExtras();
        dataLists =  data.getParcelableArrayList("listData");

        RxJavaAdapter adapter = new RxJavaAdapter(dataLists,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        

    }
}
