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
import com.example.aimar.proyectohamburguesas.hamburguesas;

/**
 * Created by Aimar&Diego
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
    private int cantclasica,cantclasiqueso,cantdoble,cantvegetal,cantespecial;
    private hamburguesas h;
    private Personas p;

    //fin de la declaración de elementos necesarios

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidohamburguesa);

        Intent i=getIntent();
        p=new Personas();
        p=(Personas) i.getSerializableExtra("persona");
        seguir=(Button) findViewById(R.id.btnseguir);
        salir=(Button) findViewById(R.id.salir);
        total = 0;
        datonombre = (TextView) findViewById(R.id.txtnombrepas);
        datodir = (TextView) findViewById(R.id.txtdirecpas);
        datotlf = (TextView) findViewById(R.id.txttlfpas);
        final Bundle recibedatos = getIntent().getExtras();
        datonombre.setText(""+p.getNombre());
        datodir.setText(""+p.getDireccion());
        datotlf.setText(""+p.getTelefono());
        edttotal = (EditText) findViewById(R.id.edtTotal);
        aniadir=(Button) findViewById(R.id.btnaniadepedido);
        modificar=(Button) findViewById(R.id.btnmodif);
        h=new hamburguesas();

        //Declaramos el spinner y el array de valores para cada spinner

        sptamaño = (Spinner) findViewById(R.id.spintamaño);
        sptipocarne = (Spinner) findViewById(R.id.spicarne);
        String[] tamaño = {"Seleccione tamaño de la hamburguesa", "Normal-5,50€", "Whoper-6,50€"};
        sptamaño.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tamaño));
        String[] tcarne = {"Seleccione tipo de carne", "Buey +2€", "Pollo +1€ ", "Ternera +3€"};
        sptipocarne.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tcarne));


        //fin de la inicialización de los elementos arriba declarados.

        //Programaremos el comportamiento de los spinner,para que cuando cambie el valor de cada uno de ellos
        //automaticamente su precio se sume al total

        sptamaño.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                totaltamanio = 0;
                switch (position) {
                    case 0:             //Caso del texto informativo
                        totaltamanio += 0;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        break;
                    case 1:             //Caso del tamaño grande,incrementa 5,5
                        totaltamanio += 5.50;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        h.setTamaño(1);

                        break;

                    case 2:             //Caso de tamaño Whoper incrementa 6.5
                        totaltamanio += 6.50;
                        // edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        h.setTamaño(2);
                        break;
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
                // vacio

            }
        });

//Repetiremos el proceso anterior pero con el spinner deñ tipo de carne
        sptipocarne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                totaltipocarne = 0;
                switch (position) {
                    case 0:
                        totaltipocarne += 0;
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total);

                        break;
                    case 1:
                        totaltipocarne += 2;
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        h.setTipoc(1);
                        break;

                    case 2:
                        totaltipocarne += 1;
                        //edttotal.setText("" + total);
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        h.setTipoc(2);
                        break;
                    case 3:
                        totaltipocarne += 3;
                        total = calculaTotal(totaltipocarne, totaltamanio);
                        edttotal.setText("" + total + "€");
                        h.setTipoc(3);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //vacio
            }
        });

        //Instanciamos los cuadros de texto en el cual especificara el usuario la cantidad de las hamburguesas
        edtclasica = (EditText) findViewById(R.id.cantclasica);
        edtclasiqueso = (EditText) findViewById(R.id.cantclasqueso);
        edtdobleq = (EditText) findViewById(R.id.cantdoblequeso);
        edtvegetal = (EditText) findViewById(R.id.cantvegetal);
        edtespecial = (EditText) findViewById(R.id.cantespecial);

        //fin de la instanciacion de los cuadros de texto

//A continuacion vamos a especificar las acciones del boton que dice:"Añadir a pedido",sin pulsar este boton no se podra seguir a delante
        /*Comportamiento
        --Cuando pulsas el boton de "añadir a pedido" este verifica que por lo menos una hamburguesa ha sido elegida
        --si al menos 1 ha sido elegida y clicas en seguir,no te dejara sin antes pulsar el boton de añadir
        --Al pulsar en añadir el boton de añadir a pedido se ocultara y aparecera un boton para modificar el pedido y los cuadros de texto
         quedaran deshabilitados
        --Al hacer click en el boton de modificar,los cuadros de texto vuelven a estar activos y desaparece el boton de modificar
        apareciendo en su lugar el boton de añadir

        */
        aniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sptamaño.getSelectedItemPosition() == 0 || sptipocarne.getSelectedItemPosition() == 0) {
                    Toast.makeText(DatosHamburguesa.this, "Por favor seleccione el tamaño o el tipo de la carne que desee", Toast.LENGTH_SHORT).show();
                    aniadir.setVisibility(View.VISIBLE);
                    modificar.setVisibility(View.GONE);}
                else{
                    if (edtvegetal.getText().toString().equals("") && edtclasica.getText().toString().equals("") && edtclasiqueso.getText().toString().equals("") && edtdobleq.getText().toString().equals("") && edtespecial.getText().toString().equals("")) {
                        Toast.makeText(DatosHamburguesa.this, "Por favor seleccione por lo menos un tipo de hamburguesa", Toast.LENGTH_SHORT).show();
                        //aniadir.setVisibility(View.VISIBLE);
                        //modificar.setVisibility(View.GONE);
                    } else {
                        cantclasica = 0;
                        if (!edtclasica.getText().toString().equals("")){
                            cantclasica = Integer.parseInt(edtclasica.getText().toString()) * 1;
                            h.setClasica(Integer.parseInt(edtclasica.getText().toString()));}
                        if (!edtclasiqueso.getText().toString().equals("")){
                            cantclasiqueso = Integer.parseInt(edtclasiqueso.getText().toString()) * 2;
                            h.setClasiqueso(Integer.parseInt(edtclasiqueso.getText().toString()));}
                        else
                            cantclasiqueso = 0;
                        if (!edtdobleq.getText().toString().equals("")){
                            cantdoble = Integer.parseInt(edtdobleq.getText().toString()) * 2;
                            h.setDobleq(Integer.parseInt(edtdobleq.getText().toString()));}
                        else
                            cantdoble = 0;
                        if (!edtvegetal.getText().toString().equals("")){
                            cantvegetal = Integer.parseInt(edtvegetal.getText().toString()) * 2;
                            h.setVegetal(Integer.parseInt(edtvegetal.getText().toString()));}
                        else
                            cantvegetal = 0;
                        if (!edtespecial.getText().toString().equals("")){
                            cantespecial = Integer.parseInt(edtespecial.getText().toString()) * 3;
                            h.setEspecial(Integer.parseInt(edtespecial.getText().toString()));}
                        else
                            cantespecial = 0;

                        total = Float.valueOf(edttotal.getText().toString().substring(0, 3)) + (cantclasica + cantclasiqueso + cantdoble + cantvegetal + cantespecial);
                        edttotal.setText(total + "€");
                       h.setTotalh(total);

                        DesactivarControles(edtclasica, edtclasiqueso, edtdobleq, edtvegetal, edtespecial);
                        aniadir.setVisibility(View.GONE);
                        modificar.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        //modificar el pedido,llevando a la posicion 0 al spinner y los edt volviendolos al valor vacio,mostrar el boton de añadir pedido y ocultar el de modificarlo
modificar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sptipocarne.setSelection(0);
        sptamaño.setSelection(0);
        ActivarControles(edtclasica,edtclasiqueso,edtdobleq,edtvegetal, edtespecial,edttotal);
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
                    /*
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
                datHamburguesa.putExtra("tcarne",sptipocarne.getSelectedItem().toString());*/
                    datHamburguesa.putExtra("hamburguesas",h);
                    datHamburguesa.putExtra("persona",p);



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
    //A esta fincion se le pasa como parametro el tipo de hamburguesa que es y el tamaño para hacer el calculo
    public static float calculaTotal(float ttipo, float ttamanio) {
        float total = 0;
        if (ttipo != 0 || ttamanio != 0)
            total = ttipo + ttamanio;
        else
            total = 0;
        return total;
    }

    /*funcion para cambiar valor de total cambiando la hamburguesa seleccionada
    a este metodo se le pasa como parametro el total actual la cantidad de la hamburguesa seleccionada y el precio de esta
    para hacer el calculo del nuevo total*/
    public static float calculoTotal(float total, int cantidad, float precio) {

        if (cantidad != 0)
            total += (cantidad * precio);
        else
        total=total;
        return total;
    }
    //Mediante este metodo desactivamos los controles de los campos de texto para no poderlos editar
    public static void DesactivarControles(EditText edtclasica,EditText edtclasiqueso,EditText edtdobleq,EditText edtvegetal,EditText edtespecial){
        edtclasica.setEnabled(false);
        edtclasiqueso.setEnabled(false);
        edtdobleq.setEnabled(false);
        edtvegetal.setEnabled(false);
        edtespecial.setEnabled(false);
    }
    //Metodo inverso que el arriba descrito
    public static void ActivarControles(EditText edtclasica,EditText edtclasiqueso,EditText edtdobleq,EditText edtvegetal,EditText edtespecial,EditText edttotal){
        edtclasica.setEnabled(true);
        edtclasiqueso.setEnabled(true);
        edtdobleq.setEnabled(true);
        edtvegetal.setEnabled(true);
        edtespecial.setEnabled(true);
        edtclasica.setText("");
        edtclasiqueso.setText("");
        edtdobleq.setText("");
        edtvegetal.setText("");
        edtespecial.setText("");
        edttotal.setText("");
    }

}
