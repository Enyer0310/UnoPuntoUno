package com.example.loginandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {

    TextView tvnombre, tvapellido, tvedad, tvcorreo;
    Button btnOk;
    Spinner combo_genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvnombre = (TextView)findViewById(R.id.tvNombre);
        tvapellido = (TextView)findViewById(R.id.tvApellido);
        tvedad = (TextView)findViewById(R.id.tvEdad);
        tvcorreo = (TextView)findViewById(R.id.tvCorreo);
        combo_genero = (Spinner) findViewById(R.id.idSpinnerGenero);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MostrarDatos.this,Activity_registro.class);
                startActivity(intent);
            }
        });

        mostrarDato();
    }

    private void mostrarDato() {
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String apellido = datos.getString("ape");
        String edad = datos.getString("age");
        String correo = datos.getString("email");
        String combo_genero = datos.getString("spi_genero");

        tvnombre.setText(nombre);
        tvapellido.setText(apellido);
        tvedad.setText(edad);
        tvcorreo.setText(correo);

    }
}