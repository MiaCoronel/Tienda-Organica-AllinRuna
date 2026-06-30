# 🌱 Tienda Orgánica AllinRuna

Plataforma web para la gestión y venta de productos orgánicos, desarrollada con **Java Spring Boot**.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow)

## 📖 Descripción

**AllinRuna** (del quechua: *persona buena / completa*) es una aplicación web que permite gestionar una tienda de productos orgánicos. El sistema incluye autenticación de usuarios, catálogo de productos, gestión de pedidos y un panel administrativo completo.

Proyecto desarrollado para el curso de **Herramientas de Desarrollo** — Universidad Tecnológica del Perú (UTP), Facultad de Ingeniería, Ingeniería de Sistemas e Informática — 2026.

## 🚀 Tecnologías utilizadas

- **Backend:** Java 21, Spring Boot 3.x, Spring Security, Spring Data JPA
- **Base de datos:** MySQL
- **Frontend:** Thymeleaf, HTML, CSS
- **Control de versiones:** Git & GitHub
- **CI/CD:** GitHub Actions + Railway
- **Generación de PDF:** OpenPDF

## ⚙️ Instalación y configuración

### Requisitos previos
- Java 21 o superior
- Maven
- MySQL 8.0
- Git

### Pasos para instalar

1. Clonar el repositorio:
```bash
git clone https://github.com/MiaCoronel/Tienda-Organica-AllinRuna.git
cd Tienda-Organica-AllinRuna
```

2. Configurar la base de datos en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tienda_organica_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

3. Ejecutar el proyecto:
```bash
./mvnw spring-boot:run
```

4. Abrir en el navegador:
   http://localhost:8080

## 📂 Estructura del proyecto
src/main/java/com/example/segundoAvance/
├── controller/     # Controladores REST y MVC
├── service/        # Lógica de negocio
├── repository/     # Acceso a datos (JPA)
├── model/          # Entidades de la base de datos
├── dto/            # Objetos de transferencia de datos
└── config/         # Configuración de seguridad

## 🌐 Despliegue

- **Backend:** Desplegado en [Railway](https://railway.app)
- **Base de datos:** MySQL en Railway
- **CI/CD:** Automatizado con GitHub Actions

## 📸 Capturas de pantalla

*(Próximamente)*

## 👥 Equipo de desarrollo

| Integrante | Rol |
|------------|-----|
| Mia Coronel | Desarrolladora Backend |
| Marlon Condori | Desarrollador Backend |
| Johann Chamorro | Desarrollador FRONT- |
| Aldo Jhonatan | Desarrollador FRONT-|


## 📝 Licencia

Proyecto académico desarrollado con fines educativos para la UTP.
