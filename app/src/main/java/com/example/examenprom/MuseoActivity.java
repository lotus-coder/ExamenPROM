package com.example.examenprom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MuseoActivity   extends AppCompatActivity implements MuseoListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);
        FragmentListado fragmentListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.frgListado);
        fragmentListado.setMuseoListener(this);
    }

    @Override
    public void onMuseoSeleccionado(Museo c) {
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(c.getWeb()));
        startActivity(intent);
    }
}