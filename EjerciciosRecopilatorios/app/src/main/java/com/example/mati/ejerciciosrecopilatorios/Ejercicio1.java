package com.example.mati.ejerciciosrecopilatorios;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {
    private Destino[] datos= new Destino[]{

            new Destino("ZONA A ","ASIA Y OCEANIA ", "30"),
            new Destino("ZONA B ","AMERICA Y AFRICA ", "20"),
            new Destino("ZONA C ","EUROPA ", "10"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        EditText texto=(EditText) findViewById(R.id.editText);
        Button boton1=(Button)findViewById(R.id.button5);
        ListView lista =(ListView)findViewById(R.id.list);
        RadioGroup grupo=(RadioGroup)findViewById(R.id.radiogroup);
        RadioButton radio1=(RadioButton)findViewById(R.id.radioButton);
        RadioButton radio2=(RadioButton)findViewById(R.id.radioButton2);
        CheckBox caja1=(CheckBox)findViewById(R.id.checkBox);
        CheckBox caja2=(CheckBox)findViewById(R.id.checkBox2);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               TextView texto = (TextView)findViewById(R.id.textView2);

                final String zona=texto.getText().toString();
                final String continente=texto.getText().toString();
                final String precio=texto.getText().toString();

                Intent intento1 = new Intent(Ejercicio1.this,Factura.class);
                Bundle objeto = new Bundle();
                Destino desti = new Destino(zona,continente,precio);

                objeto.putSerializable("FACTURA DETALLADA",desti);
                intento1.putExtras(objeto);
                startActivity(intento1);

            }
        });


        AdaptadorDestino adaptador=new AdaptadorDestino(this);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mensaje="Zona "+datos[i].getZona()+" continente "+datos[i].getContinente()+" Precio "+datos[i].getPrecio();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });

    }

    public class AdaptadorDestino extends ArrayAdapter{
        Activity context;

        AdaptadorDestino(Activity context){
            super(context,R.layout.destino,datos);
            this.context=context;
        }
        public View getView(final int i, View convertview, ViewGroup parent){
            LayoutInflater inflater =context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_factura,null);

            TextView zona=(TextView) item.findViewById(R.id.textView2);
            zona.setText(datos[i].getZona()+datos[i].getContinente()+datos[i].getPrecio());
            return item;
        }

    }



}
