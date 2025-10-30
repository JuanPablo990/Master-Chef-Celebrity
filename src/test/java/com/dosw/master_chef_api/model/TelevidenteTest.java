package com.dosw.master_chef_api.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TelevidenteTest {

    @Test
    void testGetPaisOrigen_SetPaisOrigen_HappyPath() {
        Televidente televidente = new Televidente();
        televidente.setPaisOrigen("México");
        assertEquals("México", televidente.getPaisOrigen());
    }

    @Test
    void testGetPaisOrigen_SetPaisOrigen_ErrorPath() {
        Televidente televidente = new Televidente();
        televidente.setPaisOrigen("México");
        assertNotEquals("España", televidente.getPaisOrigen());
    }

    @Test
    void testGetNombreChef_SetNombreChef_HappyPath() {
        Televidente televidente = new Televidente();
        televidente.setNombreChef("María López");
        assertEquals("María López", televidente.getNombreChef());
    }

    @Test
    void testGetNombreChef_SetNombreChef_ErrorPath() {
        Televidente televidente = new Televidente();
        televidente.setNombreChef("María López");
        assertNotEquals("Juan Pérez", televidente.getNombreChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_HappyPath() {
        Televidente televidente = new Televidente();
        televidente.setTipoChef("Espectador");
        assertEquals("Espectador", televidente.getTipoChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_ErrorPath() {
        Televidente televidente = new Televidente();
        televidente.setTipoChef("Espectador");
        assertNotEquals("Concursante", televidente.getTipoChef());
    }

    @Test
    void testConstructorNoArgs_HappyPath() {
        Televidente televidente = new Televidente();
        assertNotNull(televidente);
        assertNull(televidente.getNombreChef());
        assertNull(televidente.getTipoChef());
        assertNull(televidente.getPaisOrigen());
    }

    @Test
    void testConstructorNoArgs_ErrorPath() {
        Televidente televidente = new Televidente();
        assertNotNull(televidente);
        assertNotEquals("María López", televidente.getNombreChef());
        assertNotEquals("Espectador", televidente.getTipoChef());
        assertNotEquals("México", televidente.getPaisOrigen());
    }

    @Test
    void testConstructorAllArgs_HappyPath() {
        Televidente televidente = new Televidente("María López", "Espectador", "México");
        assertEquals("María López", televidente.getNombreChef());
        assertEquals("Espectador", televidente.getTipoChef());
        assertEquals("México", televidente.getPaisOrigen());
    }

    @Test
    void testConstructorAllArgs_ErrorPath() {
        Televidente televidente = new Televidente("María López", "Espectador", "México");
        assertNotEquals("Juan Pérez", televidente.getNombreChef());
        assertNotEquals("Concursante", televidente.getTipoChef());
        assertNotEquals("España", televidente.getPaisOrigen());
    }

    @Test
    void testConstructorThreeArgs_HappyPath() {
        Televidente televidente = new Televidente("María López", "Espectador", "México");
        assertEquals("María López", televidente.getNombreChef());
        assertEquals("Espectador", televidente.getTipoChef());
        assertEquals("México", televidente.getPaisOrigen());
    }

    @Test
    void testConstructorThreeArgs_ErrorPath() {
        Televidente televidente = new Televidente("María López", "Espectador", "México");
        assertNotEquals("Juan Pérez", televidente.getNombreChef());
        assertNotEquals("Concursante", televidente.getTipoChef());
        assertNotEquals("España", televidente.getPaisOrigen());
    }

    @Test
    void testGetPaisOrigen_Mockito_HappyPath() {
        Televidente televidenteMock = mock(Televidente.class);
        when(televidenteMock.getPaisOrigen()).thenReturn("México");

        String paisObtenido = televidenteMock.getPaisOrigen();

        assertEquals("México", paisObtenido);
        verify(televidenteMock).getPaisOrigen();
    }

    @Test
    void testGetPaisOrigen_Mockito_ErrorPath() {
        Televidente televidenteMock = mock(Televidente.class);
        when(televidenteMock.getPaisOrigen()).thenReturn("México");

        String paisObtenido = televidenteMock.getPaisOrigen();

        assertNotEquals("España", paisObtenido);
        verify(televidenteMock).getPaisOrigen();
    }

    @Test
    void testGetNombreChef_Mockito_HappyPath() {
        Televidente televidenteMock = mock(Televidente.class);
        when(televidenteMock.getNombreChef()).thenReturn("María López");

        String nombreObtenido = televidenteMock.getNombreChef();

        assertEquals("María López", nombreObtenido);
        verify(televidenteMock).getNombreChef();
    }

    @Test
    void testGetNombreChef_Mockito_ErrorPath() {
        Televidente televidenteMock = mock(Televidente.class);
        when(televidenteMock.getNombreChef()).thenReturn("María López");

        String nombreObtenido = televidenteMock.getNombreChef();

        assertNotEquals("Juan Pérez", nombreObtenido);
        verify(televidenteMock).getNombreChef();
    }

    @Test
    void testGetTipoChef_Mockito_HappyPath() {
        Televidente televidenteMock = mock(Televidente.class);
        when(televidenteMock.getTipoChef()).thenReturn("Espectador");

        String tipoObtenido = televidenteMock.getTipoChef();

        assertEquals("Espectador", tipoObtenido);
        verify(televidenteMock).getTipoChef();
    }

    @Test
    void testGetTipoChef_Mockito_ErrorPath() {
        Televidente televidenteMock = mock(Televidente.class);
        when(televidenteMock.getTipoChef()).thenReturn("Espectador");

        String tipoObtenido = televidenteMock.getTipoChef();

        assertNotEquals("Concursante", tipoObtenido);
        verify(televidenteMock).getTipoChef();
    }

    @Test
    void testSetters_Mockito_HappyPath() {
        Televidente televidenteReal = new Televidente();
        Televidente televidenteSpy = spy(televidenteReal);

        televidenteSpy.setNombreChef("María López");
        televidenteSpy.setTipoChef("Espectador");
        televidenteSpy.setPaisOrigen("México");

        assertEquals("María López", televidenteSpy.getNombreChef());
        assertEquals("Espectador", televidenteSpy.getTipoChef());
        assertEquals("México", televidenteSpy.getPaisOrigen());

        verify(televidenteSpy).setNombreChef("María López");
        verify(televidenteSpy).setTipoChef("Espectador");
        verify(televidenteSpy).setPaisOrigen("México");
        verify(televidenteSpy).getNombreChef();
        verify(televidenteSpy).getTipoChef();
        verify(televidenteSpy).getPaisOrigen();
    }

    @Test
    void testSetters_Mockito_ErrorPath() {
        Televidente televidenteReal = new Televidente();
        Televidente televidenteSpy = spy(televidenteReal);

        televidenteSpy.setNombreChef("María López");
        televidenteSpy.setTipoChef("Espectador");
        televidenteSpy.setPaisOrigen("México");

        assertNotEquals("Juan Pérez", televidenteSpy.getNombreChef());
        assertNotEquals("Concursante", televidenteSpy.getTipoChef());
        assertNotEquals("España", televidenteSpy.getPaisOrigen());

        verify(televidenteSpy).setNombreChef("María López");
        verify(televidenteSpy).setTipoChef("Espectador");
        verify(televidenteSpy).setPaisOrigen("México");
        verify(televidenteSpy).getNombreChef();
        verify(televidenteSpy).getTipoChef();
        verify(televidenteSpy).getPaisOrigen();
    }

    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        assertTrue(televidente1.equals(televidente1));
    }

    @Test
    void testEquals_DifferentClass_ReturnsFalse() {
        Televidente televidente = new Televidente("María López", "Espectador", "México");
        Object other = new Object();
        assertFalse(televidente.equals(other));
    }

    @Test
    void testEquals_SameValues_ReturnsTrue() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        Televidente televidente2 = new Televidente("María López", "Espectador", "México");
        assertTrue(televidente1.equals(televidente2));
    }

    @Test
    void testEquals_DifferentValues_ReturnsFalse() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        Televidente televidente2 = new Televidente("Juan Pérez", "Concursante", "España");
        assertFalse(televidente1.equals(televidente2));
    }

    @Test
    void testHashCode_SameValues_EqualHashCode() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        Televidente televidente2 = new Televidente("María López", "Espectador", "México");
        assertEquals(televidente1.hashCode(), televidente2.hashCode());
    }

    @Test
    void testHashCode_DifferentValues_DifferentHashCode() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        Televidente televidente2 = new Televidente("Juan Pérez", "Concursante", "España");
        assertNotEquals(televidente1.hashCode(), televidente2.hashCode());
    }


    @Test
    void testCanEqual_WithSameType_ReturnsTrue() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        Televidente televidente2 = new Televidente("Juan Pérez", "Concursante", "España");
        assertTrue(televidente1.canEqual(televidente2));
    }

    @Test
    void testCanEqual_WithDifferentType_ReturnsFalse() {
        Televidente televidente = new Televidente("María López", "Espectador", "México");
        Object other = new Object();
        assertFalse(televidente.canEqual(other));
    }

    @Test
    void testEquals_WithNull_ReturnsFalse() {
        Televidente televidente = new Televidente("María López", "Espectador", "México");
        assertFalse(televidente.equals(null));
    }

    @Test
    void testEquals_Symmetric() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        Televidente televidente2 = new Televidente("María López", "Espectador", "México");

        assertTrue(televidente1.equals(televidente2));
        assertTrue(televidente2.equals(televidente1));
    }

    @Test
    void testEquals_Transitive() {
        Televidente televidente1 = new Televidente("María López", "Espectador", "México");
        Televidente televidente2 = new Televidente("María López", "Espectador", "México");
        Televidente televidente3 = new Televidente("María López", "Espectador", "México");

        assertTrue(televidente1.equals(televidente2));
        assertTrue(televidente2.equals(televidente3));
        assertTrue(televidente1.equals(televidente3));
    }
}