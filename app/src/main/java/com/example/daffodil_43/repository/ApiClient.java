package com.example.daffodil_43.repository;

import com.example.daffodil_43.constants.ApplicationConstants;
import com.example.daffodil_43.interfaces.APIInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit;
    private static APIInterface apiInterface;

    public static APIInterface getClient() {

        if(apiInterface==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(ApplicationConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            apiInterface=retrofit.create(APIInterface.class);
        }
        return apiInterface;
    }
}
