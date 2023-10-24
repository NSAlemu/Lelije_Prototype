package org.lelije.lelijeprototype.ui.Preferences;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.lelije.lelijeprototype.databinding.ActivityLanguagePreferencesBinding;

public class LanguagePreferences extends AppCompatActivity {

    private ActivityLanguagePreferencesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguagePreferencesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityLanguagePreferencesToolbar.cardBasicToolbarTitle.setText("Language Settings");
        binding.activityLanguagePreferencesToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityLanguagePreferencesToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityLanguagePreferencesPrefEnglish.setChecked(true);
        binding.activityLanguagePreferencesSaveButton.itemButtonWideBtn.setText("Save");
    }
}