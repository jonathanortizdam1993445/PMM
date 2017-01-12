package com.example.mati.bdspinner;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Clientes[] datos=new Clientes[]{
            new Clientes("pepe","123")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

       // bd.execSQL("INSERT INTO Clientes (nombre, telefono) VALUES ('cli1','11111')");
       // bd.execSQL("INSERT INTO Clientes (nombre, telefono) VALUES ('cli2','22222')");

        String[] args3 = new String[]{"cli1,cli2"};
        Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);

        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String nombreCli = c.getString(0);
                String telefonoCli = c.getString(1);
            } while (c.moveToNext());
        }

        bd.close();


        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setAdapter(adaptador);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Nombre " + datos[position].getNombre() + " Telefono: " + datos[position].getTelf();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public class AdaptadorTitulares extends ArrayAdapter {

        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.clientes, datos);
            this.context = context;
        }


        public View getDropDownView(final int position, View convertview, ViewGroup parent) {
            View vistadesplegada = getView(position, convertview, parent);

            return vistadesplegada;

        }

        public View getView(int i, View convertView, ViewGroup parent) {

            View item = convertView;
            if (item == null) {

                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.clientes, null);
            }
            TextView nom = (TextView) item.findViewById(R.id.nombre);
            nom.setText(datos[i].getNombre());

            TextView subtitulo = (TextView) item.findViewById(R.id.telefono);
            subtitulo.setText(datos[i].getTelf());

            return item;
        }
    }
}