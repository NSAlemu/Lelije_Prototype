package org.lelije.lelijeprototype.ui.Schedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import org.lelije.lelijeprototype.databinding.ActivityCreateScheduleDatesBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateScheduleDates extends AppCompatActivity {

    private ActivityCreateScheduleDatesBinding binding;
    String pickupLoc = "", dropoffLoc = "", driverName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateScheduleDatesBinding.inflate(getLayoutInflater());
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
        binding.activityCreateScheduleDatesToolbar.cardBasicToolbarTitle.setText("Select Dates");
        binding.activityCreateScheduleDatesToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDatesToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDatesReviewButton.itemButtonBtn.setText("Review Schedule");
        binding.activityCreateScheduleDatesReviewButton.itemButtonBtn.setOnClickListener(v->{
            Intent intent = new Intent(CreateScheduleDates.this, CreateScheduleReview.class);
            intent.putExtra("pickup_location", pickupLoc);
            intent.putExtra("dropoff_location", dropoffLoc);
            intent.putExtra("driver_name", driverName);
            startActivity(intent);
        });

        binding.activityCreateScheduleDatesStartDateEt.setOnClickListener(v->{
            MaterialDatePicker<Long> datePicker =
                    MaterialDatePicker.Builder.datePicker()
                            .setTitleText("Select Start date")
                            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                            .build();
            datePicker.addOnPositiveButtonClickListener(view -> {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d, yyyy", Locale.US);

                if(datePicker.getSelection()!=null){
                    Date date = new Date(datePicker.getSelection());
                    binding.activityCreateScheduleDatesStartDateEt.setText(sdf.format(date));
                }

            });
            datePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
        });
        binding.activityCreateScheduleDatesEndDateEt.setOnClickListener(v->{
            MaterialDatePicker<Long> datePicker =
                    MaterialDatePicker.Builder.datePicker()
                            .setTitleText("Select End date")
                            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                            .build();
            datePicker.addOnPositiveButtonClickListener(view -> {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d, yyyy", Locale.US);

                if(datePicker.getSelection()!=null){
                    Date date = new Date(datePicker.getSelection());
                    binding.activityCreateScheduleDatesEndDateEt.setText(sdf.format(date));
                }

            });
            datePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
        });
        binding.activityCreateScheduleDatesStartTimeEt.setOnClickListener(v->{
            MaterialTimePicker timePicker =
                    new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(10)
                            .setTitleText("Select Morning Pickup time")
                            .build();
            timePicker.addOnPositiveButtonClickListener(view -> {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
                binding.activityCreateScheduleDatesStartTimeEt.setText(sdf.format(calendar.getTime()));
            });
            timePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
        });
        binding.activityCreateScheduleDatesEndTimeEt.setOnClickListener(v->{
            MaterialTimePicker timePicker =
                   new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(10)
                            .setTitleText("Select After school pickup time")
                            .build();

            timePicker.addOnPositiveButtonClickListener(view -> {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
                binding.activityCreateScheduleDatesEndTimeEt.setText(sdf.format(calendar.getTime()));
            });
            timePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
        });

    }

}