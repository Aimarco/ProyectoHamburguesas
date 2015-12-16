package com.example.aimar.proyectohamburguesas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by adminportatil on 10/12/2015.
 */
public class DatosHamburguesa extends AppCompatActivity {
    private TextView datonombre;
    private TextView datodir;
    private TextView datotlf;
    private Spinner sptamaño;
    private Spinner sptipocarne;
    private EditText edttotal, edtclasica, edtdobleq, edtclasiqueso, edtvegetal, edtespecial;
    private float total, totaltipocarne, totaltamanio, clasica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidohamburguesa);
        total = 0;
        datonombre = (TextView) findViewById(R.id.txtnombrepas);
        datodir = (TextView) findViewById(R.id.txtdirecpas);
        datotlf = (TextView) findViewById(R.id.txttlfpas);
        Bundle recibedatos = getIntent().getExtras();
        datonombre.setText(recibedatos.getString("nombre"));
        datodir.setText(recibedatos.getString("direccion"));
        datotlf.setText(recibedatos.getString("telefono"));
        edttotal = (EditText) findViewById(R.id.edtTotal);
        //Declaramos el spinner y el array de valores para cada spinner
        sptamaño = (Spinner) findViewById(R.id.spintamaño);
        sptipocarne = (Spinner) findViewById(R.id.spicarne);
        String[] tamaño = {"Seleccione tamaño de la hamburguesa", "Normal-5,50€", "Whoper-6,50€"};
        sptamaño.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tamaño));
        String[] tcarne = {"Seleccione tipo de carne", "Buey +2€", "Pollo +1€ ", "Ternera +3€"};
        sptipocarne.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tcarne));

        //programamos el comportamiento de los spinner(en nuestro caso cuando elija un tamaño y tipo de carne este se sumara al TOTAL
        edttotal = (EditText) findViewById(R.id.edtTotal);


        sptamaño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                totaltamanio = 0;
                switch (position) {
                    case 0:
                        totaltamanio += 0;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        break;
                    case 1:
                        totaltamanio += 5.50;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");

                        break;

                    case 2:
                        totaltamanio += 6.50;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        break;
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // vacio

            }
        });

//ahora tratamos el comportamiento del spinner del tipo de carne
        sptipocarne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                totaltipocarne = 0;
                switch (position) {
                    case 0:
                        totaltipocarne += 0;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total);
                        break;
                    case 1:
                        totaltipocarne += 2;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        break;

                    case 2:
                        totaltipocarne += 1;
                        //edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        break;
                    case 3:
                        totaltipocarne += 3;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //vacio
            }
        });

        //cambio de valor del edit text Total
        //Vamos a tratar que el usuario cambie el valor de cada una de las hamburguesas posibles
        //para ello usaremos la caracteristica whenever modifying
        edtclasica = (EditText) findViewById(R.id.cantclasica);
        edtclasiqueso = (EditText) findViewById(R.id.cantclasqueso);
        edtdobleq = (EditText) findViewById(R.id.cantdoblequeso);
        edtvegetal = (EditText) findViewById(R.id.cantvegetal);
        edtespecial = (EditText) findViewById(R.id.cantespecial);
        edtclasica.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //vacio
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //vacio
            }

            @Override
            public void afterTextChanged(Editable s) {
                total = calculoTotal(total,Integer.parseInt(edtclasica.getText().toString()),1);
            }
        });

    }


    //funciones de proyecto

    public static float calculaTotal(float ttipo, float ttamanio) {
        float total = 0;
        if (ttipo != 0 || ttamanio != 0)
            total = ttipo + ttamanio;
        else
            total = 0;
        return total;
    }

    //funcion para cambiar valor de total cambiando la hamburguesa seleccionada
    public static float calculoTotal(float total, int cantidad, float precio) {

        if (cantidad != 0)
            total += (cantidad * precio);
        return total;
    }

}
