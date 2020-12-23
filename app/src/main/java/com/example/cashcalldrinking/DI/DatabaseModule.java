package com.example.cashcalldrinking.DI;


import android.app.Application;

import androidx.room.Room;

import com.example.cashcalldrinking.database.DrinkDao;
import com.example.cashcalldrinking.database.DrinkingDatabase;
import com.example.cashcalldrinking.database.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static DrinkingDatabase provideDb(Application application){
        return Room.databaseBuilder(application,DrinkingDatabase.class,"Cashcall_drinking")
               .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static UserDao UserDao(DrinkingDatabase drinkingDatabase)
    {
        return drinkingDatabase.userDao();
    }

    @Provides
    @Singleton
    public static DrinkDao DrinkDao(DrinkingDatabase drinkingDatabase)
    {
        return drinkingDatabase.drinkDao();
    }
}
