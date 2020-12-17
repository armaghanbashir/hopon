
package com.example.test;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.ActionBarDrawerToggle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.drawerlayout.widget.DrawerLayout;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toolbar;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.android.material.navigation.NavigationView;
        import com.mapbox.mapboxsdk.Mapbox;
        import com.mapbox.mapboxsdk.maps.MapView;
        import com.mapbox.mapboxsdk.maps.MapboxMap;
        import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
        import com.mapbox.mapboxsdk.maps.Style;


    public class OfferRide extends AppCompatActivity {
        private MapView mapView, inMapView;

        Button buttonD, findRide, offerRide;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
            setContentView(R.layout.activity_offer_ride);

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
          /*  FloatingActionButton back = findViewById(R.id.toAddRide);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(OfferRide.this,MainActivity.class));
                }
            });*/
            Button add1= findViewById(R.id.Offer);
            add1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(OfferRide.this,AcceptRide.class));
                }
            });
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


