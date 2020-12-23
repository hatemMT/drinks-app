package com.example.cashcalldrinking.netwrok;

import com.example.cashcalldrinking.models.Drink;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface DrinkApi {
    @GET("drink")
    public Observable<ArrayList<Drink>> getAllDrinks();
}
