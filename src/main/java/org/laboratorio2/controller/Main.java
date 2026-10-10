package org.laboratorio2.controller;

import org.laboratorio2.config.AjustesPlataforma;
import org.laboratorio2.dto.EstadisticasCatalogoDTO;
import org.laboratorio2.model.Pelicula;
import org.laboratorio2.model.Serie;
import org.laboratorio2.service.GestorStreaming;

public class Main {
    public static void main(String[] args) {
        AjustesPlataforma ajustes = AjustesPlataforma.getInstance();
        ajustes.setRegion("LATAM");
        System.out.println("Región configurada: " + ajustes.getRegion());

        GestorStreaming gestor = new GestorStreaming();

        gestor.agregar(new Pelicula(1, "Inception", 148, false));
        gestor.agregar(new Pelicula(2, "Deadpool & Wolverine", 128, true));
        gestor.agregar(new Serie(3, "Breaking Bad", 2850, 62));
        gestor.agregar(new Serie(4, "Stranger Things", 2100, 34));

        gestor.guardarEnJSON("catalogo.json");
        System.out.println("Catálogo guardado en catalogo.json exitosamente.");

        GestorStreaming nuevoGestor = new GestorStreaming();
        nuevoGestor.cargarDesdeJSON("catalogo.json");
        System.out.println("Catálogo restaurado. Total elementos leídos: " + nuevoGestor.obtenerTodos().size());

        EstadisticasCatalogoDTO stats = nuevoGestor.generarEstadisticas();
        System.out.println(stats);
    }
}// Flujo principal de ejecucion
