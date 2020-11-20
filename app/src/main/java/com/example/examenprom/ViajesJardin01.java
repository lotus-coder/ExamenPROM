package com.example.examenprom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViajesJardin01 extends AppCompatActivity {

    private TextView fecha,hora,nombre,apellido,origen,destino;
    private Button btnSi,btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes_jardin01);
        fecha = findViewById(R.id.txtFecha);
        hora  = findViewById(R.id.txtHora);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        origen = findViewById(R.id.txtOrigen);
        destino = findViewById(R.id.txtDestino);
        btnNo = findViewById(R.id.btnNo);
        btnSi = findViewById(R.id.btnSi);
        Bundle extras = getIntent().getExtras();
        fecha.setText(extras.getString("fecha"));
        apellido.setText(extras.getString("apellido"));
        nombre.setText(extras.getString("nombre"));
        origen.setText(extras.getString("origen"));
        destino.setText(extras.getString("destino"));
        hora.setText(extras.getString("hora"));
        eventos();
    }

    private void eventos() {
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoSalir d = new DialogoSalir();
                d.show(getSupportFragmentManager(),"hastalueggo");
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
            }
        });
        btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}