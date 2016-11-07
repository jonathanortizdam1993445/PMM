package com.example.mati.shapedrawable2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mati on 7/11/16.
 */

public class VistaAMedida extends View {

    private ShapeDrawable midrawable;

    public VistaAMedida(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public VistaAMedida(Context context){
        super(context);

    }

    protected void onDraw(Canvas canvas){

        int x=10, y=10;
        int ancho=300, alto=50;
        midrawable = new ShapeDrawable(new OvalShape());
        midrawable.getPaint().setColor(0xff0000ff);
        midrawable.setBounds(x,y,x+ancho,y+alto);

        midrawable.draw(canvas);
    }
}

