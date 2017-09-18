package com.example.lsantos.requestteste.service;

import com.example.lsantos.requestteste.DataFruit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by lsantos on 13/09/2017.
 */
public class FuitsService{

    private static String BASE_URL = "https://raw.githubusercontent.com/muxidev/desafio-android/master/";
    public interface IFruitAPI {
        @GET("fruits.json")
        Call<DataFruit> listCall();
    }

    public IFruitAPI getAPI(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IFruitAPI.class);
    }
}
