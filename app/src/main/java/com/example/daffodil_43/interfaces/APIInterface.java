package com.example.daffodil_43.interfaces;


import com.example.daffodil_43.pojo.ListData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {


    @GET("/api/unknown")
    public Call<ListData> getListData();
}
