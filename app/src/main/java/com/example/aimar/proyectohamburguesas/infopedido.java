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

/**
 * Created by Aimar&Diego
 */
public class infopedido extends AppCompatActivity {
private TextView nombre,direccion,tlf,clasica,clasiqueso,dobleq,vegetal,especial,agua,nestea,limon,naranja,cola,cerveza,total,premio,tamanio,tcarne;
private ImageView imagenpremio;
    private Button aceptar,rechazar;
    private Bebidas b;
    private Personas p;
    private hamburguesas h;

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
        imagenpremio=(ImageView) findViewById(R.id.imagenPremio);
        aceptar=(Button) findViewById(R.id.btnaceptar);
        rechazar=(Button) findViewById(R.id.btnrechazar);
        premio=(TextView) findViewById(R.id.txtpremio);
        tamanio=(TextView) findViewById(R.id.Tamanio);
        tcarne=(TextView) findViewById(R.id.Tcarne);
        Intent i=getIntent();
        p=new Personas();
        b=new Bebidas();
        h=new hamburguesas();
        p=(Personas) i.getSerializableExtra("persona");
        b=(Bebidas) i.getSerializableExtra("bebidas");
        h=(hamburguesas) i.getSerializableExtra("hamburguesas");

        //asignamos valor a todos los TextView mediante el pase de Extras de la Intent





        nombre.setText(""+p.getNombre());
        direccion.setText(""+p.getDireccion());
        tlf.setText(""+p.getTelefono());
        clasica.setText("Clasicas: "+h.getClasica());
        clasiqueso.setText("Clasicas con queso: "+h.getClasiqueso());
        dobleq.setText("Dobles de Queso "+h.getDobleq());
        vegetal.setText("Vegetales: "+h.getVegetal());
        especial.setText("Especiales: "+h.getEspecial());
        agua.setText("Aguas: "+b.getAgua());
        nestea.setText("Nestea: "+b.getNestea());
        limon.setText("Limon: "+b.getLimon());
        naranja.setText("Naranja: "+b.getNaranja());
        cola.setText("Cocacola: "+b.getCocacola());
        cerveza.setText("Cerveza: "+b.getCerveza());
        float Total=h.getTotalh()+b.getTotalb();
        total.setText(""+Total+"€");
        switch (h.getTamaño()){
            case 1:tamanio.setText("Tamaño: Grande");break;
            case 2:tamanio.setText("Tamaño: Whopper");break;
        }
        switch (h.getTipoc()){
            case 1: tcarne.setText("Carne de Buey");break;
            case 2: tcarne.setText("Carne de Pollo");break;
            case 3: tcarne.setText("Carne de Ternera");break;
        }


//vamos a crear un objeto drawable para asignarle diferentes imagenes al imageView

        if(Total>15 && Total<25 ){
            imagenpremio.setImageDrawable(getResources().getDrawable(R.drawable.pandroid));
            premio.setVisibility(View.VISIBLE);}
        else if(Total>25){
            imagenpremio.setImageDrawable(getResources().getDrawable(R.drawable.premiogordo));
                premio.setVisibility(View.VISIBLE);}

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


}
