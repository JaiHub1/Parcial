package com.example.millonario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button siguienter, retry2;
    int puntos= 0;

    private int ciclo_respuestas[] = {
            R.id.respuesta1, R.id.respuesta2,R.id.respuesta3,R.id.respuesta4
    };
    private int respuestabuena;
    private int actualp;
    private String[] preguntasmult;
    private TextView pregunta;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        retry2 =(Button) findViewById(R.id.retry1);

        retry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent retry2= new Intent(MainActivity2.this, MainActivity.class);
                startActivity(retry2);
            }
        });

       pregunta = (TextView) findViewById(R.id.pregunta);

        preguntasmult = getResources().getStringArray(R.array.preguntasmult);

        actualp = 0;
        proxpregunta();

        group = (RadioGroup) findViewById(R.id.gruporespuesta);

        Button buttonsig = (Button) findViewById(R.id.buttonsig);
        buttonsig.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int id = group.getCheckedRadioButtonId();
                int respuesta = -1;
                for (int i = 0; i < ciclo_respuestas.length; i++)
                {
                    if (ciclo_respuestas[i] == id) {
                        respuesta= i;
                    }
                }
                if (respuesta == respuestabuena)
                {
                    puntos=+100;


                    Toast.makeText(MainActivity2.this, String.valueOf("+"+puntos), Toast.LENGTH_SHORT).show();
                   // Toast.makeText(MainActivity2.this, puntos,  Toast.LENGTH_SHORT).show();

                }
                else {
                    siguienter =(Button) findViewById(R.id.buttonsig);

                            Intent siguienter= new Intent(MainActivity2.this, MainActivity3.class);
                            startActivity(siguienter);

                }
                if (actualp < preguntasmult.length-1)
                {
                actualp++;
                proxpregunta();

                    }
            }
        });


    }

    private void proxpregunta() {

        String p = preguntasmult[actualp];
        String[]partes = p.split(";");

        pregunta.setText(partes[0]);


        for (int i=0; i < ciclo_respuestas.length; i++){

            RadioButton radiob = (RadioButton) findViewById(ciclo_respuestas[i]);
            String respuesta = partes[i+1];
            if (respuesta.charAt(0)== '*')
            {
                respuestabuena = i;
                respuesta = respuesta.substring(1);
            }
            radiob.setText(respuesta);
        }
    }
}