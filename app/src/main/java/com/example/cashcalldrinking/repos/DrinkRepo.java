package com.example.cashcalldrinking.repos;

import com.example.cashcalldrinking.database.DrinkDao;
import com.example.cashcalldrinking.models.Drink;
import com.example.cashcalldrinking.netwrok.DrinkApi;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class DrinkRepo {


    DrinkApi drinkApi;

    public Observable<ArrayList<Drink>> getDrinks()
    {
        return drinkApi.getAllDrinks();
    }

    @Inject
    public DrinkRepo(DrinkApi drinkApi) {
        this.drinkApi = drinkApi;
    }
}
