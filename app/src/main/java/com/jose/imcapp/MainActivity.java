package com.jose.imcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int DADOS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button enviarDados = ((Button) findViewById(R.id.botaoEnviar));
            assert enviarDados != null;
            enviarDados.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SegundaTela.class);

                    EditText nome = (EditText) findViewById(R.id.campoNome);
                    EditText telefone = (EditText) findViewById(R.id.campoTelefone);
                    EditText email = (EditText) findViewById(R.id.campoEmail);
                    EditText altura = (EditText) findViewById(R.id.campoAltura);
                    EditText peso = (EditText) findViewById(R.id.campoPeso);

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

                    intent.putExtras(bundle);


                    startActivityForResult(intent, DADOS);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DADOS) {
            TextView resultado = ((TextView) findViewById(R.id.resultado));

            if (resultCode == RESULT_OK && data.hasExtra("campoNome")) {
                String campoNome = data.getExtras().getString("campoNome");
                resultado.setText(campoNome);
            }
        }
    }
}
