package com.example.vitorpereira.criandobd;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProdutoAdaptador extends ArrayAdapter<Produto> {


    private final Context context;
    private final ArrayList<Produto>elementos;

    public ProdutoAdaptador(Context context, ArrayList<Produto> elementos) {
        super(context,R.layout.activity_main,elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_home, parent, false);

        ImageView imagem = (ImageView) rowView.findViewById(R.id.imageHome);
        TextView id = (TextView) rowView.findViewById(R.id._id);
        TextView titulo = (TextView) rowView.findViewById(R.id.titulo);
        TextView autor = (TextView) rowView.findViewById(R.id.autor);
        TextView editora = (TextView) rowView.findViewById(R.id.editora);


        int imageID = getImageId(getContext(), elementos.get(position).getImagem());

        imagem.setImageResource(imageID);
        id.setText(elementos.get(position).getId());
        titulo.setText(elementos.get(position).getTitulo());
        autor.setText(elementos.get(position).getAutor());
        editora.setText(elementos.get(position).getEditora());

        return rowView;

    }



    public static int getImageId(Context context, String imagemName){
        return context.getResources().getIdentifier("drawable/" + imagemName, null, context.getPackageName());
    }
}
