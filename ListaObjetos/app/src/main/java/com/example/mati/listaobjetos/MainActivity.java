package com.example.mati.listaobjetos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos =new Titular[]{
            new Titular("Titulo 1","subtitulo largo 1",R.drawable.android),
            new Titular("Titulo 2","subtitulo largo 2",R.drawable.android),
            new Titular("Titulo 3","subtitulo largo 3",R.drawable.android),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje="Titulo:" +datos[position].getTitulo()+"Subtitulo:"+datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();

            }

            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
    }

    public class AdaptadorTitulares extends ArrayAdapter{
        Activity context;
        AdaptadorTitulares(Activity context){
            super(context,R.layout.activity_titular,datos);
            this.context=context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_titular,null);

            TextView titulo = (TextView) item.findViewById(R.id.titulo);
            titulo.setText(datos[i].getTitulo());

            TextView subtitulo = (TextView) item.findViewById(R.id.subtitulo);
            subtitulo.setText(datos[i].getSubtitulo());

            ImageView imagen =(ImageView) item.findViewById(R.id.imagen);
            imagen.setBackground(getDrawable(datos[i].getView()));

            return item;
        }

    }

}
