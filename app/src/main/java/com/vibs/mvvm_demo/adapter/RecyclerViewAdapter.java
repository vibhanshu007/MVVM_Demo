package com.vibs.mvvm_demo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibs.mvvm_demo.databinding.NewsBinding;
import com.vibs.mvvm_demo.viewModel.NewsModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomAdapter> {

    private List<NewsModel> newsList;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter(List<NewsModel> newsList) {
        this.newsList = newsList;
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
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class CustomAdapter extends RecyclerView.ViewHolder {

        NewsBinding newsBinding;

        public CustomAdapter(NewsBinding newsBinding) {
            super(newsBinding.getRoot());
            this.newsBinding = newsBinding;
        }

        public void bind(NewsModel newsModel){
            this.newsBinding.setNewsView(newsModel);
        }

        public NewsBinding getNewsBinding(){
            return newsBinding;
        }
    }
}
