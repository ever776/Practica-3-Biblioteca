
package com.emergentes.modelo;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String Disponible;
    private Categoria cate;

    public Libro() {
        id = 0;
        titulo = "";
        autor = "";
        Disponible = "";
    }

    public Libro(int id, String titulo, String autor, String Disponible, Categoria cate) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.Disponible = Disponible;
        this.cate = cate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDisponible() {
        return Disponible;
    }

    public void setDisponible(String Disponible) {
        this.Disponible = Disponible;
    }

    public Categoria getCate() {
        return cate;
    }

    public void setCate(Categoria cate) {
        this.cate = cate;
    }
    
    
}
