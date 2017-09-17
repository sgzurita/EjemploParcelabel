package com.android.curso.ejemploparcelabel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DestinoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);
        Intent intent=getIntent();
        if(intent.hasExtra("usuario")) {
           User user= intent.getParcelableExtra("usuario");
            TextView textView=((TextView)findViewById(R.id.textView));
            textView.setText(user.getNombre()+" "+user.getApellido());
        }

        final Button boton_salida = (Button)findViewById(R.id.buttonExit);
        boton_salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


            }
        });
    }
}
