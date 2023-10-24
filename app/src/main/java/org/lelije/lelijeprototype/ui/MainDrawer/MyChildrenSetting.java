package org.lelije.lelijeprototype.ui.MainDrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityMyChildrenSettingBinding;
import org.lelije.lelijeprototype.ui.Users.ChildPage;

public class MyChildrenSetting extends AppCompatActivity {
    private ActivityMyChildrenSettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyChildrenSettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setupViews();
    }

    private void setupViews() {
        binding.activityMyChildrenSettingToolbar.cardBasicToolbarTitle.setText("My Children");
        binding.activityMyChildrenSettingToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityMyChildrenSettingToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityMyChildrenSettingAddButton.itemButtonWideBtn.setText("Add Child");
        setupChildrenList();
    }

    private void setupChildrenList() {
        binding.activityMyChildrenSettingChild1.cardChildProfileMediumAge.setText("15");
        binding.activityMyChildrenSettingChild1.cardChildProfileMediumName.setText("Elias Mohammed");
        binding.activityMyChildrenSettingChild1.cardChildProfileMediumSchool.setText("Ethio-Parents School");
        binding.activityMyChildrenSettingChild1.cardChildProfileMediumNoImageCard.setVisibility(View.GONE);
        binding.activityMyChildrenSettingChild1.cardChildProfileMediumImage.setVisibility(View.VISIBLE);
        binding.activityMyChildrenSettingChild1.cardChildProfileMediumImage
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image_temp_child_1));
        binding.activityMyChildrenSettingChild1.getRoot().setOnClickListener(v-> ChildOnClick());

        binding.activityMyChildrenSettingChild2.cardChildProfileMediumAge.setText("12");
        binding.activityMyChildrenSettingChild2.cardChildProfileMediumName.setText("Adil Mohammed");
        binding.activityMyChildrenSettingChild2.cardChildProfileMediumSchool.setText("Ethio-Parents School");
        binding.activityMyChildrenSettingChild2.cardChildProfileMediumNoImageCard.setVisibility(View.VISIBLE);
        binding.activityMyChildrenSettingChild2.cardChildProfileMediumImage.setVisibility(View.GONE);
        binding.activityMyChildrenSettingChild2.getRoot().setOnClickListener(v-> ChildOnClick());

        binding.activityMyChildrenSettingChild3.cardChildProfileMediumAge.setText("9");
        binding.activityMyChildrenSettingChild3.cardChildProfileMediumName.setText("Eman Mohammed");
        binding.activityMyChildrenSettingChild3.cardChildProfileMediumSchool.setText("Ethio-Parents School");
        binding.activityMyChildrenSettingChild3.cardChildProfileMediumNoImageCard.setVisibility(View.GONE);
        binding.activityMyChildrenSettingChild3.cardChildProfileMediumImage.setVisibility(View.VISIBLE);
        binding.activityMyChildrenSettingChild3.cardChildProfileMediumImage
                .setImageDrawable(ContextCompat.getDrawable(this, R.drawable.image_temp_child_2));
        binding.activityMyChildrenSettingChild3.getRoot().setOnClickListener(v-> ChildOnClick());

    }

    public void ChildOnClick() {
        startActivity(new Intent(this, ChildPage.class));
    }
}