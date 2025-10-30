package com.dosw.master_chef_api.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JuradoTest {

    @Test
    void testGetEspecialidadCulinaria_SetEspecialidadCulinaria_HappyPath() {
        Jurado jurado = new Jurado();
        jurado.setEspecialidadCulinaria("Alta Cocina");
        assertEquals("Alta Cocina", jurado.getEspecialidadCulinaria());
    }

    @Test
    void testGetEspecialidadCulinaria_SetEspecialidadCulinaria_ErrorPath() {
        Jurado jurado = new Jurado();
        jurado.setEspecialidadCulinaria("Alta Cocina");
        assertNotEquals("Repostería", jurado.getEspecialidadCulinaria());
    }

    @Test
    void testGetNombreChef_SetNombreChef_HappyPath() {
        Jurado jurado = new Jurado();
        jurado.setNombreChef("Gordon Ramsay");
        assertEquals("Gordon Ramsay", jurado.getNombreChef());
    }

    @Test
    void testGetNombreChef_SetNombreChef_ErrorPath() {
        Jurado jurado = new Jurado();
        jurado.setNombreChef("Gordon Ramsay");
        assertNotEquals("Jamie Oliver", jurado.getNombreChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_HappyPath() {
        Jurado jurado = new Jurado();
        jurado.setTipoChef("Ejecutivo");
        assertEquals("Ejecutivo", jurado.getTipoChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_ErrorPath() {
        Jurado jurado = new Jurado();
        jurado.setTipoChef("Ejecutivo");
        assertNotEquals("Pastelero", jurado.getTipoChef());
    }

    @Test
    void testConstructorNoArgs_HappyPath() {
        Jurado jurado = new Jurado();
        assertNotNull(jurado);
        assertNull(jurado.getNombreChef());
        assertNull(jurado.getTipoChef());
        assertNull(jurado.getEspecialidadCulinaria());
    }

    @Test
    void testConstructorNoArgs_ErrorPath() {
        Jurado jurado = new Jurado();
        assertNotNull(jurado);
        assertNotEquals("Gordon Ramsay", jurado.getNombreChef());
        assertNotEquals("Ejecutivo", jurado.getTipoChef());
        assertNotEquals("Alta Cocina", jurado.getEspecialidadCulinaria());
    }


    @Test
    void testConstructorAllArgs_ErrorPath() {
        Jurado jurado = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        assertNotEquals("Jamie Oliver", jurado.getNombreChef());
        assertNotEquals("Pastelero", jurado.getTipoChef());
        assertNotEquals("Repostería", jurado.getEspecialidadCulinaria());
    }


    @Test
    void testConstructorThreeArgs_ErrorPath() {
        Jurado jurado = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        assertNotEquals("Jamie Oliver", jurado.getNombreChef());
        assertNotEquals("Pastelero", jurado.getTipoChef());
        assertNotEquals("Repostería", jurado.getEspecialidadCulinaria());
    }

    @Test
    void testGetEspecialidadCulinaria_Mockito_HappyPath() {
        Jurado juradoMock = mock(Jurado.class);
        when(juradoMock.getEspecialidadCulinaria()).thenReturn("Alta Cocina");

        String especialidadObtenida = juradoMock.getEspecialidadCulinaria();

        assertEquals("Alta Cocina", especialidadObtenida);
        verify(juradoMock).getEspecialidadCulinaria();
    }

    @Test
    void testGetEspecialidadCulinaria_Mockito_ErrorPath() {
        Jurado juradoMock = mock(Jurado.class);
        when(juradoMock.getEspecialidadCulinaria()).thenReturn("Alta Cocina");

        String especialidadObtenida = juradoMock.getEspecialidadCulinaria();

        assertNotEquals("Repostería", especialidadObtenida);
        verify(juradoMock).getEspecialidadCulinaria();
    }

    @Test
    void testGetNombreChef_Mockito_HappyPath() {
        Jurado juradoMock = mock(Jurado.class);
        when(juradoMock.getNombreChef()).thenReturn("Gordon Ramsay");

        String nombreObtenido = juradoMock.getNombreChef();

        assertEquals("Gordon Ramsay", nombreObtenido);
        verify(juradoMock).getNombreChef();
    }

    @Test
    void testGetNombreChef_Mockito_ErrorPath() {
        Jurado juradoMock = mock(Jurado.class);
        when(juradoMock.getNombreChef()).thenReturn("Gordon Ramsay");

        String nombreObtenido = juradoMock.getNombreChef();

        assertNotEquals("Jamie Oliver", nombreObtenido);
        verify(juradoMock).getNombreChef();
    }

    @Test
    void testGetTipoChef_Mockito_HappyPath() {
        Jurado juradoMock = mock(Jurado.class);
        when(juradoMock.getTipoChef()).thenReturn("Ejecutivo");

        String tipoObtenido = juradoMock.getTipoChef();

        assertEquals("Ejecutivo", tipoObtenido);
        verify(juradoMock).getTipoChef();
    }

    @Test
    void testGetTipoChef_Mockito_ErrorPath() {
        Jurado juradoMock = mock(Jurado.class);
        when(juradoMock.getTipoChef()).thenReturn("Ejecutivo");

        String tipoObtenido = juradoMock.getTipoChef();

        assertNotEquals("Pastelero", tipoObtenido);
        verify(juradoMock).getTipoChef();
    }

    @Test
    void testSetters_Mockito_HappyPath() {
        Jurado juradoReal = new Jurado();
        Jurado juradoSpy = spy(juradoReal);

        juradoSpy.setNombreChef("Gordon Ramsay");
        juradoSpy.setTipoChef("Ejecutivo");
        juradoSpy.setEspecialidadCulinaria("Alta Cocina");

        assertEquals("Gordon Ramsay", juradoSpy.getNombreChef());
        assertEquals("Ejecutivo", juradoSpy.getTipoChef());
        assertEquals("Alta Cocina", juradoSpy.getEspecialidadCulinaria());

        verify(juradoSpy).setNombreChef("Gordon Ramsay");
        verify(juradoSpy).setTipoChef("Ejecutivo");
        verify(juradoSpy).setEspecialidadCulinaria("Alta Cocina");
        verify(juradoSpy).getNombreChef();
        verify(juradoSpy).getTipoChef();
        verify(juradoSpy).getEspecialidadCulinaria();
    }

    @Test
    void testSetters_Mockito_ErrorPath() {
        Jurado juradoReal = new Jurado();
        Jurado juradoSpy = spy(juradoReal);

        juradoSpy.setNombreChef("Gordon Ramsay");
        juradoSpy.setTipoChef("Ejecutivo");
        juradoSpy.setEspecialidadCulinaria("Alta Cocina");

        assertNotEquals("Jamie Oliver", juradoSpy.getNombreChef());
        assertNotEquals("Pastelero", juradoSpy.getTipoChef());
        assertNotEquals("Repostería", juradoSpy.getEspecialidadCulinaria());

        verify(juradoSpy).setNombreChef("Gordon Ramsay");
        verify(juradoSpy).setTipoChef("Ejecutivo");
        verify(juradoSpy).setEspecialidadCulinaria("Alta Cocina");
        verify(juradoSpy).getNombreChef();
        verify(juradoSpy).getTipoChef();
        verify(juradoSpy).getEspecialidadCulinaria();
    }

    @Test
    void testConstructorThreeArgs_HappyPath() {
        Jurado jurado = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        assertEquals("Gordon Ramsay", jurado.getNombreChef());
        assertEquals("Ejecutivo", jurado.getTipoChef());
        assertEquals("Alta Cocina", jurado.getEspecialidadCulinaria());
    }

    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        assertTrue(jurado1.equals(jurado1));
    }

    @Test
    void testEquals_DifferentClass_ReturnsFalse() {
        Jurado jurado = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Object other = new Object();
        assertFalse(jurado.equals(other));
    }

    @Test
    void testEquals_SameValues_ReturnsTrue() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        assertTrue(jurado1.equals(jurado2));
    }

    @Test
    void testEquals_DifferentValues_ReturnsFalse() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Jamie Oliver", "Pastelero", "Repostería");
        assertFalse(jurado1.equals(jurado2));
    }

    @Test
    void testHashCode_SameValues_EqualHashCode() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        assertEquals(jurado1.hashCode(), jurado2.hashCode());
    }

    @Test
    void testHashCode_DifferentValues_DifferentHashCode() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Jamie Oliver", "Pastelero", "Repostería");
        assertNotEquals(jurado1.hashCode(), jurado2.hashCode());
    }


    @Test
    void testCanEqual_WithSameType_ReturnsTrue() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Jamie Oliver", "Pastelero", "Repostería");
        assertTrue(jurado1.canEqual(jurado2));
    }

    @Test
    void testCanEqual_WithDifferentType_ReturnsFalse() {
        Jurado jurado = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Object other = new Object();
        assertFalse(jurado.canEqual(other));
    }

    @Test
    void testEquals_WithNull_ReturnsFalse() {
        Jurado jurado = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        assertFalse(jurado.equals(null));
    }

    @Test
    void testEquals_Symmetric() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");

        assertTrue(jurado1.equals(jurado2));
        assertTrue(jurado2.equals(jurado1));
    }

    @Test
    void testEquals_Transitive() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado3 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");

        assertTrue(jurado1.equals(jurado2));
        assertTrue(jurado2.equals(jurado3));
        assertTrue(jurado1.equals(jurado3));
    }

    @Test
    void testEquals_DifferentNombreChef_ReturnsFalse() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Jamie Oliver", "Ejecutivo", "Alta Cocina");
        assertFalse(jurado1.equals(jurado2));
    }

    @Test
    void testEquals_DifferentTipoChef_ReturnsFalse() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Gordon Ramsay", "Pastelero", "Alta Cocina");
        assertFalse(jurado1.equals(jurado2));
    }

    @Test
    void testEquals_DifferentEspecialidad_ReturnsFalse() {
        Jurado jurado1 = new Jurado("Gordon Ramsay", "Ejecutivo", "Alta Cocina");
        Jurado jurado2 = new Jurado("Gordon Ramsay", "Ejecutivo", "Repostería");
        assertFalse(jurado1.equals(jurado2));
    }
}