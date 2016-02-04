package com.example.aimar.proyectohamburguesas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adminportatil on 28/01/2016.
 */
public class TablasSql extends SQLiteOpenHelper {


    String sqlclientes="Create table Clientes(cliente_id INTEGER primary key ,nombre TEXT,direccion TEXT,telefono INTEGER,pedido_id INTEGER," +
            "foreign key(pedido_id) references pedidos(pedido_id))";
    String sqlPedido="Create table pedidos (pedido_id INTEGER primary key,comida TEXT,bebida TEXT,total real,cliente_id Integer, foreign key(cliente_id) references Clientes(cliente_id))";
    String inserprueba="Insert into Clientes values(1,'aimar','calle larraundi',943352514,1)";

    public TablasSql(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(sqlclientes);
        db.execSQL(sqlPedido);
        db.execSQL(inserprueba);



    }
    public void onUpgrade(SQLiteDatabase db,int versionanterior,int versionnueva){
        //vacio
    }
}
