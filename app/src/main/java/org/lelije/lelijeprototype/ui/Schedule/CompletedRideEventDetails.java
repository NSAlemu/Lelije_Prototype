package org.lelije.lelijeprototype.ui.Schedule;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityCompletedRideEventDetailsBinding;
import org.lelije.lelijeprototype.ui.Users.DriverPage;

public class CompletedRideEventDetails extends AppCompatActivity {
    private ActivityCompletedRideEventDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompletedRideEventDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        setupReportButton();
        setupRateButton();
        binding.activityCompletedRideEventDetailsToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityCompletedRideEventDetailsToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityCompletedRideEventDetailsToolbarDriverCard.setOnClickListener(v->{
            startActivity(new Intent(this, DriverPage.class));
        });
    }

    private void setupReportButton() {
        binding.activityCompletedRideEventDetailsReportButton.itemButtonWideOutlineBtn.setText(R.string.report);
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_lelije_flag);
        ((MaterialButton) binding.activityCompletedRideEventDetailsReportButton.itemButtonWideOutlineBtn).setIcon(icon);
        ((MaterialButton) binding.activityCompletedRideEventDetailsReportButton.itemButtonWideOutlineBtn).setIconTintResource(R.color.danger_red);
    }

    private void setupRateButton() {
        binding.activityCompletedRideEventDetailsRateButton.itemButtonWideOutlineBtn.setText(R.string.rate);
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_lelije_star);
        ((MaterialButton) binding.activityCompletedRideEventDetailsRateButton.itemButtonWideOutlineBtn).setIcon(icon);
        ((MaterialButton) binding.activityCompletedRideEventDetailsRateButton.itemButtonWideOutlineBtn).setIconTintResource(R.color.black);
    }

}