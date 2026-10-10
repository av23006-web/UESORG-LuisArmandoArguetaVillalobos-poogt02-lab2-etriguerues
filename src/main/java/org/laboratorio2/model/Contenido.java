package org.laboratorio2.model;

import java.util.Objects;

public abstract class Contenido {
    protected int id;
    protected String titulo;
    protected int duracionMinutos;

    public Contenido(int id, String titulo, int duracionMinutos) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public abstract double calcularCostoLicencia();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contenido other = (Contenido) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contenido[ID=" + id + ",Titulo=" + titulo + "]";
    }
}// Modelo base de contenidos
