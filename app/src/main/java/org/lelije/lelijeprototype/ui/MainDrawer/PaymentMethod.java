package org.lelije.lelijeprototype.ui.MainDrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.lelije.lelijeprototype.databinding.ActivityPaymentMethodBinding;
import org.lelije.lelijeprototype.ui.Preferences.PaymentTransactions;

public class PaymentMethod extends AppCompatActivity {
    private ActivityPaymentMethodBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activityPaymentMethodToolbar.cardBasicToolbarTitle.setText("Payment & Transactions");
        binding.activityPaymentMethodToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityPaymentMethodToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
        binding.activityPaymentMethodTransactionButton.itemButtonWideOutlineBtn.setText("View Transactions");
        binding.activityPaymentMethodTransactionButton.itemButtonWideOutlineBtn.setOnClickListener(v->{
            startActivity(new Intent(this, PaymentTransactions.class));
        });
        binding.activityPaymentMethodTransactionButton.itemButtonWideOutlineBtn.setTextSize(11);
        binding.activityPaymentMethodPayButton.itemButtonWideBtn.setText("Complete Payment");
    }
}