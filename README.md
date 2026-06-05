# 🌿 Tienda Orgánica AllinRuna

> Plataforma web para la gestión y venta de productos orgánicos desarrollada con Java Spring Boot.

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)
![GitHub](https://img.shields.io/badge/Control%20de%20versiones-GitHub-black?style=flat-square&logo=github)

---

## 📋 Descripción

**AllinRuna** (del quechua: *persona buena / completa*) es una aplicación web que permite gestionar una tienda de productos orgánicos. El sistema incluye autenticación de usuarios, catálogo de productos, gestión de pedidos y un panel administrativo completo.

Proyecto desarrollado para el curso de **Herramientas de Desarrollo** — Universidad Tecnológica del Perú (UTP), Facultad de Ingeniería, Ingeniería de Sistemas e Informática — 2026.

---

## ✨ Funcionalidades

- 🔐 Autenticación y registro de usuarios con Spring Security
- 📦 Gestión completa de productos orgánicos (crear, editar, eliminar)
- 🛒 Módulo de pedidos y carrito de compras
- 🖥️ Panel administrativo con control de acceso por roles
- 🗄️ Persistencia de datos con MySQL y Spring Data JPA

---

## 🛠️ Tecnologías

| Capa | Tecnología |
|------|------------|
| Backend | Java 17, Spring Boot 3.5 |
| Frontend | Thymeleaf, HTML5, CSS3 |
| Base de Datos | MySQL 8.0 |
| Seguridad | Spring Security |
| Control de Versiones | Git, GitHub |
| Gestión de Tareas | Jira |

---

## 🏗️ Arquitectura

El proyecto sigue el patrón **MVC (Modelo-Vista-Controlador)**:

```
src/main/java/com/example/segundoAvance/
├── config/         → Configuración de Spring Security
├── controller/     → Controladores REST y MVC
├── dto/            → Data Transfer Objects
├── model/          → Entidades JPA (Producto, Pedido, Usuario)
├── repository/     → Interfaces Spring Data JPA
└── service/        → Lógica de negocio
```

---

## 🚀 Cómo ejecutar el proyecto

### Prerrequisitos

- Java 17+
- Maven 3.8+
- MySQL 8.0+
- Git

### Instalación

```bash
# 1. Clonar el repositorio
git clone https://github.com/MiaCoronel/Tienda-Organica-AllinRuna.git
cd Tienda-Organica-AllinRuna

# 2. Crear la base de datos en MySQL
# CREATE DATABASE allinruna_db;

# 3. Configurar application.properties con tus credenciales MySQL
# spring.datasource.url=jdbc:mysql://localhost:3306/allinruna_db
# spring.datasource.username=TU_USUARIO
# spring.datasource.password=TU_CONTRASEÑA

# 4. Compilar y ejecutar
./mvnw spring-boot:run
```

Accede en: `http://localhost:8080`

---

## 👥 Equipo

| Nombre | Código | GitHub | Módulo |
|--------|--------|--------|--------|
| Mia Nicoll Coronel Uchuypoma | U23235889 | [@MiaCoronel](https://github.com/MiaCoronel) | Owner · Productos |
| Marlon Gerardo Condori Sotelo | U23223423 | [@MarlonCS18](https://github.com/MarlonCS18) | Pedidos y carrito |
| Aldo Jhonatan Aburto Ricapa | U21322413 | [@AldoJhonatan10](https://github.com/AldoJhonatan10) | Autenticación |
| Johann Miguel Chamorro Mayta | U22301535 | [@JohannChamorro20](https://github.com/JohannChamorro20) | Panel administrativo |

---

## 🌿 Estrategia de Ramas

```
main
 └── develop
      ├── feature/autenticacion   → Aldo
      ├── feature/productos       → Mia
      ├── feature/pedidos         → Marlon
      └── feature/frontend-admin  → Johann
```

---

## 📄 Licencia

Proyecto académico — Universidad Tecnológica del Perú · 2026
