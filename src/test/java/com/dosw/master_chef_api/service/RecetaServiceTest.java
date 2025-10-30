package com.dosw.master_chef_api.service;

import com.dosw.master_chef_api.factory.RecetaFactory;
import com.dosw.master_chef_api.model.Receta;
import com.dosw.master_chef_api.repository.RecetaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecetaServiceTest {

    @Mock
    private RecetaRepository repositoryMock;

    private RecetaService recetaService;
    private List<Receta> recetas;

    @BeforeEach
    void setUp() throws Exception {
        recetaService = new RecetaService();

        // Inyectar el mock en el campo repository usando reflection
        Field repositoryField = RecetaService.class.getDeclaredField("repository");
        repositoryField.setAccessible(true);
        repositoryField.set(recetaService, repositoryMock);

        // Acceder a la lista interna de recetas
        Field recetasField = RecetaService.class.getDeclaredField("recetas");
        recetasField.setAccessible(true);
        recetas = (List<Receta>) recetasField.get(recetaService);
        recetas.clear();
    }

    @Test
    void testGuardarReceta_HappyPath() {
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");

        recetaService.guardarReceta(1, receta);

        verify(repositoryMock, times(1)).save(1, receta);
    }

    @Test
    void testGuardarReceta_ErrorPath() {
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");

        recetaService.guardarReceta(1, receta);

        verify(repositoryMock, never()).save(2, receta);
        verify(repositoryMock, times(1)).save(1, receta);
    }

    @Test
    void testObtenerPorId_HappyPath() {
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");

        when(repositoryMock.findById(1)).thenReturn(receta);

        Receta resultado = recetaService.obtenerPorId(1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Tacos al Pastor", resultado.getTitulo());
        verify(repositoryMock, times(1)).findById(1);
    }

    @Test
    void testObtenerPorId_ErrorPath() {
        when(repositoryMock.findById(999)).thenReturn(null);

        Receta resultado = recetaService.obtenerPorId(999);

        assertNull(resultado);
        verify(repositoryMock, times(1)).findById(999);
        verify(repositoryMock, never()).findById(1);
    }

    @Test
    void testObtenerTodas_HappyPath() {
        Receta receta1 = new Receta();
        receta1.setId(1);
        receta1.setTitulo("Tacos al Pastor");

        Receta receta2 = new Receta();
        receta2.setId(2);
        receta2.setTitulo("Enchiladas");

        List<Receta> recetasRepo = Arrays.asList(receta1, receta2);

        when(repositoryMock.findAll()).thenReturn(recetasRepo);

        List<Receta> resultado = recetaService.obtenerTodas();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(repositoryMock, times(1)).findAll();
    }

    @Test
    void testObtenerTodas_ErrorPath() {
        when(repositoryMock.findAll()).thenReturn(Collections.emptyList());

        List<Receta> resultado = recetaService.obtenerTodas();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(repositoryMock, times(1)).findAll();
    }

    @Test
    void testEliminar_HappyPath() {
        recetaService.eliminar(1);

        verify(repositoryMock, times(1)).delete(1);
    }

    @Test
    void testEliminar_ErrorPath() {
        recetaService.eliminar(1);

        verify(repositoryMock, never()).delete(2);
        verify(repositoryMock, times(1)).delete(1);
    }

    @Test
    void testCrearReceta_HappyPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "María López");
        datosReceta.put("paisOrigen", "México");
        datosReceta.put("nombre", "Tacos al Pastor");
        datosReceta.put("ingredientes", "Carne, piña, cebolla, cilantro");
        datosReceta.put("instrucciones", "Marinar la carne y asar");

        Receta receta = recetaService.crearReceta("Televidente", datosReceta);

        assertNotNull(receta);
        assertEquals("Tacos al Pastor", receta.getTitulo());
        assertEquals(1, recetas.size());
        assertTrue(recetas.contains(receta));
    }

    @Test
    void testListarRecetas_HappyPath() {
        Map<String, Object> datosReceta = new HashMap<>();
        datosReceta.put("nombreChef", "María López");
        datosReceta.put("paisOrigen", "México");
        datosReceta.put("nombre", "Tacos al Pastor");
        datosReceta.put("ingredientes", "Carne, piña, cebolla, cilantro");
        datosReceta.put("instrucciones", "Marinar la carne y asar");

        recetaService.crearReceta("Televidente", datosReceta);
        List<Receta> resultado = recetaService.listarRecetas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Tacos al Pastor", resultado.get(0).getTitulo());
    }
}