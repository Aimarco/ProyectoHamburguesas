package com.example.aimar.proyectohamburguesas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class pedidobebida extends AppCompatActivity {
    private Intent mandadatoscli;
    private TextView total;
    private EditText agua;
    private EditText nestea;
    private EditText limon;
    private EditText naranja;
    private EditText cocacola;
    private EditText cerveza;
    private ImageButton b_agua;
    private ImageButton b_nestea;
    private ImageButton b_limon;
    private ImageButton b_naranja;
    private ImageButton b_cocacola;
    private ImageButton b_cerveza;
    private Button salir;
    private Button siguiente;
    private float totalsum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidobebida);
        total = (TextView) findViewById(R.id.textView5);
        agua = (EditText) findViewById(R.id.editText);
        nestea = (EditText) findViewById(R.id.editText2);
        limon = (EditText) findViewById(R.id.editText3);
        naranja = (EditText) findViewById(R.id.editText4);
        cocacola = (EditText) findViewById(R.id.editText5);
        cerveza = (EditText) findViewById(R.id.editText6);
        b_agua = (ImageButton) findViewById(R.id.imageButton);
        b_nestea = (ImageButton) findViewById(R.id.imageButton2);
        b_limon = (ImageButton) findViewById(R.id.imageButton3);
        b_naranja = (ImageButton) findViewById(R.id.imageButton4);
        b_cocacola = (ImageButton) findViewById(R.id.imageButton5);
        b_cerveza = (ImageButton) findViewById(R.id.imageButton6);
        salir = (Button) findViewById(R.id.btnsalir);
        siguiente = (Button) findViewById(R.id.btnseguir);
        mandadatoscli = new Intent(this, DatosHamburguesa.class);


        b_agua.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                totalsum++;
                total.setText(totalsum + "€");
            }
        });
        b_nestea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                totalsum++;
                total.setText(totalsum + "€");
            }
        });
        b_limon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                totalsum++;
                total.setText(totalsum + "€");
            }
        });
        b_naranja.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                totalsum++;
                total.setText(totalsum + "€");
            }
        });
        b_cocacola.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                totalsum++;
                total.setText(totalsum + "€");
            }
        });
        b_cerveza.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                totalsum = totalsum +2;
                total.setText(totalsum + "€");
            }
        });

    }

}
