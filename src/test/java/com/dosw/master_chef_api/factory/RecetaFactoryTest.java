package com.dosw.master_chef_api.factory;

import com.dosw.master_chef_api.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecetaFactoryTest {

    @Test
    void testCrearReceta_Televidente_HappyPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "María López");
        datosReceta.put("paisOrigen", "México");
        datosReceta.put("nombre", "Tacos al Pastor");
        datosReceta.put("ingredientes", "Carne, piña, cebolla, cilantro");
        datosReceta.put("instrucciones", "Marinar la carne y asar");

        Receta receta = RecetaFactory.crearReceta("Televidente", datosReceta);

        assertNotNull(receta);
        assertEquals("Tacos al Pastor", receta.getTitulo());
        assertEquals("Carne, piña, cebolla, cilantro", String.join(", ", receta.getIngredientes()));
        assertEquals("Marinar la carne y asar", receta.getInstrucciones());
        assertNotNull(receta.getChef());
        assertEquals("María López", receta.getChef().getNombreChef());
        assertEquals("Televidente", receta.getChef().getTipoChef());
        assertTrue(receta.getChef() instanceof Televidente);
        assertEquals("México", ((Televidente) receta.getChef()).getPaisOrigen());
    }

    @Test
    void testCrearReceta_Televidente_ErrorPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "María López");
        datosReceta.put("paisOrigen", "México");
        datosReceta.put("nombre", "Tacos al Pastor");
        datosReceta.put("ingredientes", "Carne, piña, cebolla, cilantro");
        datosReceta.put("instrucciones", "Marinar la carne y asar");

        Receta receta = RecetaFactory.crearReceta("Televidente", datosReceta);

        assertNotNull(receta);
        assertNotEquals("Enchiladas", receta.getTitulo());
        assertNotEquals("Tortillas, pollo, salsa", String.join(", ", receta.getIngredientes()));
        assertNotEquals("Freír las tortillas", receta.getInstrucciones());
        assertNotNull(receta.getChef());
        assertNotEquals("Juan Pérez", receta.getChef().getNombreChef());
        assertNotEquals("España", ((Televidente) receta.getChef()).getPaisOrigen());
    }

    @Test
    void testCrearReceta_Participante_HappyPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "Carlos García");
        datosReceta.put("temporada", "Temporada 5");
        datosReceta.put("puestoObtenido", "Primer Lugar");
        datosReceta.put("nombre", "Sopa de Mariscos");
        datosReceta.put("ingredientes", "Camarones, calamares, almejas, verduras");
        datosReceta.put("instrucciones", "Cocinar los mariscos con las verduras");

        Receta receta = RecetaFactory.crearReceta("Participante", datosReceta);

        assertNotNull(receta);
        assertEquals("Sopa de Mariscos", receta.getTitulo());
        assertEquals("Camarones, calamares, almejas, verduras", String.join(", ", receta.getIngredientes()));
        assertEquals("Cocinar los mariscos con las verduras", receta.getInstrucciones());
        assertNotNull(receta.getChef());
        assertEquals("Carlos García", receta.getChef().getNombreChef());
        assertEquals("Participante", receta.getChef().getTipoChef());
        assertTrue(receta.getChef() instanceof Participante);
        assertEquals("Temporada 5", ((Participante) receta.getChef()).getTemporada());
        assertEquals("Primer Lugar", ((Participante) receta.getChef()).getPuestoObtenido());
    }

    @Test
    void testCrearReceta_Participante_ErrorPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "Carlos García");
        datosReceta.put("temporada", "Temporada 5");
        datosReceta.put("puestoObtenido", "Primer Lugar");
        datosReceta.put("nombre", "Sopa de Mariscos");
        datosReceta.put("ingredientes", "Camarones, calamares, almejas, verduras");
        datosReceta.put("instrucciones", "Cocinar los mariscos con las verduras");

        Receta receta = RecetaFactory.crearReceta("Participante", datosReceta);

        assertNotNull(receta);
        assertNotEquals("Ensalada", receta.getTitulo());
        assertNotEquals("Lechuga, tomate, cebolla", String.join(", ", receta.getIngredientes()));
        assertNotEquals("Mezclar ingredientes", receta.getInstrucciones());
        assertNotNull(receta.getChef());
        assertNotEquals("Ana Rodríguez", receta.getChef().getNombreChef());
        assertNotEquals("Temporada 3", ((Participante) receta.getChef()).getTemporada());
        assertNotEquals("Segundo Lugar", ((Participante) receta.getChef()).getPuestoObtenido());
    }

    @Test
    void testCrearReceta_Jurado_HappyPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "Gordon Ramsay");
        datosReceta.put("especialidadCulinaria", "Alta Cocina");
        datosReceta.put("nombre", "Beef Wellington");
        datosReceta.put("ingredientes", "Lomo de res, hojaldre, paté, jamón");
        datosReceta.put("instrucciones", "Sellar la carne, envolver en hojaldre y hornear");

        Receta receta = RecetaFactory.crearReceta("Jurado", datosReceta);

        assertNotNull(receta);
        assertEquals("Beef Wellington", receta.getTitulo());
        assertEquals("Lomo de res, hojaldre, paté, jamón", String.join(", ", receta.getIngredientes()));
        assertEquals("Sellar la carne, envolver en hojaldre y hornear", receta.getInstrucciones());
        assertNotNull(receta.getChef());
        assertEquals("Gordon Ramsay", receta.getChef().getNombreChef());
        assertEquals("Jurado", receta.getChef().getTipoChef());
        assertTrue(receta.getChef() instanceof Jurado);
        assertEquals("Alta Cocina", ((Jurado) receta.getChef()).getEspecialidadCulinaria());
    }

    @Test
    void testCrearReceta_Jurado_ErrorPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "Gordon Ramsay");
        datosReceta.put("especialidadCulinaria", "Alta Cocina");
        datosReceta.put("nombre", "Beef Wellington");
        datosReceta.put("ingredientes", "Lomo de res, hojaldre, paté, jamón");
        datosReceta.put("instrucciones", "Sellar la carne, envolver en hojaldre y hornear");

        Receta receta = RecetaFactory.crearReceta("Jurado", datosReceta);

        assertNotNull(receta);
        assertNotEquals("Pasta Carbonara", receta.getTitulo());
        assertNotEquals("Pasta, huevo, panceta, queso", String.join(", ", receta.getIngredientes()));
        assertNotEquals("Cocinar la pasta y mezclar", receta.getInstrucciones());
        assertNotNull(receta.getChef());
        assertNotEquals("Jamie Oliver", receta.getChef().getNombreChef());
        assertNotEquals("Repostería", ((Jurado) receta.getChef()).getEspecialidadCulinaria());
    }

    @Test
    void testCrearReceta_TipoInvalido_HappyPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "Chef Invalido");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            RecetaFactory.crearReceta("TipoInvalido", datosReceta);
        });

        assertEquals("Tipo de chef no válido: TipoInvalido", exception.getMessage());
    }

    @Test
    void testCrearReceta_TipoInvalido_ErrorPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "Chef Invalido");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            RecetaFactory.crearReceta("TipoInvalido", datosReceta);
        });

        assertNotEquals("Mensaje incorrecto", exception.getMessage());
        assertTrue(exception.getMessage().contains("Tipo de chef no válido"));
    }
}