package com.example.mati.ejerciciosrecopilatorios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton1= (Button)findViewById(R.id.button);
        Button boton2= (Button)findViewById(R.id.button2);
        Button boton3= (Button)findViewById(R.id.button3);
        Button boton4= (Button)findViewById(R.id.button4);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miintent= new Intent(MainActivity.this,Ejercicio1.class);
                startActivity(miintent);

            }
        });



    }


}
