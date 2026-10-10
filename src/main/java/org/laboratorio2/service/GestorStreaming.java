package org.laboratorio2.service;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.laboratorio2.dto.EstadisticasCatalogoDTO;
import org.laboratorio2.model.Contenido;
import org.laboratorio2.model.Pelicula;
import org.laboratorio2.model.Serie;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestorStreaming implements RepositorioGenerico<Contenido> {
    private List<Contenido> catalogo = new ArrayList<>();
    private final Gson gson;

    public GestorStreaming() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Contenido.class, (JsonDeserializer<Contenido>) (json, typeOfT, context) -> {
                    JsonObject jsonObject = json.getAsJsonObject();
                    // Si contiene numCapitulos es Serie, si no es Pelicula
                    if (jsonObject.has("numCapitulos")) {
                        return context.deserialize(jsonObject, Serie.class);
                    } else {
                        return context.deserialize(jsonObject, Pelicula.class);
                    }
                })
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void agregar(Contenido elemento) {
        catalogo.add(elemento);
    }

    @Override
    public List<Contenido> obtenerTodos() {
        return catalogo;
    }

    @Override
    public void guardarEnJSON(String ruta) {
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(catalogo, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cargarDesdeJSON(String ruta) {
        try (Reader reader = new FileReader(ruta)) {
            Type tipoLista = new TypeToken<ArrayList<Contenido>>() {}.getType();
            List<Contenido> cargados = gson.fromJson(reader, tipoLista);
            if (cargados != null) {
                this.catalogo = cargados;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EstadisticasCatalogoDTO generarEstadisticas() {
        int totalMinutos = 0;
        double costoLicenciaTotal = 0.0;

        for (Contenido c : catalogo) {
            totalMinutos += c.getDuracionMinutos();
            costoLicenciaTotal += c.calcularCostoLicencia();
        }

        double horasTotales = totalMinutos / 60.0;
        return new EstadisticasCatalogoDTO(catalogo.size(), horasTotales, costoLicenciaTotal);
    }
}// Logica de persistencia y calculo
