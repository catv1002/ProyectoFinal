package com.catv.proyecto.Modelo;

import android.os.AsyncTask;

import com.catv.proyecto.Constantes.Conexion;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by jmim on 27/10/2017.
 */

public class Producto {

    private int codigo;
    private String nombre;
    private double precio_min;
    private double precio_max;
    private int cantidad;
    private int bodega;
    public static List<Producto> lista_productos = new ArrayList<Producto>();

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio_min, double precio_max, int cantidad, int bodega) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio_min = precio_min;
        this.precio_max = precio_max;
        this.cantidad = cantidad;
        this.bodega = bodega;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_min() {
        return precio_min;
    }

    public void setPrecio_min(double precio_min) {
        this.precio_min = precio_min;
    }

    public double getPrecio_max() {
        return precio_max;
    }

    public void setPrecio_max(double precio_max) {
        this.precio_max = precio_max;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getBodega() {
        return bodega;
    }

    public void setBodega(int bodega) {
        this.bodega = bodega;
    }

    public static List<Producto> getLista_productos() {
        return lista_productos;
    }










    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio_min=" + precio_min +
                ", precio_max=" + precio_max +
                ", cantidad=" + cantidad +
                ", bodega=" + bodega +
                '}';
    }


}
