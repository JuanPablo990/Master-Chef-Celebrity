package com.dosw.master_chef_api.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParticipanteTest {

    @Test
    void testGetTemporada_SetTemporada_HappyPath() {
        Participante participante = new Participante();
        participante.setTemporada("Temporada 5");
        assertEquals("Temporada 5", participante.getTemporada());
    }

    @Test
    void testGetTemporada_SetTemporada_ErrorPath() {
        Participante participante = new Participante();
        participante.setTemporada("Temporada 5");
        assertNotEquals("Temporada 3", participante.getTemporada());
    }

    @Test
    void testGetPuestoObtenido_SetPuestoObtenido_HappyPath() {
        Participante participante = new Participante();
        participante.setPuestoObtenido("Primer Lugar");
        assertEquals("Primer Lugar", participante.getPuestoObtenido());
    }

    @Test
    void testGetPuestoObtenido_SetPuestoObtenido_ErrorPath() {
        Participante participante = new Participante();
        participante.setPuestoObtenido("Primer Lugar");
        assertNotEquals("Segundo Lugar", participante.getPuestoObtenido());
    }

    @Test
    void testGetNombreChef_SetNombreChef_HappyPath() {
        Participante participante = new Participante();
        participante.setNombreChef("Carlos García");
        assertEquals("Carlos García", participante.getNombreChef());
    }

    @Test
    void testGetNombreChef_SetNombreChef_ErrorPath() {
        Participante participante = new Participante();
        participante.setNombreChef("Carlos García");
        assertNotEquals("Ana Rodríguez", participante.getNombreChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_HappyPath() {
        Participante participante = new Participante();
        participante.setTipoChef("Concursante");
        assertEquals("Concursante", participante.getTipoChef());
    }

    @Test
    void testGetTipoChef_SetTipoChef_ErrorPath() {
        Participante participante = new Participante();
        participante.setTipoChef("Concursante");
        assertNotEquals("Jurado", participante.getTipoChef());
    }

    @Test
    void testConstructorNoArgs_HappyPath() {
        Participante participante = new Participante();
        assertNotNull(participante);
        assertNull(participante.getNombreChef());
        assertNull(participante.getTipoChef());
        assertNull(participante.getTemporada());
        assertNull(participante.getPuestoObtenido());
    }

    @Test
    void testConstructorNoArgs_ErrorPath() {
        Participante participante = new Participante();
        assertNotNull(participante);
        assertNotEquals("Carlos García", participante.getNombreChef());
        assertNotEquals("Concursante", participante.getTipoChef());
        assertNotEquals("Temporada 5", participante.getTemporada());
        assertNotEquals("Primer Lugar", participante.getPuestoObtenido());
    }



    @Test
    void testConstructorAllArgs_ErrorPath() {
        Participante participante = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertNotEquals("Ana Rodríguez", participante.getNombreChef());
        assertNotEquals("Jurado", participante.getTipoChef());
        assertNotEquals("Temporada 3", participante.getTemporada());
        assertNotEquals("Segundo Lugar", participante.getPuestoObtenido());
    }



    @Test
    void testConstructorFourArgs_ErrorPath() {
        Participante participante = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertNotEquals("Ana Rodríguez", participante.getNombreChef());
        assertNotEquals("Jurado", participante.getTipoChef());
        assertNotEquals("Temporada 3", participante.getTemporada());
        assertNotEquals("Segundo Lugar", participante.getPuestoObtenido());
    }

    @Test
    void testGetTemporada_Mockito_HappyPath() {
        Participante participanteMock = mock(Participante.class);
        when(participanteMock.getTemporada()).thenReturn("Temporada 5");

        String temporadaObtenida = participanteMock.getTemporada();

        assertEquals("Temporada 5", temporadaObtenida);
        verify(participanteMock).getTemporada();
    }

    @Test
    void testGetTemporada_Mockito_ErrorPath() {
        Participante participanteMock = mock(Participante.class);
        when(participanteMock.getTemporada()).thenReturn("Temporada 5");

        String temporadaObtenida = participanteMock.getTemporada();

        assertNotEquals("Temporada 3", temporadaObtenida);
        verify(participanteMock).getTemporada();
    }

    @Test
    void testGetPuestoObtenido_Mockito_HappyPath() {
        Participante participanteMock = mock(Participante.class);
        when(participanteMock.getPuestoObtenido()).thenReturn("Primer Lugar");

        String puestoObtenido = participanteMock.getPuestoObtenido();

        assertEquals("Primer Lugar", puestoObtenido);
        verify(participanteMock).getPuestoObtenido();
    }

    @Test
    void testGetPuestoObtenido_Mockito_ErrorPath() {
        Participante participanteMock = mock(Participante.class);
        when(participanteMock.getPuestoObtenido()).thenReturn("Primer Lugar");

        String puestoObtenido = participanteMock.getPuestoObtenido();

        assertNotEquals("Segundo Lugar", puestoObtenido);
        verify(participanteMock).getPuestoObtenido();
    }

    @Test
    void testSetters_Mockito_HappyPath() {
        Participante participanteReal = new Participante();
        Participante participanteSpy = spy(participanteReal);

        participanteSpy.setNombreChef("Carlos García");
        participanteSpy.setTipoChef("Concursante");
        participanteSpy.setTemporada("Temporada 5");
        participanteSpy.setPuestoObtenido("Primer Lugar");

        assertEquals("Carlos García", participanteSpy.getNombreChef());
        assertEquals("Concursante", participanteSpy.getTipoChef());
        assertEquals("Temporada 5", participanteSpy.getTemporada());
        assertEquals("Primer Lugar", participanteSpy.getPuestoObtenido());

        verify(participanteSpy).setNombreChef("Carlos García");
        verify(participanteSpy).setTipoChef("Concursante");
        verify(participanteSpy).setTemporada("Temporada 5");
        verify(participanteSpy).setPuestoObtenido("Primer Lugar");
        verify(participanteSpy).getNombreChef();
        verify(participanteSpy).getTipoChef();
        verify(participanteSpy).getTemporada();
        verify(participanteSpy).getPuestoObtenido();
    }

    @Test
    void testSetters_Mockito_ErrorPath() {
        Participante participanteReal = new Participante();
        Participante participanteSpy = spy(participanteReal);

        participanteSpy.setNombreChef("Carlos García");
        participanteSpy.setTipoChef("Concursante");
        participanteSpy.setTemporada("Temporada 5");
        participanteSpy.setPuestoObtenido("Primer Lugar");

        assertNotEquals("Ana Rodríguez", participanteSpy.getNombreChef());
        assertNotEquals("Jurado", participanteSpy.getTipoChef());
        assertNotEquals("Temporada 3", participanteSpy.getTemporada());
        assertNotEquals("Segundo Lugar", participanteSpy.getPuestoObtenido());

        verify(participanteSpy).setNombreChef("Carlos García");
        verify(participanteSpy).setTipoChef("Concursante");
        verify(participanteSpy).setTemporada("Temporada 5");
        verify(participanteSpy).setPuestoObtenido("Primer Lugar");
        verify(participanteSpy).getNombreChef();
        verify(participanteSpy).getTipoChef();
        verify(participanteSpy).getTemporada();
        verify(participanteSpy).getPuestoObtenido();
    }

    @Test
    void testConstructorFourArgs_HappyPath() {
        Participante participante = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertEquals("Carlos García", participante.getNombreChef());
        assertEquals("Concursante", participante.getTipoChef());
        assertEquals("Temporada 5", participante.getTemporada());
        assertEquals("Primer Lugar", participante.getPuestoObtenido());
    }

    @Test
    void testConstructorAllArgs_HappyPath() {
        Participante participante = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertEquals("Carlos García", participante.getNombreChef());
        assertEquals("Concursante", participante.getTipoChef());
        assertEquals("Temporada 5", participante.getTemporada());
        assertEquals("Primer Lugar", participante.getPuestoObtenido());
    }

    @Test
    void testEquals_SameObject_ReturnsTrue() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertTrue(participante1.equals(participante1));
    }

    @Test
    void testEquals_DifferentClass_ReturnsFalse() {
        Participante participante = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Object other = new Object();
        assertFalse(participante.equals(other));
    }

    @Test
    void testEquals_SameValues_ReturnsTrue() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertTrue(participante1.equals(participante2));
    }

    @Test
    void testEquals_DifferentValues_ReturnsFalse() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Ana Rodríguez", "Jurado", "Temporada 3", "Segundo Lugar");
        assertFalse(participante1.equals(participante2));
    }

    @Test
    void testHashCode_SameValues_EqualHashCode() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertEquals(participante1.hashCode(), participante2.hashCode());
    }

    @Test
    void testHashCode_DifferentValues_DifferentHashCode() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Ana Rodríguez", "Jurado", "Temporada 3", "Segundo Lugar");
        assertNotEquals(participante1.hashCode(), participante2.hashCode());
    }


    @Test
    void testCanEqual_WithSameType_ReturnsTrue() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Ana Rodríguez", "Jurado", "Temporada 3", "Segundo Lugar");
        assertTrue(participante1.canEqual(participante2));
    }

    @Test
    void testCanEqual_WithDifferentType_ReturnsFalse() {
        Participante participante = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Object other = new Object();
        assertFalse(participante.canEqual(other));
    }

    @Test
    void testEquals_WithNull_ReturnsFalse() {
        Participante participante = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        assertFalse(participante.equals(null));
    }

    @Test
    void testEquals_Symmetric() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");

        assertTrue(participante1.equals(participante2));
        assertTrue(participante2.equals(participante1));
    }

    @Test
    void testEquals_Transitive() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante3 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");

        assertTrue(participante1.equals(participante2));
        assertTrue(participante2.equals(participante3));
        assertTrue(participante1.equals(participante3));
    }

    @Test
    void testEquals_DifferentNombreChef_ReturnsFalse() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Ana Rodríguez", "Concursante", "Temporada 5", "Primer Lugar");
        assertFalse(participante1.equals(participante2));
    }

    @Test
    void testEquals_DifferentTipoChef_ReturnsFalse() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Carlos García", "Jurado", "Temporada 5", "Primer Lugar");
        assertFalse(participante1.equals(participante2));
    }

    @Test
    void testEquals_DifferentTemporada_ReturnsFalse() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Carlos García", "Concursante", "Temporada 3", "Primer Lugar");
        assertFalse(participante1.equals(participante2));
    }

    @Test
    void testEquals_DifferentPuestoObtenido_ReturnsFalse() {
        Participante participante1 = new Participante("Carlos García", "Concursante", "Temporada 5", "Primer Lugar");
        Participante participante2 = new Participante("Carlos García", "Concursante", "Temporada 5", "Segundo Lugar");
        assertFalse(participante1.equals(participante2));
    }

    @Test
    void testEquals_CompareWithNullFields() {
        Participante participante1 = new Participante();
        Participante participante2 = new Participante();
        assertTrue(participante1.equals(participante2));
    }

    @Test
    void testHashCode_WithNullFields() {
        Participante participante1 = new Participante();
        Participante participante2 = new Participante();
        assertEquals(participante1.hashCode(), participante2.hashCode());
    }


}