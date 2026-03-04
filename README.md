<h1> Challenge Foro Hub Oracle One</h1>


Bienvenido a **Foro Hub**, una API REST desarrollada en Java con Spring Boot para la gestión de un foro de discusión. Este proyecto implementa un sistema completo de persistencia de datos, seguridad con JWT y manejo de perfiles de usuario.

 Tecnologías Utilizadas
* **Java 21**
* **Spring Boot 4**
* **Spring Security** (Autenticación y Autorización)
* **JSON Web Token (JWT)**
* **Spring Data JPA** (Hibernate)
* **MySQL** (Base de Datos)
* **Flyway** (Migraciones de base de datos)
* **Lombok**
* **SpringDoc OpenAPI (Swagger)**

## 📌 Funcionalidades Principales
* **Autenticación:** Sistema de login que genera un token Bearer para peticiones protegidas.
* **Registro de Usuarios:** Creación de usuarios con haseo de contraseñas mediante **BCrypt** y asignación de perfiles en cascada.
* **Gestión de Tópicos:** Operaciones CRUD protegidas por seguridad JWT.
* **Gestion de respuestas**: Crud y manejo de respuestas a cada topico.
* **Manejo de Excepciones:** Respuestas HTTP claras y personalizadas mediante `@RestControllerAdvice`.
