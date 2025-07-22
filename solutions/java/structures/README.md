# Curso: Tipos y estructuras de datos

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Esta carpeta explica todo lo necesario para usar el proyecto basado en Java.

## Tabla de contenidos

Los siguientes son los puntos más importantes en este archivo:
- [Requisitos](#requisitos)
- [Comprobar requisitos](#comprobar-requisitos)
- [Estructura](#estructura-del-proyecto)

## Requisitos

Para poder realizar el curso necesitas tener instalado en tu computadora las siguientes herramientas:
- [Java](http://jdk.java.net/)
- [Git](https://git-scm.com/)

Si no tienes algunas de estas herramientas instaladas en tu computadora, sigue las instrucciones en la documentación oficial de cada herramienta o los videos creados como guía para esta materia.

## Comprobar requisitos

Si instalaste en tu computadora algunas de estas herramientas anteriormente o lo acabas de hacer ahora, verifica si todo funciona bien.

- Comprueba si la versión de Java está correctamente instalada usando el siguiente comando:
   ````
   % java -version
   openjdk 21.0.2 2024-01-16
   OpenJDK Runtime Environment GraalVM CE 21.0.2+13.1 (build 21.0.2+13-jvmci-23.1-b30)
   OpenJDK 64-Bit Server VM GraalVM CE 21.0.2+13.1 (build 21.0.2+13-jvmci-23.1-b30, mixed mode, sharing)
   ````

- Comprueba si tienes instalado de manera correcta en tu computadora Git usando el siguiente comando:
   ````
   % git --version
   git version 2.34.1
   ````

## Estructura del proyecto

El proyecto que se usara a lo largo de la cursada tiene estructura similar a la siguiente:

````
src/
  └── main
      └── java
          └── org
              └── edteam
                  ├── algorithm
                  ├── structure
                  │   ├── definition
                  │   ├── exception
                  │   └── implementation
                  │       ├── dynamic
                  │       │   └── extras
                  │       └── fixed
                  └── util
````

Como se puede ver en la estructura existen una serie de paquetes donde cada uno tiene una funcionalidad en particular. En la siguiente tabla se detalla cada uno de los paquetes como asi tambien si deben o no tener prefijos los archivos en su interior:

| **Paquete**                  | **Descripción**                                                             |
|------------------------------|-----------------------------------------------------------------------------|
| `algorithm`                  | Contiene la implementación de algoritmos que utilizan los TDA.              |
| `structure`                  | Paquete general que agrupa las estructuras de datos.                        |
| `structure.definition`       | Contiene las interfaces o definiciones de los TDA.                          |
| `structure.exception`        | Define las excepciones personalizadas usadas en el proyecto.                |
| `structure.implementation`   | Implementaciones concretas de los TDA.                                      |
| `structure.implementation.dynamic` | Implementaciones de estructuras de datos dinámicas (ej.: listas enlazadas). |
| `structure.implementation.dynamic.extras` | Componentes auxiliares o complementarios para las estructuras dinámicas.    |
| `structure.implementation.fixed`   | Implementaciones de estructuras de datos de tamaño fijo (ej.: arrays).      |
| `util`                       | Clases utilitarias y funciones auxiliares usadas en todo el proyecto.       |

