package com.example.mp08_uf1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;
import java.util.List;

public class SpotsFragment extends Fragment {

    private MapView mapView;

    String spotsCoords = "41.36949931106624,2.159744853714095 41.42736431113858,2.185688565635218 41.56358179724196,2.102722397115702, 41.39070376962648,2.1336936310771892 41.42730005949992,2.181746942274595 41.409816105207256,2.153031235644106 41.442981732021785,2.217815095263687 41.41175196343365,2.2175818409709787 41.448731680484855,2.1827493450554654 41.4760784475211,2.081941751360531 41.36133960768586,2.0859950285305446 41.38622858494486,2.194134218559357 41.45718616601458,2.1985367996489984 41.409109949202055,2.1910178934976616 41.40636601860034,2.225307751563659 41.39292273539274,2.2001194729444893 41.36489227370818,2.1511223799378434 41.367277702832325,2.1549715405797154 41.37391346546193,2.1495965202617793 41.44965626924184,2.228343610740294 41.38700939084145,2.193543079146999 41.378428898805915,2.1415698727871773 41.38677949770694,2.125207058754383 41.44912109333521,2.2535490175895867";
    String[] spotsArray = spotsCoords.split(" ");

    //List<Double[]> mapsCoords = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spots, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //&mapsCoords.add(new Double[]{41.36949931106624,2.159744853714095});
        //mapsCoords.add(new Double[]{41.42736431113858, 2.185688565635218});
        //mapsCoords.add(new Double[]{41.56358179724196, 2.102722397115702});




        // Initialize osmdroid
        Configuration.getInstance().setUserAgentValue(requireContext().getPackageName());

        // Setup the map
        mapView = view.findViewById(R.id.map);
        mapView.setMultiTouchControls(true); // Enable zooming

        // Set map center and zoom level
        GeoPoint startPoint = new GeoPoint(41.45546334642397, 2.2013994077872017); // Example: Barcelona
        mapView.getController().setZoom(12.0);
        mapView.getController().setCenter(startPoint);

        // Add a marker for a parkour spot
        Marker marker = new Marker(mapView);
        marker.setPosition(startPoint);
        marker.setTitle("Puig Castellar, where this app was mainly developed");
        mapView.getOverlays().add(marker);

        for (String coords: spotsArray) {
            Marker markerTemp = new Marker(mapView);
            String[] coordSplit = coords.split(",");

            markerTemp.setPosition(new GeoPoint( Double.parseDouble(coordSplit[0]), Double.parseDouble(coordSplit[1])));
            markerTemp.setTitle("Parkour Spot");
            mapView.getOverlays().add(markerTemp);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mapView != null) {
            mapView.onDetach();
        }
    }
}
