package com.jose.imcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class TerceiraTela extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String resultado = bundle.getString("resultado");

        EditText imc = (EditText) findViewById(R.id.imc);
        imc.setText(resultado);

        Double imcValor = Double.parseDouble(resultado.replace("IMC = ", ""));
        String classificacao = "Classificação = ";

        if (imcValor < 16) {
            classificacao += "Magreza grave";
        }
        if (imcValor >= 16 && imcValor < 17) {
            classificacao += "Magreza moderada";
        }
        if (imcValor >= 17 && imcValor < 18.5) {
            classificacao += "Magreza leve";
        }
        if (imcValor >= 18.5 && imcValor < 25) {
            classificacao += "Saudável";
        }
        if (imcValor >= 25 && imcValor < 30) {
            classificacao += "Sobrepeso";
        }
        if (imcValor >= 30 && imcValor < 35) {
            classificacao += "Obesidade grau I";
        }
        if (imcValor >= 35 && imcValor < 40) {
            classificacao += "Obesidade grau II (Severa)";
        }
        if (imcValor >= 40) {
            classificacao += "Obesidade grau II (Mórbida)";
        }

        EditText campoClassificacao = (EditText) findViewById(R.id.classificacao);
        campoClassificacao.setText(classificacao);
    }
}
