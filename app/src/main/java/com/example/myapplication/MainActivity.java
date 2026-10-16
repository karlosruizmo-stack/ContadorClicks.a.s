package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_CONTADOR = "contador";

    private int contador = 0;
    private TextView tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContador = findViewById(R.id.tvContador);
        Button btnPulsar = findViewById(R.id.btnPulsar);
        Button btnReiniciar = findViewById(R.id.btnReiniciar);

        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt(KEY_CONTADOR, 0);
        }
        actualizarContador();

        btnPulsar.setOnClickListener(v -> {
            contador++;
            actualizarContador();
        });

        btnReiniciar.setOnClickListener(v -> {
            contador = 0;
            actualizarContador();
        });
    }

    private void actualizarContador() {
        tvContador.setText(String.valueOf(contador));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTADOR, contador);
    }
}
