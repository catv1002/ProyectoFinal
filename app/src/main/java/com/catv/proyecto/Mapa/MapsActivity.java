package com.catv.proyecto.Mapa;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.catv.proyecto.Constantes.Cliente;
import com.catv.proyecto.Constantes.Ubicacion;
import com.catv.proyecto.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private static final String TAG = "MapsActivity";

    private ImageButton guardar_cliente, consultar_cliente_cercano;

    private static String opcion="";

    GoogleMap googlemap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Activamos el permiso por el puerto 1000
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            // Si el servicio esta disponible llamamos al metodo  locationStart
            locationStart();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googlemap = googleMap;
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) { // Metodo para validar el código (1000)
        if (requestCode == 1000) { // si el código del permiso es 1000
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) { // se activa el permiso
                locationStart(); // se llama al metodo locationStart()
                return;
            }
        }
    }

    //Evento de clic sobre el mapa cuando un cliente no se encuentre en la ubicacion actual del usuario
    //y el usuario quiera agregarlo manualmente
    @Override
    public void onMapClick(LatLng point) {

        //.d(TAG, "onMapClick: latitud" + Ubicacion.latitudTouch + ", longitud" + Ubicacion.longitudTouch);
        Ubicacion.latitudTouch = point.latitude;
        Ubicacion.longitudTouch = point.longitude;

        //Log.d(TAG, "onMapClick: " + point.latitude);

        System.out.println("*************" + Ubicacion.latitudTouch + "*********" + Ubicacion.longitudTouch);

        //Estas variables son las que deben llevarse al fragment para llenar los edittext
        //y la modificacion manual de latitud longitus este completa

    }


    private void locationStart() { // Metodo para obtener el servicio de localización por GPS o Internet
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); // Activación del servicio de Localización
        LocalizacionGPS Local = new LocalizacionGPS(); // Instancia de la clase Localización
//        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER); // Activación de la API de GPS
//        if (!gpsEnabled) { // Si el GPS esta desactivado
//            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS); // Se llama una intención para activar el gps
//            startActivity(settingsIntent); // se activa la intención
//        }
        // Si los permisos ACCES_FINE_LOCATION Y ACCESS_CORE_LOCATION no están activos
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Activamos el permiso con el código 1000
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local); // Obtenemos la localización por medio de la red de datos
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local); // Obtenemos la localización por medio del GPS

    }


//    public void setLocation(Location loc) {
//        //Obtener la direccion de la calle a partir de la latitud y la longitud
//        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
//            try {
//                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
//                List<Address> list = geocoder.getFromLocation(
//                        loc.getLatitude(), loc.getLongitude(), 1);
//                if (!list.isEmpty()) {
//                    Address DirCalle = list.get(0);
////                    direccion.setText("Mi direccion es: \n"
////                            + DirCalle.getAddressLine(0));
//
//                    String dir = "Mi direccion es: \n"
//                            + DirCalle.getAddressLine(0);
//
//                    System.out.println(dir);
//
//                    Cliente.direccion = DirCalle.getAddressLine(0);
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    @Override
    public void onMapLongClick(LatLng latLng) {

        Log.d(TAG, "onMapLongClick: " + latLng);

    }



    public void AgregarCliente(View view){

    }





}


