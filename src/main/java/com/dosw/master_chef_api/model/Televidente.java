package com.dosw.master_chef_api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Televidente extends ChefBase {
    private String paisOrigen;

    public Televidente(String nombreChef, String tipoChef, String paisOrigen) {
        super(nombreChef, tipoChef);
        this.paisOrigen = paisOrigen;
    }
}