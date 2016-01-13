package com.example.aimar.proyectohamburguesas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosCliente extends AppCompatActivity {
    private EditText nombre;
    private EditText direccion;
    private EditText telefono;
    private Intent mandadatoscli;
    private Button salir;
    private Button seguir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
        nombre = (EditText) findViewById(R.id.edtnombre);
        direccion = (EditText) findViewById(R.id.edtdireccion);
        telefono = (EditText) findViewById(R.id.edttlf);
        salir = (Button) findViewById(R.id.btnsalir);
        seguir = (Button) findViewById(R.id.btnseguir);
        mandadatoscli = new Intent(this, DatosHamburguesa.class);

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
    }
}
