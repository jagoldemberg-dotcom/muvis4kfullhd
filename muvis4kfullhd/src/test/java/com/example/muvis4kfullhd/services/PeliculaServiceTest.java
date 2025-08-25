package com.example.muvis4kfullhd.services;

import com.example.muvis4kfullhd.model.Pelicula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaServiceTest {

    private PeliculaService peliculaService;

    @BeforeEach
    public void setUp() {
        peliculaService = new PeliculaService();
    }

    @Test
    public void testObtenerTodasLasPeliculas_DeberiaRetornarListaNoVacia() {
        // Act
        List<Pelicula> Pelicula = peliculaService.obtenerTodasLasPeliculas();

        // Assert
        assertNotNull(Pelicula);
        assertFalse(Pelicula.isEmpty());
        assertEquals(6, Pelicula.size());
    }

    @Test
    public void testObtenerTodasLasPeliculas_DeberiaContenerPeliculasEsperadas() {
        // Act
        List<Pelicula> Pelicula = peliculaService.obtenerTodasLasPeliculas();

        // Assert
        assertTrue(Pelicula.stream().anyMatch(p -> p.getTitulo().equals("El Padrino")));
        assertTrue(Pelicula.stream().anyMatch(p -> p.getTitulo().equals("Pulp Fiction")));
        assertTrue(Pelicula.stream().anyMatch(p -> p.getTitulo().equals("Matrix")));
        assertTrue(Pelicula.stream().anyMatch(p -> p.getTitulo().equals("Inception")));
    }

    @Test
    public void testObtenerPeliculaPorId_ConIdValido_DeberiaRetornarPelicula() {
        // Act
        Optional<Pelicula> pelicula = peliculaService.obtenerPeliculaPorId(1);

        // Assert
        assertTrue(pelicula.isPresent());
        assertEquals(1, pelicula.get().getId());
        assertEquals("El Padrino", pelicula.get().getTitulo());
        assertEquals(1972, pelicula.get().getAnio());
        assertEquals("Francis Ford Coppola", pelicula.get().getDirector());
    }

    @Test
    public void testObtenerPeliculaPorId_ConIdInvalido_DeberiaRetornarVacio() {
        // Act
        Optional<Pelicula> pelicula = peliculaService.obtenerPeliculaPorId(999);

        // Assert
        assertFalse(pelicula.isPresent());
    }

    @Test
    public void testObtenerPeliculaPorId_ConIdCero_DeberiaRetornarVacio() {
        // Act
        Optional<Pelicula> pelicula = peliculaService.obtenerPeliculaPorId(0);

        // Assert
        assertFalse(pelicula.isPresent());
    }

    @Test
    public void testObtenerPeliculaPorId_ConIdNegativo_DeberiaRetornarVacio() {
        // Act
        Optional<Pelicula> pelicula = peliculaService.obtenerPeliculaPorId(-1);

        // Assert
        assertFalse(pelicula.isPresent());
    }

    @Test
    public void testObtenerTodasLasPeliculas_DeberiaRetornarCopiaIndependiente() {
        // Act
        List<Pelicula> pelicula1 = peliculaService.obtenerTodasLasPeliculas();
        List<Pelicula> pelicula2 = peliculaService.obtenerTodasLasPeliculas();

        // Assert
        assertNotSame(pelicula1, pelicula2);
        assertEquals(pelicula1.size(), pelicula2.size());
    }

    @Test
    public void testValidarDatosPeliculas_DeberiaIncluirTodosLosCampos() {
        // Act
        List<Pelicula> Pelicula = peliculaService.obtenerTodasLasPeliculas();

        // Assert
        for (Pelicula pelicula : Pelicula) {
            assertNotNull(pelicula.getTitulo());
            assertNotNull(pelicula.getDirector());
            assertNotNull(pelicula.getGenero());
            assertNotNull(pelicula.getSinopsis());
            assertTrue(pelicula.getId() > 0);
            assertTrue(pelicula.getAnio() > 1900);
            assertFalse(pelicula.getTitulo().trim().isEmpty());
            assertFalse(pelicula.getDirector().trim().isEmpty());
        }
    }
}
