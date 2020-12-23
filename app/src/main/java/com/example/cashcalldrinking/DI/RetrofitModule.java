package com.example.cashcalldrinking.DI;

import com.example.cashcalldrinking.models.Drink;
import com.example.cashcalldrinking.netwrok.DrinkApi;
import com.example.cashcalldrinking.netwrok.UserApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {

    @Provides
    @Singleton
    public static UserApi ProvideUserApiServes(){
        return new Retrofit.Builder().baseUrl("https://5fe091f004f0780017de8fca.mockapi.io/api/v1/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserApi.class);

    }

    @Provides
    @Singleton
    public static DrinkApi ProvideDrinkApiServes(){
        return new Retrofit.Builder().baseUrl("https://5fe091f004f0780017de8fca.mockapi.io/api/v1/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DrinkApi.class);

    }
}
