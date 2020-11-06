package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Clientes;
import Clases.Prestamos;

public class Prestamos_act extends AppCompatActivity {

    private Spinner spinCli, spinCre;
    private TextView tvInfo;
    private Clientes cliente;
    private Prestamos prestamo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spinCli = (Spinner)findViewById(R.id.spnCliente);
        spinCre = (Spinner)findViewById(R.id.spnPrestamo);
        tvInfo = (TextView)findViewById(R.id.tvInfo);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayAdapter<String> adapterCliente = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaClientes);
        spinCli.setAdapter(adapterCliente);

        ArrayList<String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");
        ArrayAdapter<String> adapterCredito = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaCreditos);
        spinCre.setAdapter(adapterCredito);

    }

    public void CalculaPrestamo(View v){
        cliente = new Clientes(spinCli.getSelectedItem().toString().toUpperCase());
        prestamo = new Prestamos(spinCre.getSelectedItem().toString());
        float saldoTotal = cliente.getSaldo() + prestamo.getMonto();
        tvInfo.setText("El cliente: "+ cliente.getNombre() + " mantiene un saldo de $"+ cliente.getSaldo()+ " y con el " + prestamo.getTipo() + " solicitado el monto final sería de $" + saldoTotal);
    }

    public void CalculaDeuda(View v){
        cliente = new Clientes(spinCli.getSelectedItem().toString().toUpperCase());
        prestamo = new Prestamos(spinCre.getSelectedItem().toString());
        float saldoTotal = cliente.getSaldo() + prestamo.getMonto();
        cliente.setSaldo(saldoTotal);
        tvInfo.setText("Para: " + cliente.getNombre() + " el monto final sería $" + cliente.getSaldo() + " pactado en " + prestamo.getCuotas() + " cuotas de $" + prestamo.getMontoDeuda());
    }

}