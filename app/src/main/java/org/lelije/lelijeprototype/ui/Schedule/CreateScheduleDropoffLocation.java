package org.lelije.lelijeprototype.ui.Schedule;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.lelije.lelijeprototype.Models.TempLocation;
import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityCreateScheduleDropoffLocationBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CreateScheduleDropoffLocation extends AppCompatActivity {

    private ActivityCreateScheduleDropoffLocationBinding binding;
    private ArrayAdapter<String> adapter;
    List<String> geoResults = new ArrayList<>();
    String locationSearchString = "";
    String pickupLoc = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateScheduleDropoffLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pickupLoc = extras.getString("pickup_location");
            //The key argument here must match that used in the other activity
        }
        setupViews();
    }

    private void setupViews() {
        binding.activityCreateScheduleDropoffLocationPickup.setHint("       Pickup Location");
        binding.activityCreateScheduleDropoffLocationPickupEt.setText(pickupLoc);
        binding.activityCreateScheduleDropoffLocation.itemSimpleEdittextWithStartIcon.setHint("       Dropoff Location");
        binding.activityCreateScheduleDropoffLocationToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDropoffLocationToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDropoffLocationToolbar.cardBasicToolbarTitle.setText("       Dropoff Location");
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_lelije_location_shadow);
        binding.activityCreateScheduleDropoffLocation.itemSimpleEdittextWithStartIcon.setStartIconDrawable(icon);
        binding.activityCreateScheduleDropoffLocation.itemSimpleEdittextWithStartIcon
                .setStartIconTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.orange)));

        binding.activityCreateScheduleDropoffLocationsTv.setVisibility(View.INVISIBLE);
        binding.activityCreateScheduleDropoffLocation.itemSimpleEdittextWithStartIconEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        binding.activityCreateScheduleDropoffLocation.itemSimpleEdittextWithStartIconEt.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.activityCreateScheduleDropoffLocationsTv.setVisibility(View.INVISIBLE);
                locationSearchString = textView.getText().toString();
                new CreateScheduleDropoffLocation.MyJSONTask().execute();
                binding.activityCreateScheduleDropoffLocation.itemSimpleEdittextWithStartIconEt.clearFocus();
            }
            return false;
        });
        adapter = new ArrayAdapter<String>(this, R.layout.card_simple_list_item, R.id.card_simple_list_item_textview, geoResults);
        binding.activityCreateScheduleDropoffLocationList.setOnItemClickListener((adapterView, view, i, l) -> {
            String value = adapter.getItem(i);
            Intent intent = new Intent(CreateScheduleDropoffLocation.this, CreateScheduleSelectDriver.class);
            intent.putExtra("pickup_location", pickupLoc);
            intent.putExtra("dropoff_location", value);
            startActivity(intent);
        });

        binding.activityCreateScheduleDropoffLocationList.setAdapter(adapter);
        binding.activityCreateScheduleDropoffLocation.itemSimpleEdittextWithStartIconEt.requestFocus();

    }

    public class MyJSONTask extends AsyncTask<Void, Void, String> {
        //Web URL of the JSON file
        String jsonURL = "https://nominatim.openstreetmap.org/search?q=" + locationSearchString + "&format=json&countrycodes=et";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        /*if (mLoading != null)
        {
            mLoading.setVisibility(View.VISIBLE);
        }*/
        }

        @Override
        protected String doInBackground(Void... voids) {
            HttpURLConnection urlConnection = null;
            BufferedReader bufferedReader = null;

            try {
                //---Loading JSON from the Web URL---//
                URL url = new URL(jsonURL);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();


                InputStream inputStream = urlConnection.getInputStream();

                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line).append("\n");
                }
                if (stringBuffer.length() == 0) {
                    return null;
                } else {
                    return stringBuffer.toString();
                }
            } catch (IOException e) {
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        protected void onPostExecute(String jsonStr) {
            super.onPostExecute(jsonStr);

            if (jsonStr != null) {
                //---Parsing JSON---//
                ArrayList<TempLocation> employeesList = new ArrayList<>();
                try {
                    JSONArray rootJsonArray = new JSONArray(jsonStr);


                    geoResults.clear();
                    for (int i = 0; i < rootJsonArray.length(); i++) {
                        //Create a temp employee object
                        TempLocation tempLocation = new TempLocation();

                        String locName = rootJsonArray.getJSONObject(i).getString("display_name");
                        geoResults.add(locName);

                        //Get employee details
                        System.out.println("MYYYloccc*******************                \n" + locName);

                        //add to list
                        employeesList.add(tempLocation);
                    }
                    if (geoResults.isEmpty()) {
                        geoResults.add("Location not found");
                    }
                    binding.activityCreateScheduleDropoffLocationsTv.setVisibility(View.VISIBLE);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        /*if (mLoading != null)
        {
            mLoading.setVisibility(View.GONE);
        }*/
        }
    }
}