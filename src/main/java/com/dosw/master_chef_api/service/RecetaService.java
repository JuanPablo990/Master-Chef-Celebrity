package com.dosw.master_chef_api.service;

import com.dosw.master_chef_api.model.Receta;
import com.dosw.master_chef_api.repository.RecetaRepository;
import com.dosw.master_chef_api.factory.RecetaFactory;

import java.util.*;

public class RecetaService {
    private final RecetaRepository repository = new RecetaRepository();
    private final List<Receta> recetas = new ArrayList<>();

    public Receta crearReceta(String tipoChef, Map<String, Object> datosReceta) {
        Receta receta = RecetaFactory.crearReceta(tipoChef, datosReceta);
        recetas.add(receta);
        return receta;
    }

    public List<Receta> listarRecetas() {
        return recetas;
    }

    public void guardarReceta(Integer id, Receta receta) {
        repository.save(id, receta);
    }

    public Receta obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public List<Receta> obtenerTodas() {
        return repository.findAll();
    }

    public void eliminar(Integer id) {
        repository.delete(id);
    }
}
