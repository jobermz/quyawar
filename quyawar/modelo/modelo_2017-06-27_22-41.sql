
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


CREATE TABLE quyawar.t_catalogo
(
	int_id_catalogo int NOT NULL,
	int_id_tipo_catalogo int NOT NULL,
	var_descripcion varchar(300),
	var_abreviatura varchar(10),
	int_valor int,
	CONSTRAINT pk_t_catalogo PRIMARY KEY (int_id_catalogo)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_donante
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


CREATE TABLE quyawar.t_historial_donacion
(
	srl_id_historialdonacion serial NOT NULL,
	int_id_donante int,
	int_unidades int,
	dte_fecha_donacion date,
	CONSTRAINT pk_t_historialpuntos PRIMARY KEY (srl_id_historialdonacion)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_perfil
(
	srl_id_perfil serial NOT NULL,
	var_perfil varchar(300),
	CONSTRAINT pk_t_perfil PRIMARY KEY (srl_id_perfil)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_sede_salud
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


CREATE TABLE quyawar.t_tipo_catalogo
(
	int_id_catalogo int NOT NULL,
	var_descripcion varchar(300),
	PRIMARY KEY (int_id_catalogo)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_ubigeo
(
	int_id_ubigeo int NOT NULL,
	int_id_departamento int,
	int_id_provincia int,
	int_id_distrito int,
	var_ubigeo varchar(300),
	CONSTRAINT pk_t_ubigeo PRIMARY KEY (int_id_ubigeo)
) WITHOUT OIDS;


CREATE TABLE quyawar.t_usuario
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

ALTER TABLE quyawar.t_campania
	ADD FOREIGN KEY (int_id_tipo_sangre)
	REFERENCES quyawar.t_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD FOREIGN KEY (int_id_estadocivil)
	REFERENCES quyawar.t_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD FOREIGN KEY (int_id_sexo)
	REFERENCES quyawar.t_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_historial_donacion
	ADD CONSTRAINT fk_t_histor_reference_t_donant FOREIGN KEY (int_id_donante)
	REFERENCES quyawar.t_donante (srl_id_donante)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_usuario
	ADD FOREIGN KEY (int_id_perfil)
	REFERENCES quyawar.t_perfil (srl_id_perfil)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_campania
	ADD FOREIGN KEY (int_id_sedesalud)
	REFERENCES quyawar.t_sede_salud (srl_id_sedesalud)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_usuario
	ADD FOREIGN KEY (int_id_sedesalud)
	REFERENCES quyawar.t_sede_salud (srl_id_sedesalud)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_catalogo
	ADD FOREIGN KEY (int_id_tipo_catalogo)
	REFERENCES quyawar.t_tipo_catalogo (int_id_catalogo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_campania
	ADD FOREIGN KEY (int_id_ubigeo)
	REFERENCES quyawar.t_ubigeo (int_id_ubigeo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD FOREIGN KEY (int_id_ubigeo)
	REFERENCES quyawar.t_ubigeo (int_id_ubigeo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE quyawar.t_donante
	ADD CONSTRAINT fk_t_donant_reference_t_usuari FOREIGN KEY (srl_id_usuario)
	REFERENCES quyawar.t_usuario (srl_id_usuario)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



