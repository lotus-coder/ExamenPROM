package com.example.examenprom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnAct1,btnAct2,btnSalir;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 //       Intent i = new Intent(MainActivity.this,DialogoLogin.class);
   //     startActivity(i);
        btnAct1 = findViewById(R.id.btnActividad1);
        btnAct2 = findViewById(R.id.btnActividad2);
        btnSalir = findViewById(R.id.btnSalir);
        img = findViewById(R.id.imageView);
        img.setImageResource(R.mipmap.icjardin_logo);
        eventos();

    }
    final static void termina(){
        System.exit(0);
    }
    private void eventos() {
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoSalir d = new DialogoSalir();
                d.show(getSupportFragmentManager(),"hastalueggo");
            }
        });
        btnAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ViajesJardin.class);
                startActivity(i);
            }
        });
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MuseoActivity.class);
                startActivity(i);
            }
        });
    }
}