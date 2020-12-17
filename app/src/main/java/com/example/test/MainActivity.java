package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;


public class MainActivity extends AppCompatActivity {
    private MapView mapView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button buttonD, findRide, offerRide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));

        setContentView(R.layout.activity_main);
//////////////////////////////////////////////
        navigationView=findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
       /* navUsername = headerView.findViewById(R.id.nav_name);
        navUserMail = headerView.findViewById(R.id.nav_email);
        navUserPic = headerView.findViewById(R.id.nav_Pic);*/
/////////////////////////////////////
 //////////////////////////////////////////////
        drawerLayout = findViewById(R.id.drawer_layout);
        buttonD = (Button) findViewById(R.id.menu);
        findRide = (Button) findViewById(R.id.find);
        offerRide = (Button) findViewById(R.id.offer);

        offerRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOfferRide();
            }
        });

        findRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFindRide();
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.LOGOUT:
                        {
                        FirebaseAuth.getInstance().signOut();
                        Intent intToMain = new Intent(MainActivity.this, splash.class);
                        startActivity(intToMain);
                        return true;
                     }
                }
                return true;
            }
        });
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        // Map is set up and the style has loaded. Now you can add data or make other map adjustments


                    }
                });

            }
        });

    }

    public void openFindRide(){
        Intent intent = new Intent(this, finding_ride.class);
        startActivity(intent);
    }
    public void openOfferRide(){
        Intent intent2 = new Intent(this, OfferRide.class);
        startActivity(intent2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}

