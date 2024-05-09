package com.example.lab3_2024_tp3.Services;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.lab3_2024_tp3.Model.User;
import com.example.lab3_2024_tp3.Services.HelperClass.AppendingObjectOutputStream;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUserService {

    public static void saveUser(Context context, User user) {
        File archivo = new File(context.getFilesDir(), "user_data.dat");
        ObjectOutputStream oos;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
            fos.close();
        } catch (IOException e) {
            Log.e("FileService", "Error saving user data: " + e.getMessage());
        }
    }

    public static User read(Context context) {
        User user = null;
        File archivo = new File(context.getFilesDir(), "user_data.dat");
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            user = (User) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            Log.e("FileService", "Error reading user data: " + e.getMessage());
        }
        return user;
    }

    public static User login(Context context, String inputMail, String inputPassword) {
        User user = read(context);
        if (user != null && inputMail.equals(user.getMail()) && inputPassword.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
