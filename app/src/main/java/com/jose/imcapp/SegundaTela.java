package com.jose.imcapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SegundaTela extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String nome = bundle.getString("campoNome");
        String telefone = bundle.getString("campoTelefone");
        String email = bundle.getString("campoEmail");
        String altura = bundle.getString("campoAltura");
        String peso = bundle.getString("campoPeso");

        EditText resultadoNome = (EditText) findViewById(R.id.resultadoNome);
        resultadoNome.setText(nome);

        EditText resultadoTelefone = (EditText) findViewById(R.id.resultadoTelefone);
        resultadoTelefone.setText(telefone);

        EditText resultadoEmail = (EditText) findViewById(R.id.resultadoEmail);
        resultadoEmail.setText(email);

        EditText resultadoAltura = (EditText) findViewById(R.id.resultadoAltura);
        resultadoAltura.setText(altura);

        EditText resultadoPeso = (EditText) findViewById(R.id.resultadoPeso);
        resultadoPeso.setText(peso);

        Button botaoEnviaResultado = ((Button) findViewById(R.id.botaoEnviaResultado));
        assert botaoEnviaResultado != null;
        botaoEnviaResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.putExtra("resultado", "");

                EditText nome = (EditText) findViewById(R.id.resultadoNome);
                EditText telefone = (EditText) findViewById(R.id.resultadoTelefone);
                EditText email = (EditText) findViewById(R.id.resultadoEmail);
                EditText altura = (EditText) findViewById(R.id.resultadoAltura);
                EditText peso = (EditText) findViewById(R.id.resultadoPeso);

                String campoNome =  nome.getText().toString();
                String campoTelefone =  telefone.getText().toString();
                String campoEmail =  email.getText().toString();
                String campoAltura =  altura.getText().toString();
                String campoPeso =  peso.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("campoNome", campoNome);
                bundle.putString("campoTelefone", campoTelefone);
                bundle.putString("campoEmail", campoEmail);
                bundle.putString("campoAltura", campoAltura);
                bundle.putString("campoPeso", campoPeso);

                it.putExtras(bundle);

                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}
