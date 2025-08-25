# Microservicio de Películas - muvis4kfullhd

Microservicio REST desarrollado con **Spring Boot 3.3.2** y **Java 17** que proporciona información detallada sobre películas a través de endpoints HTTP.

## Descripción del Proyecto

Este microservicio implementa una API REST básica para consultar información de películas almacenadas en memoria. Desarrollado como parte del curso **DESARROLLO FULLSTACK I_001A** de DuocUC, cumple con los siguientes requisitos:

- API REST con endpoints GET para consultar películas
- Datos almacenados en memoria (sin base de datos)
- Respuestas en formato JSON
- Manejo apropiado de códigos de estado HTTP
- Arquitectura de capas (Controller, Service, Model)

## Tecnologías Utilizadas

- **Java 17** - Lenguaje de programación
- **Spring Boot 3.3.2** - Framework principal
- **Spring Web** - Para crear la API REST
- **Spring Boot DevTools** - Desarrollo con hot reload
- **JUnit 5** - Framework de testing
- **Mockito** - Mocking para pruebas unitarias
- **Maven** - Gestión de dependencias y build
- **Docker** - Containerización de la aplicación

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/muvis4kfullhd/
│   │   ├── Muvis4kfullhdApplication.java     # Clase principal
│   │   ├── controller/
│   │   │   └── PeliculaController.java       # Controlador REST
│   │   ├── service/
│   │   │   └── PeliculaService.java          # Lógica de negocio
│   │   └── model/
│   │       └── peliculas.java                # Modelo de datos
│   └── resources/
│       └── application.properties            # Configuración
└── test/
    └── java/com/example/muvis4kfullhd/
        ├── controller/
        ├── service/
        └── model/                            # Pruebas unitarias
```

## API Endpoints

### 1. Obtener todas las películas

```http
GET /peliculas
```

**Respuesta (200 OK):**
```json
[
  {
    "id": 1,
    "titulo": "El Padrino",
    "anio": 1972,
    "director": "Francis Ford Coppola",
    "genero": "Drama",
    "sinopsis": "La historia de una familia mafiosa italoamericana..."
  }
]
```

### 2. Obtener película por ID

```http
GET /peliculas/{id}
```

**Parámetros:**
- `id` (entero): Identificador único de la película

**Respuesta exitosa (200 OK):**
```json
{
  "id": 1,
  "titulo": "El Padrino",
  "anio": 1972,
  "director": "Francis Ford Coppola",
  "genero": "Drama",
  "sinopsis": "La historia de una familia mafiosa italoamericana..."
}
```

**Respuesta de error (404 Not Found):**
Cuando la película no existe.

## Dataset Incluido

El microservicio incluye 6 películas precargadas:

| ID | Título | Año | Director | Género |
|----|--------|-----|----------|--------|
| 1 | El Padrino | 1972 | Francis Ford Coppola | Drama |
| 2 | Pulp Fiction | 1994 | Quentin Tarantino | Crimen |
| 3 | El Señor de los Anillos | 2001 | Peter Jackson | Fantasía |
| 4 | Matrix | 1999 | Lana & Lilly Wachowski | Ciencia Ficción |
| 5 | Forrest Gump | 1994 | Robert Zemeckis | Drama |
| 6 | Inception | 2010 | Christopher Nolan | Ciencia Ficción |

## Instalación y Configuración

### Requisitos Previos

- **Java 17** o superior ([Descargar](https://adoptium.net/))
- **Maven 3.6+** ([Descargar](https://maven.apache.org/))
- **Git** ([Descargar](https://git-scm.com/))

### Instalación Local

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/jagoldemberg-dotcom/muvisen4kfullhd.git
   cd muvisen4kfullhd/muvis4kfullhd
   ```

2. **Verificar Java 17:**
   ```bash
   java -version
   javac -version
   ```

3. **Compilar el proyecto:**
   ```bash
   mvn clean compile
   ```

4. **Ejecutar pruebas:**
   ```bash
   mvn test
   ```

5. **Ejecutar la aplicación:**
   ```bash
   mvn spring-boot:run
   ```

6. **Verificar funcionamiento:**
   - Abrir: http://localhost:8080/peliculas
   - O usar: `curl http://localhost:8080/peliculas`

## Ejecución con Docker

### Construcción de la imagen

```bash
# Construir imagen Docker
docker build -t muvis4kfullhd .

# Ejecutar contenedor
docker run -p 8080:8080 muvis4kfullhd
```

### Docker Compose

```bash
docker-compose up -d
```

## Testing

### Ejecutar todas las pruebas:
```bash
mvn test
```

### Ejecutar pruebas específicas:
```bash
# Pruebas del controlador
mvn test -Dtest=PeliculaControllerTest

# Pruebas del servicio
mvn test -Dtest=PeliculaServiceTest

# Pruebas del modelo
mvn test -Dtest=PeliculasTest
```

### Cobertura de Pruebas:
- Tests unitarios para todas las capas
- Tests de integración
- Validación de respuestas JSON
- Manejo de casos de error
- Tests de la clase principal

## Ejemplos de Uso

### Con cURL:
```bash
# Todas las películas
curl http://localhost:8080/peliculas

# Película específica
curl http://localhost:8080/peliculas/1

# Película inexistente (retorna 404)
curl http://localhost:8080/peliculas/999
```

### Con HTTPie:
```bash
# Todas las películas
http GET localhost:8080/peliculas

# Película específica
http GET localhost:8080/peliculas/1
```

### Con navegador:
- http://localhost:8080/peliculas
- http://localhost:8080/peliculas/1

## Configuración

El archivo `application.properties` permite configurar:

```properties
# Puerto del servidor
server.port=8080

# Nombre de la aplicación
spring.application.name=muvis4kfullhd

# Configuración de logging
logging.level.org.apache.tomcat=ERROR
logging.level.com.example.muvis4kfullhd=DEBUG
```

## Solución de Problemas

### Error: "JAVA_HOME not defined"
```bash
# Windows
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.x.x.x-hotspot

# Linux/Mac
export JAVA_HOME=/path/to/jdk-17
```

### Puerto 8080 ocupado:
```bash
# Cambiar puerto
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

### Limpiar y recompilar:
```bash
mvn clean compile
```

## Desarrollo

### Estructura de Capas:
- **Controller**: Maneja requests HTTP
- **Service**: Lógica de negocio
- **Model**: Representación de datos

### Agregar nuevas películas:
Modificar el método `inicializarPeliculas()` en `PeliculaService.java`

### Cambiar puerto:
Modificar `server.port` en `application.properties`

## Contribución

Este proyecto es de uso académico. Para contribuir:

1. Fork del repositorio
2. Crear rama feature
3. Commit de cambios
4. Pull request

## Información del Desarrollador

- **Autor**: Jacob Goldemberg
- **Curso**:DESARROLLO FULLSTACK I_001A
- **Institución**: DuocUC
- **Año**: 2025


## Contacto

- GitHub: [@jagoldemberg-dotcom](https://github.com/jagoldemberg-dotcom)
- Repositorio: [muvisen4kfullhd](https://github.com/jagoldemberg-dotcom/muvisen4kfullhd)

---

**Versión**: 1.0.0  
**Última actualización**: Agosto 2024