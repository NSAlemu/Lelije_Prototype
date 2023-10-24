package org.lelije.lelijeprototype.ui.HomePage.MainScheduleTab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.tabs.TabLayoutMediator;

import org.lelije.lelijeprototype.Adapters.ScheduleListPagerAdapter;
import org.lelije.lelijeprototype.databinding.FragmentMainTabScheduleBinding;



public class ScheduleFragment extends Fragment {

    private FragmentMainTabScheduleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ScheduleViewModel dashboardViewModel =
                new ViewModelProvider(this).get(ScheduleViewModel.class);

        binding = FragmentMainTabScheduleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
    }

    private void setupViews() {
//        binding.fragmentMainTabScheduleCalendarViewButton.itemButtonWideBtn.setText("Calendar View");
//        Drawable icon = ContextCompat.getDrawable(getContext(), R.drawable.ic_lelije_calendar);
//        ((MaterialButton) binding.fragmentMainTabScheduleCalendarViewButton.itemButtonWideBtn).setIcon(icon);
//        ((MaterialButton) binding.fragmentMainTabScheduleCalendarViewButton.itemButtonWideBtn).setIconSize(30);
//        ((MaterialButton) binding.fragmentMainTabScheduleCalendarViewButton.itemButtonWideBtn).setIconTintResource(R.color.white);
//        ((MaterialButton) binding.fragmentMainTabScheduleCalendarViewButton.itemButtonWideBtn).setIconGravity(MaterialButton.ICON_GRAVITY_TEXT_START);

        ScheduleListPagerAdapter pagerAdapter = new ScheduleListPagerAdapter(getActivity().getSupportFragmentManager(), getActivity().getLifecycle());
        binding.fragmentMainTabScheduleViewpager.setAdapter(pagerAdapter);
        new TabLayoutMediator(binding.fragmentMainTabScheduleTablayout, binding.fragmentMainTabScheduleViewpager, (tab, position) -> {
            if(position==0)
                tab.setText("Scheduled");
            else
                tab.setText("Completed");
        }).attach();

        binding.fragmentMainTabScheduleCalendarPicker.setOnClickListener(v->{
            MaterialDatePicker datePicker = MaterialDatePicker.Builder.dateRangePicker()
                    .setTitleText("Select Schedule dates")
                    .setSelection(
                            new Pair(
                                    MaterialDatePicker.thisMonthInUtcMilliseconds(),
                                    MaterialDatePicker.todayInUtcMilliseconds()
                            )
                    )
                    .build();

            datePicker.show(getParentFragmentManager(), "MATERIAL_DATE_PICKER");
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}