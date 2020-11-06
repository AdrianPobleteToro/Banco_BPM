package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private EditText usuario,pwrd;
    private Button iniSesion;
    private String u, p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText)findViewById(R.id.etUser);
        pwrd = (EditText)findViewById((R.id.etPw));

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        iniSesion = (Button)findViewById(R.id.btIn);
        iniSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u = usuario.getText().toString();
                p = pwrd.getText().toString();
                if(!u.equalsIgnoreCase("android") || !p.equalsIgnoreCase("123")){
                    Toast.makeText(MainActivity.this, "Ingreso inválido, revise sus credenciales.", Toast.LENGTH_LONG).show();

                }else{
                    new Task().execute();
                }
            }
        });

    }

    public void Hilo(View v)
    {
        for(int i = 0; i <= 10; i++)
        {
            try{
                Thread.sleep((2000));

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            for(int i = 1; i <= 3; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Home_act.class);
            startActivity(i);
        }
    }

}