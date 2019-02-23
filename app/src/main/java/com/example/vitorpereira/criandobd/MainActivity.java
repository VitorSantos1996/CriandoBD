package com.example.vitorpereira.criandobd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populaLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populaLista();
    }

    public void cadastrar(View view){
        final Intent intent = new Intent(this, CadastrarProduto.class);
        startActivity(intent);
    }

    public void populaLista(){
        ControllerDB crud = new ControllerDB(this);
        final ListView lista = (ListView) findViewById(R.id.ListProdutos);
        final ArrayList<Produto> produtos = crud.carregaTodosDados();

        ProdutoAdaptador adapter = new ProdutoAdaptador(this, produtos);
        lista.setAdapter(adapter);
    }


}
