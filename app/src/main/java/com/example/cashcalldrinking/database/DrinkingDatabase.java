package com.example.cashcalldrinking.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.cashcalldrinking.models.Department;
import com.example.cashcalldrinking.models.Drink;
import com.example.cashcalldrinking.models.Order;
import com.example.cashcalldrinking.models.User;
import com.example.cashcalldrinking.models.UserType;

@Database(entities = {User.class, Drink.class, Order.class, UserType.class, Department.class},version = 3)
public abstract class DrinkingDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract DrinkDao drinkDao();


}
