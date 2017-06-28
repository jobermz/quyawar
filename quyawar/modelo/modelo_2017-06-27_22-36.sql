
/* Drop Tables */

DROP TABLE IF EXISTS lupdup.t_campania;
DROP TABLE IF EXISTS lupdup.t_historial_donacion;
DROP TABLE IF EXISTS lupdup.t_donante;
DROP TABLE IF EXISTS lupdup.t_catalogo;
DROP TABLE IF EXISTS lupdup.t_tipo_catalogo;
DROP TABLE IF EXISTS lupdup.t_usuario;
DROP TABLE IF EXISTS lupdup.t_perfil;
DROP TABLE IF EXISTS lupdup.t_sede_salud;
DROP TABLE IF EXISTS lupdup.t_ubigeo;



/* Drop Sequences */

DROP SEQUENCE IF EXISTS lupdup.t_campania_id_campania_seq;
DROP SEQUENCE IF EXISTS lupdup.t_catalogo_id_catalogo_seq;
DROP SEQUENCE IF EXISTS lupdup.t_centrosalud_id_centrosalud_seq;
DROP SEQUENCE IF EXISTS lupdup.t_cita_id_cita_seq;
DROP SEQUENCE IF EXISTS lupdup.t_cuestionario_id_cuestionario_seq;
DROP SEQUENCE IF EXISTS lupdup.t_detalleficha_id_detalleficha_seq;
DROP SEQUENCE IF EXISTS lupdup.t_donante_id_donante_seq;
DROP SEQUENCE IF EXISTS lupdup.t_entidadcolaboradora_id_entidadcolaboradora_seq;
DROP SEQUENCE IF EXISTS lupdup.t_ficha_id_ficha_seq;
DROP SEQUENCE IF EXISTS lupdup.t_historialpuntos_id_historialpuntos_seq;
DROP SEQUENCE IF EXISTS lupdup.t_imagen_id_imagen_seq;
DROP SEQUENCE IF EXISTS lupdup.t_perfil_id_perfil_seq;
DROP SEQUENCE IF EXISTS lupdup.t_sedeentidad_id_sedeentidad_seq;
DROP SEQUENCE IF EXISTS lupdup.t_sedesalud_id_sedesalud_seq;
DROP SEQUENCE IF EXISTS lupdup.t_usuario_id_usuario_seq;




/* Create Sequences */

CREATE SEQUENCE lupdup.t_campania_id_campania_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_catalogo_id_catalogo_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_centrosalud_id_centrosalud_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_cita_id_cita_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_cuestionario_id_cuestionario_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_detalleficha_id_detalleficha_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_donante_id_donante_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_entidadcolaboradora_id_entidadcolaboradora_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_ficha_id_ficha_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_historialpuntos_id_historialpuntos_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_imagen_id_imagen_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_perfil_id_perfil_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_sedeentidad_id_sedeentidad_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_sedesalud_id_sedesalud_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE lupdup.t_usuario_id_usuario_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;



/* Create Tables */

CREATE TABLE lupdup.t_campania
(
	srl_id_campania serial NOT NULL,
	var_descripcion varchar(300),
	int_id_tipo_sangre int,
	var_ubicacion varchar(1000),
	int_zool int,
	var_imagen varchar(200),
	int_id_ubigeo int,
	int_id_sedesalud int,
	PRIMARY KEY (srl_id_campania)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_tipo_catalogo
(
	int_id_catalogo int NOT NULL,
	var_descripcion varchar(300),
	PRIMARY KEY (int_id_catalogo)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_catalogo
(
	int_id_catalogo int NOT NULL,
	int_id_tipo_catalogo int NOT NULL,
	var_descripcion varchar(300),
	var_abreviatura varchar(10),
	int_valor int,
	CONSTRAINT pk_t_catalogo PRIMARY KEY (int_id_catalogo)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_donante
(
	srl_id_donante serial NOT NULL,
	srl_id_usuario int,
	var_num_dni varchar(20),
	var_nombre varchar(300),
	var_appaterno varchar(300),
	var_apmaterno varchar(300),
	dte_fecha_nacimiento date,
	int_id_estadocivil int,
	int_id_sexo int,
	var_celular varchar(12),
	var_celular2 varchar(12),
	var_telefono varchar(12),
	var_correo varchar(300),
	var_direccion varchar(300),
	ind_tipo int,
	int_zoom int,
	int_ubicacion varchar(1000),
	int_id_ubigeo int NOT NULL,
	CONSTRAINT pk_t_donante PRIMARY KEY (srl_id_donante)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_historial_donacion
(
	srl_id_historialdonacion serial NOT NULL,
	int_id_donante int,
	int_unidades int,
	dte_fecha_donacion date,
	CONSTRAINT pk_t_historialpuntos PRIMARY KEY (srl_id_historialdonacion)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_perfil
(
	srl_id_perfil serial NOT NULL,
	var_perfil varchar(300),
	CONSTRAINT pk_t_perfil PRIMARY KEY (srl_id_perfil)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_sede_salud
(
	srl_id_sedesalud serial NOT NULL,
	var_nombre varchar(300),
	var_direccion varchar(300),
	var_telefono varchar(12),
	var_celular varchar(12),
	var_ubicacion varchar(1000),
	int_zoom int,
	CONSTRAINT pk_t_sedesalud PRIMARY KEY (srl_id_sedesalud)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_ubigeo
(
	int_id_ubigeo int NOT NULL,
	int_id_departamento int,
	int_id_provincia int,
	int_id_distrito int,
	var_ubigeo varchar(300),
	CONSTRAINT pk_t_ubigeo PRIMARY KEY (int_id_ubigeo)
) WITHOUT OIDS;


CREATE TABLE lupdup.t_usuario
(
	srl_id_usuario serial NOT NULL,
	int_id_perfil int NOT NULL,
	var_usuario varchar(300),
	var_clave_usuario varchar(15),
	var_nombre_responsable varchar(300),
	var_appaterno varchar(300),
	var_apmaterno varchar(300),
	var_telefono varchar(12),
	var_correo varchar(300),
	var_celular varchar(12),
	int_id_sedesalud int NOT NULL,
	CONSTRAINT pk_t_usuario PRIMARY KEY (srl_id_usuario)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE lupdup.t_catalogo
	ADD FOREIGN KEY (int_id_tipo_catalogo)
	REFERENCES lupdup.t_tipo_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_campania
	ADD FOREIGN KEY (int_id_tipo_sangre)
	REFERENCES lupdup.t_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_donante
	ADD FOREIGN KEY (int_id_estadocivil)
	REFERENCES lupdup.t_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_donante
	ADD FOREIGN KEY (int_id_sexo)
	REFERENCES lupdup.t_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_historial_donacion
	ADD CONSTRAINT fk_t_histor_reference_t_donant FOREIGN KEY (int_id_donante)
	REFERENCES lupdup.t_donante (srl_id_donante)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_usuario
	ADD FOREIGN KEY (int_id_perfil)
	REFERENCES lupdup.t_perfil (srl_id_perfil)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_campania
	ADD FOREIGN KEY (int_id_sedesalud)
	REFERENCES lupdup.t_sede_salud (srl_id_sedesalud)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_usuario
	ADD FOREIGN KEY (int_id_sedesalud)
	REFERENCES lupdup.t_sede_salud (srl_id_sedesalud)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_campania
	ADD FOREIGN KEY (int_id_ubigeo)
	REFERENCES lupdup.t_ubigeo (int_id_ubigeo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_donante
	ADD FOREIGN KEY (int_id_ubigeo)
	REFERENCES lupdup.t_ubigeo (int_id_ubigeo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE lupdup.t_donante
	ADD CONSTRAINT fk_t_donant_reference_t_usuari FOREIGN KEY (srl_id_usuario)
	REFERENCES lupdup.t_usuario (srl_id_usuario)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



