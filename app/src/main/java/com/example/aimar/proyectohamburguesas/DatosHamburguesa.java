package com.example.aimar.proyectohamburguesas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private Intent datHamburguesa;
    private Button seguir,salir,aniadir,modificar;
    private int totalhamburguesas;
    private int cantclasica,cantclasiqueso,cantdoble,cantvegetal,cantespecial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidohamburguesa);
        seguir=(Button) findViewById(R.id.btnseguir);
        salir=(Button) findViewById(R.id.salir);
        total = 0;
        totalhamburguesas=0;
        datonombre = (TextView) findViewById(R.id.txtnombrepas);
        datodir = (TextView) findViewById(R.id.txtdirecpas);
        datotlf = (TextView) findViewById(R.id.txttlfpas);
        final Bundle recibedatos = getIntent().getExtras();
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
        totalhamburguesas=0;
        //programamos el comportamiento de los spinner(en nuestro caso cuando elija un tamaño y tipo de carne este se sumara al TOTAL
        edttotal = (EditText) findViewById(R.id.edtTotal);
        aniadir=(Button) findViewById(R.id.btnaniadepedido);
        modificar=(Button) findViewById(R.id.btnmodif);


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

        edtclasica.setSelectAllOnFocus(true);
        edtclasiqueso.setSelectAllOnFocus(true);
        edtdobleq.setSelectAllOnFocus(true);
        edtvegetal.setSelectAllOnFocus(true);
        edtespecial.setSelectAllOnFocus(true);


//añadir las hamburguesas seleccionadas e incrementar el total
        aniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sptamaño.getSelectedItemPosition() == 0 || sptipocarne.getSelectedItemPosition() == 0){
                    Toast.makeText(DatosHamburguesa.this, "Por favor seleccione el tamaño o el tipo de la carne que desee", Toast.LENGTH_SHORT).show();
                    aniadir.setVisibility(View.VISIBLE);
                    modificar.setVisibility(View.GONE);}
                if (edtvegetal.getText().toString().equals("") && edtclasica.getText().toString().equals("") && edtclasiqueso.getText().toString().equals("") && edtdobleq.getText().toString().equals("") && edtespecial.getText().toString().equals("")){
                    Toast.makeText(DatosHamburguesa.this, "Por favor seleccione por lo menos un tipo de hamburguesa", Toast.LENGTH_SHORT).show();
                aniadir.setVisibility(View.VISIBLE);
                modificar.setVisibility(View.GONE);}
                else if (!edtclasica.getText().toString().equals(""))
                    cantclasica = Integer.parseInt(edtclasica.getText().toString()) * 1;
                else
                    cantclasica = 0;
                if (!edtclasiqueso.getText().toString().equals(""))
                    cantclasiqueso = Integer.parseInt(edtclasiqueso.getText().toString()) * 2;
                else
                    cantclasiqueso = 0;
                if (!edtdobleq.getText().toString().equals(""))
                    cantdoble = Integer.parseInt(edtdobleq.getText().toString()) * 2;
                else
                    cantdoble = 0;
                if (!edtvegetal.getText().toString().equals(""))
                    cantvegetal = Integer.parseInt(edtvegetal.getText().toString()) * 2;
                else
                    cantvegetal = 0;
                if (!edtespecial.getText().toString().equals(""))
                    cantespecial = Integer.parseInt(edtespecial.getText().toString()) * 3;
                else
                    cantespecial = 0;

                total = Float.valueOf(edttotal.getText().toString().substring(0, 3)) + (cantclasica + cantclasiqueso + cantdoble + cantvegetal + cantespecial);
                edttotal.setText(total + "€");

                DesactivarControles(edtclasica,edtclasiqueso,edtdobleq,edtvegetal, edtespecial);
                aniadir.setVisibility(View.GONE);
                modificar.setVisibility(View.VISIBLE);

            }
        });
        //modificar el pedido,llevando a la posicion 0 al spinner y los edt volviendolos al valor vacio,mostrar el boton de añadir pedido y ocultar el de modificarlo
modificar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sptipocarne.setSelection(0);
        sptamaño.setSelection(0);
        edtclasica.setText("");
        edtclasiqueso.setText("");
        edtdobleq.setText("");
        edtvegetal.setText("");
        edtespecial.setText("");
        edttotal.setText("");
        ActivarControles(edtclasica,edtclasiqueso,edtdobleq,edtvegetal, edtespecial);
        aniadir.setVisibility(View.VISIBLE);
        modificar.setVisibility(View.GONE);
    }
});



        edttotal.setText(""+total+"€");

        //PROGRAMACION DE LOS BOTONES
        //vamos a instanciar la intent que llamara a la pantalla de bebidas
        datHamburguesa=new Intent(this,pedidobebida.class);
        seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aniadir.getVisibility()==View.VISIBLE)
                    Toast.makeText(DatosHamburguesa.this, "Por favor añada las hamburguesas al pedido antes de continuar", Toast.LENGTH_SHORT).show();
                else{
                datHamburguesa.putExtra("clasica",edtclasica.getText().toString());
                datHamburguesa.putExtra("clasiqueso",edtclasiqueso.getText().toString());
                datHamburguesa.putExtra("dobleq",edtdobleq.getText().toString());
                datHamburguesa.putExtra("vegetal",edtvegetal.getText().toString());
                datHamburguesa.putExtra("especial",edtespecial.getText().toString());
                datHamburguesa.putExtra("nombre", recibedatos.getString("nombre"));
                datHamburguesa.putExtra("direccion",recibedatos.getString("direccion"));
                datHamburguesa.putExtra("tlf",recibedatos.getString("telefono"));
                datHamburguesa.putExtra("total", Float.toString(total));
                datHamburguesa.putExtra("tamanio",sptamaño.getSelectedItem().toString());
                datHamburguesa.putExtra("tcarne",sptipocarne.getSelectedItem().toString());




                startActivity(datHamburguesa);finish();}




            }

        });


        //programacion del boton salir

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        else
        total=total;
        return total;
    }
    public static void DesactivarControles(EditText edtclasica,EditText edtclasiqueso,EditText edtdobleq,EditText edtvegetal,EditText edtespecial){
        edtclasica.setEnabled(false);
        edtclasiqueso.setEnabled(false);
        edtdobleq.setEnabled(false);
        edtvegetal.setEnabled(false);
        edtespecial.setEnabled(false);
    }
    public static void ActivarControles(EditText edtclasica,EditText edtclasiqueso,EditText edtdobleq,EditText edtvegetal,EditText edtespecial){
        edtclasica.setEnabled(true);
        edtclasiqueso.setEnabled(true);
        edtdobleq.setEnabled(true);
        edtvegetal.setEnabled(true);
        edtespecial.setEnabled(true);
    }

}
