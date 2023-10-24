package org.lelije.lelijeprototype.ui.HomePage.MainScheduleTab;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.lelije.lelijeprototype.Adapters.ScheduleListAdapter;
import org.lelije.lelijeprototype.Models.RideModel;
import org.lelije.lelijeprototype.SampleData.RideGenerator;
import org.lelije.lelijeprototype.databinding.FragmentScheduleListBinding;
import org.lelije.lelijeprototype.ui.Schedule.CompletedRideEventDetails;
import org.lelije.lelijeprototype.ui.Schedule.RideEventDetails;

import java.util.ArrayList;

public class PastScheduleList extends Fragment implements ScheduleListAdapter.ItemClickListener {
    private FragmentScheduleListBinding binding;
    private ArrayList<RideModel> rideModels;
    ScheduleListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentScheduleListBinding.inflate(inflater, container, false);
        rideModels = RideGenerator.generatePreviousRides(20);
        rideModels.add(0, RideGenerator.generateCurrentRide());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentScheduleListRv.setOnClickListener(v->
                getActivity().startActivity(new Intent(getActivity(), RideEventDetails.class)));

        adapter = new ScheduleListAdapter(getContext(), rideModels, false);
        adapter.setClickListener(this);
        binding.fragmentScheduleListRv.setAdapter(adapter);
        binding.fragmentScheduleListRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onItemClick(View view, int position) {
        getActivity().startActivity(new Intent(getActivity(), CompletedRideEventDetails.class));
    }
}