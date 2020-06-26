package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSuma, btnresta, btnreset;
    private TextView txtCero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSuma = findViewById(R.id.btnSuma);
        btnresta = findViewById(R.id.btnresta);
        btnreset = findViewById(R.id.btnreset);
        txtCero = findViewById(R.id.txtCero);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                suma();
            }
        });

        btnresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resta();
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtCero.setText("0");
            }
        });
    }

    private void suma(){

        int incrementar = Integer.parseInt(txtCero.getText().toString());
        incrementar ++;
        txtCero.setText( String.valueOf(incrementar));

    }

    private void resta(){

        int decrementar = Integer.parseInt(txtCero.getText().toString());
        if(decrementar == 0) return;
        decrementar--;
        txtCero.setText(String.valueOf(decrementar));

    }

}
