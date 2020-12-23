package com.example.cashcalldrinking.models;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Order {
    @PrimaryKey(autoGenerate = true)

    private int id;

    @Embedded(prefix = "order_owner") private User orderOwner;
    @Embedded(prefix = "user_drink")private Drink userDrink;
    private String orderTime;
    private String state;
    @Embedded(prefix = "office_boy") private User officeBoy;

    public Order(int id, User orderOwner, Drink userDrink, String orderTime, String state, User officeBoy) {
        this.id = id;
        this.orderOwner = orderOwner;
        this.userDrink = userDrink;
        this.orderTime = orderTime;
        this.state = state;
        this.officeBoy = officeBoy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(User orderOwner) {
        this.orderOwner = orderOwner;
    }

    public Drink getUserDrink() {
        return userDrink;
    }

    public void setUserDrink(Drink userDrink) {
        this.userDrink = userDrink;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getOfficeBoy() {
        return officeBoy;
    }

    public void setOfficeBoy(User officeBoy) {
        this.officeBoy = officeBoy;
    }
}
