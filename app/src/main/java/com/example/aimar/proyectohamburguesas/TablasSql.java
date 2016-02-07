package com.example.aimar.proyectohamburguesas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adminportatil on 28/01/2016.
 */
public class TablasSql extends SQLiteOpenHelper {


    String sqlclientes="Create table Clientes(cliente_id INTEGER PRIMARY KEY,nombre TEXT,direccion TEXT,telefono INTEGER,pedido_id INTEGER," +
            "foreign key(pedido_id) references pedidos(pedido_id))";
    String sqlPedido="Create table pedidos (pedido_id INTEGER primary key,comida TEXT,bebida TEXT,total real,cliente_id Integer, foreign key(cliente_id) references Clientes(cliente_id))";


    public TablasSql(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlclientes);
        db.execSQL(sqlPedido);
        ContentValues cliente = new ContentValues();
        cliente.put("nombre", "aimar");
        cliente.put("direccion", "calle larraundi");
        cliente.put("telefono", 943352514);
        cliente.put("pedido_id", 0);
        db.insert("Clientes",null,cliente);



    }
    public void onUpgrade(SQLiteDatabase db,int versionanterior,int versionnueva){
        //vacio
    }
}
