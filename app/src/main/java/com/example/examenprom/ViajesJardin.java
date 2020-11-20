package com.example.examenprom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class ViajesJardin extends AppCompatActivity {
    private Button btnAceptar,btnCancelar;
    private EditText txtFecha,txtNombre,txtApellido;
    private Spinner spnOrigen,spnDestino;
    private RadioButton rbtn1,rbtn2,rbtn3,rbtn4,rbtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes_jardin);
        btnAceptar = findViewById(R.id.btnOK);
        btnCancelar = findViewById(R.id.btnNoOK);
        txtApellido = findViewById(R.id.editTextTextPersonName3);
        txtNombre = findViewById(R.id.editTextTextPersonName2);
        txtFecha = findViewById(R.id.txtDate);
        spnDestino = findViewById(R.id.spnDestino);
        spnOrigen = findViewById(R.id.spnOrigen);
        rbtn1 = findViewById(R.id.radioButton);
        rbtn2 = findViewById(R.id.radioButton2);
        rbtn3 = findViewById(R.id.radioButton3);
        rbtn4 = findViewById(R.id.radioButton4);
        rbtn5 = findViewById(R.id.radioButton5);
        final String[] datos = new String [] {"Vitoria","logroño","Hernani","Agurain", "Arrasate","Lekeitio"} ;//Creamos el adaptador para el spinner
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDestino.setAdapter(adaptador);
        spnOrigen.setAdapter(adaptador);
        View.OnClickListener list = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String opcion = "";
                switch (view.getId()) {
                    case R.id.radioButton:
                        if (rbtn2.isChecked()||rbtn3.isChecked()||rbtn4.isChecked()||rbtn5.isChecked()){
                            rbtn2.setChecked(false);
                            rbtn3.setChecked(false);
                            rbtn4.setChecked(false);
                            rbtn5.setChecked(false);
                        }
                        break;
                    case R.id.radioButton2:
                        if (rbtn1.isChecked()||rbtn3.isChecked()||rbtn4.isChecked()||rbtn5.isChecked()){
                            rbtn1.setChecked(false);
                            rbtn3.setChecked(false);
                            rbtn4.setChecked(false);
                            rbtn5.setChecked(false);
                        }
                        break;
                    case R.id.radioButton3:
                        if (rbtn1.isChecked()||rbtn2.isChecked()||rbtn4.isChecked()||rbtn5.isChecked()){
                            rbtn1.setChecked(false);
                            rbtn2.setChecked(false);
                            rbtn4.setChecked(false);
                            rbtn5.setChecked(false);
                        }
                        break;
                    case R.id.radioButton4:
                        if (rbtn1.isChecked()||rbtn2.isChecked()||rbtn3.isChecked()||rbtn5.isChecked()){
                            rbtn1.setChecked(false);
                            rbtn2.setChecked(false);
                            rbtn3.setChecked(false);
                            rbtn5.setChecked(false);
                        }
                        break;
                    case R.id.radioButton5:
                        if (rbtn1.isChecked()||rbtn2.isChecked()||rbtn3.isChecked()||rbtn4.isChecked()){
                            rbtn1.setChecked(false);
                            rbtn2.setChecked(false);
                            rbtn3.setChecked(false);
                            rbtn4.setChecked(false);

                            break;
                }
            }
        };

    };
        rbtn1.setOnClickListener(list);
        rbtn2.setOnClickListener(list);
        rbtn3.setOnClickListener(list);
        rbtn4.setOnClickListener(list);
        rbtn5.setOnClickListener(list);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViajesJardin.this,ViajesJardin01.class);
                if(rbtn1.isSelected()){
                    i.putExtra("hora",rbtn1.getText().toString());
                }
                else if(rbtn2.isSelected()){
                    i.putExtra("hora",rbtn2.getText().toString());
                }
                else if(rbtn3.isSelected()){
                    i.putExtra("hora",rbtn3.getText().toString());
                }
                else if(rbtn4.isSelected()){
                    i.putExtra("hora",rbtn4.getText().toString());
                }
                else{
                    i.putExtra("hora",rbtn5.getText().toString());
                }
                i.putExtra("nombre",txtNombre.getText().toString());
                i.putExtra("origen",spnOrigen.getSelectedItem().toString());
                i.putExtra("destino",spnDestino.getSelectedItem().toString());
                i.putExtra("fecha",txtFecha.getText().toString());
                i.putExtra("apellido",txtApellido.getText().toString());
                startActivityForResult(i,1);
            }
        });


    }
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            txtFecha.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            spnOrigen.setSelection(0);
            spnDestino.setSelection(0);
            rbtn1.setSelected(false);
            rbtn4.setSelected(false);
            rbtn2.setSelected(false);
            rbtn3.setSelected(false);
            rbtn5.setSelected(false);
        }
    }
}