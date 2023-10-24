package org.lelije.lelijeprototype.ui.MainDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityAccountSettingsBinding;
import org.lelije.lelijeprototype.databinding.ActivityHelpCenterBinding;

public class HelpCenter extends AppCompatActivity {
    private ActivityHelpCenterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHelpCenterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityHelpCenterToolbar.cardBasicToolbarTitle.setText("Help Center");
        binding.activityHelpCenterToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityHelpCenterToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
    }
}