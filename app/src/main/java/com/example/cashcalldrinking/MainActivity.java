package com.example.cashcalldrinking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.cashcalldrinking.database.UserDao;
import com.example.cashcalldrinking.databinding.ActivityMainBinding;
import com.example.cashcalldrinking.models.Department;
import com.example.cashcalldrinking.models.User;
import com.example.cashcalldrinking.models.UserType;
import com.example.cashcalldrinking.netwrok.UserApi;
import com.example.cashcalldrinking.viewmodels.UserViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Inject
    public UserDao userDao;
    private MutableLiveData<List<User>> users=
            new MutableLiveData<>();
    UserViewModel userViewModel ;
    private ActivityMainBinding binding;



    @Inject
    UserApi userApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setUserViewModel(userViewModel);

        binding.usernameTxt.setText("username 1");
        binding.txtPassword.setText("password 1");

        userViewModel.user.observe(MainActivity.this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null)
                {
                    Intent myIntent = new Intent(MainActivity.this, UserProfile.class);
                    myIntent.putExtra("user", (new Gson()).toJson(user) ); //Optional parameters
                    MainActivity.this.startActivity(myIntent);


                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("wrong username or wrong password");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "retry",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }
            }
        });
    }
}