package org.lelije.lelijeprototype.ui.Preferences;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.lelije.lelijeprototype.databinding.ActivityPaymentTransactionsBinding;

public class PaymentTransactions extends AppCompatActivity {

    private ActivityPaymentTransactionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentTransactionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupViews();
    }

    private void setupViews() {
        binding.activityPaymentTransactionsToolbar.cardBasicToolbarTitle.setText("Transactions History");
        binding.activityPaymentTransactionsToolbar.cardBasicToolbarEndIcon.setVisibility(View.INVISIBLE);
        binding.activityPaymentTransactionsToolbar.cardBasicToolbarStartIcon.setVisibility(View.INVISIBLE);
    }
}