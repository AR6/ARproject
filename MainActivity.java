package com.test3.suyoung.test3project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.skp.Tmap.TMapView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        TMapView tmapview = new TMapView(this);

        tmapview.setSKPMapApiKey("ce940124-25ad-3534-b894-727562e95d59");

        tmapview.setCompassMode(true);
        tmapview.setIconVisibility(true);
        tmapview.setZoomLevel(15);
        tmapview.setMapType(TMapView.MAPTYPE_STANDARD);
        tmapview.setLanguage(TMapView.LANGUAGE_KOREAN);
        tmapview.setTrackingMode(true);
        tmapview.setSightVisible(true);
        relativeLayout.addView(tmapview);
        setContentView(relativeLayout);
    }
}