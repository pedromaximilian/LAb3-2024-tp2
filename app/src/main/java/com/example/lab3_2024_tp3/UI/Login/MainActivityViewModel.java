package com.example.lab3_2024_tp3.UI.Login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lab3_2024_tp3.Model.User;
import com.example.lab3_2024_tp3.Services.FileUserService;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<User> mUser;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<User> getMUser(){
        if (mUser == null){
            mUser = new MutableLiveData<>();
        }
        return mUser;
    }

    public void login(String inputMail, String inputPassword){
        mUser.setValue(FileUserService.login(getApplication().getApplicationContext(), inputMail, inputPassword));
    }

}
