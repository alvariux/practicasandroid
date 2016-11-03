package com.example.tecnologico.listasqlite;

/**
 * Created by tecnologico on 17/10/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;
import java.util.ArrayList;

public class PersonaDB extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT , nombre TEXT,email TEXT,telefono TEXT)";
    public static final String BASE_DATOS = "personas.db";
    public static final int VERSION_DB = 1;

    public PersonaDB(Context contexto) {
        super(contexto,BASE_DATOS , null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS personas");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }

    void agregar(Persona per)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nombre", per.getNombre());
        values.put("telefono", per.getTelefono());
        values.put("email", per.getEmail());

        db.insert("personas", null, values);
        db.close();

    }

    void editar(Persona per)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nombre", per.getNombre());
        values.put("telefono", per.getTelefono());
        values.put("email", per.getEmail());

        db.update("personas", values,"id = ?",new String[] { String.valueOf(per.getId()) });
        db.close();
    }

    void borrar(Persona per)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("personas", "id = ?",
                new String[] { String.valueOf(per.getId()) });
        db.close();
    }

    List<Persona> lista()
    {
        List<Persona> resultado = new ArrayList();
        String query = "SELECT  id,nombre,email,telefono FROM personas";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Persona p = new Persona();
                p.setId(Integer.parseInt(cursor.getString(0)));
                p.setNombre(cursor.getString(1));
                p.setEmail(cursor.getString(2));
                p.setTelefono(cursor.getString(3));

                resultado.add(p);
            } while (cursor.moveToNext());
        }

        db.close();

        return resultado;
    }
}
