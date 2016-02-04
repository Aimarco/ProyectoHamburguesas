package com.example.aimar.proyectohamburguesas;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.Notification.Style;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import com.example.aimar.proyectohamburguesas.hamburguesas;

/**
 * Created by Aimar&Diego
 */
public class infopedido extends AppCompatActivity {
private TextView nombre,direccion,tlf,clasica,clasiqueso,dobleq,vegetal,especial,agua,nestea,limon,naranja,cola,cerveza,total,premio,tamanio,tcarne;
private ImageView imagenpremio;
    private Button aceptar,rechazar;
    hamburguesas ham;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infopedido);
        Intent i=getIntent();
        ham=new hamburguesas();
        ham=(hamburguesas)i.getSerializableExtra("hamburguesas");
        //muestraHamburguesa(ham);
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
        imagenpremio=(ImageView) findViewById(R.id.imagenPremio);
        aceptar=(Button) findViewById(R.id.btnaceptar);
        rechazar=(Button) findViewById(R.id.btnrechazar);
        premio=(TextView) findViewById(R.id.txtpremio);
        tamanio=(TextView) findViewById(R.id.Tamanio);
        tcarne=(TextView) findViewById(R.id.Tcarne);

        clasica.setText("Hamburguesa clasica: "+ham.getClasica());
        clasiqueso.setText(""+ham.getClasiqueso());
        dobleq.setText(""+ham.getDobleq());
        vegetal.setText(""+ham.getVegetal());
        especial.setText(""+ham.getEspecial());
        total.setText(Float.valueOf(ham.getTotalh()).toString()+"€");

        //asignamos valor a todos los TextView mediante el pase de Extras de la Intent
        /*nombre.setText(cogerinfo.getString("nombre"));
        direccion.setText(cogerinfo.getString("direccion"));
        tlf.setText(cogerinfo.getString("tlf"));
        clasica.setText(clasica.getText()+""+cogerinfo.getString("clasica"));
        clasiqueso.setText(clasiqueso.getText()+""+cogerinfo.getString("clasiqueso"));
        dobleq.setText(dobleq.getText()+""+cogerinfo.getString("dobleq"));
        vegetal.setText(vegetal.getText()+""+cogerinfo.getString("vegetal"));
        especial.setText(especial.getText()+""+cogerinfo.getString("especial"));
        agua.setText(agua.getText()+""+cogerinfo.getString("agua"));
        nestea.setText(nestea.getText()+""+cogerinfo.getString("nestea"));
        limon.setText(limon.getText()+""+cogerinfo.getString("limon"));
        naranja.setText(naranja.getText()+""+cogerinfo.getString("naranja"));
        cola.setText(cola.getText()+""+cogerinfo.getString("cocacola"));
        cerveza.setText(cerveza.getText() + "" + cogerinfo.getString("cerveza"));
        total.setText(total.getText()+""+cogerinfo.getString("total"));*/
       // tamanio.setText(tamanio.getText().toString()+""+cogerinfo.getString("tamanio"));
        //tcarne.setText(tcarne.getText().toString()+""+cogerinfo.getString("tcarne"));

//vamos a crear un objeto drawable para asignarle diferentes imagenes al imageView
/*
        if(Float.valueOf(total.getText().toString().substring(6, 10))>15 && Float.valueOf(total.getText().toString().substring(6, 10))<25 ){
            imagenpremio.setImageDrawable(getResources().getDrawable(R.drawable.pandroid));
            premio.setVisibility(View.VISIBLE);}
        else if(Float.valueOf(total.getText().toString().substring(6, 10))>25){
            imagenpremio.setImageDrawable(getResources().getDrawable(R.drawable.premiogordo));
                premio.setVisibility(View.VISIBLE);}
*/
        //Programación del botón para aceptar el pedido
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificar();
                Toast.makeText(infopedido.this, "Gracias por confiar en nosotros.", Toast.LENGTH_SHORT).show();
               setContentView(R.layout.activity_datos_cliente);
                finish();
            }
        });

        //Programacion del boton de rechazar el pedido y salir de la app
        rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(infopedido.this, "Hasta la proxima!", Toast.LENGTH_SHORT).show();
                //setContentView(R.layout.activity_datos_cliente);
                finish();
            }
        });







    }
    public void notificar(){
        NotificationManager nmanager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder notificacionbuild=new Notification.Builder(this)
        .setWhen(System.currentTimeMillis())
        .setTicker("Cebanc Burguer")
        .setSmallIcon(R.drawable.hamburguesaini)
        .setSmallIcon(R.drawable.hamburguesaini)
        .setContentTitle("Notificación de pedido")
        .setContentText("Realizado el pedido correctamente.")
        .setStyle(new Notification.BigTextStyle()
                .bigText("Realizado el pedido correctamente,tardara al rededor de 40 minutos.Incluira el regalo descrito en la App"));
        nmanager.notify(1,notificacionbuild.build());
    }
    public void muestraHamburguesa(hamburguesas ham){

        clasica.setText(ham.getClasica());
        clasiqueso.setText(ham.getClasiqueso());
        dobleq.setText(ham.getDobleq());
        vegetal.setText(ham.getVegetal());
        especial.setText(ham.getEspecial());
        total.setText(Float.valueOf(ham.getTotalh()).toString());

    }


}
