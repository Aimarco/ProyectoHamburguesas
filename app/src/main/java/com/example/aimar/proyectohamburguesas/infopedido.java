package com.example.aimar.proyectohamburguesas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by adminportatil on 18/12/2015.
 */
public class infopedido extends AppCompatActivity {
private TextView nombre,direccion,tlf,clasica,clasiqueso,dobleq,vegetal,especial,agua,nestea,limon,naranja,cola,cerveza,total;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infopedido);
        Bundle cogerinfo=getIntent().getExtras();
        nombre=(TextView) findViewById(R.id.nombre);
        direccion=(TextView) findViewById(R.id.direccion);
        tlf=(TextView) findViewById(R.id.telefono);
        clasica=(TextView) findViewById(R.id.clasica);
        clasiqueso=(TextView) findViewById(R.id.clasiqueso);
        dobleq=(TextView) findViewById(R.id.doblequeso);
        vegetal=(TextView) findViewById(R.id.vegetal);
        especial=(TextView) findViewById(R.id.especial);
        limon=(TextView) findViewById(R.id.limon);
        agua=(TextView) findViewById(R.id.agua);
        nestea=(TextView) findViewById(R.id.nestea);
        naranja=(TextView) findViewById(R.id.naranja);
        cola=(TextView) findViewById(R.id.cola);
        cerveza=(TextView) findViewById(R.id.cerveza);
        total=(TextView) findViewById(R.id.total);

        //asignamos valor a todos los TextView mediante elpase de Extras de la Intent
        nombre.setText(cogerinfo.getString("nombre"));
        direccion.setText(cogerinfo.getString("direccion"));
        tlf.setText(cogerinfo.getString("tlf"));
        clasica.setText(clasica.getText()+""+cogerinfo.getString("clasica"));
        clasiqueso.setText(clasiqueso.getText()+""+cogerinfo.getString("clasiqueso"));
        dobleq.setText(dobleq.getText()+""+cogerinfo.getString("dobleq"));
        vegetal.setText(vegetal.getText()+""+cogerinfo.getString("vegetal"));
        especial.setText(especial.getText()+""+cogerinfo.getString("especial"));
        agua.setText(cogerinfo.getString("agua"));
        nestea.setText(cogerinfo.getString("nestea"));
        limon.setText(cogerinfo.getString("limon"));
        naranja.setText(cogerinfo.getString("naranja"));
        cola.setText(cogerinfo.getString("cocacola"));
        cerveza.setText(cogerinfo.getString("cerveza"));
        total.setText(cogerinfo.getString("total"));








    }


}
