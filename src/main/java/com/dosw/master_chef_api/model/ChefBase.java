package com.dosw.master_chef_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChefBase {

    protected String nombreChef;
    protected String tipoChef;
}
