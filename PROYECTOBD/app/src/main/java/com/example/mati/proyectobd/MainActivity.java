package com.example.mati.proyectobd;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BDUsuarios cliBDh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button entrar= (Button)findViewById(R.id.Entrar);
        Button formulario= (Button)findViewById(R.id.ir_a_registro);
        final EditText verificar_usuario=(EditText)findViewById(R.id.verificar_usuario);
        final EditText verificar_contraseña=(EditText)findViewById(R.id.verificar_contraseña);

        
        cliBDh = new BDUsuarios(this, "Usuarios", null, 1);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificar si el usuario y contraseña está en la bd, si es asi, puede entrar dentro
                //Abrimos la base de datos en modo escritura
                SQLiteDatabase bd = cliBDh.getWritableDatabase();

                //guardamos los datos introducido en la variables
                String usuario=verificar_usuario.getText().toString();
                String contraseña=verificar_contraseña.getText().toString();

                Cursor fila=bd.rawQuery("SELECT usuario,password FROM Usuarios WHERE usuario='"+usuario+"' and password='"+contraseña+"'",null);

                //para que se coloque en el principio
                if(fila.moveToFirst()) {
                    //capturamos los valores del cursos y lo almacenamos en variable
                    String usu = fila.getString(0);
                    String pass = fila.getString(1);


                    //preguntamos si los datos ingresados son iguales, si coinciden con los almacenados en la bd, puede pasar a la aplicacion
                    //si son iguales entonces vamos a otra ventana
                    if (usuario.equals(usu)&&contraseña.equals(pass)) {
                        Intent adelante= new Intent(MainActivity.this,Pantalla_Aplicacion.class);
                        adelante.putExtra("usuario", usu);
                        startActivity(adelante);


                        
                    }else {
                        //String mensaje="Error: usuario o contraseña incorrecta. Vuelva a intentarlo.";
                        Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta.Vuelva a intentarlo",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ir a formulario de registro
                Intent ventana = new Intent(MainActivity.this,Pantalla_Registro.class);
                startActivity(ventana);
            }
        });

    }
}
