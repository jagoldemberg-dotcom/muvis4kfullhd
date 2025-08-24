package com.example.muvis4kfullhd.services;

import org.springframework.stereotype.Service;
import com.example.muvis4kfullhd.model.peliculas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private List<peliculas> peliculas;

    public PeliculaService() {
        inicializarPeliculas();
    }

    private void inicializarPeliculas() {
        peliculas = new ArrayList<>();

        peliculas.add(new peliculas(1, "El Padrino", 1972, "Francis Ford Coppola", "Drama",
                "La historia de una familia mafiosa italoamericana y su lucha por el poder en Nueva York."));

        peliculas.add(new peliculas(2, "Pulp Fiction", 1994, "Quentin Tarantino", "Crimen",
                "Historias entrelazadas de crimen y redención en Los Ángeles, contadas de manera no lineal."));

        peliculas.add(new peliculas(3, "El Señor de los Anillos: La Comunidad del Anillo", 2001, "Peter Jackson", "Fantasía",
                "Un hobbit debe destruir un anillo mágico para salvar la Tierra Media del malvado Sauron."));

        peliculas.add(new peliculas(4, "Matrix", 1999, "Lana Wachowski, Lilly Wachowski", "Ciencia Ficción",
                "Un programador descubre que la realidad es una simulación y debe luchar contra las máquinas."));

        peliculas.add(new peliculas(5, "Forrest Gump", 1994, "Robert Zemeckis", "Drama",
                "La extraordinaria vida de un hombre con discapacidad intelectual que presencia eventos históricos."));

        peliculas.add(new peliculas(6, "Inception", 2010, "Christopher Nolan", "Ciencia Ficción",
                "Un ladrón que roba secretos del subconsciente recibe la tarea de implantar una idea en lugar de robarla."));
    }

    public List<peliculas> obtenerTodasLasPeliculas() {
        return new ArrayList<>(peliculas);
    }

    public Optional<peliculas> obtenerPeliculaPorId(int id) {
        return peliculas.stream()
                .filter(peliculas -> peliculas.getId() == id)
                .findFirst();
    }
}
