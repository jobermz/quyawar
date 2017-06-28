package pe.edu.upc.quyawar.core.model.entity;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.io.Serializable;
import pe.edu.upc.quyawar.common.CadenaUtil;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

import pe.edu.upc.quyawar.core.model.entity.Catalogo;
import pe.edu.upc.quyawar.core.model.entity.Ubigeo;
import pe.edu.upc.quyawar.core.model.entity.SedeSalud;
	

@Entity
@Table(name = "t_campania", schema="quyawar")
public class Campania implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_campania_srl_id_campania_seq")
	@SequenceGenerator(name="t_campania_srl_id_campania_seq", sequenceName="quyawar.t_campania_srl_id_campania_seq")
	@Column(name = "srl_id_campania")
	private Integer srlIdCampania;
	
	@Column(name = "var_descripcion")
	private String strDescripcion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_tipo_sangre")
	private Catalogo idTipoSangre;
	
	@Column(name = "var_ubicacion")
	private String strUbicacion;
	
	@Column(name = "int_zool")
	private Integer intZool;
	
	@Column(name = "var_imagen")
	private String strImagen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_ubigeo")
	private Ubigeo idUbigeo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_sedesalud")
	private SedeSalud idSedesalud;
	
	public Campania() {}
	
	public Campania(int srlIdCampania) {
		this.srlIdCampania		= srlIdCampania;
	}
	
	public Campania(int srlIdCampania, String strDescripcion, Catalogo idTipoSangre, String strUbicacion, int intZool, String strImagen, Ubigeo idUbigeo, SedeSalud idSedesalud) {
		this.srlIdCampania		= srlIdCampania;
		this.strDescripcion		= strDescripcion;
		this.idTipoSangre		= idTipoSangre;
		this.strUbicacion		= strUbicacion;
		this.intZool		= intZool;
		this.strImagen		= strImagen;
		this.idUbigeo		= idUbigeo;
		this.idSedesalud		= idSedesalud;
	}
	
	public Catalogo getIdTipoSangre() {
		return idTipoSangre;
	}
	public Campania setIdTipoSangre(Catalogo idTipoSangre) {
		this.idTipoSangre = idTipoSangre;
		return this;
	}
	public Ubigeo getIdUbigeo() {
		return idUbigeo;
	}
	public Campania setIdUbigeo(Ubigeo idUbigeo) {
		this.idUbigeo = idUbigeo;
		return this;
	}
	public SedeSalud getIdSedesalud() {
		return idSedesalud;
	}
	public Campania setIdSedesalud(SedeSalud idSedesalud) {
		this.idSedesalud = idSedesalud;
		return this;
	}
	public Integer getSrlIdCampania() {
		return srlIdCampania;
	}
	public Campania setSrlIdCampania(Integer srlIdCampania) {
		this.srlIdCampania = srlIdCampania;
		return this;
	}
	public String getStrDescripcion() {
		return strDescripcion;
	}
	public Campania setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
		return this;
	}
	public String getStrUbicacion() {
		return strUbicacion;
	}
	public Campania setStrUbicacion(String strUbicacion) {
		this.strUbicacion = strUbicacion;
		return this;
	}
	public Integer getIntZool() {
		return intZool;
	}
	public Campania setIntZool(Integer intZool) {
		this.intZool = intZool;
		return this;
	}
	public String getStrImagen() {
		return strImagen;
	}
	public Campania setStrImagen(String strImagen) {
		this.strImagen = strImagen;
		return this;
	}
	
	}
