package com.dosw.master_chef_api.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecetaTest {


    @Test
    void testGetId_SetId_HappyPath() {
        Receta receta = new Receta();
        receta.setId(1);
        assertEquals(1, receta.getId());
    }

    @Test
    void testGetId_SetId_ErrorPath() {
        Receta receta = new Receta();
        receta.setId(1);
        assertNotEquals(2, receta.getId());
    }


    @Test
    void testGetTitulo_SetTitulo_HappyPath() {
        Receta receta = new Receta();
        receta.setTitulo("Sopa de Tomate");
        assertEquals("Sopa de Tomate", receta.getTitulo());
    }

    @Test
    void testGetTitulo_SetTitulo_ErrorPath() {
        Receta receta = new Receta();
        receta.setTitulo("Sopa de Tomate");
        assertNotEquals("Ensalada César", receta.getTitulo());
    }


    @Test
    void testGetDescripcion_SetDescripcion_HappyPath() {
        Receta receta = new Receta();
        receta.setDescripcion("Una deliciosa sopa de tomate");
        assertEquals("Una deliciosa sopa de tomate", receta.getDescripcion());
    }

    @Test
    void testGetDescripcion_SetDescripcion_ErrorPath() {
        Receta receta = new Receta();
        receta.setDescripcion("Una deliciosa sopa de tomate");
        assertNotEquals("Una ensalada fresca", receta.getDescripcion());
    }


    @Test
    void testGetIngredientes_SetIngredientes_HappyPath() {
        Receta receta = new Receta();
        List<String> ingredientes = Arrays.asList("Tomate", "Cebolla", "Ajo");
        receta.setIngredientes(ingredientes);
        assertEquals(ingredientes, receta.getIngredientes());
    }

    @Test
    void testGetIngredientes_SetIngredientes_ErrorPath() {
        Receta receta = new Receta();
        List<String> ingredientes = Arrays.asList("Tomate", "Cebolla", "Ajo");
        receta.setIngredientes(ingredientes);
        assertNotEquals(Arrays.asList("Lechuga", "Pollo"), receta.getIngredientes());
    }


    @Test
    void testGetInstrucciones_SetInstrucciones_HappyPath() {
        Receta receta = new Receta();
        receta.setInstrucciones("Cocinar todos los ingredientes");
        assertEquals("Cocinar todos los ingredientes", receta.getInstrucciones());
    }

    @Test
    void testGetInstrucciones_SetInstrucciones_ErrorPath() {
        Receta receta = new Receta();
        receta.setInstrucciones("Cocinar todos los ingredientes");
        assertNotEquals("Mezclar todos los ingredientes", receta.getInstrucciones());
    }


    @Test
    void testGetChef_SetChef_HappyPath() {
        ChefBase chefMock = mock(ChefBase.class);
        when(chefMock.getNombreChef()).thenReturn("Gordon Ramsay");

        Receta receta = new Receta();
        receta.setChef(chefMock);

        assertEquals(chefMock, receta.getChef());
        assertEquals("Gordon Ramsay", receta.getChef().getNombreChef());
        verify(chefMock).getNombreChef();
    }

    @Test
    void testGetChef_SetChef_ErrorPath() {
        ChefBase chefMock = mock(ChefBase.class);
        when(chefMock.getNombreChef()).thenReturn("Gordon Ramsay");

        Receta receta = new Receta();
        receta.setChef(chefMock);

        assertNotEquals("Jamie Oliver", receta.getChef().getNombreChef());
        verify(chefMock).getNombreChef();
    }


    @Test
    void testConstructorNoArgs_HappyPath() {
        Receta receta = new Receta();
        assertNotNull(receta);
        assertNull(receta.getTitulo());
        assertNull(receta.getChef());
    }

    @Test
    void testConstructorAllArgs_HappyPath() {
        ChefBase chefMock = mock(ChefBase.class);
        List<String> ingredientes = Arrays.asList("Tomate", "Cebolla");

        Receta receta = new Receta(1, "Sopa", "Descripción", ingredientes, "Instrucciones", chefMock);

        assertEquals(1, receta.getId());
        assertEquals("Sopa", receta.getTitulo());
        assertEquals("Descripción", receta.getDescripcion());
        assertEquals(ingredientes, receta.getIngredientes());
        assertEquals("Instrucciones", receta.getInstrucciones());
        assertEquals(chefMock, receta.getChef());
    }

    @Test
    void testConstructorAllArgs_ErrorPath() {
        ChefBase chefMock = mock(ChefBase.class);
        List<String> ingredientes = Arrays.asList("Tomate", "Cebolla");

        Receta receta = new Receta(1, "Sopa", "Descripción", ingredientes, "Instrucciones", chefMock);

        assertNotEquals(2, receta.getId());
        assertNotEquals("Ensalada", receta.getTitulo());
        assertNotEquals("Otra descripción", receta.getDescripcion());
        assertNotEquals(Arrays.asList("Lechuga"), receta.getIngredientes());
        assertNotEquals("Otras instrucciones", receta.getInstrucciones());
    }

    @Test
    void testConstructorSpecial_HappyPath() {
        ChefBase chefMock = mock(ChefBase.class);
        Receta receta = new Receta(1, "Sopa de Tomate", "Tomate, Cebolla, Ajo", "Cocinar por 30 minutos", chefMock);

        assertEquals(1, receta.getId());
        assertEquals("Sopa de Tomate", receta.getTitulo());
        assertEquals(Arrays.asList("Tomate", "Cebolla", "Ajo"), receta.getIngredientes());
        assertEquals("Cocinar por 30 minutos", receta.getInstrucciones());
        assertEquals(chefMock, receta.getChef());
    }

    @Test
    void testConstructorSpecial_NullId() {
        ChefBase chefMock = mock(ChefBase.class);
        Receta receta = new Receta(null, "Sopa de Tomate", "Tomate, Cebolla, Ajo", "Cocinar por 30 minutos", chefMock);

        assertEquals(0, receta.getId());
        assertEquals("Sopa de Tomate", receta.getTitulo());
        assertEquals(Arrays.asList("Tomate", "Cebolla", "Ajo"), receta.getIngredientes());
        assertEquals("Cocinar por 30 minutos", receta.getInstrucciones());
        assertEquals(chefMock, receta.getChef());
    }

    @Test
    void testConstructorSpecial_NullIngredientes() {
        ChefBase chefMock = mock(ChefBase.class);
        Receta receta = new Receta(1, "Sopa de Tomate", null, "Cocinar por 30 minutos", chefMock);

        assertEquals(1, receta.getId());
        assertEquals("Sopa de Tomate", receta.getTitulo());
        assertNull(receta.getIngredientes());
        assertEquals("Cocinar por 30 minutos", receta.getInstrucciones());
        assertEquals(chefMock, receta.getChef());
    }

    @Test
    void testConstructorSpecial_EmptyIngredientes() {
        ChefBase chefMock = mock(ChefBase.class);
        Receta receta = new Receta(1, "Sopa de Tomate", "", "Cocinar por 30 minutos", chefMock);

        assertEquals(1, receta.getId());
        assertEquals("Sopa de Tomate", receta.getTitulo());
        assertEquals(List.of(""), receta.getIngredientes());
        assertEquals("Cocinar por 30 minutos", receta.getInstrucciones());
        assertEquals(chefMock, receta.getChef());
    }

    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        assertTrue(receta1.equals(receta1));
    }

    @Test
    void testEquals_DifferentClass_ReturnsFalse() {
        Receta receta = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Object other = new Object();
        assertFalse(receta.equals(other));
    }

    @Test
    void testEquals_SameValues_ReturnsTrue() {
        ChefBase chef = new ChefBase("Chef", "Tipo");
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef);
        assertTrue(receta1.equals(receta2));
    }

    @Test
    void testEquals_DifferentValues_ReturnsFalse() {
        ChefBase chef1 = new ChefBase("Chef1", "Tipo1");
        ChefBase chef2 = new ChefBase("Chef2", "Tipo2");
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef1);
        Receta receta2 = new Receta(2, "Ensalada", "Otra Descripción", Arrays.asList("Lechuga"), "Otras Instrucciones", chef2);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testHashCode_SameValues_EqualHashCode() {
        ChefBase chef = new ChefBase("Chef", "Tipo");
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef);
        assertEquals(receta1.hashCode(), receta2.hashCode());
    }





    @Test
    void testCanEqual_WithSameType_ReturnsTrue() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Receta receta2 = new Receta(2, "Ensalada", "Otra Descripción", Arrays.asList("Lechuga"), "Otras Instrucciones", null);
        assertTrue(receta1.canEqual(receta2));
    }

    @Test
    void testCanEqual_WithDifferentType_ReturnsFalse() {
        Receta receta = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Object other = new Object();
        assertFalse(receta.canEqual(other));
    }

    @Test
    void testEquals_WithNull_ReturnsFalse() {
        Receta receta = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        assertFalse(receta.equals(null));
    }

    @Test
    void testEquals_Symmetric() {
        ChefBase chef = new ChefBase("Chef", "Tipo");
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef);

        assertTrue(receta1.equals(receta2));
        assertTrue(receta2.equals(receta1));
    }

    @Test
    void testEquals_DifferentId_ReturnsFalse() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Receta receta2 = new Receta(2, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testEquals_DifferentTitulo_ReturnsFalse() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Receta receta2 = new Receta(1, "Ensalada", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testEquals_DifferentDescripcion_ReturnsFalse() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Receta receta2 = new Receta(1, "Sopa", "Otra Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testEquals_DifferentIngredientes_ReturnsFalse() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Lechuga"), "Instrucciones", null);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testEquals_DifferentInstrucciones_ReturnsFalse() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Otras Instrucciones", null);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testEquals_DifferentChef_ReturnsFalse() {
        ChefBase chef1 = new ChefBase("Chef1", "Tipo1");
        ChefBase chef2 = new ChefBase("Chef2", "Tipo2");
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef1);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef2);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testEquals_OneNullChef_ReturnsFalse() {
        ChefBase chef = new ChefBase("Chef", "Tipo");
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", chef);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        assertFalse(receta1.equals(receta2));
    }

    @Test
    void testEquals_BothNullChef_ReturnsTrue() {
        Receta receta1 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        Receta receta2 = new Receta(1, "Sopa", "Descripción", Arrays.asList("Tomate"), "Instrucciones", null);
        assertTrue(receta1.equals(receta2));
    }

    @Test
    void testHashCode_WithNullFields() {
        Receta receta1 = new Receta();
        Receta receta2 = new Receta();
        assertEquals(receta1.hashCode(), receta2.hashCode());
    }

    @Test
    void testEquals_WithNullFields() {
        Receta receta1 = new Receta();
        Receta receta2 = new Receta();
        assertTrue(receta1.equals(receta2));
    }
}