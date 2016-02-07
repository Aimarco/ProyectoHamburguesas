package com.example.aimar.proyectohamburguesas;

/**
 * Created by Aimar&Diego
 */

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
    //instanciacion de Objetos necasario
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
    private Bebidas b;
    private hamburguesas h;
    private Personas p;
//find e instanciacion de objetos necesarios



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Inicializacion de elementos instanciados
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
        b=new Bebidas();
        Intent i=getIntent();
        h=new hamburguesas();
        h=(hamburguesas) i.getSerializableExtra("hamburguesas");
        p=(Personas) i.getSerializableExtra("persona");
        //fin inicialización

        //Programación de los imageButton de cada una de las bebidas
        b_agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalagua;
                totalsum++;
                totalagua = totalsum;
                aguacont++;
                total.setText(totalagua + "€");
                texto();
                b.setAgua(aguacont);

            }
        });
        b_nestea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                nesteacont++;
                total.setText(totalsum + "€");
                texto();
                b.setNestea(nesteacont);
            }
        });
        b_limon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                limoncont++;
                total.setText(totalsum + "€");
                texto();
                b.setLimon(limoncont);


            }
        });
        b_naranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                naranjacont++;
                total.setText(totalsum + "€");
                texto();
                b.setNaranja(naranjacont);


            }
        });
        b_cocacola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum++;
                cocacolacont++;
                total.setText(totalsum + "€");
                texto();
                b.setCocacola(cocacolacont);
            }
        });

        b_cerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalsum = totalsum + 2;
                cervezacont++;
                total.setText(totalsum + "€");
                texto();
                b.setCerveza(cervezacont);
            }
        });

        //fin programación ImageButton de bebidas

        //Programación del boton de borrar las pedidas seleccionadas
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
            //Mandar datos de hamburguesas y bebidas
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setTotalb(totalsum);
                if(aguacont!=0 || nesteacont!=0 || limoncont!=0 || naranjacont!=0 || cocacolacont!=0 || cervezacont!=0){
                intent.putExtra("bebidas", b);
                intent.putExtra("hamburguesas",h);
                intent.putExtra("persona",p);
                startActivity(intent);
                finish();}
                else
                Toast.makeText(pedidobebida.this, "Por favor,seleccione al menos una bebida", Toast.LENGTH_SHORT).show();

            }
        });


    }
    //Gracias a este metodo,imprimimos el texto debajo de los imageButton
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
