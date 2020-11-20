package com.example.appteste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        EditText etResultado = (EditText) findViewById(R.id.etResultado);
        etResultado.setInputType(View.LAYER_TYPE_NONE);
        etResultado.setTextSize(18);
        etResultado.setGravity(Gravity.CENTER);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);

        Intent iMain = getIntent();
        Bundle b = iMain.getExtras();
        int numeroGerado = b.getInt("numeroGerado");

        etResultado.setText("Parabéns ! Você acertou o número: "+ numeroGerado);

        btnVoltar.setOnClickListener(v -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        this.finish();
    }
}