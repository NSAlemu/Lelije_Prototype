package org.lelije.lelijeprototype.ui.Schedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.lelije.lelijeprototype.MainActivity;
import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityCreateScheduleReviewBinding;

public class CreateScheduleReview extends AppCompatActivity {

    private ActivityCreateScheduleReviewBinding binding;
    String pickupLoc = "", dropoffLoc = "", driverName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateScheduleReviewBinding.inflate(getLayoutInflater());
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
        binding.activityCreateScheduleReviewToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleReviewToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleReviewToolbar.cardBasicToolbarTitle.setText("Review Schedule");
        binding.activityCreateScheduleReviewButton.itemButtonWideBtn.setText("Create Schedule");

        binding.activityCreateScheduleReviewPickup.setHint("        Pickup Location");
        binding.activityCreateScheduleReviewPickupEt.setText(pickupLoc);
        binding.activityCreateScheduleReviewDropoff.setHint("       Dropoff Location");
        binding.activityCreateScheduleReviewDropoffEt.setText(dropoffLoc);
        binding.activityCreateScheduleReviewDriver.setHint("        Driver");
        binding.activityCreateScheduleReviewDriverEt.setText(driverName);

        binding.activityCreateScheduleReviewButton.itemButtonWideBtn.setOnClickListener(v->{
            Toast.makeText(CreateScheduleReview.this, "Schedule Created", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CreateScheduleReview.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
        setupChildrenList();
    }


    private void setupChildrenList() {
        binding.activityCreateScheduleReviewChild1.cardChildProfileMediumName.setText("Elias Mohammed");
        binding.activityCreateScheduleReviewChild1.cardChildProfileMediumNoImageCard.setVisibility(View.GONE);
        binding.activityCreateScheduleReviewChild1.cardChildProfileMediumImage.setVisibility(View.VISIBLE);
        binding.activityCreateScheduleReviewChild1.cardChildProfileMediumImage
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image_temp_child_1));

        binding.activityCreateScheduleReviewChild2.cardChildProfileMediumName.setText("Adil Mohammed");
        binding.activityCreateScheduleReviewChild2.cardChildProfileMediumNoImageCard.setVisibility(View.VISIBLE);
        binding.activityCreateScheduleReviewChild2.cardChildProfileMediumImage.setVisibility(View.GONE);

        binding.activityCreateScheduleReviewChild3.cardChildProfileMediumName.setText("Eman Mohammed");
        binding.activityCreateScheduleReviewChild3.cardChildProfileMediumNoImageCard.setVisibility(View.GONE);
        binding.activityCreateScheduleReviewChild3.cardChildProfileMediumImage.setVisibility(View.VISIBLE);
        binding.activityCreateScheduleReviewChild3.cardChildProfileMediumImage
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image_temp_child_2));

    }
}