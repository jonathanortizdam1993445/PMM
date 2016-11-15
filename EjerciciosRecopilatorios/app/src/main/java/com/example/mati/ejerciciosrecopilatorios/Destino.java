package com.example.mati.ejerciciosrecopilatorios;

import java.io.Serializable;

/**
 * Created by mati on 14/11/16.
 */

public class Destino implements Serializable{
    private String Zona,continente;
    private String precio;

    public Destino(){

    }

    public Destino(String lugar,String pais,String coste){
        this.Zona=lugar;
        this.continente=pais;
        this.precio=coste;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String zona) {
        Zona = zona;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "Zona='" + Zona + '\'' +
                ", continente='" + continente + '\'' +
                ", precio=" + precio +
                '}';
    }
}
