package com.vibs.mvvm_demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vibs.mvvm_demo.R;
import com.vibs.mvvm_demo.adapter.RecyclerViewAdapter;
import com.vibs.mvvm_demo.viewModel.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemo extends AppCompatActivity {

    private List<NewsModel> newsModelList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsModelList = new ArrayList<>();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(newsModelList);
        recyclerView.setAdapter(recyclerViewAdapter);
        setData();
    }

    public void setData(){
        NewsModel newsModel1 = new NewsModel();
        newsModel1.title = "Title 1";
        newsModel1.description = "Description 1";
        newsModelList.add(newsModel1);

        NewsModel newsModel2 = new NewsModel();
        newsModel2.title = "Title 2";
        newsModel2.description = "Description 2";
        newsModelList.add(newsModel2);

        NewsModel newsModel3 = new NewsModel();
        newsModel3.title = "Title 3";
        newsModel3.description = "Description 3";
        newsModelList.add(newsModel3);

        NewsModel newsModel4 = new NewsModel();
        newsModel4.title = "Title 4";
        newsModel4.description = "Description 4";
        newsModelList.add(newsModel4);

        NewsModel newsModel5 = new NewsModel();
        newsModel5.title = "Title 5";
        newsModel5.description = "Description 5";
        newsModelList.add(newsModel5);
    }
}
