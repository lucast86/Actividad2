package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button  btnConvertir, btnReiniciar;
    private RadioButton rdbDolar, rdbEuro, rdbReal;
    private EditText editResultado, editmonto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnConvertir = findViewById(R.id.btnConvertir);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        rdbDolar = findViewById(R.id.rdbDolar);
        rdbEuro = findViewById(R.id.rdbEuro);
        rdbReal = findViewById(R.id.rdbReal);
        editResultado = findViewById(R.id.editResultado);
        editmonto = findViewById(R.id.editmonto);

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    limpiarControles();
            }
        });

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validar()){
                    convertirMoneda();
                }
                else{
                    Toast.makeText(Main2Activity.this, "Cargar monto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validar(){

        return editmonto.getText().toString().trim().isEmpty();

    }

    private void limpiarControles(){
        editmonto.setText("");
        editResultado.setText("");
        rdbDolar.setChecked(true);
        String dato = editmonto.getText().toString();
    }



    private void convertirMoneda(){
         int monto = Integer.parseInt(editmonto.getText().toString());
                                                                      //Integer.parseInt (convierto en int)
        int cotizacion = 0;                                           // leo que que hay en editmonto
                                                                      //comprobamos que checked esta seleccionado
        if(rdbDolar.isChecked()){                                     //y * el monto con la cotizacion
            cotizacion = 73;
        }
        if(rdbEuro.isChecked()){
            cotizacion = 81;
        }
        if(rdbReal.isChecked()){
            cotizacion = 1450;
        }

        editResultado.setText( String.valueOf(monto / cotizacion)); // String.valueOf(monto * cotizacion)
                                                                    // convertimos un int en String
    }
}

