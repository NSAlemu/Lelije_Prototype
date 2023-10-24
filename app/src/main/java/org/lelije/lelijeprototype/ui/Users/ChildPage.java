package org.lelije.lelijeprototype.ui.Users;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.ActivityChildPageBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ChildPage extends AppCompatActivity {
    private ActivityChildPageBinding binding;
    final Calendar birthdayCal = Calendar.getInstance();
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChildPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityChildPageToolbar.cardBasicToolbarTitle.setText("My Child");
        binding.activityChildPageSaveButton.itemButtonWideBtn.setText("Save");
        binding.activityChildPageIdButton.itemButtonWideOutlineBtn.setText("View ID");
        binding.activityChildPageIdButton.itemButtonWideOutlineCard.setCardBackgroundColor(ContextCompat.getColor(this,R.color.base_background));

        binding.activityChildPageToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityChildPageToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityChildPageFirstName.itemSimpleEdittext.setHint("First Name");
        binding.activityChildPageMiddleName.itemSimpleEdittext.setHint("Middle Name");
        binding.activityChildPageLastName.itemSimpleEdittext.setHint("Last Name");
        binding.activityChildPageSchool.itemSimpleEdittext.setHint("School");

        binding.activityChildPageFirstName.itemSimpleEdittextEt.setText("Eman");
        binding.activityChildPageMiddleName.itemSimpleEdittextEt.setText("Mohammed");
        binding.activityChildPageLastName.itemSimpleEdittextEt.setText("Osman");
        binding.activityChildPageSchool.itemSimpleEdittextEt.setText("Ethio-Parents School");
        binding.activityChildPageBirthdayEt.setText("Mar 13, 2014");

        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            birthdayCal.set(Calendar.YEAR, year);
            birthdayCal.set(Calendar.MONTH,month);
            birthdayCal.set(Calendar.DAY_OF_MONTH,day);
            updateLabel();
        };
        binding.activityChildPageBirthdayEt.setOnClickListener(view -> {
            new DatePickerDialog(this,date, birthdayCal.get(Calendar.YEAR), birthdayCal.get(Calendar.MONTH), birthdayCal.get(Calendar.DAY_OF_MONTH)).show();
        });
        binding.activityChildPageIdButton.itemButtonWideOutlineBtn.setOnClickListener(this::showPopupWindow);
        binding.activityChildPageToolbar.cardBasicToolbarTitle.requestFocus();
    }

    public void showPopupWindow(final View view) {


        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_child_id, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        popupWindow = new PopupWindow(popupView, width, height, focusable);
//        popupWindow.setAnimationStyle(R.style.AnimationPopup);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //modify views
        Button cancel = popupView.findViewById(R.id.popup_child_id_close_button).findViewById(R.id.item_button_wide_outline_btn);
        Button download = popupView.findViewById(R.id.popup_child_id_download_button).findViewById(R.id.item_button_btn);
        cancel.setText("Close");
        cancel.setOnClickListener(v-> popupWindow.dismiss());

        download.setText("Download");
        download.setOnClickListener(v-> popupWindow.dismiss());

    }

    private void updateLabel(){
        String myFormat="MMM d, yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.activityChildPageBirthdayEt.setText(dateFormat.format(birthdayCal.getTime()));
    }
}