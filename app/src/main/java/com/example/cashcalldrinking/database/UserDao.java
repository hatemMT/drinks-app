package com.example.cashcalldrinking.database;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.cashcalldrinking.models.User;

@Dao
public interface UserDao {
    @Insert
    public void InsertUser(User usser);

}
