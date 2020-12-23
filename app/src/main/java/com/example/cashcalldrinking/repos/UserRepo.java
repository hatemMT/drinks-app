package com.example.cashcalldrinking.repos;

import android.util.Log;

import androidx.annotation.LongDef;

import com.example.cashcalldrinking.database.UserDao;
import com.example.cashcalldrinking.models.User;
import com.example.cashcalldrinking.netwrok.UserApi;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.observers.BlockingBaseObserver;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserRepo {
    private UserDao userDao;
    private UserApi userApi;
    Observable<ArrayList<User>> getAllUsers()
    {
        return userApi.getUsers();
    }
    public Observable<ArrayList<User>> Login(String username)
    {
       return userApi.Login(username);

    }


    @Inject
    public UserRepo(UserDao userDao, UserApi userApi) {
        this.userDao = userDao;
        this.userApi = userApi;
    }

}
