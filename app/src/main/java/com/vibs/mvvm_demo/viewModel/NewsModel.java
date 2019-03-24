package com.vibs.mvvm_demo.viewModel;

import com.vibs.mvvm_demo.model.News;

public class NewsModel {

    public String title, description;

    public NewsModel() {
    }

    public NewsModel(News news) {
        this.title = news.title;
        this.description = news.description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
