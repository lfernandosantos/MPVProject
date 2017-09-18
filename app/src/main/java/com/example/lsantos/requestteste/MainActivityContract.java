package com.example.lsantos.requestteste;

/**
 * Created by lsantos on 14/09/2017.
 */

public interface MainActivityContract {


    interface View{

        void onLoadedFruits(DataFruit dataFruit);

    }

    interface Presenter{
        void getFruits();
    }
}
