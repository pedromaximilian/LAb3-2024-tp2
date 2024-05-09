package com.example.lab3_2024_tp3.UI.Register;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab3_2024_tp3.Model.User;
import com.example.lab3_2024_tp3.R;
import com.example.lab3_2024_tp3.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
        User user = (User) getIntent().getSerializableExtra("user");


        if (user != null) {
            vm.getMUser().observe(this, new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    binding.etRegistroDni.setText(user.getDni()+"");
                    binding.etRegistroLastName.setText((user.getLastname()));
                    binding.etRegistroName.setText(user.getName());
                    binding.etRegistroMail.setText(user.getMail());
                    binding.etRegistroPassword.setText(user.getPassword());
                }
            });
            vm.readUser();
        }

        binding.btnRegistroSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(
                        Long.parseLong(binding.etRegistroDni.getText().toString()),
                        binding.etRegistroLastName.getText().toString(),
                        binding.etRegistroName.getText().toString(),
                        binding.etRegistroMail.getText().toString(),
                        binding.etRegistroPassword.getText().toString());
                vm.setUser(user);
            }
        });

    }
}