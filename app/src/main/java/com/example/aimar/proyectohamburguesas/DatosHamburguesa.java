package com.example.aimar.proyectohamburguesas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by adminportatil on 10/12/2015.
 */
public class DatosHamburguesa extends AppCompatActivity {
private TextView datonombre;
    private TextView datodir;
    private TextView datotlf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidohamburguesa);
        datonombre=(TextView) findViewById(R.id.txtnombrepas);
        datodir=(TextView)findViewById(R.id.txtdirecpas);
        datotlf=(TextView) findViewById(R.id.txttlfpas);
        Bundle recibedatos=getIntent().getExtras();
        datonombre.setText(recibedatos.getString("nombre"));
        datodir.setText(recibedatos.getString("direccion"));
        datotlf.setText(recibedatos.getString("telefono"));
    }
}
