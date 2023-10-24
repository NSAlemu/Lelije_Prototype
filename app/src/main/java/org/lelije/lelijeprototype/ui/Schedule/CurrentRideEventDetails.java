package org.lelije.lelijeprototype.ui.Schedule;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityCurrentRideEventDetailsBinding;
import org.lelije.lelijeprototype.ui.Users.DriverPage;

public class CurrentRideEventDetails extends AppCompatActivity {
    private ActivityCurrentRideEventDetailsBinding binding;
    private boolean miniCollapsed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCurrentRideEventDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityCurrentRideEventDetailsManageButton.itemButtonWideOutlineBtn.setText(R.string.manage);
        binding.activityCurrentRideEventDetailsToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityCurrentRideEventDetailsToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityCurrentRideEventDetailsToolbarDriverCard.setOnClickListener(v -> {
            startActivity(new Intent(this, DriverPage.class));
        });
        binding.activityCurrentRideEventDetailsCollapser.setOnClickListener(v -> {
            if (miniCollapsed)
                expandMini();
            else
                collapseMini();
        });

    }

    private void collapseMini() {
        binding.activityCurrentRideEventDetailsMiniContainer.setVisibility(View.VISIBLE);
        binding.activityCurrentRideEventDetailsExpandedContainer.setVisibility(View.GONE);
        binding.activityCurrentRideEventDetailsRouteImage.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        binding.activityCurrentRideEventDetailsCollapserImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_lelije_double_chevron_up));
        binding.activityCurrentRideEventDetailsCollapserText.setText("Collapse");
        miniCollapsed = true;
    }

    private void expandMini() {
        binding.activityCurrentRideEventDetailsMiniContainer.setVisibility(View.GONE);
        binding.activityCurrentRideEventDetailsExpandedContainer.setVisibility(View.VISIBLE);
        binding.activityCurrentRideEventDetailsRouteImage.getLayoutParams().height = convertDpToPixel(150);
        binding.activityCurrentRideEventDetailsCollapserImage.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_lelije_double_chevron_down));
        binding.activityCurrentRideEventDetailsCollapserText.setText("Expand");
        miniCollapsed = false;
    }

    private int convertDpToPixel(float dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

}