package org.lelije.lelijeprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.lelije.lelijeprototype.Adapters.CurrentRideListAdapter;
import org.lelije.lelijeprototype.Drawers.MainBottomSheet;
import org.lelije.lelijeprototype.Models.RideModel;
import org.lelije.lelijeprototype.SampleData.RideGenerator;
import org.lelije.lelijeprototype.databinding.ActivityMainBinding;
import org.lelije.lelijeprototype.ui.Schedule.CurrentRideEventDetails;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CurrentRideListAdapter.ItemClickListener {
    private ArrayList<RideModel> rideModels;
    private ActivityMainBinding binding;
    CurrentRideListAdapter adapter;
    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupBottomNavBar();
        setupViews();
        rideModels = new ArrayList<>();
        rideModels.add(RideGenerator.generateCurrentRide());
    }
    @OptIn(markerClass = com.google.android.material.badge.ExperimentalBadgeUtils.class)
    private void setupViews() {
        binding.activityMainToolbar.cardMainToolbarStartIcon.setOnClickListener(v->{
            MainBottomSheet bottomSheetDialog = new MainBottomSheet();

            bottomSheetDialog.show(getSupportFragmentManager(), "simple tag");
        });
        binding.activityMainToolbar.cardMainToolbarEndIcon.setOnClickListener(this::showPopupWindow);

        Animation anim = new AlphaAnimation(0.5f, 1.0f);
        anim.setDuration(700); //You can manage the blinking time with this parameter
        anim.setStartOffset(200);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        binding.activityMainToolbar.cardMainToolbarEndIcon.startAnimation(anim);
        binding.activityMainToolbar.cardMainToolbarEndIcon.post(() -> {
            BadgeDrawable badgeDrawable =  BadgeDrawable.create(MainActivity.this);
            badgeDrawable.setNumber(1);
            badgeDrawable.setBackgroundColor(getResources().getColor(R.color.green));
            badgeDrawable.setVerticalOffset(4);
            badgeDrawable.setHorizontalOffset(4);
            //Note that there is a third argument which is our FrameLayout
            BadgeUtils.attachBadgeDrawable(badgeDrawable, binding.activityMainToolbar.cardMainToolbarEndIcon);
        });

    }

    private void setupBottomNavBar(){

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
    public void showPopupWindow(final View view) {


        //Create a View object yourself through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_current_ride_status_none, null);

        //Specify the length and width through constants
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        //Make Inactive Items Outside Of PopupWindow
        boolean focusable = true;

        //Create a window with our parameters
        popupWindow = new PopupWindow(popupView, width, height, focusable);
//        popupWindow.setAnimationStyle(R.style.AnimationPopup);
        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        adapter = new CurrentRideListAdapter(this, rideModels);
        adapter.setClickListener(this);
        ((RecyclerView)popupView.findViewById(R.id.popup_current_ride_status_rv)).setAdapter(adapter);
        ((RecyclerView)popupView.findViewById(R.id.popup_current_ride_status_rv)).setLayoutManager(new LinearLayoutManager(this));
        //Handler for clicking on the inactive zone of the window
        ((Button)popupView.findViewById(R.id.item_button_wide_outline_btn)).setText("Cancel");
        popupView.findViewById(R.id.item_button_wide_outline_btn).setOnClickListener(v-> popupWindow.dismiss());
        popupView.setOnTouchListener((v, event) -> {
            //Close the window when clicked
            popupWindow.dismiss();
            return true;
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        startActivity(new Intent(this, CurrentRideEventDetails.class));
        if(popupWindow != null){
            popupWindow.dismiss();
        }
    }
}