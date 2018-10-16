package com.example.daffodil_43.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.daffodil_43.pojo.Datum;

import java.util.ArrayList;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ViewHolder> {

    private ArrayList<Datum> listData;
    private Context context;
    public ListDataAdapter(ArrayList<Datum> listData) {
        this.listData=listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();

        ViewHolder viewHolder=new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_data_one_item,viewGroup,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        if(listData!=null && listData.size()>0)
        {
            viewHolder.list_item_parent.setBackgroundColor(Color.parseColor(listData.get(i).getColor()));
            viewHolder.year.setText(String.valueOf(listData.get(i).getYear()));
            viewHolder.name.setText(listData.get(i).getName());
            viewHolder.pantone_value.setText(listData.get(i).getPantoneValue());
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name, year, pantone_value;
        private RelativeLayout list_item_parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            year=itemView.findViewById(R.id.year);
            pantone_value=itemView.findViewById(R.id.pantone_value);
            list_item_parent=itemView.findViewById(R.id.list_item_parent);
        }
    }
}
