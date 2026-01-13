# 📐 Fibonacci API – Spring Boot 3

API REST desarrollada con **Spring Boot 3 y Java 17** que genera series Fibonacci a partir de una hora dada (`HH:mm:ss`), persiste los resultados en base de datos y envía el resultado por correo electrónico.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security (Basic Auth)
- H2 Database
- Lombok
- Spring Mail
- Springdoc OpenAPI (Swagger)
- JUnit 5 / Mockito

---

## 🧩 Descripción funcional

La aplicación recibe una hora en formato `HH:mm:ss` y un correo electrónico:

- **Minutos** → se usan como semillas de la serie Fibonacci  
  - Ejemplo: `23` → semillas `2` y `3`
- **Segundos** → cantidad de números a generar (sin contar semillas)
- La serie se genera de forma **iterativa** y se devuelve en **orden descendente**
- El resultado:
  - Se guarda en base de datos
  - Se envía por correo electrónico
  - Se retorna como respuesta del API

---

## 📌 Ejemplo

Entrada:
```
12:23:04
```

Salida:
```
[21, 13, 8, 5, 3, 2]
```

---

## 📡 Endpoints

### 🔐 Autenticación
Todos los endpoints están protegidos con **Basic Auth**.

```
Usuario: admin
Password: admin123
```

---

### ▶️ Generar serie Fibonacci

**POST** `/api/fibonacci`

**Request**
```json
{
  "time": "12:23:04",
  "email": "test@test.com"
}
```

**Response**
```json
{
  "executionTime": "12:23:04",
  "series": [21, 13, 8, 5, 3, 2],
  "message": "La serie Fibonacci fue generada y enviada correctamente al correo test@test.com"
}
```

---

### 📥 Obtener todas las series generadas

**GET** `/api/fibonacci`

---

## 🧪 Pruebas

Ejecutar pruebas:
```bash
mvn test
```

---

## 📘 Swagger / OpenAPI

```
http://localhost:8080/swagger-ui.html
```

---

## ▶️ Ejecución local

```bash
mvn clean spring-boot:run
```

---

## ✉️ Autor

Prueba técnica – Backend Spring Boot
