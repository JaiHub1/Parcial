package com.example.millonario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //boton de salto de pantalla
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //metodo para cambiar de activity


        next =(Button) findViewById(R.id.btnjugar);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent next= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(next);
            }
        });


    }
}