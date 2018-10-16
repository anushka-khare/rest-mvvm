package com.example.daffodil_43.repository;

import android.arch.lifecycle.MutableLiveData;
import com.example.daffodil_43.interfaces.APIInterface;
import com.example.daffodil_43.pojo.ListData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private APIInterface apiInterface;
    private MutableLiveData<ListData> listDataLiveData;

    public Repository() {

        apiInterface=ApiClient.getClient();
        listDataLiveData=new MutableLiveData<>();
    }


    public MutableLiveData<ListData> getListData()
    {

        Call<ListData> listDataCall=apiInterface.getListData();

        listDataCall.enqueue(new Callback<ListData>() {
            @Override
            public void onResponse(Call<ListData> call, Response<ListData> response) {
                if(response.isSuccessful())
                {
                    listDataLiveData.postValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<ListData> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return listDataLiveData;
    }
}
