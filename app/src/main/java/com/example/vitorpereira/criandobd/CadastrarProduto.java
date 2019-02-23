package com.example.vitorpereira.criandobd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastrarProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        Button btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ControllerDB crud = new ControllerDB(getBaseContext());

                EditText titulo = (EditText)findViewById(R.id.titulo);
                EditText autor = (EditText)findViewById(R.id.autor);
                EditText editora = (EditText)findViewById(R.id.editora);


                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();
                String imagemString = "teste";

                String resultado;

                resultado = crud.insereDado(tituloString,autorString,editoraString, imagemString);

                Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_LONG).show();

                finish();
            }
        });

    }
}
