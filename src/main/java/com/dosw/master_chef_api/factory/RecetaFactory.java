package com.dosw.master_chef_api.factory;

import com.dosw.master_chef_api.model.*;
import java.util.Map;

public class RecetaFactory {

    public static Receta crearReceta(String tipoChef, Map<String, Object> datosReceta) {
        ChefBase chef;

        switch (tipoChef) {
            case "Televidente":
                chef = new Televidente(
                        (String) datosReceta.get("nombreChef"),
                        tipoChef,
                        (String) datosReceta.get("paisOrigen")
                );
                break;

            case "Participante":
                chef = new Participante(
                        (String) datosReceta.get("nombreChef"),
                        tipoChef,
                        (String) datosReceta.get("temporada"),
                        (String) datosReceta.get("puestoObtenido")
                );
                break;

            case "Jurado":
                chef = new Jurado(
                        (String) datosReceta.get("nombreChef"),
                        tipoChef,
                        (String) datosReceta.get("especialidadCulinaria")
                );
                break;

            default:
                throw new IllegalArgumentException("Tipo de chef no válido: " + tipoChef);
        }

        return new Receta(
                null,
                (String) datosReceta.get("nombre"),
                (String) datosReceta.get("ingredientes"),
                (String) datosReceta.get("instrucciones"),
                chef
        );
    }
}