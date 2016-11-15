package com.example.mati.ejerciciosrecopilatorios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        TextView fact = (TextView)findViewById(R.id.textView2);
        Bundle object= getIntent().getExtras();

        Destino destino = (Destino) object.getSerializable("FACTURA DETALLADA");
        fact.setText("Zona: "+destino.getZona()+" Continente: "+destino.getContinente()+" precio: "+destino.getPrecio());


    }
}
