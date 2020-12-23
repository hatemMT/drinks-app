package com.example.cashcalldrinking.viewmodels;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cashcalldrinking.models.User;
import com.example.cashcalldrinking.repos.UserRepo;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserViewModel extends ViewModel {

    public String username;
    public String password;

    UserRepo userRepo;
    public MutableLiveData<ArrayList<User>> allUsers = new MutableLiveData<>();
    public MutableLiveData<User> user = new MutableLiveData<>();

    @ViewModelInject
    public UserViewModel(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    public void login()
    {

        userRepo.Login(username).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result->{if (result.get(0).getPassword().equals(password))user.setValue(result.get(0)); else user.setValue(null);},error-> {Log.d("TAG", "login error : " + error.getMessage());user.setValue(null);});
    }

    

}
