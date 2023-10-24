package org.lelije.lelijeprototype.ui.Schedule;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.lelije.lelijeprototype.Models.DriverModel;
import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.SampleData.DriverGenerator;
import org.lelije.lelijeprototype.databinding.ActivityCreateScheduleSelectDriverBinding;

import java.util.ArrayList;
import java.util.List;

public class CreateScheduleSelectDriver extends AppCompatActivity {
    private ActivityCreateScheduleSelectDriverBinding binding;
    private ArrayAdapter<String> adapter;
    List<String> driverList = new ArrayList<>();
    String pickupLoc = "", dropoffLoc = "",locationSearchString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateScheduleSelectDriverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pickupLoc = extras.getString("pickup_location");
            dropoffLoc = extras.getString("dropoff_location");
        }
        setupViews();
    }

    private void setupViews() {
        binding.activityCreateScheduleDriverPickup.setHint("       Pickup Location");
        binding.activityCreateScheduleDriverDropoff.setHint("       Dropoff Location");
        binding.activityCreateScheduleDriverPickupEt.setText(pickupLoc);
        binding.activityCreateScheduleDriverDropoffEt.setText(dropoffLoc);
        binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIcon.setHint("       Select Driver");
        binding.activityCreateScheduleDriverToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDriverToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDriverToolbar.cardBasicToolbarTitle.setText("Select Driver");
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_lelije_steering_wheel);
        binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIcon.setStartIconDrawable(icon);
        binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIcon
                .setStartIconTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.black_2)));


        binding.activityCreateScheduleDriversTv.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIconEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIconEt.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.activityCreateScheduleDriversTv.setVisibility(View.INVISIBLE);
                binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIconEt.clearFocus();
                locationSearchString = textView.getText().toString();
                ArrayList<DriverModel> drivers = DriverGenerator.generateDriver(7);
                driverList.clear();
                for(DriverModel driver: drivers){
                    driverList.add(driver.getFirstName()+" "+driver.getMiddleName()+ " "+driver.getLastName());
                }
                adapter.notifyDataSetChanged();
                binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIconEt.clearFocus();
                binding.activityCreateScheduleDriversTv.setVisibility(View.VISIBLE);
            }
            return false;
        });
        adapter = new ArrayAdapter<String>(this, R.layout.card_simple_list_item, R.id.card_simple_list_item_textview, driverList);
        binding.activityCreateScheduleDriverList.setOnItemClickListener((adapterView, view, i, l) -> {
            String value = adapter.getItem(i);
            Intent intent = new Intent(CreateScheduleSelectDriver.this, CreateScheduleAddChildren.class);
            intent.putExtra("pickup_location", pickupLoc);
            intent.putExtra("dropoff_location", dropoffLoc);
            intent.putExtra("driver_name", value);
            startActivity(intent);
        });

        binding.activityCreateScheduleDriverList.setAdapter(adapter);
        binding.activityCreateScheduleDriver.itemSimpleEdittextWithStartIconEt.requestFocus();
    }
}