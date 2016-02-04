package com.example.aimar.proyectohamburguesas;


/**
 * Created by Aimar&Diego
 */

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class DatosCliente extends AppCompatActivity {
    private EditText nombre;
    private EditText direccion;
    private EditText telefono;
    private Intent mandadatoscli,datosapp;
    private Button salir,buscar,seguir;
    private ImageButton imgInfo;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
        //Objetos necesarios para la creacion de BBDD
        TablasSql tablas=new TablasSql(this,"DB2DM3burguer",null,1);
        db=tablas.getWritableDatabase();
        //Validación de si la BBDD se ha creado correctamente
       /* if(db!=null)
            Toast.makeText(DatosCliente.this, "BBDD creada correctamente", Toast.LENGTH_SHORT).show();*/

        nombre = (EditText) findViewById(R.id.edtnombre);
        direccion = (EditText) findViewById(R.id.edtdireccion);
        telefono = (EditText) findViewById(R.id.edttlf);
        salir = (Button) findViewById(R.id.btnsalir);
        seguir = (Button) findViewById(R.id.btnseguir);
        mandadatoscli = new Intent(this, DatosHamburguesa.class);
        imgInfo=(ImageButton) findViewById(R.id.imgbinfo);
        datosapp=new Intent(this,DatosApp.class);
        buscar=(Button) findViewById(R.id.btnbuscarcli);



        //Programacion de botones Seguir y Salir Con validaciones en los 3 campos

        seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().length() > 0) {
                    if (direccion.getText().toString().length() > 0) {
                        if (telefono.getText().length() == 9) {
                            mandadatoscli.putExtra("nombre", nombre.getText().toString());
                            mandadatoscli.putExtra("direccion", direccion.getText().toString());
                            mandadatoscli.putExtra("telefono", telefono.getText().toString());
                            startActivity(mandadatoscli);
                            finish();
                        } else {
                            telefono.setError("Tiene que tener 9 números");
                            Toast.makeText(DatosCliente.this, "Rellene los datos correctamente por favor", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        direccion.setError("Campo de la direción vacio");
                        Toast.makeText(DatosCliente.this, "Rellene los datos correctamente por favor", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    nombre.setError("Campo del nombre vacio");
                    Toast.makeText(DatosCliente.this, "Rellene los datos correctamente por favor", Toast.LENGTH_SHORT).show();
                }
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(datosapp);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descri = nombre.toString();
                String[] buscnombre=new String[] {nombre.getText().toString()};
                Cursor fila = db.rawQuery("select nombre,direccion,telefono from Clientes where nombre like ?" ,buscnombre,null);
                if (fila.moveToFirst()) {
                    nombre.setText(fila.getString(0));
                    direccion.setText(fila.getString(1));
                    telefono.setText(fila.getString(2));
                    buscar.setVisibility(View.GONE);
                }
                else
                    Toast.makeText(DatosCliente.this, "No existen clientes con ese nombre", Toast.LENGTH_SHORT).show();
                fila.close();
                db.close();
            }
        });
    }
}
