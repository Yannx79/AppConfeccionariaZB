# AppConfeccionariaZB

Es una propuesta de mejora para el proyecto de Ingeniería de Software de V ciclo, que consiste en la implementación de un software para el control del kardex de la empresa Confecciones "Z y B". El software permitirá registrar, consultar y actualizar la información de los productos, las entradas, las salidas y los saldos de inventario de la empresa. El software se desarrollará utilizando el lenguaje de programación Java y el sistema de gestión de bases de datos MySQL. El software se entregará en un plazo de seis meses y tendrá un costo estimado de 15.000 dólares.

## Indice
[1. Desarrolladores](#1-desarrolladores)

[2. Instalación](#2-instalación)

[3. Empleabilidad](#3-empleabilidad)

[4. Roles](#4-roles)

[5. Arquitectura](#5-arquitectura)

[6. Estructura del Proyecto](#6-estructura-del-proyecto)

[7. Funcionalidades Principales](#7-funcionalidades-principales)

[8. Tecnologías Utilizadas](#8-tecnologías-utilizadas)

[9. Base de Datos](#9-base-de-datos)

[10. Requisitos](#10-requisitos)

## 1. Desarrolladores

- [Funes Chavez, Yannick Yasuhiro](https://github.com/Yannx79)

- [Cárdenas Jiménez, José Jesús](https://github.com/JoseCarden)

- [Enriquez Leiva, Aracelly Ibeth](https://github.com/ARACELLYENR)

- [Piscoche Olivarez, Edgar Nino](https://github.com/EDGARNPO)

- [Zeta Bran, Gerson Steven](https://github.com/GersonZeta)

## 2. Instalación

## 3. Ejecución de Prueba

### 3.1. Vista Menu

![Vista Menu](/src/doc/Vista-Menu.PNG)

### 3.2. Vista Login

![Vista Login](/src/doc/Vista-Login.PNG)

### 3.3. Vista Cliente

![Vista Cliente](/src/doc/Vista-Cliente.PNG)

### 3.4. Vista Proveedor

![Vista Proveedor](/src/doc/Vista-Proveedor.PNG)

### 3.5. Vista Movimientos Internos

![Vista Movimientos Internos](/src/doc/Vista-Movimientos-Internos.PNG)

### 3.6. Vista Venta

![Vista Venta](/src/doc/Vista-Venta.PNG)

### 3.7. Vista Abastecimiento

![Vista Abastecimiento](/src/doc/Vista-Abastecer.PNG)

## 4. Roles

- Jefe de Proyecto: 
    - [Funes Chavez, Yannick Yasuhiro](https://github.com/Yannx79)

- Analista de Negocio: 
    - [Funes Chavez, Yannick Yasuhiro](https://github.com/Yannx79)
    - [Cárdenas Jiménez, José Jesús](https://github.com/JoseCarden)

- Desarrolldor Backend:
    - [Funes Chavez, Yannick Yasuhiro](https://github.com/Yannx79)

    - [Cárdenas Jiménez, José Jesús](https://github.com/JoseCarden)

    - [Enriquez Leiva, Aracelly Ibeth](https://github.com/ARACELLYENR)

    - [Piscoche Olivarez, Edgar Nino](https://github.com/EDGARNPO)

    - [Zeta Bran, Gerson Steven](https://github.com/GersonZeta)

- Desarrollador Frontend:
    - [Funes Chavez, Yannick Yasuhiro](https://github.com/Yannx79)

    - [Cárdenas Jiménez, José Jesús](https://github.com/JoseCarden)

    - [Enriquez Leiva, Aracelly Ibeth](https://github.com/ARACELLYENR)

    - [Piscoche Olivarez, Edgar Nino](https://github.com/EDGARNPO)

    - [Zeta Bran, Gerson Steven](https://github.com/GersonZeta)

## 5. Arquitectura

El sistema está estructurado en base a una **arquitectura MVC (Modelo-Vista-Controlador)** y capas DAO/BO para una separación clara de responsabilidades.

- **Modelo (models)**: Lógica de negocio (BO) y acceso a datos (DAO/IDAO).
- **Vista (views)**: Interfaces gráficas de usuario (Swing + AbsoluteLayout).
- **Controlador (controllers)**: Enlace entre vista y modelo.
- **Recursos (img, doc)**: Imágenes y documentación del sistema.


## 6. Estructura del Proyecto

```text
AppConfeccionariaZB/
│
├── lib/                          # Librerías externas (ej. AbsoluteLayout)
│
├── src/
│   ├── db/                       # Script SQL de la base de datos
│   ├── doc/                      # Capturas de pantalla de las interfaces
│   ├── main/
│   │   └── java/
│   │       └── com/nk/
│   │           ├── app/         # Clase principal App.java
│   │           ├── controllers/ # Controladores de cada vista
│   │           ├── img/         # Imágenes para la GUI
│   │           └── models/      
│   │               ├── bo/      # Objetos de negocio
│   │               ├── dao/     # Acceso a datos
│   │               ├── dto/     # Objetos de transferencia de datos
│   │               ├── datasource/ # Configuraciones de conexión
│   │               ├── idao/    # Interfaces de acceso a datos
│   │               └── utilities/ # Utilidades generales
│
├── pom.xml                      # Configuración del proyecto Maven
├── README.md                    # Documentación del proyecto
└── nbactions.xml                # Configuración de NetBeans
```

## 7. Funcionalidades Principales

- 🔐 Login de usuarios  
- 👥 Módulo de clientes (Registrar, consultar y actualizar clientes)  
- 🏢 Módulo de proveedores  
- 📦 Gestión de productos e insumos (inventario, entradas y salidas)  
- 🛒 Compras y abastecimiento  
- 💰 Ventas y detalle de ventas  
- 🔄 Movimientos internos entre almacenes  
- 🧭 Menú principal con navegación sencilla entre módulos  

## 8. Tecnologías Utilizadas

- **Lenguaje:** Java 8+  
- **IDE:** NetBeans  
- **Framework GUI:** Swing (con AbsoluteLayout)  
- **Conexión a BD:** JDBC  
- **Base de datos:** MySQL  
- **Gestión de proyecto:** Maven  
- **Estilo arquitectónico:** MVC + DAO + BO  

## 9. Recursos Visuales

El sistema incluye vistas gráficas para facilitar su uso. Algunas capturas incluidas:

- `Vista-Login.PNG`  
- `Vista-Menu.PNG`  
- `Vista-Clientes.PNG`  
- `Vista-Proveedores.PNG`  
- `Vista-Abastecimiento.PNG`  

Las imágenes se encuentran en la carpeta `src/doc`.

## 9. Base de Datos

El archivo de base de datos `db_confeccionario.sql` ubicado en `src/db` contiene todas las instrucciones necesarias para crear la base de datos, sus tablas y relaciones.

### 10. Requisitos

- Servidor MySQL (puedes usar XAMPP, WAMP o MySQL Workbench)
- Crear una base de datos llamada `confeccionario`
- Ejecutar el script `db_confeccionario.sql`

