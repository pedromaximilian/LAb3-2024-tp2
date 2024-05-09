package com.example.lab3_2024_tp3.Services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.lab3_2024_tp3.Model.User;

public class SPService {

    private static SharedPreferences sp;

    private static SharedPreferences connect(Context context){
        if (sp==null){
            sp=context.getSharedPreferences("data",0);
        }
        return sp;
    }

    public static void saveUser(Context context, User user) {
        SharedPreferences.Editor editor= sp.edit();
        editor.putLong("dni", user.getDni());
        editor.putString("lastName", user.getLastname());
        editor.putString("name", user.getName());
        editor.putString("mail", user.getMail());
        editor.putString("password", user.getPassword());
        editor.commit();
    }

    public static User read(Context context){
        SharedPreferences sp = connect(context);
        Long dni = sp.getLong("dni", -1);
        String lastName = sp.getString("lastName", "-1");
        String name = sp.getString("name", "-1");
        String mail = sp.getString("mail", "-1");
        String password = sp.getString("password", "-1");

        User user = new User(dni, lastName, name, mail, password);
        return user;
    }

    public static User login(Context context, String inputMail, String inputPassword){
        User user = null;
        SharedPreferences sp = connect(context);
        Long dni = sp.getLong("dni", -1);
        String lastName = sp.getString("lastName", "-1");
        String name = sp.getString("name", "-1");
        String mail = sp.getString("mail", "-1");
        String password = sp.getString("password", "-1");

        if (inputPassword.equals(password) && inputMail.equals(mail)) {
            user = new User(dni, lastName, name, mail, password);
        }
        return user;
    }
}
