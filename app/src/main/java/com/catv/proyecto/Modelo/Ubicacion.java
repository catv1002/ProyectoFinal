package com.catv.proyecto.Modelo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by jmim on 23/11/2017.
 */

public class Ubicacion {

    private String latitud, longitud, idCliente;

    public Ubicacion() {
    }

    public Ubicacion(String latitud, String longitud, String idCliente) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.idCliente = idCliente;
    }


    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                " latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", idCliente='" + idCliente + '\'' +
                '}';
    }

    public LinkedHashMap<String, String> insertUbicacion() {
        LinkedHashMap<String, String> hashMapToken = new LinkedHashMap<>();
        hashMapToken.put("latitud", getIdCliente());
        hashMapToken.put("longitud", getLongitud());
        hashMapToken.put("idCliente", getLatitud());
        return hashMapToken;
    }


}
