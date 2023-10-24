package org.lelije.lelijeprototype.ui.MainDrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivitySettingPageBinding;
import org.lelije.lelijeprototype.ui.Preferences.AppearancePreferences;
import org.lelije.lelijeprototype.ui.Preferences.LanguagePreferences;

public class SettingPage extends AppCompatActivity {
    private ActivitySettingPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activitySettingsPageToolbar.cardBasicToolbarTitle.setText("Settings & Preferences");
        binding.activitySettingsPageToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activitySettingsPageToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);

        binding.activitySettingsPageAppearance.cardListIconItemText.setText("Appearance");
        binding.activitySettingsPageAppearance.cardListIconItemIcon
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_lelije_dark_mode));
        binding.activitySettingsPageAppearance.getRoot().setOnClickListener(v->{
            startActivity(new Intent(this, AppearancePreferences.class));
        });

        binding.activitySettingsPageLanguage.cardListIconItemText.setText("Language");
        binding.activitySettingsPageLanguage.cardListIconItemIcon
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_lelije_language));
        binding.activitySettingsPageLanguage.getRoot().setOnClickListener(v->{
            startActivity(new Intent(this, LanguagePreferences.class));
        });

        binding.activitySettingsPageNotifications.cardListIconItemText.setText("Notifications");
        binding.activitySettingsPageNotifications.cardListIconItemIcon
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_lelije_bell));

        binding.activitySettingsPageSchoolApi.cardListIconItemText.setText("Connect to School");
        binding.activitySettingsPageSchoolApi.cardListIconItemIcon
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_lelije_school));

        binding.activitySettingsPageBusServiceApi.cardListIconItemText.setText("Connect with Bus Service Account");
        binding.activitySettingsPageBusServiceApi.cardListIconItemIcon
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_lelije_bus));
    }
}