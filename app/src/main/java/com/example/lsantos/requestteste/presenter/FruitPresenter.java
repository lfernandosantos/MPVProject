package com.example.lsantos.requestteste.presenter;

import android.content.Context;

import com.example.lsantos.requestteste.DataFruit;
import com.example.lsantos.requestteste.MainActivityContract;
import com.example.lsantos.requestteste.service.FuitsService;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lsantos on 13/09/2017.
 */

public class FruitPresenter implements MainActivityContract.Presenter{
    private final Context context;
    private final FuitsService service;
    private final CompositeDisposable disposable = new CompositeDisposable();


    private final MainActivityContract.View view;

    public FruitPresenter(Context context, MainActivityContract.View view){
        this.context = context;
        this.view = view;
        this.service = new FuitsService();
    }

    void onRunRequestObservable(){
        disposable
    }

    //static Observable<DataFruit> sampleObservable()
    @Override
    public void getFruits(){
        service.getAPI()
                .listCall()
                .enqueue(new Callback<DataFruit>() {
                    @Override
                    public void onResponse(Call<DataFruit> call, Response<DataFruit> response) {
                        DataFruit dataFruit = response.body();

                        if(dataFruit != null){
                            view.onLoadedFruits(dataFruit);
                        }
                    }

                    @Override
                    public void onFailure(Call<DataFruit> call, Throwable t) {

                    }
                });
    }

}

