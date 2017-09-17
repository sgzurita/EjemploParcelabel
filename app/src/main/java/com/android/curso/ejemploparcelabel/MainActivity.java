package com.android.curso.ejemploparcelabel;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext=(Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,DestinoActivity.class);
        String apellido=((EditText)findViewById(R.id.editTextApellido)).getText().toString();
        String nombre=((EditText)findViewById(R.id.editTextNombre)).getText().toString();;
        User user=new User(nombre,apellido);
        intent.putExtra("usuario",user);
        startActivity(intent);


    }
}
