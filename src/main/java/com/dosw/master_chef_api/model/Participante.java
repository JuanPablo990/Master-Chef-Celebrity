package com.dosw.master_chef_api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Participante extends ChefBase {
    private String temporada;
    private String puestoObtenido;

    public Participante(String nombreChef, String tipoChef, String temporada, String puestoObtenido) {
        super(nombreChef, tipoChef);
        this.temporada = temporada;
        this.puestoObtenido = puestoObtenido;
    }
}