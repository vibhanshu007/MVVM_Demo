package com.vibs.mvvm_demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vibs.mvvm_demo.commands.RecyclerViewOnItemClick;
import com.vibs.mvvm_demo.databinding.NewsBinding;
import com.vibs.mvvm_demo.viewModel.NewsModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomAdapter> {

    private List<NewsModel> newsList;
    private LayoutInflater layoutInflater;
    private Context context;

    public RecyclerViewAdapter(List<NewsModel> newsList,Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        NewsBinding newsBinding = NewsBinding.inflate(layoutInflater,viewGroup,false);

        return new CustomAdapter(newsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter customAdapter, int i) {

        NewsModel newsModel = newsList.get(i);
        customAdapter.bind(newsModel);
        customAdapter.newsBinding.setNewsDetail(new RecyclerViewOnItemClick() {
            @Override
            public void recyclerViewOnItemClick(NewsModel newsModel) {
                Toast.makeText(context, "You clicked " + newsModel.title,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class CustomAdapter extends RecyclerView.ViewHolder {

        public NewsBinding newsBinding;

        public CustomAdapter(NewsBinding newsBinding) {
            super(newsBinding.getRoot());
            this.newsBinding = newsBinding;
        }

        public void bind(NewsModel newsModel){
            this.newsBinding.setNewsView(newsModel);
            newsBinding.executePendingBindings();
        }

        public void recyclerViewOnItemClick(NewsModel newsModel){
            Toast.makeText(context, "You clicked " + newsModel.title,
                    Toast.LENGTH_LONG).show();
        }

        public NewsBinding getNewsBinding(){
            return newsBinding;
        }
    }
}
