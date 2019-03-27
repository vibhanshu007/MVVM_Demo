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

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(newsModelList,this);
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

        NewsModel newsModel6 = new NewsModel();
        newsModel6.title = "Title 6";
        newsModel6.description = "Description 6";
        newsModelList.add(newsModel6);

        NewsModel newsModel7 = new NewsModel();
        newsModel7.title = "Title 7";
        newsModel7.description = "Description 7";
        newsModelList.add(newsModel7);

        NewsModel newsModel8 = new NewsModel();
        newsModel8.title = "Title 8";
        newsModel8.description = "Description 8";
        newsModelList.add(newsModel8);

        NewsModel newsModel9 = new NewsModel();
        newsModel9.title = "Title 9";
        newsModel9.description = "Description 9";
        newsModelList.add(newsModel9);

        NewsModel newsModel10 = new NewsModel();
        newsModel10.title = "Title 10";
        newsModel10.description = "Description 10";
        newsModelList.add(newsModel10);

        NewsModel newsModel11 = new NewsModel();
        newsModel11.title = "Title 11";
        newsModel11.description = "Description 11";
        newsModelList.add(newsModel11);

        NewsModel newsModel12 = new NewsModel();
        newsModel12.title = "Title 12";
        newsModel12.description = "Description 12";
        newsModelList.add(newsModel12);

        NewsModel newsModel13 = new NewsModel();
        newsModel13.title = "Title 13";
        newsModel13.description = "Description 13";
        newsModelList.add(newsModel13);

        NewsModel newsModel14 = new NewsModel();
        newsModel14.title = "Title 14";
        newsModel14.description = "Description 14";
        newsModelList.add(newsModel14);

        NewsModel newsModel15 = new NewsModel();
        newsModel15.title = "Title 15";
        newsModel15.description = "Description 15";
        newsModelList.add(newsModel15);

    }
}
