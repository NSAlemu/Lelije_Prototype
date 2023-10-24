package org.lelije.lelijeprototype.ui.MainDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityAccountSettingsBinding;
import org.lelije.lelijeprototype.databinding.ActivityFaqBinding;

public class FAQ extends AppCompatActivity {
    private ActivityFaqBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFaqBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityFaqToolbar.cardBasicToolbarTitle.setText("FAQ");
        binding.activityFaqToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityFaqToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
    }
}