package com.example.aimar.proyectohamburguesas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class pedidobebida extends AppCompatActivity {
    private TextView total;
    private TextView fact;
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
        fact = (TextView) findViewById(R.id.textView9);
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
                texto();

            }
        });
        b_nestea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                nesteacont++;
                total.setText(totalsum + "€");
                texto();
            }
        });
        b_limon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                limoncont++;
                total.setText(totalsum + "€");
                texto();


            }
        });
        b_naranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                naranjacont++;
                total.setText(totalsum + "€");
                texto();


            }
        });
        b_cocacola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                cocacolacont++;
                total.setText(totalsum + "€");
                texto();
            }
        });

        b_cerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum = totalsum + 2;
                cervezacont++;
                total.setText(totalsum + "€");
                texto();
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
                fact.setText("");
                total.setText("0 €");
                Toast.makeText(getApplicationContext(), "Se han borrado las bebidas", Toast.LENGTH_SHORT).show();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalham= Integer.parseInt(recibedatos.getString("total")+total.toString());
                int total2= totalham + totalsum;

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
                intent.putExtra("total",total2);
                startActivity(intent);

            }
        });


    }
    public void texto(){
        String cadena= "";
        String cont;
        if (aguacont!=0){
            cont = Integer.toString(aguacont);
            cadena=cadena+(" agua: "+cont+"\n");
        }
        if (nesteacont!=0){
            cont = Integer.toString(nesteacont);
            cadena+=(" nestea: "+cont+"\n");
        }
        if (limoncont!=0){
            cont = Integer.toString(limoncont);
            cadena+=(" limon: "+cont+"\n");
        }
        if (naranjacont!=0){
            cont = Integer.toString(naranjacont);
            cadena+=(" naranja: "+cont+"\n");
        }
        if (cocacolacont!=0){
            cont = Integer.toString(cocacolacont);
            cadena+=(" cocacola: "+cont+"\n");
        }
        if (cervezacont!=0){
            cont = Integer.toString(cervezacont);
            cadena+=(" cerveza: "+cont+"\n");
        }
        fact.setText(cadena);
    }
    public void salir(View view){
        finish();
    }
}
