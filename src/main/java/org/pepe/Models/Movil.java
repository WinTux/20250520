package org.pepe.Models;

public class Movil {
    int id;
    String nombre;
    String marca;
    int almacenamiento_interno;
    int ram;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAlmacenamiento_interno() {
        return almacenamiento_interno;
    }

    public void setAlmacenamiento_interno(int almacenamiento_interno) {
        this.almacenamiento_interno = almacenamiento_interno;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
