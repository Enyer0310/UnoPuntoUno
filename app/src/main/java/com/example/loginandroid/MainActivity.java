package com.example.loginandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button btnlogin;
    Button btnRegistrar;
    CheckBox showcheck_btn;
    Button btnEstadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnLoading);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        showcheck_btn=findViewById(R.id.checkbox_btn);
        btnEstadio =findViewById(R.id.btnEstadio);

        showcheck_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("user") && pass.getText().toString().equals("123")){
                    Intent intent = new Intent(MainActivity.this, Principal.class );
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Credenciales Correctas!", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this, "Credenciales Incorrectas", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, Activity_registro.class);
                startActivity(intent);
            }
        });

        btnEstadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, activity_mapa.class);
                startActivity(intent);
            }
        });

    }
}