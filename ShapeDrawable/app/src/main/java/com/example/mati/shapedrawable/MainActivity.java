package com.example.mati.shapedrawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VistaAMedida(this));
    }

    public class VistaAMedida extends View{
        private ShapeDrawable midrawable;
        public VistaAMedida(Context context){
            super(context);
            int x=10, y=10;
            int ancho=300, alto=50;
            midrawable = new ShapeDrawable(new OvalShape());
            midrawable.getPaint().setColor(0xff0000ff);
            midrawable.setBounds(x,y,x+ancho,y+alto);
        }

        protected void onDraw(Canvas canvas){
            midrawable.draw(canvas);
        }
    }
}
