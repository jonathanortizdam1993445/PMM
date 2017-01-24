package com.herprogramacion.mytechs.modelo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Content Provider personalizado para las actividades
 */
public class TechsProvider extends ContentProvider {
    /**
     * Nombre de la base de datos
     */
    private static final String DATABASE_NAME = "techs.db";
    /**
     * Versión actual de la base de datos
     */
    private static final int DATABASE_VERSION = 1;
    /**
     * Instancia del administrado de BD
     */
    private DatabaseHelper databaseHelper;

    @Override
    public boolean onCreate() {
        // Inicializando gestor BD
        databaseHelper = new DatabaseHelper(
                getContext(),
                DATABASE_NAME,
                null,
                DATABASE_VERSION
        );

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {


        // Obtener base de datos
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        // Comparar Uri
        int match = TechsContract.uriMatcher.match(uri);

        Cursor c;

        switch (match) {
            case TechsContract.ALLROWS:
                // Consultando todos los registros
                c = db.query(TechsContract.ACTIVIDAD, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(
                        getContext().getContentResolver(),
                        TechsContract.CONTENT_URI);
                break;
            case TechsContract.SINGLE_ROW:
                // Consultando un solo registro basado en el Id del Uri
                long videoID = ContentUris.parseId(uri);
                c = db.query(TechsContract.ACTIVIDAD, projection,
                        TechsContract.Columnas._ID + " = " + videoID,
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(
                        getContext().getContentResolver(),
                        TechsContract.CONTENT_URI);
                break;
            default:
                throw new IllegalArgumentException("URI no soportada: " + uri);
        }
        return c;

    }

    @Override
    public String getType(Uri uri) {
        switch (TechsContract.uriMatcher.match(uri)) {
            case TechsContract.ALLROWS:
                return TechsContract.MULTIPLE_MIME;
            case TechsContract.SINGLE_ROW:
                return TechsContract.SINGLE_MIME;
            default:
                throw new IllegalArgumentException("Tipo de actividad desconocida: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // Validar la uri
        if (TechsContract.uriMatcher.match(uri) != TechsContract.ALLROWS) {
            throw new IllegalArgumentException("URI desconocida : " + uri);
        }
        ContentValues contentValues;
        if (values != null) {
            contentValues = new ContentValues(values);
        } else {
            contentValues = new ContentValues();
        }

        // Si es necesario, verifica los valores

        // Inserción de nueva fila
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long rowId = db.insert(TechsContract.ACTIVIDAD,
                null, contentValues);
        if (rowId > 0) {
            Uri uri_actividad =
                    ContentUris.withAppendedId(
                            TechsContract.CONTENT_URI, rowId);
            getContext().getContentResolver().
                    notifyChange(uri_actividad, null);
            return uri_actividad;
        }
        throw new SQLException("Falla al insertar fila en : " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        int match = TechsContract.uriMatcher.match(uri);
        int affected;

        switch (match) {
            case TechsContract.ALLROWS:
                affected = db.delete(TechsContract.ACTIVIDAD,
                        selection,
                        selectionArgs);
                break;
            case TechsContract.SINGLE_ROW:
                long videoId = ContentUris.parseId(uri);
                affected = db.delete(TechsContract.ACTIVIDAD,
                        TechsContract.Columnas._ID + "=" + videoId
                                + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs);
                // Notificar cambio asociado a la uri
                getContext().getContentResolver().
                        notifyChange(uri, null);
                break;
            default:
                throw new IllegalArgumentException("Elemento actividad desconocido: " +
                        uri);
        }
        return affected;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int affected;
        switch (TechsContract.uriMatcher.match(uri)) {
            case TechsContract.ALLROWS:
                affected = db.update(TechsContract.ACTIVIDAD, values,
                        selection, selectionArgs);
                break;
            case TechsContract.SINGLE_ROW:
                String videoId = uri.getPathSegments().get(1);
                affected = db.update(TechsContract.ACTIVIDAD, values,
                        TechsContract.Columnas._ID + "=" + videoId
                                + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("URI desconocida: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return affected;
    }

}

