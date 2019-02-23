package com.example.vitorpereira.criandobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ControllerDB {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public ControllerDB(Context context) {
        banco = new CriaBanco(context);
    }

    //metodo inserir
    public String insereDado(String titulo, String autor, String editora, String imagem) {

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.TITULO, titulo);
        valores.put(CriaBanco.AUTOR, autor);
        valores.put(CriaBanco.EDITORA, editora);
        valores.put(CriaBanco.IMAGEM, imagem);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
            }
    }

    //metodo carregar todos dados
    public ArrayList<Produto> carregaTodosDados(){
        ArrayList<Produto> produtoList = new ArrayList<Produto>();

        String selectQuery = "SELECT * FROM " + CriaBanco.TABELA;

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null && cursor.moveToFirst()){
            do{
                Produto produto = new Produto();
                produto.setId(cursor.getString(0));
                produto.setTitulo(cursor.getString(1));
                produto.setAutor(cursor.getString(2));
                produto.setEditora(cursor.getString(3));
                produto.setImagem(cursor.getString(4));

                produtoList.add(produto);

            }while (cursor.moveToNext());
        }
        db.close();
        return produtoList;
    }

    //metodo carrega por id
    public Produto buscaID(int id) {

        db = banco.getReadableDatabase();

        Cursor cursor = db.query(CriaBanco.TABELA, new String[] { CriaBanco.ID, CriaBanco.EDITORA, CriaBanco.TITULO, CriaBanco.AUTOR},
                CriaBanco.ID + "=?",
                new String[] { String.valueOf(id)},
                null,
                null,
                null,
                null);
        Produto produto = null;

        db.close();

        if (cursor != null){
            cursor.moveToFirst();
            produto = new Produto();
            produto.setId(cursor.getString(0));
            produto.setTitulo(cursor.getString(1));
            produto.setEditora(cursor.getString(2));
            produto.setAutor(cursor.getString(3));
            return produto;
        }else {
            throw new RuntimeException("Não Existe");
        }
    }

    //metodo update
    public int update(Produto produto) {
        db = banco.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CriaBanco.AUTOR, produto.getAutor());
        values.put(CriaBanco.EDITORA, produto.getEditora());
        values.put(CriaBanco.TITULO, produto.getTitulo());

        return db.update(CriaBanco.TABELA, values,
                CriaBanco.ID + "= ?",
                new String[]{ String.valueOf(produto.getId())}
                );
    }

    //metodo deletar
    public void delete(Produto produto){
        db = banco.getWritableDatabase();

        db.delete(CriaBanco.TABELA, CriaBanco.ID + " = ?",
                new String[] { String.valueOf(produto.getId())});

        db.close();
    }


}
