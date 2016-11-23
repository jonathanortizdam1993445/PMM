package com.example.mati.correccionexamenconcesionario;

import java.io.Serializable;

/**
 * Created by mati on 23/11/16.
 */

public class Coche implements Serializable {
    private String marca,modelo,precio;
    private int view;

    public Coche(String marca,String modelo,String precio,int imagen){
        this.marca=marca;
        this.modelo=modelo;
        this.precio=precio;
        this.view=imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio='" + precio + '\'' +
                ", view=" + view +
                '}';
    }
}
