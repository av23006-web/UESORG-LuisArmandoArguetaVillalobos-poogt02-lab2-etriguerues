package org.laboratorio2.model;

public class Pelicula extends Contenido {
    private boolean esEstreno;

    public Pelicula(int id, String titulo, int duracionMinutos, boolean esEstreno) {
        super(id, titulo, duracionMinutos);
        this.esEstreno = esEstreno;
    }

    public boolean isEsEstreno() {
        return esEstreno;
    }

    @Override
    public double calcularCostoLicencia() {
        return esEstreno ? 500.0 : 200.0;
    }
}