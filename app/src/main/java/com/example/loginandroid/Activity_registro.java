package com.example.loginandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_registro extends AppCompatActivity{

    TextView estado;
    Spinner comboGenero;
    EditText nombre, apellido, edad, correo;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        estado = (TextView) findViewById(R.id.etiSeleccion);
        comboGenero= (Spinner) findViewById(R.id.idSpinnerGenero);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.combo_genero, android.R.layout.simple_spinner_item);
        comboGenero.setAdapter(adapter);

        comboGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Toast.makeText(parent.getContext(),"Seleccionado: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                estado.setText("Seleccion: " + parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nombre = (EditText)findViewById(R.id.editNombre);
        apellido =(EditText)findViewById(R.id.editApellido);
        edad = (EditText)findViewById(R.id.editEdad);
        correo = (EditText)findViewById(R.id.editCorreo);
        aceptar = (Button) findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombre.getText().toString();
                String ape = apellido.getText().toString();
                String age = edad.getText().toString();
                String email = correo.getText().toString();
                Intent i = new Intent(Activity_registro.this,MostrarDatos.class);

                i.putExtra("name", name);
                i.putExtra("ape", ape);
                i.putExtra("age", age);
                i.putExtra("email", email);

                startActivity(i);
            }
        });
    }
}