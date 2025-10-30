package com.dosw.master_chef_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    private int id;
    private String titulo;
    private String descripcion;
    private List<String> ingredientes;
    private String instrucciones;
    private ChefBase chef;

    public Receta(Object id, String titulo, String ingredientes, String instrucciones, ChefBase chef) {
        this.id = id != null ? (Integer) id : 0;
        this.titulo = titulo;
        this.ingredientes = ingredientes != null ? List.of(ingredientes.split(", ")) : null;
        this.instrucciones = instrucciones;
        this.chef = chef;
    }
}