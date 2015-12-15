package com.example.aimar.proyectohamburguesas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private EditText edttotal;
    private float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidohamburguesa);
        total=0;
        datonombre = (TextView) findViewById(R.id.txtnombrepas);
        datodir = (TextView) findViewById(R.id.txtdirecpas);
        datotlf = (TextView) findViewById(R.id.txttlfpas);
        Bundle recibedatos = getIntent().getExtras();
        datonombre.setText(recibedatos.getString("nombre"));
        datodir.setText(recibedatos.getString("direccion"));
        datotlf.setText(recibedatos.getString("telefono"));

        //Declaramos el spinner y el array de valores para cada spinner
        sptamaño = (Spinner) findViewById(R.id.spintamaño);
        sptipocarne = (Spinner) findViewById(R.id.spicarne);
        String[] tamaño = {"","Normal-5,50€", "Whoper-6,50€"};
        sptamaño.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tamaño));
        String[] tcarne={"","Buey +2€","Pollo +1€ ","Ternera +3€"};
        sptipocarne.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tcarne));

        //programamos el comportamiento de los spinner(en nuestro caso cuando elija un tamaño y tipo de carne este se sumara al TOTAL
        edttotal=(EditText) findViewById(R.id.edtTotal);

        sptamaño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 1:
                        total += 5.50;
                       // edttotal.setText("" + total);
                        break;

                    case 2:
                        total += 6.50;
                       // edttotal.setText("" + total);
                        break;
                }
                edttotal.setText("" + total);

            }
    public void onNothingSelected(AdapterView<?> parent)
    {
        // vacio

    }
});

//ahora tratamos el comportamiento del spinner del tipo de carne
        sptipocarne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        total += 2;
                       // edttotal.setText("" + total);
                        break;

                    case 2:
                        total += 1;
                        //edttotal.setText("" + total);
                        break;
                    case 3:
                        total+=3;
                       // edttotal.setText("" + total);
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    //vacio
            }
        });

    }
}
