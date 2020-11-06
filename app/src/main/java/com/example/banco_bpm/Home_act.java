package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {

    private ViewFlipper flipper;
    private int[] arregloImgs = {R.drawable.a,R.drawable.b,R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        flipper = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < arregloImgs.length; i++){
            muestraImagen(arregloImgs[i]);
        }
    }

    public void muestraImagen(int img){
        ImageView iView = new ImageView(this);
        iView.setBackgroundResource(img);
        flipper.addView(iView);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(3500);
        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void InfoActivity(View v){
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void SeguridadActivity(View v){
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }

    public void PrestamosActivity(View v){
        Intent i = new Intent(this, Prestamos_act.class);
        ArrayList<String> clientes = new ArrayList<String>();
        clientes.add("Axel");
        clientes.add("Roxane");
        clientes.add("Betzabe");
        clientes.add("Matias");
        ArrayList<String> creditos = new ArrayList<String>();
        creditos.add("Crédito Hipotecario");
        creditos.add("Crédito Automotriz");

        i.putExtra("listaClientes",clientes);
        i.putExtra("listaCreditos",creditos);
        startActivity(i);
    }

    public void ClienteActivity(View v){
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }

}