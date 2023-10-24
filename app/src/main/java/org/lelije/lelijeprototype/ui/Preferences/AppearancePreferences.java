package org.lelije.lelijeprototype.ui.Preferences;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.lelije.lelijeprototype.databinding.ActivityAppreancePreferencesBinding;

public class AppearancePreferences extends AppCompatActivity {


    private ActivityAppreancePreferencesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppreancePreferencesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityAppearancePreferencesToolbar.cardBasicToolbarTitle.setText("Appearance Settings");
        binding.activityAppearancePreferencesToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityAppearancePreferencesToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityAppearancePreferencesSysDark.setOnCheckedChangeListener((compoundButton, sysChecked) -> {
            if (sysChecked) {
                binding.activityAppearancePreferencesCustDark.setEnabled(false);
            } else{
                binding.activityAppearancePreferencesCustDark.setEnabled(true);
            }

        });
    }
}