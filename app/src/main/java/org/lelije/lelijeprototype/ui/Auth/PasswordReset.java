package org.lelije.lelijeprototype.ui.Auth;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.lelije.lelijeprototype.databinding.ActivityPasswordResetBinding;

public class PasswordReset extends AppCompatActivity {
    private ActivityPasswordResetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordResetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityPasswordResetButton.itemButtonWideBtn.setText("Send OTP");
        binding.activityPasswordResetEmail.itemSimpleEdittext.setHint("Email");

        binding.activityPasswordResetButton.itemButtonWideBtn.setOnClickListener(v->{
            Toast.makeText(this, "One Time Password Sent.", Toast.LENGTH_LONG).show();
        });

    }
}