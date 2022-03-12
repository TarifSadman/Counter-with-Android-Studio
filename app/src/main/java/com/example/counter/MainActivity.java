package com.example.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;

    private TextView tcounter;
    private Button bplus, bminus, breset, bmage, bprofile;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        tcounter = findViewById(R.id.texthw);
        bplus = findViewById(R.id.b1);
        bminus = findViewById(R.id.b2);
        breset = findViewById(R.id.b3);
        bmage = findViewById(R.id.b4);
        bprofile = findViewById(R.id.b5);
        img = findViewById(R.id.iv);

        bprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityMap();
            }
        });
    }
    public void openActivityMap(){
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }

    public void Lol(View view){
        int id = view.getId();
        int counter = 0;

        switch(id){
            case R.id.b1:
                counter = Integer.parseInt(tcounter.getText().toString());
                counter++;
                tcounter.setText(counter+"");
                break;
            case R.id.b2:
                counter = Integer.parseInt(tcounter.getText().toString());
                if(counter!=0) {
                    counter--;
                    tcounter.setText(counter + "");
                }
                    break;
            case R.id.b3:
                tcounter.setText("0");
                }
                bmage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(img.getVisibility() == View.VISIBLE){
                            img.setVisibility(View.GONE);
                        }
                        else{
                            img.setVisibility(View.VISIBLE);
                        }
                    }
                                         ;}
                );

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
          map = googleMap;
        LatLng Uttara = new LatLng(23.869, 90.401);
                map.addMarker(new MarkerOptions(). position(Uttara).title("pp"));
//        map.animateCamera( CameraUpdateFactory.zoomTo( 1.0f ) );
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Uttara,15));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        LatLng centerLatLang = map.getProjection().getVisibleRegion().latLngBounds.getCenter();
    }
}