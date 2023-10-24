package org.lelije.lelijeprototype.ui.Schedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityCreateScheduleAddChildrenBinding;

public class CreateScheduleAddChildren extends AppCompatActivity {

    private ActivityCreateScheduleAddChildrenBinding binding;
    String pickupLoc = "", dropoffLoc = "", driverName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateScheduleAddChildrenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pickupLoc = extras.getString("pickup_location");
            dropoffLoc = extras.getString("dropoff_location");
            driverName = extras.getString("driver_name");
        }
        setupViews();
    }

    private void setupViews() {
        binding.activityCreateScheduleChildrenToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleChildrenToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleChildrenToolbar.cardBasicToolbarTitle.setText("Select Children");
        binding.activityCreateScheduleChildrenAddButton.itemButtonBtn.setText("Add Selected");
        binding.activityCreateScheduleChildrenAddButton.itemButtonBtn.setOnClickListener(v->{
            Intent intent = new Intent(CreateScheduleAddChildren.this, CreateScheduleDates.class);
            intent.putExtra("pickup_location", pickupLoc);
            intent.putExtra("dropoff_location", dropoffLoc);
            intent.putExtra("driver_name", driverName);
            startActivity(intent);
        });
        setupChildrenList();
    }

    private void setupChildrenList() {
        binding.activityCreateScheduleChildrenCard1.cardChildProfileMediumName.setText("Elias Mohammed");
        binding.activityCreateScheduleChildrenCard1.cardChildProfileMediumNoImageCard.setVisibility(View.GONE);
        binding.activityCreateScheduleChildrenCard1.cardChildProfileMediumImage.setVisibility(View.VISIBLE);
        binding.activityCreateScheduleChildrenCard1.cardChildProfileMediumImage
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image_temp_child_1));

        binding.activityCreateScheduleChildrenCard2.cardChildProfileMediumName.setText("Adil Mohammed");
        binding.activityCreateScheduleChildrenCard2.cardChildProfileMediumNoImageCard.setVisibility(View.VISIBLE);
        binding.activityCreateScheduleChildrenCard2.cardChildProfileMediumImage.setVisibility(View.GONE);

        binding.activityCreateScheduleChildrenCard3.cardChildProfileMediumName.setText("Eman Mohammed");
        binding.activityCreateScheduleChildrenCard3.cardChildProfileMediumNoImageCard.setVisibility(View.GONE);
        binding.activityCreateScheduleChildrenCard3.cardChildProfileMediumImage.setVisibility(View.VISIBLE);
        binding.activityCreateScheduleChildrenCard3.cardChildProfileMediumImage
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image_temp_child_2));

    }
}