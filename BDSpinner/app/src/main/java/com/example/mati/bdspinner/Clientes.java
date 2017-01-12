package com.example.mati.bdspinner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * Created by mati on 11/01/17.
 */

public class Clientes implements Serializable {

    private String nombre, telf;


    public Clientes(String nom, String telefono){
        nombre=nom;
        telf=telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", telf='" + telf + '\'' +
                '}';
    }
}
