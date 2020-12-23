package com.example.cashcalldrinking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cashcalldrinking.databinding.ActivityUserProfileBinding;
import com.example.cashcalldrinking.models.Drink;
import com.example.cashcalldrinking.models.User;
import com.example.cashcalldrinking.viewmodels.UserProfileViewModel;
import com.example.cashcalldrinking.viewmodels.UserViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserProfile extends AppCompatActivity {
    TextView t1;
    ActivityUserProfileBinding binding;
    UserProfileViewModel userProfileViewModel;
    ArrayList<String> drinksArray = new ArrayList<>();
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userProfileViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("user");
        User user = gson.fromJson(strObj, User.class);
        binding = DataBindingUtil.setContentView(UserProfile.this,R.layout.activity_user_profile);
        binding.setLifecycleOwner(this);
        binding.name.setText(user.getName());
        binding.username.setText(user.getUsername());
        binding.userdepart.setText(user.getUserDepartment().getName());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getApplicationContext(), R.layout.spinner_txt, drinksArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.drinks.setAdapter(adapter);

        userProfileViewModel.getAllDrinks();
        userProfileViewModel.allDrinks.observe(UserProfile.this, new Observer<ArrayList<Drink>>() {
            @Override
            public void onChanged(ArrayList<Drink> drinks) {

                for (Drink drink : drinks) {
                    drinksArray.add(drink.getName());
                }
                adapter.notifyDataSetChanged();



            }
        });





    }
}