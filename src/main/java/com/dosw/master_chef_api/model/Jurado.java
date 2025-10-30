package com.dosw.master_chef_api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Jurado extends ChefBase {
    private String especialidadCulinaria;

    public Jurado(String nombreChef, String tipoChef, String especialidadCulinaria) {
        super(nombreChef, tipoChef);
        this.especialidadCulinaria = especialidadCulinaria;
    }
}