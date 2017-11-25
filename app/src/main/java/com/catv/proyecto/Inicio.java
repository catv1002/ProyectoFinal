package com.catv.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.catv.proyecto.Constantes.Cliente;
import com.catv.proyecto.Constantes.Producto;
import com.catv.proyecto.Mapa.MapsActivity;
import com.catv.proyecto.Qr.IntentIntegrator;
import com.catv.proyecto.Qr.IntentResult;

import java.util.concurrent.ExecutionException;

public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "Inicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    com.catv.proyecto.Modelo.Producto producto = new com.catv.proyecto.Modelo.Producto();
//                    producto.acceso_consultar();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//
//
//                }
//
//            }
//
//        });
//
//
//        try {
//            com.catv.proyecto.Modelo.Cliente cliente = new com.catv.proyecto.Modelo.Cliente();
//            cliente.acceso_consultar();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mapa) {
            // Handle the camera action
            startActivity(new Intent(this, MapsActivity.class));
        } else if (id == R.id.nav_buscar) {

            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
            Log.d(TAG, "onNavigationItemSelected: nav_buscar");


        } else if (id == R.id.nav_cliente) {

        } else if (id == R.id.nav_producto) {

//            //Insercion de Productos
//            //*********************
//            int codigo = 999999;
//            String nombre = "holi";
//            double precio_min = 1;
//            double precio_max = 2;
//            int cantidad = 1;
//            int bodega = 1;
//
//            com.catv.proyecto.Modelo.Producto producto = new com.catv.proyecto.Modelo.Producto(codigo, nombre, precio_min, precio_max, cantidad, bodega);
//
//            //System.out.println(cliente);
//            producto.Insertar();
//
//            try {
//                producto.acceso_Insert_Update_Productos();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

//*****************

//            //Cosulta de productos
//            com.catv.proyecto.Modelo.Producto productoc = new com.catv.proyecto.Modelo.Producto();
//
//            try {
//                productoc.acceso_consultar();
//                System.out.println("777777777777" + productoc.getLista_productos());
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        Producto.producto_qr = scanResult.getContents();
        Log.d(TAG, "onActivityResult: " + Producto.producto_qr);

        //Intent intent_c_producto_c = new Intent(getApplicationContext(), cProductoC.class);
        //startActivity(intent_c_producto_c);


    }
}
