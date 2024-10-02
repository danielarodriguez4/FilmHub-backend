package com.udea.filmhub.config;

import com.udea.filmhub.model.*;
import com.udea.filmhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private TipoContenidoRepository tipoContenidoRepository;

    @Autowired
    private IdiomaRepository idiomaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insertar datos de ejemplo en la tabla Clasificacion
        Clasificacion pg13 = clasificacionRepository.save(new Clasificacion("PG-13", "Parents Strongly Cautioned"));
        clasificacionRepository.save(new Clasificacion("R", "Restricted"));
        clasificacionRepository.save(new Clasificacion("G", "General Audiences"));

        // Insertar datos de ejemplo en la tabla TipoContenido
        TipoContenido movie = tipoContenidoRepository.save(new TipoContenido("Movie"));
        tipoContenidoRepository.save(new TipoContenido("Series"));
        tipoContenidoRepository.save(new TipoContenido("Documentary"));

        // Insertar datos de ejemplo en la tabla Idioma
        Idioma english = idiomaRepository.save(new Idioma("English"));
        idiomaRepository.save(new Idioma("Spanish"));
        idiomaRepository.save(new Idioma("French"));

        // Insertar datos de ejemplo en la tabla Estado
        estadoRepository.save(new Estado("Visto"));
        estadoRepository.save(new Estado("Por ver"));

        // Insertar datos de ejemplo en la tabla Genero
        generoRepository.save(new Genero("Accion"));
        generoRepository.save(new Genero("Comedia"));

        Contenido contenido = contenidoRepository.save(new Contenido("Inception", LocalDate.parse("2010-07-16"), "http://example.com/poster.jpg", "A mind-bending thriller...", 8.8f, 10, 1, pg13, movie, english));
    }
}