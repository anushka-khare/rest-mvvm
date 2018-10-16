package com.example.daffodil_43.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.daffodil_43.pojo.ListData;
import com.example.daffodil_43.repository.Repository;

public class RepoDataViewModel extends ViewModel {


    private MutableLiveData<ListData> mutableLiveData;
    private Repository repository=new Repository();;

    public MutableLiveData<ListData> getMutableLiveData() {
        mutableLiveData=repository.getListData();
        return mutableLiveData;
    }
}
