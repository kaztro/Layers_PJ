CREATE DATABASE "MODULO"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_El Salvador.1252'
    LC_CTYPE = 'Spanish_El Salvador.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE DEPARTAMENTO(
	id_departamento SERIAL PRIMARY KEY NOT NULL,
	departamento VARCHAR(30) UNIQUE NOT NULL 
);

CREATE TABLE MUNICIPIO(
	id_municipio SERIAL PRIMARY KEY NOT NULL,
	municipio VARCHAR(30) UNIQUE NOT NULL, 
	id_depart INTEGER,
	FOREIGN KEY(id_depart) REFERENCES DEPARTAMENTO(id_departamento)
);

CREATE TABLE USUARIO(
	id_usuario SERIAL PRIMARY KEY NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	enabled BOOL NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	fNac DATE NOT NULL,
	direccion TEXT NOT NULL,
	telFijo VARCHAR(8) NOT NULL,
	telMovil VARCHAR(8) NOT NULL,
    enabled BOOL NOT NULL,
	id_municipio INTEGER NOT NULL,
	FOREIGN KEY(id_municipio) REFERENCES MUNICIPIO(id_municipio)
);

CREATE TABLE ROLES(
	id_rol SERIAL PRIMARY KEY NOT NULL,
	rol VARCHAR(13) NOT NULL
);

CREATE TABLE ROLES_USUARIO(
	id_rolesUser SERIAL PRIMARY KEY NOT NULL,
	id_usuario INTEGER NOT NULL,
	id_rol INTEGER NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES USUARIO(id_usuario),
	FOREIGN KEY(id_rol) REFERENCES ROLES(id_rol)
);

CREATE TABLE CENTROS_ESCOLARES(
	id_centro SERIAL PRIMARY KEY NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	descripcion TEXT NOT NULL,
	estado BOOL NOT NULL,
    enabled BOOL NOT NULL,
	id_municipio INTEGER NOT NULL,
	FOREIGN KEY(id_municipio) REFERENCES MUNICIPIO(id_municipio)
);

CREATE TABLE ESTUDIANTE(
	id_estudiante SERIAL PRIMARY KEY NOT NULL,
	nombres VARCHAR(80) NOT NULL,
	apellidos VARCHAR(80) NOT NULL, 
	cMinoridad TEXT NOT NULL,
	fNac DATE NOT NULL,
	direccion TEXT NOT NULL,
	telFijo VARCHAR(8) NOT NULL,
	telMovil VARCHAR(8) NOT NULL,
	nombreMadre VARCHAR(50) NOT NULL,
	nombrePadre VARCHAR(50) NOT NULL, 
	id_centro INTEGER NOT NULL,
	FOREIGN KEY(id_centro) REFERENCES CENTROS_ESCOLARES(id_centro)
);

CREATE TABLE MATERIA(
	id_materia SERIAL PRIMARY KEY NOT NULL,
	materia VARCHAR(10) NOT NULL,
	descripcion TEXT NOT NULL,
    enabled BOOL NOT NULL
);

CREATE TABLE MATERIA_CURSADA(
	id_materiaCursada SERIAL PRIMARY KEY NOT NULL,
	id_materia INTEGER NOT NULL,
	id_estudiante INTEGER NOT NULL, 
	ano DATE NOT NULL,
	ciclo VARCHAR(2) NOT NULL,
	nota DECIMAL  NOT NULL,
	FOREIGN KEY(id_materia) REFERENCES MATERIA(id_materia),
	FOREIGN KEY(id_estudiante) REFERENCES ESTUDIANTE(id_estudiante)
);