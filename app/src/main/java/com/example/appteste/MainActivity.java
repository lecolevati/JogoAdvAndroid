package com.example.appteste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNumero = (EditText) findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER);

        Button btnTentar = (Button) findViewById(R.id.btnTentar);
        TextView tvTentativa = (TextView) findViewById(R.id.tvTentativa);

        int numeroGerado = (int) ((Math.random() * 100) + 1);

        btnTentar.setOnClickListener(v -> jogar(etNumero, numeroGerado, tvTentativa));

    }

    private void jogar(EditText etNumero, int numeroGerado, TextView tvTentativa) {
        int numero = Integer.parseInt(etNumero.getText().toString());
        if (numero > numeroGerado){
            tvTentativa.setText("O número é menor !");
        }
        if (numero < numeroGerado) {
            tvTentativa.setText("O número é maior !");
        }
        if (numero == numeroGerado){
            vitoria(numeroGerado);
        }
    }

    private void vitoria(int numeroGerado) {
        Bundle b = new Bundle();
        b.putInt("numeroGerado", numeroGerado);
        Intent i = new Intent(this, ResultadoActivity.class);
        i.putExtras(b);
        startActivity(i);
        this.finish();
    }


}