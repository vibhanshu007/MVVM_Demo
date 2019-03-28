package com.vibs.mvvm_demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vibs.mvvm_demo.R;
import com.vibs.mvvm_demo.model.Data;

import java.util.List;

public class RxJavaAdapter extends RecyclerView.Adapter<RxJavaAdapter.MyViewHolder> {

    private List<Data> dataList;
    private Context context;

    public RxJavaAdapter(List<Data> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.layout_rx_cardview, viewGroup, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.tv_id.setText(String.valueOf(dataList.get(position).getId()));
        myViewHolder.tv_name.setText(dataList.get(position).getName());
        myViewHolder.tv_year.setText(String.valueOf(dataList.get(position).getYear()));
        myViewHolder.tv_pro_val.setText(dataList.get(position).getPantone_value());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id, tv_name, tv_year, tv_pro_val;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_id = itemView.findViewById(R.id.id);
            this.tv_name = itemView.findViewById(R.id.name);
            this.tv_year = itemView.findViewById(R.id.year);
            this.tv_pro_val = itemView.findViewById(R.id.pantone_value);
        }
    }
}
