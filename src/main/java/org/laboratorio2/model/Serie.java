package org.laboratorio2.model;

public class Serie extends Contenido {
    private int numCapitulos;

    public Serie(int id, String titulo, int duracionMinutos, int numCapitulos) {
        super(id, titulo, duracionMinutos);
        this.numCapitulos = numCapitulos;
    }

    public int getNumCapitulos() {
        return numCapitulos;
    }

    @Override
    public double calcularCostoLicencia() {
        return numCapitulos * 15.0;
    }
}