package com.example.mati.examenconcesionario;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dibujar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));
    }
    public class Dibujo extends View {
        public Dibujo(Context context) {
            super(context);
        }


        protected void onDraw(Canvas canvas) {

            Paint rueda1 = new Paint();
            Paint rueda2 = new Paint();
            Paint linea_une = new Paint();
            Paint linea_delante = new Paint();
            Paint linea_trasera = new Paint();
            Paint curva = new Paint();

            rueda1.setColor(Color.BLACK);
            rueda1.setStrokeWidth(15);
            rueda1.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(700,500,100,rueda1);

            rueda2.setColor(Color.BLACK);
            rueda2.setStrokeWidth(15);
            rueda2.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(300,500,100,rueda2);

            linea_une.setColor(Color.BLACK);
            linea_une.setStrokeWidth(15);
            linea_une.setStyle(Paint.Style.STROKE);

            canvas.drawLine(400,500,600,500,linea_une);

            linea_delante.setColor(Color.BLACK);
            linea_delante.setStrokeWidth(15);
            linea_delante.setStyle(Paint.Style.STROKE);

            canvas.drawLine(800,500,900,500,linea_delante);

            linea_trasera.setColor(Color.BLACK);
            linea_trasera.setStrokeWidth(15);
            linea_trasera.setStyle(Paint.Style.STROKE);

            canvas.drawLine(200,500,100,500,linea_trasera);

            curva.setColor(Color.BLACK);
            curva.setStrokeWidth(15);
            curva.setStyle(Paint.Style.STROKE);

            canvas.drawRoundRect(1000,500,0,300,800,800,curva);

        }
    }
}

