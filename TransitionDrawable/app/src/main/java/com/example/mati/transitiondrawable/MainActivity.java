package com.example.mati.transitiondrawable;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imagen = new ImageView(this);
        setContentView(imagen);

        TransitionDrawable transicion = (TransitionDrawable) getResources().getDrawable(R.drawable.mi_transicion,null);
        imagen.setImageDrawable(transicion);
        transicion.startTransition(5000);
    }


}
