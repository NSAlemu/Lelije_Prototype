package org.lelije.lelijeprototype.ui.Users;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityDriverPageBinding;

public class DriverPage extends AppCompatActivity {
    private ActivityDriverPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDriverPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityDriverPageMessageButton.itemButtonWideOutlineBtn.setText(R.string.message);
        binding.activityDriverPageToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityDriverPageToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        setupCallButton();
        setupMessageButton();
    }

    private void setupCallButton() {
        binding.activityDriverPageCallButton.itemButtonWideOutlineBtn.setText(R.string.call);
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_lelije_call);
        ((MaterialButton) binding.activityDriverPageCallButton.itemButtonWideOutlineBtn).setIcon(icon);
        ((MaterialButton) binding.activityDriverPageCallButton.itemButtonWideOutlineBtn).setIconSize(30);
        ((MaterialButton) binding.activityDriverPageCallButton.itemButtonWideOutlineBtn).setIconTintResource(R.color.black_0);
    }

    private void setupMessageButton() {
        binding.activityDriverPageMessageButton.itemButtonWideOutlineBtn.setText(R.string.message);
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_lelije_message_simple);
        ((MaterialButton) binding.activityDriverPageMessageButton.itemButtonWideOutlineBtn).setIcon(icon);
        ((MaterialButton) binding.activityDriverPageMessageButton.itemButtonWideOutlineBtn).setIconSize(30);
        ((MaterialButton) binding.activityDriverPageMessageButton.itemButtonWideOutlineBtn).setIconTintResource(R.color.black_0);
    }
}