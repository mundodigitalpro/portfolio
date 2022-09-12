
# Contenido del Proyecto

· Proyectos de Netbeans desarrollados en Java.
· Documento PDF con la memoria del ejercicio.
· Base de Datos SQL.


# Descripción de la tarea


## EJERCICIO 1

Desarrolla un proyecto en Netbeans y configura Hibernate para realizar el mapeo de esta base de datos relacional.	4
1.1.1 Crea el fichero de configuración de Hibernate (hibernate.cfg.xml), con conexión a la base de datos consultorait con JDBC.	4
1.1.2.Crea el fichero de ingeniería inversa hibernate.reveng.xml e indica las tablas sobre las que se va a establecer correspondencia.	8
1.1.3. Genera las clases y los ficheros de correspondencia (hbm).	8
1.1.4. Codifica y genera las siguientes consultas mediante HQL	11
Consulta 1: Apellido, nombre, salario y número de empleado con un salario inferior a 1600.	11
Consulta 2: Número de empleado, departamento y salario de los empleados, ordenados de menor a mayor salario.	11
Consulta 3: Datos de empleados cuyo departamento no esté en GRANADA.	12
Consulta 4: Apellido, salario y número de departamento de los empleados cuyo salario sea mayor que el máximo salario del departamento 10.	12
Consulta 5: Empleados con salario menor que alguno de los empleados del departamento 20.	13
Consulta 6: Mostrar nombre y total de empleados de aquellos departamentos con más de un empleado adscrito. Ordena el resultado por número de empleado.	13

## EJERCICIO 2

Crea un proyecto Netbean llamado AD03_Ej2_ApellidosNombre que realice un mapeo objeto-relacional con Hibernate sobre la siguiente base de datos:	14
2.1. Una vez creado el proyecto y realizado el mapeo de los objetos de la BD (incluidas las relaciones), observa los ficheros de mapeo generados y las correspondientes clases Java (POJO):	14
2.1.1 Realiza un estudio sobre las clases generadas, interpretando y describiendo brevemente el mapeo realizado por Hibernate. Acompaña tus explicaciones de capturas de pantalla.	15
2.1.2 ¿Cambia algo en el fichero de configuración de Hibernate?	16
2.1.3 ¿Qué ocurre con los nombres de los atributos de las clases (por ejemplo: nom_depto)? 	17
2.1.4 ¿Se llaman igual que los atributos de las tablas?	17
2.2 Crea y añade a tu proyecto los siguientes métodos:	18
2.2.1 Inserta un nuevo objeto Empleados en la BD (código empleado: 'A22', nombre: 'Pepe García', fecha de ingreso: 'la fecha actual', salario: 2000, jefe: 'A11' y departamento '01'). Ejecuta una consulta desde el intérprete de HQL incluido en NetBeans para comprobar que se ha insertado correctamente.	18
2.2.2 Modifica el salario del objeto Empleados de la BD creado en el apartado anterior (empleado A22) con un nuevo valor de 2500. Ejecuta una consulta desde el intérprete de HQL incluido en NetBeans para comprobar que se ha modificado correctamente.	19
2.2.3 Elimina un objeto Empleados de la BD (por ejemplo el empleado A22). Ejecuta una consulta desde el intérprete de HQL incluido en NetBeans para comprobar que se ha eliminado correctamente.	21
2.2.4 Realiza (codifica) la siguiente consulta: "Empleados con salario superior a 1000 € (mostrar su nombre, número de departamento y salario)".	21
