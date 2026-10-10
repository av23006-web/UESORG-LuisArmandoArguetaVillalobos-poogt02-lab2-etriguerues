package org.laboratorio2.config;

public class AjustesPlataforma {
    private static AjustesPlataforma instance;
    private String region = "LATAM";
    private double costoServidorPorHora = 0.05;

    private AjustesPlataforma() {}

    public static synchronized AjustesPlataforma getInstance() {
        if (instance == null) {
            instance = new AjustesPlataforma();
        }
        return instance;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getCostoServidorPorHora() {
        return costoServidorPorHora;
    }

    public void setCostoServidorPorHora(double costoServidorPorHora) {
        this.costoServidorPorHora = costoServidorPorHora;
    }
}