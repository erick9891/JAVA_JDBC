/*
Empresa        :  Comunidad Cristiana Agua Viva
Software       :  Sistema de Control de Asistencias
DBMS           :  Oracle XE
Base de Datos  :  ndr
Script         :  Crea la Base de Datos
Responsable    :  Erick Ore
Email          :  erick989@gmail.com
*/

-- =============================================
-- CREACIÓN DE LA APLICACIÓN
-- =============================================

DECLARE
	N INT;
	COMMAND VARCHAR2(200);
BEGIN
	COMMAND := 'DROP USER ndr CASCADE';
	SELECT COUNT(*) INTO N
	FROM DBA_USERS
	WHERE USERNAME = 'NDR';
	IF ( N = 1 ) THEN
		EXECUTE IMMEDIATE COMMAND;
	END IF;
END;
/

CREATE USER ndr IDENTIFIED BY admin;

GRANT CONNECT, RESOURCE TO ndr;

ALTER USER NDR
QUOTA UNLIMITED ON USERS;

GRANT CREATE VIEW TO ndr;


-- =============================================
-- CONECTARSE A LA APLICACIÓN
-- =============================================

CONNECT ndr/admin


-- =============================================
-- CREACIÓN DE LOS OBJETOS DE LA BASE DE DATOS
-- =============================================

CREATE TABLE Aula (
	chr_aulacodigo       	CHAR(2) NOT NULL,
	vch_auladescripcion		VARCHAR(40) NOT NULL,
	CONSTRAINT XPK_Aula 
		PRIMARY KEY (chr_aulacodigo)				
);

CREATE TABLE Sede (
	chr_sedecodigo       	CHAR(2) NOT NULL,
	vch_sedenombre			VARCHAR(40)	NOT NULL,
	vch_sedeciudad			VARCHAR(40) NOT NULL,
	CONSTRAINT XPK_Sede 
		PRIMARY KEY (chr_sedecodigo)				
);

CREATE TABLE Escuela (
	chr_escucodigo       	CHAR(2) NOT NULL,
	vch_escunombre			VARCHAR(40) NOT NULL,
	chr_sedecodigo       	CHAR(2) NOT NULL,
	CONSTRAINT XPK_Escuela 
		PRIMARY KEY (chr_escucodigo),	
	CONSTRAINT fk_chr_sedecodigo
		FOREIGN KEY (chr_sedecodigo)
			REFERENCES Sede
);

CREATE TABLE Maestro (
	chr_maesdni				CHAR(8) NOT NULL,
	vch_maespaterno			VARCHAR(40) NOT NULL,
	vch_maesmaterno			VARCHAR(40) NOT NULL,
	vch_maesnombre			VARCHAR(40) NULL,
	vch_maesdistrito	   	VARCHAR(40) NOT NULL,
	vch_maestelefono		VARCHAR(40) NOT NULL,
	vch_maeseducacion		VARCHAR(40) NOT NULL,
	vch_maesusuario			VARCHAR(15) NOT NULL,
	vch_maesclave			VARCHAR(15) NOT NULL,	
	chr_escucodigo       	CHAR(2) NOT NULL,
	CONSTRAINT XPK_Maestro 
		PRIMARY KEY (chr_maesdni),
	CONSTRAINT fk_chr_escucodigo
		FOREIGN KEY (chr_escucodigo)
			REFERENCES Escuela		
);

CREATE TABLE Apoderado (
	chr_apodni				CHAR(8) NOT NULL,
	vch_apopaterno			VARCHAR(40) NOT NULL,
	vch_apomaterno			VARCHAR(40) NOT NULL,
	vch_aponombre			VARCHAR(40) NOT NULL,
	chr_escucodigo       	CHAR(2) NOT NULL,
	CONSTRAINT XPK_Apoderado 
		PRIMARY KEY (chr_apodni),
	CONSTRAINT fk_chr_escucodigo
		FOREIGN KEY (chr_escucodigo)
			REFERENCES Escuela
);

CREATE TABLE Estudiante (
	chr_estudni				CHAR(8) NOT NULL,
	vch_estupaterno			VARCHAR(40) NOT NULL,
	vch_estumaterno			VARCHAR(40) NOT NULL,
	vch_estunombre			VARCHAR(40) NOT NULL,
	vch_estuedad			CHAR(1) NOT NULL,
	vch_estudistrito		VARCHAR(40) NOT NULL,
	chr_apodni				CHAR(8) NOT NULL,	
	CONSTRAINT XPK_Estudiante 
		PRIMARY KEY (chr_estudni),
	CONSTRAINT fk_chr_apodni
		FOREIGN KEY (chr_apodni)
			REFERENCES Apoderado
);

CREATE TABLE Curso (
	chr_cursocodigo			CHAR(3) NOT NULL,
	chr_sedecodigo			CHAR(2) NOT NULL,
	chr_aulacodigo       	CHAR(2) NOT NULL,
	chr_maesdni				CHAR(8) NOT NULL,
	vch_cursoperiodo		VARCHAR(40) NOT NULL,
	CONSTRAINT XPK_Curso
		PRIMARY KEY (chr_cursocodigo),
	CONSTRAINT fk_chr_sedecodigo
		FOREIGN KEY (chr_sedecodigo)
			REFERENCES Sede,
	CONSTRAINT fk_chr_aulacodigo
		FOREIGN KEY (chr_aulacodigo)
			REFERENCES Aula,
	CONSTRAINT fk_chr_maesdni
		FOREIGN KEY (chr_maesdni)
			REFERENCES Maestro
);

CREATE TABLE Asistencia (
	chr_cursocodigo			CHAR(3) NOT NULL,
	chr_estudni				CHAR(8) NOT NULL,
	dtt_asisfecha			DATE NOT NULL,
	CONSTRAINT XPK_Asistencia 
		PRIMARY KEY (chr_cursocodigo, chr_estudni,dtt_asisfecha),
	CONSTRAINT fk_cursocodigo
		FOREIGN KEY (chr_cursocodigo)
			REFERENCES Curso,
	CONSTRAINT fk_chr_estudni
		FOREIGN KEY (chr_estudni)
			REFERENCES Estudiante
);

CREATE TABLE Contador (
       vch_conttabla        VARCHAR(30) NOT NULL,
       int_contitem         NUMBER(6,0) NOT NULL,
       int_contlongitud     NUMBER(3,0) NOT NULL,
       CONSTRAINT XPKContador 
              PRIMARY KEY (vch_conttabla)
);
