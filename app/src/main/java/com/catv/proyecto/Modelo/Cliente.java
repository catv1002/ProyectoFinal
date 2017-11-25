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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.catv.proyecto.Constantes.Conexion.CLIENTE_INSERT;

/**
 * Created by jmim on 22/11/2017.
 */

public class Cliente {

    private String nombre1, nombre2, apellido1, apellido2, correo, ciudad, direccion, telefono, idCliente;
    private int idUbica;


    public Cliente() {
    }


    public Cliente(String nombre1, String nombre2, String apellido1, String apellido2, String correo, String ciudad, String direccion, String telefono, String idCliente, int idUbica) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idCliente = idCliente;
        this.idUbica = idUbica;
    }


    public Cliente(String idCliente, int idUbica) {
        this.idCliente = idCliente;
        this.idUbica = idUbica;
    }


    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUbica() {
        return idUbica;
    }

    public void setIdUbica(int idUbica) {
        this.idUbica = idUbica;
    }



}
