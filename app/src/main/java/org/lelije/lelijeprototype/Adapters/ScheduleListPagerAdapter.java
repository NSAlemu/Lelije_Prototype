package org.lelije.lelijeprototype.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.lelije.lelijeprototype.ui.HomePage.MainScheduleTab.FutureScheduleList;
import org.lelije.lelijeprototype.ui.HomePage.MainScheduleTab.PastScheduleList;

public class ScheduleListPagerAdapter extends FragmentStateAdapter {


    public ScheduleListPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return position == 0 ? new FutureScheduleList() : new PastScheduleList();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
