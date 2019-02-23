package com.example.vitorpereira.criandobd;

public class Produto {
    private String imagem;
    private String id;
    private String titulo;
    private String autor;
    private String editora;


    public String getImagem() { return imagem; }

    public void setImagem(String imagem) { this.imagem = imagem; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Produto( String id, String titulo, String autor, String editora,String imagem) {
        this.imagem = imagem;
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public Produto() {
    }
}
