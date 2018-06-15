# Plantilla para proyectos java thymeleaf

## Arquitectura
- Spring boot
- Spring data JPA
- Spring Security
- Spring MVC
- Hibernate
- Thymeleaf

## Cómo ejecutarlo
1. Arrancar la BD mediante 
$ docker-compose up

2. Compilar el proyecto
$ ./mvnw package

3. Ejecutarlo
$ ./mvnw spring-boot:run -Dspring.profiles.active="development"
