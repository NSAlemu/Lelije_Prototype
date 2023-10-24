package org.lelije.lelijeprototype.ui.OTR;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityMainBinding;
import org.lelije.lelijeprototype.databinding.ActivityRequestOtrBinding;

public class  RequestOTR extends AppCompatActivity {
    private ActivityRequestOtrBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRequestOtrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}