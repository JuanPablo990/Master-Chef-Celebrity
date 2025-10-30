package com.dosw.master_chef_api.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChefBaseTest {

    static class TestChef extends ChefBase {
        public TestChef() {
            super();
        }

        public TestChef(String nombreChef, String tipoChef) {
            super(nombreChef, tipoChef);
        }
    }

    @Test
    void testGetNombreChef_SetNombreChef_HappyPath() {
        TestChef chef = new TestChef();
        chef.setNombreChef("Gordon Ramsay");
        assertEquals("Gordon Ramsay", chef.getNombreChef());
    }

    @Test
    void testGetNombreChef_SetNombreChef_ErrorPath() {
        TestChef chef = new TestChef();
        chef.setNombreChef("Gordon Ramsay");
        assertNotEquals("Jamie Oliver", chef.getNombreChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_HappyPath() {
        TestChef chef = new TestChef();
        chef.setTipoChef("Ejecutivo");
        assertEquals("Ejecutivo", chef.getTipoChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_ErrorPath() {
        TestChef chef = new TestChef();
        chef.setTipoChef("Ejecutivo");
        assertNotEquals("Pastelero", chef.getTipoChef());
    }

    @Test
    void testConstructorNoArgs_HappyPath() {
        TestChef chef = new TestChef();
        assertNotNull(chef);
        assertNull(chef.getNombreChef());
        assertNull(chef.getTipoChef());
    }

    @Test
    void testConstructorNoArgs_ErrorPath() {
        TestChef chef = new TestChef();
        assertNotNull(chef);
        assertNotEquals("Gordon Ramsay", chef.getNombreChef());
        assertNotEquals("Ejecutivo", chef.getTipoChef());
    }

    @Test
    void testConstructorAllArgs_HappyPath() {
        TestChef chef = new TestChef("Gordon Ramsay", "Ejecutivo");
        assertEquals("Gordon Ramsay", chef.getNombreChef());
        assertEquals("Ejecutivo", chef.getTipoChef());
    }

    @Test
    void testConstructorAllArgs_ErrorPath() {
        TestChef chef = new TestChef("Gordon Ramsay", "Ejecutivo");
        assertNotEquals("Jamie Oliver", chef.getNombreChef());
        assertNotEquals("Pastelero", chef.getTipoChef());
    }

    @Test
    void testGetNombreChef_Mockito_HappyPath() {
        ChefBase chefMock = mock(ChefBase.class);
        when(chefMock.getNombreChef()).thenReturn("Gordon Ramsay");

        String nombreObtenido = chefMock.getNombreChef();

        assertEquals("Gordon Ramsay", nombreObtenido);
        verify(chefMock).getNombreChef();
    }

    @Test
    void testGetNombreChef_Mockito_ErrorPath() {
        ChefBase chefMock = mock(ChefBase.class);
        when(chefMock.getNombreChef()).thenReturn("Gordon Ramsay");

        String nombreObtenido = chefMock.getNombreChef();

        assertNotEquals("Jamie Oliver", nombreObtenido);
        verify(chefMock).getNombreChef();
    }

    @Test
    void testGetTipoChef_Mockito_HappyPath() {
        ChefBase chefMock = mock(ChefBase.class);
        when(chefMock.getTipoChef()).thenReturn("Ejecutivo");

        String tipoObtenido = chefMock.getTipoChef();

        assertEquals("Ejecutivo", tipoObtenido);
        verify(chefMock).getTipoChef();
    }

    @Test
    void testGetTipoChef_Mockito_ErrorPath() {
        ChefBase chefMock = mock(ChefBase.class);
        when(chefMock.getTipoChef()).thenReturn("Ejecutivo");

        String tipoObtenido = chefMock.getTipoChef();

        assertNotEquals("Pastelero", tipoObtenido);
        verify(chefMock).getTipoChef();
    }

    @Test
    void testSetters_Mockito_HappyPath() {
        TestChef chefReal = new TestChef();
        TestChef chefSpy = spy(chefReal);

        chefSpy.setNombreChef("Gordon Ramsay");
        chefSpy.setTipoChef("Ejecutivo");

        assertEquals("Gordon Ramsay", chefSpy.getNombreChef());
        assertEquals("Ejecutivo", chefSpy.getTipoChef());

        verify(chefSpy).setNombreChef("Gordon Ramsay");
        verify(chefSpy).setTipoChef("Ejecutivo");
        verify(chefSpy).getNombreChef();
        verify(chefSpy).getTipoChef();
    }

    @Test
    void testSetters_Mockito_ErrorPath() {
        TestChef chefReal = new TestChef();
        TestChef chefSpy = spy(chefReal);

        chefSpy.setNombreChef("Gordon Ramsay");
        chefSpy.setTipoChef("Ejecutivo");

        assertNotEquals("Jamie Oliver", chefSpy.getNombreChef());
        assertNotEquals("Pastelero", chefSpy.getTipoChef());

        verify(chefSpy).setNombreChef("Gordon Ramsay");
        verify(chefSpy).setTipoChef("Ejecutivo");
        verify(chefSpy).getNombreChef();
        verify(chefSpy).getTipoChef();
    }
}