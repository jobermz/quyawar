
/* Drop Tables */

DROP TABLE IF EXISTS quyawar.t_campania;
DROP TABLE IF EXISTS quyawar.t_historial_donacion;
DROP TABLE IF EXISTS quyawar.t_donante;
DROP TABLE IF EXISTS quyawar.t_catalogo;
DROP TABLE IF EXISTS quyawar.t_usuario;
DROP TABLE IF EXISTS quyawar.t_perfil;
DROP TABLE IF EXISTS quyawar.t_sede_salud;
DROP TABLE IF EXISTS quyawar.t_tipo_catalogo;
DROP TABLE IF EXISTS quyawar.t_ubigeo;




/* Create Tables */

CREATE TABLE quyawar.t_campania
(
	id_campania serial NOT NULL,
	descripcion varchar(300),
	id_tipo_sangre int,
	ubicacion varchar(1000),
	zool int,
	imagen varchar(200),
	id_ubigeo int,
	id_sedesalud int,
	PRIMARY KEY (id_campania)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_catalogo
(
	id_catalogo int NOT NULL,
	id_tipo_catalogo int NOT NULL,
	descripcion varchar(300),
	abreviatura varchar(10),
	valor int,
	CONSTRAINT pk_t_catalogo PRIMARY KEY (id_catalogo)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_donante
(
	id_donante serial NOT NULL,
	id_usuario int,
	num_dni varchar(20),
	nombre varchar(300),
	appaterno varchar(300),
	apmaterno varchar(300),
	fecha_nacimiento date,
	clave_usuario varchar(300),
	id_estadocivil int,
	id_sexo int,
	celular varchar(12),
	celular2 varchar(12),
	telefono varchar(12),
	correo varchar(300),
	direccion varchar(300),
	ind_tipo int,
	zoom int,
	ubicacion varchar(1000),
	id_ubigeo int,
	id_sedesalud int,
	CONSTRAINT pk_t_donante PRIMARY KEY (id_donante)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_historial_donacion
(
	id_historialdonacion serial NOT NULL,
	id_donante int,
	unidades int,
	fecha_donacion date,
	CONSTRAINT pk_t_historialpuntos PRIMARY KEY (id_historialdonacion)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_perfil
(
	id_perfil serial NOT NULL,
	perfil varchar(300),
	CONSTRAINT pk_t_perfil PRIMARY KEY (id_perfil)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_sede_salud
(
	id_sedesalud serial NOT NULL,
	nombre varchar(300),
	direccion varchar(300),
	telefono varchar(12),
	celular varchar(12),
	ubicacion varchar(1000),
	zoom int,
	CONSTRAINT pk_t_sedesalud PRIMARY KEY (id_sedesalud)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_tipo_catalogo
(
	id_catalogo int NOT NULL,
	descripcion varchar(300),
	PRIMARY KEY (id_catalogo)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_ubigeo
(
	id_ubigeo int NOT NULL,
	id_departamento int,
	id_provincia int,
	id_distrito int,
	ubigeo varchar(300),
	CONSTRAINT pk_t_ubigeo PRIMARY KEY (id_ubigeo)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_usuario
(
	id_usuario serial NOT NULL,
	id_perfil int NOT NULL,
	usuario varchar(300),
	clave_usuario varchar(15),
	nombre_responsable varchar(300),
	appaterno varchar(300),
	apmaterno varchar(300),
	telefono varchar(12),
	correo varchar(300),
	celular varchar(12),
	id_sedesalud int NOT NULL,
	CONSTRAINT pk_t_usuario PRIMARY KEY (id_usuario)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE quyawar.t_campania
	ADD FOREIGN KEY (id_tipo_sangre)
	REFERENCES quyawar.t_catalogo (id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD FOREIGN KEY (id_sexo)
	REFERENCES quyawar.t_catalogo (id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD FOREIGN KEY (id_estadocivil)
	REFERENCES quyawar.t_catalogo (id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_historial_donacion
	ADD CONSTRAINT fk_t_histor_reference_t_donant FOREIGN KEY (id_donante)
	REFERENCES quyawar.t_donante (id_donante)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_usuario
	ADD FOREIGN KEY (id_perfil)
	REFERENCES quyawar.t_perfil (id_perfil)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_campania
	ADD FOREIGN KEY (id_sedesalud)
	REFERENCES quyawar.t_sede_salud (id_sedesalud)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD FOREIGN KEY (id_sedesalud)
	REFERENCES quyawar.t_sede_salud (id_sedesalud)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_usuario
	ADD FOREIGN KEY (id_sedesalud)
	REFERENCES quyawar.t_sede_salud (id_sedesalud)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_catalogo
	ADD FOREIGN KEY (id_tipo_catalogo)
	REFERENCES quyawar.t_tipo_catalogo (id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_campania
	ADD FOREIGN KEY (id_ubigeo)
	REFERENCES quyawar.t_ubigeo (id_ubigeo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD FOREIGN KEY (id_ubigeo)
	REFERENCES quyawar.t_ubigeo (id_ubigeo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD CONSTRAINT fk_t_donant_reference_t_usuari FOREIGN KEY (id_usuario)
	REFERENCES quyawar.t_usuario (id_usuario)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



