package com.example.examenprom;

public class Museo {
    private String imagen,nombre, localizacion,web;
    Museo(String img,String nom,String lugar){
        imagen = img;
        nombre = nom;
        localizacion = lugar;
    }
    Museo(String img,String nom,String lugar,String web){
        imagen = img;
        nombre = nom;
        localizacion = lugar;
        this.web = web;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
}
