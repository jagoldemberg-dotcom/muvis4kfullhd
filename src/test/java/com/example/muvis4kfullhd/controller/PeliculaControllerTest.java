package com.example.muvis4kfullhd.controller;

import com.example.muvis4kfullhd.model.Pelicula;
import com.example.muvis4kfullhd.services.PeliculaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaService peliculaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testObtenerTodasLasPeliculas_DeberiaRetornarListaCompleta() throws Exception {
        // Arrange
        List<Pelicula> Pelicula = Arrays.asList(
                new Pelicula(1, "El Padrino", 1972, "Francis Ford Coppola", "Drama", "Una saga familiar mafiosa"),
                new Pelicula(2, "Pulp Fiction", 1994, "Quentin Tarantino", "Crimen", "Historias entrelazadas de crimen")
        );

        when(peliculaService.obtenerTodasLasPeliculas()).thenReturn(Pelicula);

        // Act & Assert
        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].titulo", is("El Padrino")))
                .andExpect(jsonPath("$[0].anio", is(1972)))
                .andExpect(jsonPath("$[0].director", is("Francis Ford Coppola")))
                .andExpect(jsonPath("$[0].genero", is("Drama")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].titulo", is("Pulp Fiction")));
    }

    @Test
    public void testObtenerPeliculaPorId_ConIdValido_DeberiaRetornarPelicula() throws Exception {
        // Arrange
        Pelicula pelicula = new Pelicula(1, "El Padrino", 1972, "Francis Ford Coppola", "Drama", "Una saga familiar mafiosa");
        when(peliculaService.obtenerPeliculaPorId(1)).thenReturn(Optional.of(pelicula));

        // Act & Assert
        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.titulo", is("El Padrino")))
                .andExpect(jsonPath("$.anio", is(1972)))
                .andExpect(jsonPath("$.director", is("Francis Ford Coppola")))
                .andExpect(jsonPath("$.genero", is("Drama")))
                .andExpect(jsonPath("$.sinopsis", is("Una saga familiar mafiosa")));
    }

    @Test
    public void testObtenerPeliculaPorId_ConIdInvalido_DeberiaRetornar404() throws Exception {
        // Arrange
        when(peliculaService.obtenerPeliculaPorId(999)).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(get("/peliculas/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testObtenerPeliculaPorId_ConIdCero_DeberiaRetornar404() throws Exception {
        // Arrange
        when(peliculaService.obtenerPeliculaPorId(0)).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(get("/peliculas/0"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testObtenerTodasLasPeliculas_ConListaVacia_DeberiaRetornarListaVacia() throws Exception {
        // Arrange
        when(peliculaService.obtenerTodasLasPeliculas()).thenReturn(Arrays.asList());

        // Act & Assert
        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}