package com.dosw.master_chef_api.repository;

import com.dosw.master_chef_api.model.Receta;
import java.util.*;

public class RecetaRepository {
    private final Map<Integer, Receta> dataStore = new HashMap<>();

    public void save(Integer id, Receta receta) {
        dataStore.put(id, receta);
    }

    public Receta findById(Integer id) {
        return dataStore.get(id);
    }

    public List<Receta> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    public void delete(Integer id) {
        dataStore.remove(id);
    }
}
