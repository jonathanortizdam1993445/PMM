package com.example.mati.examenconcesionario;

import java.io.Serializable;

/**
 * Created by mati on 21/11/16.
 */

public class Coches implements Serializable {
    private String modelo,marca;
    private String precio;


    public Coches(String modelo, String marca,String precio){
        this.modelo=modelo;
        this.marca=marca;
        this.precio=precio;

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
