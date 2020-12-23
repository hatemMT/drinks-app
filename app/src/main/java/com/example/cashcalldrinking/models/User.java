package com.example.cashcalldrinking.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

//@Entity(foreignKeys = {@ForeignKey(entity = UserType.class,parentColumns = "id" ,childColumns = "userType_id")} )
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @Embedded(prefix = "department_")
    private Department userDepartment;
    @ColumnInfo(name = "user_name")
    private String name;
    private String username;
    private String password;

    public User() {
    }

    public User(int id, Department userDepartment, String name, String username, String password) {
        this.id = id;
        this.userDepartment = userDepartment;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(Department userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}