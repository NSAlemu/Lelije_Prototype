package org.lelije.lelijeprototype.ui.Schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityRideEventDetailsBinding;
import org.lelije.lelijeprototype.ui.Users.DriverPage;

public class RideEventDetails extends AppCompatActivity {
    private ActivityRideEventDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRideEventDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityRideEventDetailsManageButton.itemButtonWideOutlineBtn.setText(R.string.manage);
        binding.activityRideEventDetailsToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityRideEventDetailsToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityRideEventDetailsToolbarDriverCard.setOnClickListener(v->{
            startActivity(new Intent(this, DriverPage.class));
        });
    }


}