package com.example.mati.proyectobd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon on 14/01/2017.
 */

public class BDUsuarios extends SQLiteOpenHelper {
    String consulta= "CREATE TABLE Usuarios (usuario TEXT, password TEXT)";


    public BDUsuarios(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
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
        bd.execSQL("DROP TABLE IF EXISTS Usuarios");


        //Creamos la nueva versi�n de la tabla
        bd.execSQL(consulta);

    }

}
