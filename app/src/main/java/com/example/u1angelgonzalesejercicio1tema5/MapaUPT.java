package com.example.u1angelgonzalesejercicio1tema5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;

public class MapaUPT extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnInfoWindowLongClickListener {
    GoogleMap mapa;
    LatLng ubicacion_rectorado;
    LatLng ubicacion_rectorado_1;
    LatLng ubicacion_rectorado_2;

    LatLng ubicacion_campus;
    LatLng ubicacion_campus_1;
    LatLng ubicacion_campus_2;


    LatLng ubicacion_admision;
    LatLng ubicacion_admision_1;
    LatLng ubicacion_admision_2;

    LatLng ubicacion_posgrado;
    LatLng ubicacion_posgrado_1;
    LatLng ubicacion_posgrado_2;

    Polygon polygon_rectorado = null;
    Polygon polygon_campus = null;
    Polygon polygon_admision = null;
    Polygon polygon_posgrado = null;

    //Latitud
    List<LatLng> latLngList = new ArrayList<>();
    List<Marker> markerList = new ArrayList<>();

    List<LatLng> latLngListCampus = new ArrayList<>();
    List<Marker> markerListCampus = new ArrayList<>();

    List<LatLng> latLngListAdmision = new ArrayList<>();
    List<Marker> markerListAdmision = new ArrayList<>();

    List<LatLng> latLngListPosgrado = new ArrayList<>();
    List<Marker> markerListPosgrado = new ArrayList<>();
    ArrayList<Marker> markers = new ArrayList<>();

    Button btncentrar, btnposgrado, btnrectorado, btnadmision, btncampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_upt);
        btncentrar = findViewById(R.id.btncentrar);
        btnposgrado = findViewById(R.id.btnposgrado);
        btnrectorado = findViewById(R.id.btnrectorado);
        btnadmision = findViewById(R.id.btnadmision);
        btncampus = findViewById(R.id.btncampus);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

        btncentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.013240, -70.250091), 13));
            }
        });

        btnrectorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.009282, -70.242908), 20));
                CameraPosition position = mapa.getCameraPosition();
                float zoom = position.zoom;
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.rectorado))
                        .title("Rectorado UPT")
                        .snippet("Rectorado"));

            }
        });

        btnposgrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.005058, -70.235099), 18));
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.posgrado))
                        .title("Posgrado UPT")
                        .snippet("Posgrado"));
            }
        });

        btnadmision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.013522, -70.250260), 20));
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.posgrado))
                        .title("Admision UPT")
                        .snippet("Admision"));
                        //.snippet("https://www.google.com/maps/place/Instituto+Telesup/@-18.0134241,-70.2502144,21z/data=!4m5!3m4!1s0x915acf65a8f8c66d:0x2aa34c7bd8c6ac97!8m2!3d-18.0135324!4d-70.2502479"));
            }
        });

        btncampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.005694, -70.225477), 18));
                mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.campus))
                        .title("Campus UPT")
                        .snippet("Campus Capanique"));
                /*markers.add(mapa.addMarker(new MarkerOptions()
                        .position(mapa.getCameraPosition().target)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.campus))
                        .title("Marker onMapClick")
                        .snippet("Este marker es producto del evento de pulsar en el mapa")));*/
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Rectorado
        mapa = googleMap;
        ubicacion_rectorado = new LatLng(-18.009265, -70.242981);
        ubicacion_rectorado_1 = new LatLng(-18.009265, -70.242854);
        ubicacion_rectorado_2 = new LatLng(-18.009402, -70.242960);

        MarkerOptions markerOptions = new MarkerOptions().position(ubicacion_rectorado);
        MarkerOptions markerOptions1 = new MarkerOptions().position(ubicacion_rectorado_1);
        MarkerOptions markerOptions2 = new MarkerOptions().position(ubicacion_rectorado_2);
        Marker marker1 = mapa.addMarker(markerOptions1);
        Marker marker2 = mapa.addMarker(markerOptions2);
        Marker marker = mapa.addMarker(markerOptions);
        latLngList.add(ubicacion_rectorado);
        latLngList.add(ubicacion_rectorado_1);
        latLngList.add(ubicacion_rectorado_2);
        markerList.add(marker);
        markerList.add(marker1);
        markerList.add(marker2);

        //Marker encerrado

        //Campus

        ubicacion_campus = new LatLng(-18.005674, -70.225914);
        ubicacion_campus_1 = new LatLng(-18.005159, -70.225230);
        ubicacion_campus_2 = new LatLng(-18.005945, -70.225321);

        MarkerOptions markerOptionscampus = new MarkerOptions().position(ubicacion_campus);
        MarkerOptions markerOptions1campus = new MarkerOptions().position(ubicacion_campus_1);
        MarkerOptions markerOptions2campus = new MarkerOptions().position(ubicacion_campus_2);
        Marker markercampus1 = mapa.addMarker(markerOptions1campus);
        Marker markercampus2 = mapa.addMarker(markerOptions2campus);
        Marker markercampus = mapa.addMarker(markerOptionscampus);
        latLngListCampus.add(ubicacion_campus);
        latLngListCampus.add(ubicacion_campus_1);
        latLngListCampus.add(ubicacion_campus_2);
        markerListCampus.add(markercampus);
        markerListCampus.add(markercampus2);
        markerListCampus.add(markercampus1);

        //Admision

        ubicacion_admision = new LatLng(-18.013515, -70.250327);
        ubicacion_admision_1= new LatLng(-18.013565, -70.250213);
        ubicacion_admision_2 = new LatLng(-18.013464, -70.250233);

        MarkerOptions markerOptionsadmision = new MarkerOptions().position(ubicacion_admision);
        MarkerOptions markerOptions1admision = new MarkerOptions().position(ubicacion_admision_1);
        MarkerOptions markerOptions2admision = new MarkerOptions().position(ubicacion_admision_2);
        Marker markeradmision1 = mapa.addMarker(markerOptionsadmision);
        Marker markeradmision2 = mapa.addMarker(markerOptions1admision);
        Marker markeradmision = mapa.addMarker(markerOptions2admision);
        latLngListAdmision.add(ubicacion_admision);
        latLngListAdmision.add(ubicacion_admision_1);
        latLngListAdmision.add(ubicacion_admision_2);
        markerListAdmision.add(markeradmision);
        markerListAdmision.add(markeradmision2);
        markerListAdmision.add(markeradmision1);

        //Posgrado

        ubicacion_posgrado = new LatLng(-18.005197, -70.235027);
        ubicacion_posgrado_1= new LatLng(-18.005130, -70.235448);
        ubicacion_posgrado_2 = new LatLng(-18.004923, -70.235043);

        MarkerOptions markerOptionpos = new MarkerOptions().position(ubicacion_posgrado);
        MarkerOptions markerOption1pos = new MarkerOptions().position(ubicacion_posgrado_1);
        MarkerOptions markerOption2pos = new MarkerOptions().position(ubicacion_posgrado_2);
        Marker markerpos1 = mapa.addMarker(markerOptionpos);
        Marker markerpos2 = mapa.addMarker(markerOption1pos);
        Marker markerpos = mapa.addMarker(markerOption2pos);
        latLngListPosgrado.add(ubicacion_posgrado);
        latLngListPosgrado.add(ubicacion_posgrado_1);
        latLngListPosgrado.add(ubicacion_posgrado_2);
        markerListPosgrado.add(markeradmision);
        markerListPosgrado.add(markeradmision2);
        markerListPosgrado.add(markeradmision1);


        if (!latLngList.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngList).clickable(true);
            polygon_rectorado = mapa.addPolygon(polygonOptions);
            polygon_rectorado.setStrokeColor(Color.rgb(179, 95, 12));
        }

        if (!latLngListCampus.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngListCampus).clickable(true);
            polygon_campus = mapa.addPolygon(polygonOptions);
            polygon_campus.setStrokeColor(Color.rgb(69, 255, 91));
        }

        if (!latLngListAdmision.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngListAdmision).clickable(true);
            polygon_admision = mapa.addPolygon(polygonOptions);
            polygon_admision.setStrokeColor(Color.rgb(255, 150, 43));
        }

        if (!latLngListPosgrado.isEmpty()) {
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(latLngListPosgrado).clickable(true);
            polygon_posgrado = mapa.addPolygon(polygonOptions);
            polygon_posgrado.setStrokeColor(Color.rgb(71, 14, 204));
        }


        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.013240, -70.250091), 13));
        mapa.setOnInfoWindowLongClickListener(this);
    }

    @Override
    public void onInfoWindowLongClick(Marker markerListCampus) {
        WebView web = new WebView(this);
        setContentView(web);
        web.loadUrl("https://www.google.com/maps/place/Instituto+Telesup/@-18.0134241,-70.2502144,21z/data=!4m5!3m4!1s0x915acf65a8f8c66d:0x2aa34c7bd8c6ac97!8m2!3d-18.0135324!4d-70.2502479");
    }

    public void moveCamera(View view) {
        mapa.moveCamera(CameraUpdateFactory.newLatLng(ubicacion_rectorado));
    }

    public void addMarker(View view) {
        mapa.addMarker(new MarkerOptions().position(
                mapa.getCameraPosition().target));
    }

    @Override public void onMapClick(LatLng puntoPulsado) {
        mapa.addMarker(new MarkerOptions().position(puntoPulsado)
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
    }
}
