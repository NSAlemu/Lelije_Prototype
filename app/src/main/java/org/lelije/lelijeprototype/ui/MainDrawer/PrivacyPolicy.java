package org.lelije.lelijeprototype.ui.MainDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityAccountSettingsBinding;
import org.lelije.lelijeprototype.databinding.ActivityPrivacyPolicyBinding;

public class PrivacyPolicy extends AppCompatActivity {
    private ActivityPrivacyPolicyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrivacyPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityPrivacyPolicyToolbar.cardBasicToolbarTitle.setText("Privacy Policy");
        binding.activityPrivacyPolicyToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityPrivacyPolicyToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
    }
}