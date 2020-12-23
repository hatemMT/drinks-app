package com.example.cashcalldrinking.viewmodels;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cashcalldrinking.models.Drink;
import com.example.cashcalldrinking.models.User;
import com.example.cashcalldrinking.repos.DrinkRepo;
import com.example.cashcalldrinking.repos.UserRepo;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class UserProfileViewModel extends ViewModel {


    DrinkRepo drinkRepo;
    public MutableLiveData<ArrayList<Drink>> allDrinks = new MutableLiveData<>();
    @ViewModelInject
    public UserProfileViewModel(DrinkRepo drinkRepo) {
        this.drinkRepo = drinkRepo;
    }

    public void getAllDrinks(){
        drinkRepo.getDrinks().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result->{allDrinks.setValue(result);}, erroe->{
                    Log.d("TAG", "getAllDrinks error : "+erroe);
                });
    }
}
