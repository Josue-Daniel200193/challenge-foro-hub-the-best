# Foro con CRUD de Tópicos y Autenticación con Token

Este proyecto implementa un foro con operaciones CRUD para tópicos y autenticación mediante tokens. 
Utiliza Spring Boot y MySQL para el almacenamiento de datos.

## Requisitos previos

Antes de ejecutar la aplicación, asegúrate de tener instalado lo siguiente:

- Java JDK 17
- Maven
- MySQL

## Configuración de la Base de Datos

1. Crea una base de datos MySQL llamada `foro`.
2. Actualiza las credenciales de acceso a la base de datos en `application.properties`.

## Ejecución de la Aplicación

1. Clona este repositorio.
2. Navega al directorio del proyecto y ejecuta el siguiente comando:

```bash
mvn spring-boot:run

La aplicación estará disponible en http://localhost:8080.

Endpoints API
Registro de Nuevo Tópico
URL: /topicos
Método HTTP: POST
Descripción: Registra un nuevo tópico en la base de datos.

Listado de Tópicos Activos
URL: /topicos
Método HTTP: GET
Descripción: Obtiene un listado paginado de todos los tópicos activos.

Actualización de Tópico
URL: /topicos
Método HTTP: PUT
Descripción: Actualiza los datos de un tópico existente.

Eliminación Lógica de Tópico
URL: /topicos/{id}
Método HTTP: DELETE
Descripción: Desactiva lógicamente un tópico por su ID.

Obtener Tópico por ID
URL: /topicos/{id}
Método HTTP: GET
Descripción: Obtiene los datos de un tópico específico por su ID.

Autenticación y Autorización
La autenticación se gestiona mediante tokens. Para realizar operaciones CRUD en los tópicos, debes incluir el token de acceso en la cabecera de la solicitud HTTP:

http
Copiar código
Authorization: Bearer {tu_token}
Reemplaza {tu_token} con el token válido obtenido al autenticarte.

¡Disfruta explorando el foro!

go
Copiar código

Guarda este contenido en un archivo con la extensión `.md` para tener la documentación en formato Markdown.
