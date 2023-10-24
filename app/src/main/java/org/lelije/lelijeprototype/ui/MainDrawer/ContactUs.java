package org.lelije.lelijeprototype.ui.MainDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityAccountSettingsBinding;
import org.lelije.lelijeprototype.databinding.ActivityContactUsBinding;

public class ContactUs extends AppCompatActivity {
    private ActivityContactUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupViews();
    }

    private void setupViews() {
        binding.activityContactUsToolbar.cardBasicToolbarTitle.setText("Contact Us");
        binding.activityContactUsToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityContactUsToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);

        binding.activityContactUsPhone1.setOnClickListener(v->{
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:6525"));
            startActivity(callIntent);
        });
        binding.activityContactUsPhone2.setOnClickListener(v->{
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+251917171717"));
            startActivity(callIntent);
        });
        binding.activityContactUsFacebookCard.setOnClickListener(v->{
            Uri uri = Uri.parse("http://www.facebook.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        binding.activityContactUsInstagramCard.setOnClickListener(v->{
            Uri uri = Uri.parse("http://www.instagram.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        binding.activityContactUsXCard.setOnClickListener(v->{
            Uri uri = Uri.parse("http://www.X.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        binding.activityContactUsYoutubeCard.setOnClickListener(v->{
            Uri uri = Uri.parse("http://www.youtube.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}