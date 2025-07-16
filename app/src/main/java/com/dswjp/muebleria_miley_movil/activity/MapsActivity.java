package com.dswjp.muebleria_miley_movil.activity;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.dswjp.muebleria_miley_movil.R;
import com.dswjp.muebleria_miley_movil.context.SessionManager.SessionManager;
import com.dswjp.muebleria_miley_movil.dto.profile.address.AddressDTO;
import com.dswjp.muebleria_miley_movil.sales.dto.order.shipping.OrderShippingDTO;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.dswjp.muebleria_miley_movil.databinding.ActivityMapsBinding;
import com.google.gson.Gson;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private SessionManager sessionManager;

    private OrderShippingDTO orderShippingDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final String orderShipping = this.getIntent().getStringExtra("orderShipping");
        orderShippingDTO = new Gson().fromJson(orderShipping, OrderShippingDTO.class);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        sessionManager = SessionManager.getInstance();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        sessionManager.getAddress().observe(this, address -> {
            // Add a marker in Sydney and move the camera
            LatLng client = new LatLng(address.getLta(), address.getLng());
            mMap.addMarker(new MarkerOptions().position(client).title("Destino del Pedido"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(client));
            Log.d("MapsActivity","Cargando marcador y zoom");
            mMap.setMinZoomPreference(15.0f);
           // mMap.setMaxZoomPreference(5.0f);

            if(orderShippingDTO != null){
                //TODO: CARGAR UBICACION DEL REPARTIDOR
                //LatLng carrier = new LatLng(orderShippingDTO.);
            }
        });
    }

}