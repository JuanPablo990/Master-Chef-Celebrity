package com.dosw.master_chef_api.controller;

import com.dosw.master_chef_api.model.Receta;
import com.dosw.master_chef_api.service.RecetaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.lang.reflect.Field;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecetaControllerTest {

    @Mock
    private RecetaService recetaServiceMock;

    private RecetaController recetaController;

    @BeforeEach
    void setUp() throws Exception {
        recetaController = new RecetaController();
        Field serviceField = RecetaController.class.getDeclaredField("recetaService");
        serviceField.setAccessible(true);
        serviceField.set(recetaController, recetaServiceMock);
    }

    @Test
    void testRegistrarTelevidente_HappyPath() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombreChef", "María López");
        datos.put("paisOrigen", "México");
        datos.put("nombre", "Tacos al Pastor");
        Receta recetaMock = new Receta();
        recetaMock.setTitulo("Tacos al Pastor");
        when(recetaServiceMock.crearReceta("Televidente", datos)).thenReturn(recetaMock);
        Receta resultado = recetaController.registrarTelevidente(datos);
        assertNotNull(resultado);
        assertEquals("Tacos al Pastor", resultado.getTitulo());
        verify(recetaServiceMock, times(1)).crearReceta("Televidente", datos);
    }

    @Test
    void testRegistrarTelevidente_ErrorPath() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombreChef", "María López");
        Receta recetaMock = new Receta();
        recetaMock.setTitulo("Tacos al Pastor");
        when(recetaServiceMock.crearReceta("Televidente", datos)).thenReturn(recetaMock);
        Receta resultado = recetaController.registrarTelevidente(datos);
        assertNotNull(resultado);
        assertNotEquals("Enchiladas", resultado.getTitulo());
        verify(recetaServiceMock, never()).crearReceta("Participante", datos);
    }

    @Test
    void testRegistrarParticipante_HappyPath() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombreChef", "Carlos García");
        datos.put("temporada", "Temporada 5");
        datos.put("puestoObtenido", "Primer Lugar");
        datos.put("nombre", "Sopa de Mariscos");
        Receta recetaMock = new Receta();
        recetaMock.setTitulo("Sopa de Mariscos");
        when(recetaServiceMock.crearReceta("Participante", datos)).thenReturn(recetaMock);
        Receta resultado = recetaController.registrarParticipante(datos);
        assertNotNull(resultado);
        assertEquals("Sopa de Mariscos", resultado.getTitulo());
        verify(recetaServiceMock, times(1)).crearReceta("Participante", datos);
    }

    @Test
    void testRegistrarParticipante_ErrorPath() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombreChef", "Carlos García");
        Receta recetaMock = new Receta();
        recetaMock.setTitulo("Sopa de Mariscos");
        when(recetaServiceMock.crearReceta("Participante", datos)).thenReturn(recetaMock);
        Receta resultado = recetaController.registrarParticipante(datos);
        assertNotNull(resultado);
        assertNotEquals("Ensalada", resultado.getTitulo());
        verify(recetaServiceMock, never()).crearReceta("Televidente", datos);
    }

    @Test
    void testRegistrarChef_HappyPath() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombreChef", "Gordon Ramsay");
        datos.put("especialidadCulinaria", "Alta Cocina");
        datos.put("nombre", "Beef Wellington");
        Receta recetaMock = new Receta();
        recetaMock.setTitulo("Beef Wellington");
        when(recetaServiceMock.crearReceta("Jurado", datos)).thenReturn(recetaMock);
        Receta resultado = recetaController.registrarChef(datos);
        assertNotNull(resultado);
        assertEquals("Beef Wellington", resultado.getTitulo());
        verify(recetaServiceMock, times(1)).crearReceta("Jurado", datos);
    }

    @Test
    void testRegistrarChef_ErrorPath() {
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombreChef", "Gordon Ramsay");
        Receta recetaMock = new Receta();
        recetaMock.setTitulo("Beef Wellington");
        when(recetaServiceMock.crearReceta("Jurado", datos)).thenReturn(recetaMock);
        Receta resultado = recetaController.registrarChef(datos);
        assertNotNull(resultado);
        assertNotEquals("Pasta Carbonara", resultado.getTitulo());
        verify(recetaServiceMock, never()).crearReceta("Participante", datos);
    }

    @Test
    void testObtenerTodasLasRecetas_HappyPath() {
        Receta receta1 = new Receta();
        receta1.setId(1);
        receta1.setTitulo("Tacos al Pastor");
        Receta receta2 = new Receta();
        receta2.setId(2);
        receta2.setTitulo("Enchiladas");
        List<Receta> recetas = Arrays.asList(receta1, receta2);
        when(recetaServiceMock.obtenerTodas()).thenReturn(recetas);
        List<Receta> resultado = recetaController.obtenerTodasLasRecetas();
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testObtenerTodasLasRecetas_ErrorPath() {
        when(recetaServiceMock.obtenerTodas()).thenReturn(Collections.emptyList());
        List<Receta> resultado = recetaController.obtenerTodasLasRecetas();
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testObtenerPorId_HappyPath() {
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");
        when(recetaServiceMock.obtenerPorId(1)).thenReturn(receta);
        Receta resultado = recetaController.obtenerPorId(1);
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("Tacos al Pastor", resultado.getTitulo());
        verify(recetaServiceMock, times(1)).obtenerPorId(1);
    }

    @Test
    void testObtenerPorId_ErrorPath() {
        when(recetaServiceMock.obtenerPorId(999)).thenReturn(null);
        Receta resultado = recetaController.obtenerPorId(999);
        assertNull(resultado);
        verify(recetaServiceMock, times(1)).obtenerPorId(999);
    }

    @Test
    void testObtenerRecetasParticipantes_HappyPath() {
        Receta recetaParticipante = new Receta();
        recetaParticipante.setTitulo("Receta Participante");
        Receta recetaTelevidente = new Receta();
        recetaTelevidente.setTitulo("Receta Televidente");
        List<Receta> todas = Arrays.asList(recetaParticipante, recetaTelevidente);
        when(recetaServiceMock.obtenerTodas()).thenReturn(todas);
        List<Receta> resultado = recetaController.obtenerRecetasParticipantes();
        assertNotNull(resultado);
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testObtenerRecetasTelevidentes_HappyPath() {
        Receta recetaTelevidente = new Receta();
        recetaTelevidente.setTitulo("Receta Televidente");
        List<Receta> todas = Collections.singletonList(recetaTelevidente);
        when(recetaServiceMock.obtenerTodas()).thenReturn(todas);
        List<Receta> resultado = recetaController.obtenerRecetasTelevidentes();
        assertNotNull(resultado);
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testObtenerRecetasChefs_HappyPath() {
        Receta recetaChef = new Receta();
        recetaChef.setTitulo("Receta Chef");
        List<Receta> todas = Collections.singletonList(recetaChef);
        when(recetaServiceMock.obtenerTodas()).thenReturn(todas);
        List<Receta> resultado = recetaController.obtenerRecetasChefs();
        assertNotNull(resultado);
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testObtenerPorTemporada_HappyPath() {
        Receta receta = new Receta();
        receta.setTitulo("Receta Temporada 5");
        List<Receta> todas = Collections.singletonList(receta);
        when(recetaServiceMock.obtenerTodas()).thenReturn(todas);
        List<Receta> resultado = recetaController.obtenerPorTemporada("Temporada 5");
        assertNotNull(resultado);
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testObtenerPorTemporada_ErrorPath() {
        when(recetaServiceMock.obtenerTodas()).thenReturn(Collections.emptyList());
        List<Receta> resultado = recetaController.obtenerPorTemporada("Temporada 5");
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testBuscarPorIngrediente_HappyPath() {
        Receta receta = new Receta();
        receta.setTitulo("Tacos al Pastor");
        receta.setIngredientes(Arrays.asList("Carne", "Piña", "Cebolla"));
        List<Receta> todas = Collections.singletonList(receta);
        when(recetaServiceMock.obtenerTodas()).thenReturn(todas);
        List<Receta> resultado = recetaController.buscarPorIngrediente("carne");
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testBuscarPorIngrediente_ErrorPath() {
        Receta receta = new Receta();
        receta.setTitulo("Tacos al Pastor");
        receta.setIngredientes(Arrays.asList("Carne", "Piña", "Cebolla"));
        List<Receta> todas = Collections.singletonList(receta);
        when(recetaServiceMock.obtenerTodas()).thenReturn(todas);
        List<Receta> resultado = recetaController.buscarPorIngrediente("pollo");
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }

    @Test
    void testEliminarReceta_HappyPath() {
        recetaController.eliminarReceta(1);
        verify(recetaServiceMock, times(1)).eliminar(1);
    }

    @Test
    void testEliminarReceta_ErrorPath() {
        recetaController.eliminarReceta(1);
        verify(recetaServiceMock, never()).eliminar(2);
        verify(recetaServiceMock, times(1)).eliminar(1);
    }

    @Test
    void testActualizarReceta_HappyPath() {
        Receta recetaActual = new Receta();
        recetaActual.setId(1);
        recetaActual.setTitulo("Título Antiguo");
        recetaActual.setIngredientes(Arrays.asList("Ingrediente1"));
        recetaActual.setInstrucciones("Instrucciones antiguas");
        Map<String, Object> nuevosDatos = new HashMap<>();
        nuevosDatos.put("titulo", "Título Nuevo");
        nuevosDatos.put("ingredientes", Arrays.asList("Ingrediente1", "Ingrediente2"));
        nuevosDatos.put("instrucciones", "Instrucciones nuevas");
        when(recetaServiceMock.obtenerPorId(1)).thenReturn(recetaActual);
        Receta resultado = recetaController.actualizarReceta(1, nuevosDatos);
        assertNotNull(resultado);
        assertEquals("Título Nuevo", resultado.getTitulo());
        assertEquals(2, resultado.getIngredientes().size());
        assertEquals("Instrucciones nuevas", resultado.getInstrucciones());
        verify(recetaServiceMock, times(1)).guardarReceta(1, recetaActual);
    }

    @Test
    void testActualizarReceta_ErrorPath() {
        when(recetaServiceMock.obtenerPorId(999)).thenReturn(null);
        Map<String, Object> nuevosDatos = new HashMap<>();
        nuevosDatos.put("titulo", "Título Nuevo");
        Receta resultado = recetaController.actualizarReceta(999, nuevosDatos);
        assertNull(resultado);
        verify(recetaServiceMock, never()).guardarReceta(anyInt(), any(Receta.class));
    }

    @Test
    void testActualizarReceta_Parcial_HappyPath() {
        Receta recetaActual = new Receta();
        recetaActual.setId(1);
        recetaActual.setTitulo("Título Antiguo");
        recetaActual.setIngredientes(Arrays.asList("Ingrediente1"));
        recetaActual.setInstrucciones("Instrucciones antiguas");
        Map<String, Object> nuevosDatos = new HashMap<>();
        nuevosDatos.put("titulo", "Título Nuevo");
        when(recetaServiceMock.obtenerPorId(1)).thenReturn(recetaActual);
        Receta resultado = recetaController.actualizarReceta(1, nuevosDatos);
        assertNotNull(resultado);
        assertEquals("Título Nuevo", resultado.getTitulo());
        assertEquals(1, resultado.getIngredientes().size());
        assertEquals("Instrucciones antiguas", resultado.getInstrucciones());
        verify(recetaServiceMock, times(1)).guardarReceta(1, recetaActual);
    }

    @Test
    void testFiltrarPorTipoChef_HappyPath() throws Exception {
        java.lang.reflect.Method method = RecetaController.class.getDeclaredMethod("filtrarPorTipoChef", String.class);
        method.setAccessible(true);
        Receta receta = new Receta();
        receta.setTitulo("Receta Test");
        List<Receta> todas = Collections.singletonList(receta);
        when(recetaServiceMock.obtenerTodas()).thenReturn(todas);
        @SuppressWarnings("unchecked")
        List<Receta> resultado = (List<Receta>) method.invoke(recetaController, "Televidente");
        assertNotNull(resultado);
        verify(recetaServiceMock, times(1)).obtenerTodas();
    }
}
