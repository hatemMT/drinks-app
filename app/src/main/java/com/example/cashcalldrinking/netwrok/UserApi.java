package com.example.cashcalldrinking.netwrok;

import com.example.cashcalldrinking.models.User;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface UserApi {
    @GET("user")
    public Observable<ArrayList<User>> getUsers();

    @GET("user")
    public Observable<ArrayList<User>> Login(@Query("username") String username);


}
