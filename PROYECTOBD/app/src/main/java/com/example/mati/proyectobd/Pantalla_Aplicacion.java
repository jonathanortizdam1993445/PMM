package com.example.mati.proyectobd;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla_Aplicacion extends AppCompatActivity implements Fragment_Dinamico.OnFragmentInteractionListener {

    private Juegos[]listado;
    public ArrayList<Juegos> juegos= new ArrayList<Juegos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_aplicacion);

        CheckBox pc=(CheckBox)findViewById(R.id.caja_pc);
        CheckBox play=(CheckBox)findViewById(R.id.caja_play);
        CheckBox xbox=(CheckBox)findViewById(R.id.caja_xbox);
        Button boton_comprar=(Button)findViewById(R.id.boton_comprar);

        BDJuegos juego = new BDJuegos(this, "DBJuegos", null, 1);

        SQLiteDatabase bd = juego.getWritableDatabase();

        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Mass Effect Andromeda','rol,aventuras','49,99')");
        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('The Witcher 3','RPG,aventuras','9,99')");

        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();

        String[] campos = new String[] {"Titulo", "Genero", "Precio"};
        Cursor c = bd.query("Juegos", campos, null, null, null, null, null);
        listado=new Juegos[c.getCount()];
        int i=0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String titulo = c.getString(0);
                String genero = c.getString(1);
                Double precio=c.getDouble(2);

                listado[i]= new Juegos(titulo,genero,precio);

                i++;

            } while (c.moveToNext());
        }

        AdaptadorJuegos adaptador = new AdaptadorJuegos(this);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo: " + listado[position].getTitulo() + ", Genero: " + listado[position].getGenero()+ ", Precio: " +listado[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bd.close();

        boton_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO PASAR EL TITULO,GENERO Y PRECIO AL FRAGMENT

                //obtener la instancia del administrador de fragmentos
                FragmentManager fragmentmanager =getFragmentManager();

                //crear la transaccion
                FragmentTransaction transaction =fragmentmanager.beginTransaction();

                //crear un nuevo ojbeto de nuestro fragment y añadirlo
                Fragment_Dinamico fragment= new Fragment_Dinamico();
                transaction.add(R.id.activity_pantalla__aplicacion,fragment);

                //confirmar el cambio
                transaction.commit();

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class AdaptadorJuegos extends ArrayAdapter {

        Activity context;

        AdaptadorJuegos(Activity context) {

            super(context, R.layout.juegos, listado);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.juegos, null);

            TextView tit = (TextView) item.findViewById(R.id.juego_titulo);
            tit.setText(listado[i].getTitulo());

            TextView gen = (TextView) item.findViewById(R.id.juego_genero);
            gen.setText(listado[i].getGenero());

            TextView pre = (TextView) item.findViewById(R.id.juego_precio);
            pre.setText(String.valueOf(listado[i].getPrecio()));

            return (item);
        }
    }
}
