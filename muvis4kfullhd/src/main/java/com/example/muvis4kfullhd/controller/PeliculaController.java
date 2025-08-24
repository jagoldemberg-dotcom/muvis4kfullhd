package com.example.muvis4kfullhd.controller;

import com.example.muvis4kfullhd.model.peliculas;
import com.example.muvis4kfullhd.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    // GET /peliculas - Obtener todas las películas
    @GetMapping
    public ResponseEntity<List<peliculas>> obtenerTodasLasPeliculas() {
        List<peliculas> peliculas = peliculaService.obtenerTodasLasPeliculas();
        return new ResponseEntity<>(peliculas, HttpStatus.OK);
    }

    // GET /peliculas/{id} - Obtener película por ID
    @GetMapping("/{id}")
    public ResponseEntity<peliculas> obtenerPeliculaPorId(@PathVariable int id) {
        Optional<peliculas> pelicula = peliculaService.obtenerPeliculaPorId(id);

        return pelicula.map(peliculas -> new ResponseEntity<>(peliculas, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}