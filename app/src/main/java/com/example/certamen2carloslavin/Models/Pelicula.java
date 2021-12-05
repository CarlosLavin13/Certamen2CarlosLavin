package com.example.certamen2carloslavin.Models;

public class Pelicula {
    private String idPelicula;
    private  String nombre;
    private String genero;

    public Pelicula(){
        this.idPelicula="";
        this.nombre="";
        this.genero="";
    }
    public Pelicula(String idPelicula, String nombre, String genero) {
        this.idPelicula = idPelicula;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula='" + idPelicula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
