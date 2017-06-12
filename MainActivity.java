package com.test3.suyoung.test3project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;
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

    private  TMapData tmapdata = null;
    private TMapGpsManager tmapgps = null;
    private TMapView tmapview = null;
    private static String mApiKey ="ce940124-25ad-3534-b894-727562e95d59";

    private ArrayList<TMapPoint> m_tampPoint = new ArrayList<TMapPoint>();
    private ArrayList<String> mArrayMarkerID = new ArrayList<String>();
    private ArrayList<MapPoint> m_mapPoint =new ArrayList<MapPoint>();

    @Override
    public void onLocationChange(Location location){
        if (m_bTrackingMode){
            tmapview.setLocationPoint(location.getLongitude(), location.getLatitude());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        //실내일 때 유용
        //tmapgps.setProvider(tmapgps.GPS_PROVIDER);    //gps로 현 위치를 잡음
        tmapgps.OpenGps();

        /*화면중심을 단말의 현재위치로 이동*/
        tmapview.setTrackingMode(true);
        tmapview.setSightVisible(true);
        drawPedestrianPath();
    }
    //보행자 경로찾기
    public void drawPedestrianPath(){
        TMapPoint startpoint = tmapview.getCenterPoint();
        TMapPoint endpoint = new TMapPoint(36.800309, 127.074910);
        tmapdata = new TMapData();
        tmapdata.findPathData(startpoint, endpoint, new FindPathDataListenerCallback() {
            @Override
            public void onFindPathData(TMapPolyLine tMapPolyLine) {
                tMapPolyLine.setLineColor(Color.BLUE);
                tmapview.addTMapPath(tMapPolyLine);
            }
        });
    }
    //현재위치 받아오기
    public  void getCenterPoint(){
        TMapPoint point = tmapview.getCenterPoint();
    }


}