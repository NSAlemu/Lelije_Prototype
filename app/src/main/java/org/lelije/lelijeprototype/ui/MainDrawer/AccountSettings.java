package org.lelije.lelijeprototype.ui.MainDrawer;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityAccountSettingsBinding;

public class AccountSettings extends AppCompatActivity {
    private ActivityAccountSettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountSettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityAccountSettingToolbar.cardBasicToolbarTitle.setText("Account Settings");
        binding.activityAccountSettingSaveButton.itemButtonWideBtn.setText("Save");
        binding.activityAccountSettingToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityAccountSettingToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);

        binding.activityAccountSettingToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityAccountSettingToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityAccountSettingFullName.itemSimpleEdittext.setHint("Full Name");
        binding.activityAccountSettingEmail.itemSimpleEdittext.setHint("Email");
        binding.activityAccountSettingPhoneNumber.itemSimpleEdittext.setHint("Phone number");

        binding.activityAccountSettingFullName.itemSimpleEdittextEt.setText("Mohammed Osman");
        binding.activityAccountSettingEmail.itemSimpleEdittextEt.setText("mohammed.osman@gmail.com");
        binding.activityAccountSettingPhoneNumber.itemSimpleEdittextEt.setText("+251 935 32 45 25");

        binding.activityAccountSettingEmail.itemSimpleEdittextEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        binding.activityAccountSettingPhoneNumber.itemSimpleEdittextEt.setInputType(InputType.TYPE_CLASS_PHONE);

        Drawable icon2 = ContextCompat.getDrawable(this, R.drawable.ic_lelije_verify_badge);
        binding.activityAccountSettingPhoneNumber.itemSimpleEdittext.setEndIconActivated(true);
        binding.activityAccountSettingPhoneNumber.itemSimpleEdittext.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
        binding.activityAccountSettingPhoneNumber.itemSimpleEdittext.setEndIconDrawable(icon2);
        binding.activityAccountSettingPhoneNumber.itemSimpleEdittext
                .setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.verify_green)));

        Drawable icon = ContextCompat.getDrawable(this, R.drawable.ic_lelije_warning);
        binding.activityAccountSettingEmail.itemSimpleEdittext.setEndIconActivated(true);
        binding.activityAccountSettingEmail.itemSimpleEdittext.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
        binding.activityAccountSettingEmail.itemSimpleEdittext.setEndIconDrawable(icon);
        binding.activityAccountSettingEmail.itemSimpleEdittext
                .setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(this,R.color.warning_orange)));

    }

}