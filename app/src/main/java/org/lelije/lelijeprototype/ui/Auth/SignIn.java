package org.lelije.lelijeprototype.ui.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;

import androidx.appcompat.app.AppCompatActivity;

import org.lelije.lelijeprototype.MainActivity;
import org.lelije.lelijeprototype.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activitySignInLogin.itemButtonWideBtn.setText("Login");
        binding.activitySignInRegister.itemButtonWideOutlineBtn.setText("Sign up");
        binding.activitySignInEmail.itemSimpleEdittext.setHint("Email");
        binding.activitySignInEmail.itemSimpleEdittextEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        binding.activitySignInPassword.itemSimpleEdittext.setHint("Password");
        binding.activitySignInPassword.itemSimpleEdittextEt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        binding.activitySignInLogin.itemButtonWideBtn.setOnClickListener(v->{
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        binding.activitySignInRegister.itemButtonWideOutlineBtn.setOnClickListener(v->{
            startActivity(new Intent(this, RegisterUser.class));
        });

        binding.activitySignInForgotPassword.setOnClickListener(v->{
            startActivity(new Intent(this, PasswordReset.class));
        });
    }
}