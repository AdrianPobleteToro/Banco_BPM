package com.example.banco_bpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        //          -->Video de información<--
        videoView = (VideoView)findViewById(R.id.vv);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);

    }

    //         -->Acceso a google maps<--
    public void AccesoUbicacion(View v){
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }
}