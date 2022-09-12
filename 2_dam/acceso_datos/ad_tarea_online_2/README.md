
# Contenido del Proyecto

· Proyectos de Netbeans desarrollados en Java.
· Documento PDF con la memoria del ejercicio.
· Base de Datos SQL consultoraIT.


# Descripción de la tarea

## Caso práctico

Los propietarios de una empresa de consultoría informática le han encargado a  BK Programación el backend de una aplicación que gestione cierta información sobre las áreas y trabajadores recogidas en la base de datos MySQL que tienen en su negocio. Para ello, solicitan la creación de algunos objetos de la B.D. como consultas y procedimientos almacenados que sean accedidos a través de aplicaciones desarrolladas en lenguaje Java.

# ¿ Que te pedimos que hagas ?

## EJERCICIO 1

Lanza el script SQL de creación del esquema de la base de datos (consultoraIT) y asegúrate de que se crean ambas tablas y se insertan los registros correspondientes. Puedes usar, bien un cliente gráfico (MySQL Workbench) o bien un cliente en modo texto (Línea de comandos MySQL).

## EJERCICIO 2

Crea un proyecto en Netbeans con nombre AD02_Ej02_ApellidosNombre que establezca conexión con la BD y muestre la información obtenida, resultado de implementar a través de sentencias preparadas y parametrizadas las siguientes consultas, por la salida estándar:
a. Consulta 1: Empleados que pertenecen a un departamento, indicado por su nombre.
b. Consulta 2: Para cada departamento, obtener el número de empleados que pertenecen a dicho departamento y el presupuesto (cantidad de dinero) destinado a ese departamento.
c. Consulta 3: Incremento salarial en un porcentaje del 10% de todos los empleados de un determinado departamento que se pasará como parámetro.
Debes gestionar las posibles excepciones y errores que puedan presentarse, así como el cierre de recursos utilizados de forma adecuada si la aplicación dejara de funcionar (usa la sentencia try-catch-finally o equivalente).

## EJERCICIO 3

Desarrolla un proyecto en NetBeans con nombre AD02_Ej03_ApellidoNombre que establezca conexión con la BD y muestre la información obtenida, resultado de ejecutar los siguientes procedimientos almacenados, por la salida estándar:
a. P.A. 1: Un procedimiento almacenado que obtenga en un parámetro de salida, el número total de empleados cuya comisión pertenece a un determinado intervalo. Se deben pasar como parámetros al procedimiento, tanto el valor inicial del intervalo como el valor final.
b. P.A. 2: Un procedimiento almacenado que devuelva en un parámetro de salida, el número total de empleados dados de alta en la consultora, cuyo salario pertenece a un determinado intervalo económico. Se deben pasar como parámetros al procedimiento, tanto el valor inicial como el valor final de dicho intervalo.
c. P.A. 3: Un procedimiento almacenado que aumente el salario de los empleados de cierto departamento en un porcentaje. El departamento y valor entero del porcentaje a aplicar se han de pasar como parámetros (de entrada).
Debes gestionar las posibles excepciones y errores que puedan presentarse, así como el cierre de recursos utilizados de forma adecuada si la aplicación dejara de funcionar (usa la sentencia try-catch-finally o equivalente).