package com.example.muvis4kfullhd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
        "server.port=0",  // Puerto random para evitar conflictos
        "spring.main.banner-mode=off"  // Deshabilitar banner para tests más limpios
})
public class Muvis4kfullhdApplicationTest {

    @Test
    public void testContextLoads() {
        // Este test verifica que el contexto de Spring Boot se cargue correctamente
        // Si el contexto no se puede cargar, el test fallará automáticamente
        assertTrue(true);
    }

    @Test
    public void testMainMethod() {
        // Test para verificar que el método main funciona sin lanzar excepciones
        assertDoesNotThrow(() -> {
            // Configuramos argumentos para que la aplicación no se quede ejecutándose
            String[] args = {"--server.port=0", "--spring.main.web-environment=false"};

            // Ejecutamos la aplicación de forma que se inicie y termine rápidamente
            ConfigurableApplicationContext context = SpringApplication.run(Muvis4kfullhdApplication.class, args);

            // Verificamos que el contexto se creó correctamente
            assertNotNull(context);
            assertTrue(context.isRunning());

            // Cerramos el contexto para limpiar recursos
            context.close();
        });
    }

    @Test
    public void testApplicationClassExists() {
        // Verifica que la clase principal existe y es accesible
        assertNotNull(Muvis4kfullhdApplication.class);

        // Verifica que tiene la anotación @SpringBootApplication
        assertTrue(Muvis4kfullhdApplication.class.isAnnotationPresent(
                org.springframework.boot.autoconfigure.SpringBootApplication.class
        ));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        // Verifica que existe el método main con la firma correcta
        assertNotNull(Muvis4kfullhdApplication.class.getDeclaredMethod("main", String[].class));

        // Verifica que el método main es público y estático
        var mainMethod = Muvis4kfullhdApplication.class.getDeclaredMethod("main", String[].class);
        assertTrue(java.lang.reflect.Modifier.isPublic(mainMethod.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isStatic(mainMethod.getModifiers()));
    }

    @Test
    public void testSpringBootApplicationAnnotation() {
        // Verifica que la clase tiene la anotación @SpringBootApplication
        var annotation = Muvis4kfullhdApplication.class.getAnnotation(
                org.springframework.boot.autoconfigure.SpringBootApplication.class
        );

        assertNotNull(annotation, "La clase debe tener la anotación @SpringBootApplication");
    }

    @Test
    public void testApplicationCanStart() {
        // Test de integración que verifica que la aplicación puede iniciarse completamente
        assertDoesNotThrow(() -> {
            String[] args = {
                    "--server.port=0",
                    "--spring.main.web-environment=true",
                    "--spring.main.banner-mode=off"
            };

            ConfigurableApplicationContext context = SpringApplication.run(
                    Muvis4kfullhdApplication.class, args
            );

            // Verificaciones adicionales del contexto
            assertNotNull(context);
            assertTrue(context.isRunning());
            assertTrue(context.isActive());

            // Verificar que algunos beans básicos están presentes
            assertTrue(context.containsBean("muvis4kfullhdApplication"));

            context.close();
            assertFalse(context.isActive());
        });
    }
}