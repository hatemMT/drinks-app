package com.example.cashcalldrinking.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Drink {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public Drink(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
