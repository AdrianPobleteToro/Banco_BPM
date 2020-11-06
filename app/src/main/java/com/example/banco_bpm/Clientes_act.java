package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Clientes_act extends AppCompatActivity {

    EditText codCli,nomCli,salCli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        codCli = (EditText)findViewById(R.id.etCodigo);
        nomCli = (EditText)findViewById(R.id.etNombre);
        salCli = (EditText)findViewById(R.id.etSalario);
    }

    public void GuardarCliente(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ficherobd",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codCli.getText().toString();
        if(!codigo.isEmpty()){
            ContentValues content = new ContentValues();
            content.put("codigo",codCli.getText().toString());
            content.put("nombre",nomCli.getText().toString());
            content.put("salario",salCli.getText().toString());
            bd.insert("clientes",null,content);
            bd.close();
            Toast.makeText(this,"Se ha registrado el cliente.",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "No se pudo registrar. Debe ingresar un código", Toast.LENGTH_LONG).show();
        }
        borrarRegistros();
    }

    public void MostrarCliente(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ficherobd",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codCli.getText().toString();
        if(!codigo.isEmpty()){
            Cursor fila = bd.rawQuery("SELECT codigo, nombre, salario FROM clientes WHERE codigo = " + codigo,null);
            if(fila.moveToFirst()){
                codCli.setText(fila.getString(0));
                nomCli.setText(fila.getString(1));
                salCli.setText(fila.getString(2));
            }
            else{
                Toast.makeText(this,"No existe cliente asociado al código consultado.",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"El codigo es necesario para consultar clientes.", Toast.LENGTH_LONG).show();
        }
    }

    public void EliminarCliente(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ficherobd",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codCli.getText().toString();
        if(!codigo.isEmpty()){
            bd.delete("clientes","codigo="+codigo,null);
            bd.close();
            Toast.makeText(this,"Cliente eliminado.",Toast.LENGTH_LONG).show();
            borrarRegistros();
        }else{
            Toast.makeText(this,"El codigo es necesario para eliminar clientes.",Toast.LENGTH_LONG).show();
        }
    }

    public void ActualizarCliente(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ficherobd",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codigo = codCli.getText().toString();
        ContentValues content = new ContentValues();
        content.put("codigo",codigo);
        content.put("nombre",nomCli.getText().toString());
        content.put("salario",salCli.getText().toString());
        if(!codigo.isEmpty()){
            bd.update("clientes",content,"codigo = " + codigo, null);
            bd.close();
            Toast.makeText(this,"Cliente Modificado.",Toast.LENGTH_LONG).show();
            MostrarCliente(v);
        }else{
            Toast.makeText(this,"El codigo es necesario para modificar clientes.",Toast.LENGTH_LONG).show();
        }
    }

    public void borrarRegistros(){
        codCli.setText("");
        nomCli.setText("");
        salCli.setText("");
    }
}