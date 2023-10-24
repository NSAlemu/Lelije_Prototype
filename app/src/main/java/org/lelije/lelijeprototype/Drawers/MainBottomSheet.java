package org.lelije.lelijeprototype.Drawers;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.lelije.lelijeprototype.R;
import org.lelije.lelijeprototype.databinding.DrawerMainBinding;
import org.lelije.lelijeprototype.ui.MainDrawer.AccountSettings;
import org.lelije.lelijeprototype.ui.MainDrawer.ContactUs;
import org.lelije.lelijeprototype.ui.MainDrawer.FAQ;
import org.lelije.lelijeprototype.ui.MainDrawer.Feedback;
import org.lelije.lelijeprototype.ui.MainDrawer.HelpCenter;
import org.lelije.lelijeprototype.ui.MainDrawer.PaymentMethod;
import org.lelije.lelijeprototype.ui.MainDrawer.PrivacyPolicy;
import org.lelije.lelijeprototype.ui.MainDrawer.SettingPage;
import org.lelije.lelijeprototype.ui.MainDrawer.MyChildrenSetting;
import org.lelije.lelijeprototype.ui.MainDrawer.TermsOfService;

public class MainBottomSheet extends BottomSheetDialogFragment{
    private DrawerMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        binding = DrawerMainBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.drawer_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int height = displayMetrics.heightPixels;
        int maxHeight = (int) (height*0.85);
        BottomSheetBehavior behavior = BottomSheetBehavior.from((View) view.getParent());

        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        CoordinatorLayout cLayout = getDialog().findViewById(R.id.drawer_main_container);
        cLayout.setMinimumHeight(maxHeight);

        setItemOnClick(view);
    }

    private void setItemOnClick(View view) {
        view.findViewById(R.id.drawer_main_account_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(),AccountSettings.class));
        });
        view.findViewById(R.id.drawer_main_faq_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), FAQ.class));
        });
        view.findViewById(R.id.drawer_main_feedback_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), Feedback.class));
        });
        view.findViewById(R.id.drawer_main_help_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), HelpCenter.class));
        });
        view.findViewById(R.id.drawer_main_payment_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), PaymentMethod.class));
        });
        view.findViewById(R.id.drawer_main_privacy_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), PrivacyPolicy.class));
        });
        view.findViewById(R.id.drawer_main_setting_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), SettingPage.class));
        });
        view.findViewById(R.id.drawer_main_my_children_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), MyChildrenSetting.class));
        });
        view.findViewById(R.id.drawer_main_contact_us_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), ContactUs.class));
        });
        view.findViewById(R.id.drawer_main_terms_btn).setOnClickListener(v->{
            getActivity().startActivity(new Intent(getActivity(), TermsOfService.class));
        });
    }
}
