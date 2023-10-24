package org.lelije.lelijeprototype.ui.MainDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityAccountSettingsBinding;
import org.lelije.lelijeprototype.databinding.ActivityTermsOfServiceBinding;

public class TermsOfService extends AppCompatActivity {
    private ActivityTermsOfServiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsOfServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityTermsOfServiceToolbar.cardBasicToolbarTitle.setText("Terms of Service");
        binding.activityTermsOfServiceToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityTermsOfServiceToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
    }
}