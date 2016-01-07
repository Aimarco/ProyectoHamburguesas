package com.example.aimar.proyectohamburguesas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class pedidobebida extends AppCompatActivity {
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
    private Button borrar;
    private int totalsum = 0;
    private int aguacont=0;
    private int nesteacont=0;
    private int limoncont=0;
    private int naranjacont=0;
    private int cocacolacont=0;
    private int cervezacont=0;
    private Intent intent;




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
        borrar = (Button)findViewById(R.id.button3);
        salir = (Button) findViewById(R.id.button);
        siguiente = (Button) findViewById(R.id.button2);
        intent = new Intent(this, infopedido.class);
        final Bundle recibedatos = getIntent().getExtras();

        b_agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalagua;
                totalsum++;
                totalagua = totalsum;
                aguacont++;
                total.setText(totalagua + "€");
                String cont = Integer.toString(aguacont);
                agua.setText(cont);

            }
        });
        b_nestea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                nesteacont++;
                total.setText(totalsum + "€");
                String cont = Integer.toString(nesteacont);
                nestea.setText(cont);
            }
        });
        b_limon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                limoncont++;
                total.setText(totalsum + "€");
                String cont = Integer.toString(limoncont);
                limon.setText(cont);


            }
        });
        b_naranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                naranjacont++;
                total.setText(totalsum + "€");
                String cont = Integer.toString(naranjacont);
                naranja.setText(cont);


            }
        });
        b_cocacola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                cocacolacont++;
                total.setText(totalsum + "€");
                String cont = Integer.toString(cocacolacont);
                cocacola.setText(cont);


            }
        });

        b_cerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum = totalsum + 2;
                cervezacont++;
                total.setText(totalsum + "€");
                String cont = Integer.toString(cervezacont);
                cerveza.setText(cont);


            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum = 0;
                aguacont=0;
                nesteacont=0;
                limoncont=0;
                naranjacont=0;
                cocacolacont=0;
                cervezacont=0;
                agua.setText("");
                nestea.setText("");
                limon.setText("");
                naranja.setText("");
                cocacola.setText("");
                cerveza.setText("");
                total.setText("0 €");
                Toast.makeText(getApplicationContext(), "Se han borrado las bebidas", Toast.LENGTH_SHORT).show();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("agua", aguacont);
                intent.putExtra("nestea", nesteacont);
                intent.putExtra("limon", limoncont);
                intent.putExtra("naranja", naranjacont);
                intent.putExtra("cocacola",cocacolacont);
                intent.putExtra("cerveza", cervezacont);
                intent.putExtra("clasica",recibedatos.getString("clasica"));
                intent.putExtra("clasiqueso",recibedatos.getString("clasiqueso"));
                intent.putExtra("dobleq",recibedatos.getString("dobleq"));
                intent.putExtra("vegetal",recibedatos.getString("vegetal"));
                intent.putExtra("especial",recibedatos.getString("especial"));
                intent.putExtra("nombre", recibedatos.getString("nombre"));
                intent.putExtra("direccion",recibedatos.getString("direccion"));
                intent.putExtra("tlf",recibedatos.getString("tlf"));
                intent.putExtra("total",(recibedatos.getString("total")+total.toString()));
                startActivity(intent);

            }
        });

    }

}
