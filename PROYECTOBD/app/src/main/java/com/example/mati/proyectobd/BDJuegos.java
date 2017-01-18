package com.example.mati.proyectobd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon on 16/01/2017.
 */

public class BDJuegos extends SQLiteOpenHelper {
    String consulta= "CREATE TABLE Juegos (Titulo TEXT, Genero TEXT, Precio DOUBLE)";


    public BDJuegos(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase bd) {
        //Ejecutamos la sentencia SQL para crear la tabla Usuarios y Juegos
        //El metodo execSQL se limita a ejecutar directamente el codigo SQL que le pasemos.
        bd.execSQL(consulta);

    }

    //Este metodo se lanza automaticamente cuando es necesaria una actualizacion de la estructura
    //de la base de datos o una conversion de los datos.
    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        //NOTA: Para simplificar este ejemplo eliminamos la tabla anterior y la creamos de nuevo
        //		con el nuevo formato.
        //		Lo normal sera realizar una migracion o traspaso de los datos de la tabla antigua
        //		a la nueva, con la consiguiente complicacion que ello conlleva.

        //Eliminamos la version anterior de la tabla
        bd.execSQL("DROP TABLE IF EXISTS Juegos");


        //Creamos la nueva versi�n de la tabla
        bd.execSQL(consulta);

    }
}
