# Final Project From Course Java 21 Backend Developer

Link course:
```
https://mitocode.com/curso/javabackend/
```

# 📋 Evaluación

## 1. Requerimiento General

Crear un **backend** enfocado en **servicios REST** que resuelva el siguiente escenario:

> Se desea llevar el control de registros de matrícula de los estudiantes de una academia. Para ello, se deben almacenar los datos de los estudiantes, los cursos, y las matrículas (cursos en los que están inscritos los estudiantes).

### 🧩 Servicios REST a implementar:

#### 📌 CRUD Estudiante

| Campo     | Tipo     |
|-----------|----------|
| `id`      | integer  |
| `nombres` | string   |
| `apellidos` | string |
| `dni`     | string   |
| `edad`    | integer  |

---

#### 📌 CRUD Curso

| Campo     | Tipo     |
|-----------|----------|
| `id`      | integer  |
| `nombre`  | string   |
| `siglas`  | string   |
| `estado`  | boolean  |

---

#### 📌 Registrar Matrícula

##### Datos de matrícula:

| Campo             | Tipo             |
|------------------|------------------|
| `fechaMatricula` | LocalDateTime    |
| `estudiante`     | Estudiante (clase) |
| `detalleMatricula` | Arreglo de DetalleMatricula |
| `estado`         | boolean          |

##### DetalleMatricula:

| Campo | Tipo   |
|-------|--------|
| `curso` | Curso (clase) |
| `aula`  | string        |

---

### 🧮 Requisitos adicionales

- ✅ **Listar estudiantes ordenados de forma descendente por edad** usando **programación funcional**.
- ✅ **Mostrar la relación de cursos matriculados con sus estudiantes** usando **programación funcional** (sugerencia: usar un `Map<K, V>`).

#### Ejemplo esperado:
Programación:
- Jaime Medina

Base de Datos:
- Mito X
- Code Y

---

## 2. Consideraciones técnicas

- Usar cualquier **base de datos** de preferencia.
- Incluir **control de excepciones globales**.
- Validar los `request` de los servicios usando `@Valid` según tu stack.
- **No es obligatorio** usar `Spring Security` o `JWT`.

---

## 3. Entrega

- Subir el código a un repositorio público en **Bitbucket**, **GitHub**, u otra plataforma de control de versiones.
- Asegúrate de incluir un archivo `.gitignore` para no subir archivos innecesarios.
- Enviar el enlace del repositorio al correo: **cursos@mitocodenetwork.com**

---