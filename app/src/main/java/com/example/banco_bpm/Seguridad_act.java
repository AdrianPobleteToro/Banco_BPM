package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity {

    private EditText pass;
    private TextView passEncriptada;
    private String passUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        pass = (EditText)findViewById(R.id.edPw);
        passEncriptada = (TextView)findViewById(R.id.tvPwEncriptada);
    }

    public void EncriptaPw(View v)
    {
        passUser = pass.getText().toString();
        try{
            String mensaje = Encriptar(passUser, passUser);
            passEncriptada.setText(mensaje);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private SecretKeySpec generateKey(String passEncriptar) throws Exception{
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] key = passEncriptar.getBytes("UTF-8");
        key = sh.digest(key);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }

    public String Encriptar(String datos, String password)throws Exception{
        if(!passUser.isEmpty()){
            SecretKeySpec secretKey = generateKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[] datosEncriptadosBytes = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes,Base64.DEFAULT);
            return  datosEncriptadosString;
        }
        else
        {
            Toast.makeText(this, "El campo no debe estar vacío", Toast.LENGTH_LONG).show();
            return null;
        }
    }
}