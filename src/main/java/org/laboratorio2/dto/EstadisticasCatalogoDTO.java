package org.laboratorio2.dto;

public class EstadisticasCatalogoDTO {
    private int cantidadTitulos;
    private double horasTotales;
    private double costoLicenciamientoTotal;

    public EstadisticasCatalogoDTO(int cantidadTitulos, double horasTotales, double costoLicenciamientoTotal) {
        this.cantidadTitulos = cantidadTitulos;
        this.horasTotales = horasTotales;
        this.costoLicenciamientoTotal = costoLicenciamientoTotal;
    }

    public int getCantidadTitulos() {
        return cantidadTitulos;
    }

    public double getHorasTotales() {
        return horasTotales;
    }

    public double getCostoLicenciamientoTotal() {
        return costoLicenciamientoTotal;
    }

    @Override
    public String toString() {
        return "EstadisticasCatalogoDTO {" +
                "cantidadTitulos=" + cantidadTitulos +
                ", horasTotales=" + horasTotales +
                ", costoLicenciamientoTotal=$" + costoLicenciamientoTotal +
                '}';
    }
}// DTO para metricas
