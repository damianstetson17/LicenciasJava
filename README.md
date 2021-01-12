# 👥 Sistema de Gestión de Licencias 👥
Basado en el [Sistema de Licencias hecho en python](https://github.com/damianstetson17/PyLicenciasPersonal) desarrollado para un sistema de gestión de licencias para un departamento de personal, en donde se lleva registro y control de licencias de empleados, en el podrás:

* Crear y borrar empleados basados en un identificador denominado "número de legajo".
* Crear y borrar dias correspondientes por año.
* Crear Licencias con controles de fines de semana y/o feriados.
* Llevar registro de licencias y días correspondientes de empleados.

## Diagrama de Clases
Se ha ajustado levemente el diagra de clases del [Sistema de Licencias hecho en python](https://github.com/damianstetson17/PyLicenciasPersonal) para ser más consistente y completo.

![diagrama_de_clases](https://github.com/damianstetson17/LicenciasJava/blob/main/img/class_diagram_java.png)

## ⚠️ Estado del proyecto ⚠️

### Hecho ✅:
* Modelo completo.
* No contabilizar **días feriados** _(Estos cargables por el usuario)_ ni **fines de semana** a la hora de contabilizar los días de licencia
* Caducidad de días correspondientes no utilizados en *X* cantidad de tiempo.
* "Logger" en consola de los llamados a los módulos y mensajes de errores.
![errors and msj](https://github.com/damianstetson17/PyLicenciasPersonal/blob/main/img/msj_errors.png)

### No implementado ❌:
* Conexión con BD.
* Graphic user interface.
* Generación de Hojas de cálculo con resultados.

## 🔧 Construido con:
* [Lucidchart](www.lucidchart.com)
* [NetBeans 11.3](https://netbeans.apache.org/download/nb113/index.html)
* [jdk 13.0.2](https://www.oracle.com/ar/java/technologies/javase-jdk13-downloads.html)
* [SQLite](https://www.sqlite.org/index.html)

## 🚀 ¿Cómo ejecutar? 🚀

* Conectar la BD configurando el archivo [persistence.xml](https://github.com/damianstetson17/LicenciasJava/blob/main/src/main/resources/META-INF/persistence.xml)
* Compilar el archivo [main.java](https://github.com/damianstetson17/LicenciasJava/blob/main/src/main/java/Main.java)
* Ejecutar el archivo [main.java](https://github.com/damianstetson17/LicenciasJava/blob/main/src/main/java/Main.java) 
** Al finalizar el proyecto se incluirá el ejecutable.

### ¿Que me encontraré al compilar el archivo [main.java](https://github.com/damianstetson17/PyLicenciasPersonal/blob/main/src/main.py)?
Que no te pierda la cantidad de contenido dentro del fichero [main.java](https://github.com/damianstetson17/PyLicenciasPersonal/blob/main/src/main.py), simplemente
crea instancias de los objetos del modelo, generación de Licencias, entre otros. Los métodos se encuentran documentados con la finalidad del mísmo. 

## 🦚 Aclaraciones 🦚

Este proyecto se ha desarrollado con el fin de desarrollar un sistema gestor de licencias para un organización privada, con sus limitaciones y alcances que satisfacen sus necesidades.

_Todas estas imágenes y documentación se encuentran sujetas a cambios, que serán publicados en tiempo y forma._
