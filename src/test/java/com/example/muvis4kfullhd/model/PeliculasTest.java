package com.example.muvis4kfullhd.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PeliculasTest {

    private Pelicula pelicula;

    @BeforeEach
    public void setUp() {
        pelicula = new Pelicula();
    }

    @Test
    public void testConstructorVacio() {
        // Act
        Pelicula peliculaVacia = new Pelicula();

        // Assert
        assertNotNull(peliculaVacia);
        assertEquals(0, peliculaVacia.getId());
        assertNull(peliculaVacia.getTitulo());
        assertEquals(0, peliculaVacia.getAnio());
        assertNull(peliculaVacia.getDirector());
        assertNull(peliculaVacia.getGenero());
        assertNull(peliculaVacia.getSinopsis());
    }

    @Test
    public void testConstructorCompleto() {
        // Arrange
        int id = 1;
        String titulo = "El Padrino";
        int anio = 1972;
        String director = "Francis Ford Coppola";
        String genero = "Drama";
        String sinopsis = "Una saga familiar mafiosa";

        // Act
        Pelicula peliculaCompleta = new Pelicula(id, titulo, anio, director, genero, sinopsis);

        // Assert
        assertEquals(id, peliculaCompleta.getId());
        assertEquals(titulo, peliculaCompleta.getTitulo());
        assertEquals(anio, peliculaCompleta.getAnio());
        assertEquals(director, peliculaCompleta.getDirector());
        assertEquals(genero, peliculaCompleta.getGenero());
        assertEquals(sinopsis, peliculaCompleta.getSinopsis());
    }

    @Test
    public void testGetSetId() {
        // Arrange
        int idEsperado = 42;

        // Act
        pelicula.setId(idEsperado);

        // Assert
        assertEquals(idEsperado, pelicula.getId());
    }

    @Test
    public void testGetSetIdConValorNegativo() {
        // Arrange
        int idNegativo = -1;

        // Act
        pelicula.setId(idNegativo);

        // Assert
        assertEquals(idNegativo, pelicula.getId());
    }

    @Test
    public void testGetSetTitulo() {
        // Arrange
        String tituloEsperado = "Matrix";

        // Act
        pelicula.setTitulo(tituloEsperado);

        // Assert
        assertEquals(tituloEsperado, pelicula.getTitulo());
    }

    @Test
    public void testGetSetTituloConNull() {
        // Act
        pelicula.setTitulo(null);

        // Assert
        assertNull(pelicula.getTitulo());
    }

    @Test
    public void testGetSetTituloConStringVacio() {
        // Arrange
        String tituloVacio = "";

        // Act
        pelicula.setTitulo(tituloVacio);

        // Assert
        assertEquals(tituloVacio, pelicula.getTitulo());
    }

    @Test
    public void testGetSetAnio() {
        // Arrange
        int anioEsperado = 2024;

        // Act
        pelicula.setAnio(anioEsperado);

        // Assert
        assertEquals(anioEsperado, pelicula.getAnio());
    }

    @Test
    public void testGetSetAnioConValorHistorico() {
        // Arrange
        int anioHistorico = 1895; // Nacimiento del cine

        // Act
        pelicula.setAnio(anioHistorico);

        // Assert
        assertEquals(anioHistorico, pelicula.getAnio());
    }

    @Test
    public void testGetSetAnioConValorNegativo() {
        // Arrange
        int anioNegativo = -100;

        // Act
        pelicula.setAnio(anioNegativo);

        // Assert
        assertEquals(anioNegativo, pelicula.getAnio());
    }

    @Test
    public void testGetSetDirector() {
        // Arrange
        String directorEsperado = "Steven Spielberg";

        // Act
        pelicula.setDirector(directorEsperado);

        // Assert
        assertEquals(directorEsperado, pelicula.getDirector());
    }

    @Test
    public void testGetSetDirectorConNull() {
        // Act
        pelicula.setDirector(null);

        // Assert
        assertNull(pelicula.getDirector());
    }

    @Test
    public void testGetSetDirectorConStringVacio() {
        // Arrange
        String directorVacio = "";

        // Act
        pelicula.setDirector(directorVacio);

        // Assert
        assertEquals(directorVacio, pelicula.getDirector());
    }

    @Test
    public void testGetSetGenero() {
        // Arrange
        String generoEsperado = "Ciencia Ficción";

        // Act
        pelicula.setGenero(generoEsperado);

        // Assert
        assertEquals(generoEsperado, pelicula.getGenero());
    }

    @Test
    public void testGetSetGeneroConNull() {
        // Act
        pelicula.setGenero(null);

        // Assert
        assertNull(pelicula.getGenero());
    }

    @Test
    public void testGetSetSinopsis() {
        // Arrange
        String sinopsisEsperada = "Una épica aventura espacial llena de acción y drama";

        // Act
        pelicula.setSinopsis(sinopsisEsperada);

        // Assert
        assertEquals(sinopsisEsperada, pelicula.getSinopsis());
    }

    @Test
    public void testGetSetSinopsisConNull() {
        // Act
        pelicula.setSinopsis(null);

        // Assert
        assertNull(pelicula.getSinopsis());
    }

    @Test
    public void testGetSetSinopsisConTextoLargo() {
        // Arrange
        String sinopsisLarga = "Esta es una sinopsis muy larga que contiene múltiples oraciones y describe detalladamente la trama de la película, incluyendo personajes principales, conflictos centrales y elementos dramáticos que hacen que la historia sea interesante y atractiva para los espectadores.";

        // Act
        pelicula.setSinopsis(sinopsisLarga);

        // Assert
        assertEquals(sinopsisLarga, pelicula.getSinopsis());
    }

    @Test
    public void testModificacionCompleta() {
        // Arrange
        int nuevoId = 100;
        String nuevoTitulo = "Inception";
        int nuevoAnio = 2010;
        String nuevoDirector = "Christopher Nolan";
        String nuevoGenero = "Thriller";
        String nuevaSinopsis = "Un ladrón que roba secretos del subconsciente";

        // Act
        pelicula.setId(nuevoId);
        pelicula.setTitulo(nuevoTitulo);
        pelicula.setAnio(nuevoAnio);
        pelicula.setDirector(nuevoDirector);
        pelicula.setGenero(nuevoGenero);
        pelicula.setSinopsis(nuevaSinopsis);

        // Assert
        assertEquals(nuevoId, pelicula.getId());
        assertEquals(nuevoTitulo, pelicula.getTitulo());
        assertEquals(nuevoAnio, pelicula.getAnio());
        assertEquals(nuevoDirector, pelicula.getDirector());
        assertEquals(nuevoGenero, pelicula.getGenero());
        assertEquals(nuevaSinopsis, pelicula.getSinopsis());
    }

    @Test
    public void testValoresLimite() {
        // Arrange & Act
        pelicula.setId(Integer.MAX_VALUE);
        pelicula.setAnio(Integer.MIN_VALUE);

        // Assert
        assertEquals(Integer.MAX_VALUE, pelicula.getId());
        assertEquals(Integer.MIN_VALUE, pelicula.getAnio());
    }

    @Test
    public void testCaracteresEspeciales() {
        // Arrange
        String tituloConCaracteresEspeciales = "El Niño & la Niña: ¿Película del Año?";
        String directorConAcentos = "Alejandro González Iñárritu";
        String generoConEnie = "Acción/Suspenso";

        // Act
        pelicula.setTitulo(tituloConCaracteresEspeciales);
        pelicula.setDirector(directorConAcentos);
        pelicula.setGenero(generoConEnie);

        // Assert
        assertEquals(tituloConCaracteresEspeciales, pelicula.getTitulo());
        assertEquals(directorConAcentos, pelicula.getDirector());
        assertEquals(generoConEnie, pelicula.getGenero());
    }

    @Test
    public void testInmutabilidadEntreInstancias() {
        // Arrange
        Pelicula pelicula1 = new Pelicula(1, "Pelicula 1", 2000, "Director 1", "Genero 1", "Sinopsis 1");
        Pelicula pelicula2 = new Pelicula(2, "Pelicula 2", 2001, "Director 2", "Genero 2", "Sinopsis 2");

        // Act
        pelicula1.setTitulo("Titulo Modificado");

        // Assert
        assertEquals("Titulo Modificado", pelicula1.getTitulo());
        assertEquals("Pelicula 2", pelicula2.getTitulo()); // No debe haber cambiado
        assertNotEquals(pelicula1.getTitulo(), pelicula2.getTitulo());
    }
}