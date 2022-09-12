/**************************************************************************/
/*Este script SQL crea la base de datos proyectosx y todas sus tablas*/
/*************************************************************************/

/*Borramos, si existe, una base de datos anterior */
DROP DATABASE IF EXISTS proyectosx;

/*Creamos la base de datos llamada gestionproyectos */
CREATE DATABASE proyectosx
CHARACTER SET utf8
COLLATE utf8_spanish_ci;

USE proyectosx;
/***********************/
/* TABLA: departamento */
/***********************/
CREATE TABLE departamento (
  cod_depto CHAR(2) NOT NULL PRIMARY KEY,
  nom_depto VARCHAR(30),
  ciudad VARCHAR(20)
) ENGINE=INNODB;



/***********************/
/* TABLA: empleado     */
/***********************/
CREATE TABLE empleado (
  cod_emp CHAR(3) NOT NULL PRIMARY KEY,
  nom_emp VARCHAR(30),
  fecha_ingreso DATE DEFAULT NULL,
  salario FLOAT(6,2) UNSIGNED,
  cod_jefe CHAR(3) DEFAULT NULL,
  cod_depto CHAR(2),
  FOREIGN KEY (cod_depto)
  REFERENCES departamento(cod_depto)
  ON DELETE RESTRICT ON UPDATE CASCADE ,
  FOREIGN KEY (cod_jefe)
  REFERENCES empleado(cod_emp)
  ON DELETE SET NULL ON UPDATE CASCADE 
) ENGINE=INNODB;



/***********************/
/* TABLA: proyecto     */
/***********************/
CREATE TABLE proyecto (
  cod_pro CHAR(3) NOT NULL PRIMARY KEY,
  nom_pro VARCHAR(30),
  cod_depto CHAR(2),
  FOREIGN KEY (cod_depto)
  REFERENCES departamento(cod_depto)
  ON DELETE RESTRICT ON UPDATE CASCADE 
) ENGINE=INNODB;



/***********************/
/* TABLA: trabaja      */
/***********************/
CREATE TABLE trabaja (
  cod_emp CHAR(3) NOT NULL,
  cod_pro CHAR(3) NOT NULL,
  nhoras INTEGER DEFAULT 0,
  PRIMARY KEY (cod_emp,cod_pro),
  FOREIGN KEY (cod_emp)
  REFERENCES empleado(cod_emp)
  ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (cod_pro)
  REFERENCES proyecto(cod_pro)
  ON DELETE CASCADE ON UPDATE CASCADE 
) ENGINE=INNODB;

/****************************************************************************************
Estas sentencias SQL insertan en las tablas de proyectosx un conjunto de datos de prueba
****************************************************************************************/

/***********************/
/* TABLA: departamento */
/***********************/
INSERT INTO departamento
(cod_depto,nom_depto,ciudad) VALUES ('01','Contabilidad-1','Almería'),
 ('02','Ventas','Sevilla'), ('03','I+D','Málaga'), ('04','Gerencia','Córdoba'),
 ('05','Administración','Córdoba'),('06','Contabilidad-2','Córdoba'), ('07','Marketing','Granada');


/***********************/
/* TABLA: empleado     */
/***********************/
INSERT INTO empleado
(cod_emp,nom_emp,fecha_ingreso,salario,cod_jefe,cod_depto) VALUES ('A11','Esperanza Amarillo','1993-09-23',3000,NULL,'04'),
('A03','Pedro Rojo','1995-03-07',2000,'A11','01'), ('C01','Juan Rojo','1997-02-03',1800,'A03','01'),
('B02','María Azul','1996-01-09',1450,'A03','01'),('A07','Elena Blanco','1994-04-09',2000,'A11','02'),
('B06','Carmen Violeta','1997-02-03',2200,'A07','02'),('C05','Alfonso Amarillo','1998-12-03',2000,'B06','02'),
('B09','Pablo Verde','1998-10-12',1600,'A11','03'),('C04','Ana Verde',NULL,2000,'A07','02'),
('C08','Javier Naranja',NULL,1680,'B09','03'),('A10','Dolores Blanco','1998-11-15',1900,'A11','04'),
('B12','Juan Negro','1997-02-03',1900,'A11','05'),('A13','Jesús Marrón','1999-02-21',2200,'A11','05'),
('A14','Manuel Amarillo','2000-09-01',2000,'A11',NULL);


/***********************/
/* TABLA: proyecto     */
/***********************/
INSERT INTO proyecto
(cod_pro,nom_pro,cod_depto) VALUES ('GRE','Gestión de residuos','03');
INSERT INTO proyecto
(cod_pro,nom_pro,cod_depto) VALUES ('DAG','Depuración de aguas','03');
INSERT INTO proyecto
(cod_pro,nom_pro,cod_depto) VALUES ('AEE','Análisis económico energías','04');
INSERT INTO proyecto
(cod_pro,nom_pro,cod_depto) VALUES ('MES','Marketing de energía solar','02');


/***********************/
/* TABLA: trabaja      */
/***********************/
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('C01','GRE',10);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('C08','GRE',54);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('C01','DAG',5);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('C08','DAG',150);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('B09','DAG',100);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('A14','DAG',10);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('A11','AEE',15);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('C04','AEE',20);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('A11','MES',0);
INSERT INTO trabaja
(cod_emp,cod_pro,nhoras) VALUES ('A03','MES', 0);