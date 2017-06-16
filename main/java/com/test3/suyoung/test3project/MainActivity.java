package com.test3.suyoung.test3project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import  com.skp.Tmap.TMapData.FindPathDataListenerCallback;
import  com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapGpsManager;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapPolyLine;
import com.skp.Tmap.TMapView;

import java.util.ArrayList;
//단말의 위치탐색 클래스
public class MainActivity extends Activity implements TMapGpsManager.onLocationChangedCallback {

    private  Context mContext = null;
    private boolean m_bTrackingMode = true;
    public static String str_item = "";

    private  TMapData tmapdata = null;
    private TMapGpsManager tmapgps = null;
    private TMapView tmapview = null;
    private static String mApiKey ="ce940124-25ad-3534-b894-727562e95d59";

    private ArrayList<TMapPoint> m_tampPoint = new ArrayList<TMapPoint>();
    private ArrayList<String> mArrayMarkerID = new ArrayList<String>();
    private ArrayList<MapPoint> m_mapPoint =new ArrayList<MapPoint>();

    @Override
    public void onLocationChange(Location location){
        if(m_bTrackingMode) {
            tmapview.setLocationPoint(location.getLongitude(), location.getLatitude());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner3);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bd,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),adapter.getItem(position),Toast.LENGTH_SHORT).show();
                // TODO Auto-generated method stub
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        str_item = (String)spinner.getSelectedItem().toString();
        mContext = this;

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mapview);
        tmapview = new TMapView(this);
        linearLayout.addView(tmapview);
        tmapview.setSKPMapApiKey(mApiKey);

        /*현재 보는 방향*/
        tmapview.setCompassMode(true);

        /*현위치 아이콘표시 */
        tmapview.setIconVisibility(true);

        /*줌레벨*/
        tmapview.setZoomLevel(15);
        tmapview.setMapType(TMapView.MAPTYPE_STANDARD);
        tmapview.setLanguage(TMapView.LANGUAGE_KOREAN);
        tmapgps = new TMapGpsManager(MainActivity.this);
        tmapgps.setMinTime(1000);
        tmapgps.setMinDistance(5);
        tmapgps.setProvider(tmapgps.NETWORK_PROVIDER); //연결된 인터넷으로 현 위치 받음
        //tmapgps.setProvider(tmapgps.GPS_PROVIDER);    //gps로 현 위치를 잡음
        tmapgps.OpenGps();

        /*화면중심을 단말의 현재위치로 이동*/
        tmapview.setTrackingMode(true);
        tmapview.setSightVisible(true);

        findViewById(R.id.btn_start).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                drawPedestrianPath();
            }
        });

    }
    public TMapPoint deTMapPoint(){
        double latitude;
        double longitude;

        switch (str_item) {
            case "본관": {
                latitude = 36.799830;
                longitude = 127.074925;
                break;
            }
            case "인문관": {
                latitude = 36.798816;
                longitude = 127.075869;
                break;
            }
            case "자연관": {
                latitude = 36.798868;
                longitude = 127.074024;
                break;
            }
            case "보건관": {
                latitude = 36.798765;
                longitude = 127.078369;
                break;
            }
            case "원화관": {
                latitude = 36.800140;
                longitude = 127.077382;
                break;
            }
            case "학생회관": {
                latitude = 36.797614;
                longitude = 127.077167;
                break;
            }
            case "공학관": {
                latitude = 36.800137;
                longitude = 127.072826;
                break;
            }
            default: {
                latitude = 36.798802;
                longitude = 127.074909;
                break;
            }
        }
        TMapPoint point = new TMapPoint(latitude, longitude);
        return point;
    }
    //경로찾기
    public void drawPedestrianPath(){
        //TMapPoint startpoint = new TMapPoint(36.798437, 127.076000);
        TMapPoint startpoint = tmapview.getCenterPoint();
        TMapPoint endpoint = deTMapPoint();
        tmapdata = new TMapData();
        tmapdata.findPathData(startpoint, endpoint, new FindPathDataListenerCallback() {
            @Override
            public void onFindPathData(TMapPolyLine tMapPolyLine) {
                tMapPolyLine.setLineColor(Color.BLUE);
                tmapview.addTMapPath(tMapPolyLine);
            }
        });
    }
}