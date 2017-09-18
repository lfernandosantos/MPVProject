package com.example.lsantos.requestteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lsantos.requestteste.model.Fruit;
import com.example.lsantos.requestteste.presenter.FruitPresenter;
import com.example.lsantos.requestteste.service.FuitsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements  MainActivityContract.View{

    private FruitPresenter fruitPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitPresenter = new FruitPresenter(this, this);
        fruitPresenter.getFruits();

    }

    @Override
    public void onLoadedFruits(DataFruit dataFruit) {
        for (Fruit f : dataFruit.getFruits()){
            Log.i("Request", "Fruta: " + f.getName());
        }
    }
}

