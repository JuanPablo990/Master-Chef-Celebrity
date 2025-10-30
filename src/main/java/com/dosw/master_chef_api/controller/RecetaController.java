package com.dosw.master_chef_api.controller;

import com.dosw.master_chef_api.model.Receta;
import com.dosw.master_chef_api.service.RecetaService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    private final RecetaService recetaService = new RecetaService();

    // 1. Registrar una receta de un televidente
    @PostMapping("/televidente")
    public Receta registrarTelevidente(@RequestBody Map<String, Object> datos) {
        return recetaService.crearReceta("Televidente", datos);
    }

    // 2. Registrar una receta de un participante
    @PostMapping("/participante")
    public Receta registrarParticipante(@RequestBody Map<String, Object> datos) {
        return recetaService.crearReceta("Participante", datos);
    }

    // 3. Registrar una receta de un jurado (chef)
    @PostMapping("/chef")
    public Receta registrarChef(@RequestBody Map<String, Object> datos) {
        return recetaService.crearReceta("Jurado", datos);
    }

    // 4. Obtener todas las recetas
    @GetMapping
    public List<Receta> obtenerTodasLasRecetas() {
        return recetaService.obtenerTodas();
    }

    // 5. Obtener receta por ID
    @GetMapping("/{id}")
    public Receta obtenerPorId(@PathVariable Integer id) {
        return recetaService.obtenerPorId(id);
    }

    // 6. Recetas de participantes
    @GetMapping("/participantes")
    public List<Receta> obtenerRecetasParticipantes() {
        return filtrarPorTipoChef("Participante");
    }

    // 7. Recetas de televidentes
    @GetMapping("/televidentes")
    public List<Receta> obtenerRecetasTelevidentes() {
        return filtrarPorTipoChef("Televidente");
    }

    // 8. Recetas de chefs
    @GetMapping("/chefs")
    public List<Receta> obtenerRecetasChefs() {
        return filtrarPorTipoChef("Jurado");
    }

    // 9. Recetas por temporada (solo participantes)
    @GetMapping("/temporada/{temporada}")
    public List<Receta> obtenerPorTemporada(@PathVariable String temporada) {
        List<Receta> todas = recetaService.obtenerTodas();
        List<Receta> filtradas = new ArrayList<>();
        for (Receta receta : todas) {
            if (receta.getChef() != null
                    && "Participante".equalsIgnoreCase(receta.getChef().getTipoChef())) {
                String temp = ((Map<String, Object>) receta.getChef()).get("temporada").toString();
                if (temporada.equalsIgnoreCase(temp)) {
                    filtradas.add(receta);
                }
            }
        }
        return filtradas;
    }

    // 10. Buscar recetas por ingrediente
    @GetMapping("/buscar")
    public List<Receta> buscarPorIngrediente(@RequestParam String ingrediente) {
        List<Receta> todas = recetaService.obtenerTodas();
        List<Receta> filtradas = new ArrayList<>();
        for (Receta receta : todas) {
            List<String> ingredientes = receta.getIngredientes();
            if (ingredientes != null) {
                for (String ing : ingredientes) {
                    if (ing.toLowerCase().contains(ingrediente.toLowerCase())) {
                        filtradas.add(receta);
                        break;
                    }
                }
            }
        }
        return filtradas;
    }

    // 11. Eliminar receta
    @DeleteMapping("/{id}")
    public void eliminarReceta(@PathVariable Integer id) {
        recetaService.eliminar(id);
    }

    // 12. Actualizar receta
    @PutMapping("/{id}")
    public Receta actualizarReceta(@PathVariable Integer id, @RequestBody Map<String, Object> nuevosDatos) {
        Receta actual = recetaService.obtenerPorId(id);
        if (actual == null) return null;

        if (nuevosDatos.containsKey("titulo")) {
            actual.setTitulo((String) nuevosDatos.get("titulo"));
        }
        if (nuevosDatos.containsKey("ingredientes")) {
            Object ingredientes = nuevosDatos.get("ingredientes");
            if (ingredientes instanceof List) {
                actual.setIngredientes((List<String>) ingredientes);
            }
        }
        if (nuevosDatos.containsKey("instrucciones")) {
            actual.setInstrucciones((String) nuevosDatos.get("instrucciones"));
        }

        recetaService.guardarReceta(id, actual);
        return actual;
    }

    private List<Receta> filtrarPorTipoChef(String tipo) {
        List<Receta> todas = recetaService.obtenerTodas();
        List<Receta> filtradas = new ArrayList<>();
        for (Receta receta : todas) {
            if (receta.getChef() != null &&
                    tipo.equalsIgnoreCase(receta.getChef().getTipoChef())) {
                filtradas.add(receta);
            }
        }
        return filtradas;
    }
}
