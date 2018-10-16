package com.example.daffodil_43.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.daffodil_43.pojo.Datum;
import com.example.daffodil_43.pojo.ListData;
import com.example.daffodil_43.viewmodel.RepoDataViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RepoDataViewModel repoDataViewModel;
    private Observer<ListData> observer;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ListDataAdapter listDataAdapter;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list_data);
        progressBar=findViewById(R.id.progress_bar);

        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        repoDataViewModel= ViewModelProviders.of(this).get(RepoDataViewModel.class);

        observer=new Observer<ListData>() {
            @Override
            public void onChanged(@Nullable ListData listData) {

                if(listData!=null)
                {
                    ArrayList<Datum> data= (ArrayList<Datum>) listData.getData();
                   listDataAdapter=new ListDataAdapter(data);
                   recyclerView.setAdapter(listDataAdapter);
                }
                else
                {
                    System.out.println("data not found");

                }
                progressBar.setVisibility(View.GONE);

            }
        };
        repoDataViewModel.getMutableLiveData().observe(this,observer);
    }
}
