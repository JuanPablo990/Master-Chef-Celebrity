package com.dosw.master_chef_api.repository;

import com.dosw.master_chef_api.model.Receta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecetaRepositoryTest {

    @Test
    void testSave_HappyPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");

        repository.save(1, receta);
        Receta encontrada = repository.findById(1);

        assertNotNull(encontrada);
        assertEquals(1, encontrada.getId());
        assertEquals("Tacos al Pastor", encontrada.getTitulo());
    }

    @Test
    void testSave_ErrorPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");

        repository.save(1, receta);
        Receta encontrada = repository.findById(1);

        assertNotNull(encontrada);
        assertNotEquals(2, encontrada.getId());
        assertNotEquals("Enchiladas", encontrada.getTitulo());
    }

    @Test
    void testFindById_HappyPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");
        repository.save(1, receta);

        Receta encontrada = repository.findById(1);

        assertNotNull(encontrada);
        assertEquals(1, encontrada.getId());
        assertEquals("Tacos al Pastor", encontrada.getTitulo());
    }

    @Test
    void testFindById_ErrorPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");
        repository.save(1, receta);

        Receta encontrada = repository.findById(2);

        assertNull(encontrada);
    }

    @Test
    void testFindAll_HappyPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta1 = new Receta();
        receta1.setId(1);
        receta1.setTitulo("Tacos al Pastor");

        Receta receta2 = new Receta();
        receta2.setId(2);
        receta2.setTitulo("Enchiladas");

        repository.save(1, receta1);
        repository.save(2, receta2);

        List<Receta> todas = repository.findAll();

        assertNotNull(todas);
        assertEquals(2, todas.size());
        assertTrue(todas.stream().anyMatch(r -> r.getId() == 1));
        assertTrue(todas.stream().anyMatch(r -> r.getId() == 2));
    }

    @Test
    void testFindAll_ErrorPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta1 = new Receta();
        receta1.setId(1);
        receta1.setTitulo("Tacos al Pastor");
        repository.save(1, receta1);

        List<Receta> todas = repository.findAll();

        assertNotNull(todas);
        assertFalse(todas.isEmpty());
        assertFalse(todas.stream().anyMatch(r -> r.getId() == 2));
    }

    @Test
    void testDelete_HappyPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");
        repository.save(1, receta);

        repository.delete(1);
        Receta eliminada = repository.findById(1);

        assertNull(eliminada);
    }

    @Test
    void testDelete_ErrorPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta = new Receta();
        receta.setId(1);
        receta.setTitulo("Tacos al Pastor");
        repository.save(1, receta);

        repository.delete(2);
        Receta noEliminada = repository.findById(1);

        assertNotNull(noEliminada);
        assertEquals(1, noEliminada.getId());
    }

    @Test
    void testSave_Overwrite_HappyPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta1 = new Receta();
        receta1.setId(1);
        receta1.setTitulo("Tacos al Pastor");
        repository.save(1, receta1);

        Receta receta2 = new Receta();
        receta2.setId(1);
        receta2.setTitulo("Tacos Actualizados");
        repository.save(1, receta2);

        Receta actualizada = repository.findById(1);

        assertNotNull(actualizada);
        assertEquals(1, actualizada.getId());
        assertEquals("Tacos Actualizados", actualizada.getTitulo());
    }

    @Test
    void testSave_Overwrite_ErrorPath() {
        RecetaRepository repository = new RecetaRepository();
        Receta receta1 = new Receta();
        receta1.setId(1);
        receta1.setTitulo("Tacos al Pastor");
        repository.save(1, receta1);

        Receta receta2 = new Receta();
        receta2.setId(1);
        receta2.setTitulo("Tacos Actualizados");
        repository.save(1, receta2);

        Receta actualizada = repository.findById(1);

        assertNotNull(actualizada);
        assertNotEquals("Tacos al Pastor", actualizada.getTitulo());
    }

    @Test
    void testFindAll_Empty_HappyPath() {
        RecetaRepository repository = new RecetaRepository();

        List<Receta> todas = repository.findAll();

        assertNotNull(todas);
        assertTrue(todas.isEmpty());
    }

    @Test
    void testFindAll_Empty_ErrorPath() {
        RecetaRepository repository = new RecetaRepository();

        List<Receta> todas = repository.findAll();

        assertNotNull(todas);
        assertEquals(0, todas.size());
        assertFalse(todas.stream().anyMatch(r -> r.getId() == 1));
    }
}