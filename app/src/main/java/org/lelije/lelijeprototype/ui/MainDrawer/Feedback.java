package org.lelije.lelijeprototype.ui.MainDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityAccountSettingsBinding;
import org.lelije.lelijeprototype.databinding.ActivityFeedbackBinding;

public class Feedback extends AppCompatActivity {
    private ActivityFeedbackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedbackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityFeedbackToolbar.cardBasicToolbarTitle.setText("Feedback");
        binding.activityFeedbackToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityFeedbackToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
    }
}