package org.lelije.lelijeprototype.ui.HomePage.MainOTRTab;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.lelije.lelijeprototype.BuildConfig;
import org.lelije.lelijeprototype.databinding.FragmentMainCreateScheduleBinding;
import org.lelije.lelijeprototype.ui.Schedule.CreateSchedulePickupLocation;
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapListener;
import org.osmdroid.events.ScrollEvent;
import org.osmdroid.events.ZoomEvent;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class OTRFragment extends Fragment implements MapListener {
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    String[] permArray = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private FragmentMainCreateScheduleBinding binding;
    MapView mMap;
    IMapController controller;
    MyLocationNewOverlay mMyLocationOverlay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        Context ctx = getContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        OTRViewModel homeViewModel = new ViewModelProvider(this).get(OTRViewModel.class);
        binding = FragmentMainCreateScheduleBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.fragmentMainTabRideSearch.setOnClickListener(v->{
//            getActivity().startActivity(new Intent(getActivity(), CreateSchedulePickupLocation.class));
//        });
//        requestPerms();

        setupViews();
    }

    private void setupViews() {
        binding.fragmentMainCreateScheduleItem1.cardScheduleListDateContainer.setVisibility(View.GONE);
        binding.fragmentMainCreateScheduleItem1.cardScheduleListTitle.setText("Adil, Eman and Elias have scheduled rides");
        binding.fragmentMainCreateScheduleCreateSchedule.itemButtonWideBtn.setText("Create Schedule");
        binding.fragmentMainCreateScheduleCreateSchedule.itemButtonWideBtn.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), CreateSchedulePickupLocation.class));
        });
    }


    @Override
    public boolean onScroll(ScrollEvent event) {
        // event?.source?.getMapCenter()
        Log.e("TAG", "onCreate:la ${event?.source?.getMapCenter()?.latitude}");
        Log.e("TAG", "onCreate:lo ${event?.source?.getMapCenter()?.longitude}");
        //  Log.e("TAG", "onScroll   x: ${event?.x}  y: ${event?.y}", )

        return true;
    }

    @Override
    public boolean onZoom(ZoomEvent event) {
        //  event?.zoomLevel?.let { controller.setZoom(it) }

        Log.e("TAG", "onZoom zoom level: ${event?.zoomLevel}   source:  ${event?.source}");
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (int i = 0; i < grantResults.length; i++) {
            permissionsToRequest.add(permissions[i]);
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    getActivity(),
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(getContext(), permission)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    getActivity(),
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }
    private void setupMap(){
//        mMap = binding.osmmap;
        mMap.setTileSource(TileSourceFactory.MAPNIK);
        mMap.getMapCenter();
        mMap.setMultiTouchControls(true);
        mMap.getLocalVisibleRect(new Rect());
        requestPermissionsIfNecessary(permArray);
        mMap.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.NEVER);
        mMap.setMultiTouchControls(true);

        mMyLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), mMap);
        controller = mMap.getController();

        mMyLocationOverlay.enableMyLocation();
        mMyLocationOverlay.enableFollowLocation();
        mMyLocationOverlay.setDrawAccuracyEnabled(true);

        mMyLocationOverlay.runOnFirstFix(() -> {
            getActivity().runOnUiThread(()->{
                controller.setCenter(mMyLocationOverlay.getMyLocation());
                controller.animateTo(mMyLocationOverlay.getMyLocation());
            });
        });

        // val mapPoint = GeoPoint(latitude, longitude)

        controller.setZoom(14.5);

        Log.e("TAG", "onCreate:in ${controller.zoomIn()}");
        Log.e("TAG", "onCreate: out  ${controller.zoomOut()}");

        // controller.animateTo(mapPoint)
        mMap.getOverlays().add(mMyLocationOverlay);



        mMap.addMapListener(this);
    }

    private void requestPerms(){
        if (ContextCompat.checkSelfPermission(
                getContext(), Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.
            setupMap();
        }  else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            requestPermissionLauncher.launch(
                    Manifest.permission.ACCESS_FINE_LOCATION);
        }
    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                    setupMap();
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // feature requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            });
}