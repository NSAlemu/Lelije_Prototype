package org.lelije.lelijeprototype.ui.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;

import androidx.appcompat.app.AppCompatActivity;

import org.lelije.lelijeprototype.MainActivity;
import org.lelije.lelijeprototype.databinding.ActivityRegisterUserBinding;

public class RegisterUser extends AppCompatActivity {

    private ActivityRegisterUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityRegisterUserRegButton.itemButtonWideBtn.setText("Sign up");
        binding.activityRegisterUserEmail.itemSimpleEdittext.setHint("Email");
        binding.activityRegisterUserConfirmPassword.itemSimpleEdittextEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        binding.activityRegisterUserPassword.itemSimpleEdittext.setHint("Password");
        binding.activityRegisterUserPassword.itemSimpleEdittextEt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        binding.activityRegisterUserConfirmPassword.itemSimpleEdittext.setHint("Confirm Password");
        binding.activityRegisterUserConfirmPassword.itemSimpleEdittextEt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        binding.activityRegisterUserPhone.itemSimpleEdittext.setHint("Phone Number");
        binding.activityRegisterUserPhone.itemSimpleEdittextEt.setInputType(InputType.TYPE_CLASS_PHONE);

        binding.activityRegisterUserRegButton.itemButtonWideBtn.setOnClickListener(v->{
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

    }
}