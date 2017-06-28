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

	

@Entity
@Table(name = "t_sede_salud", schema="quyawar")
public class SedeSalud implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_sede_salud_srl_id_sedesalud_seq")
	@SequenceGenerator(name="t_sede_salud_srl_id_sedesalud_seq", sequenceName="quyawar.t_sede_salud_srl_id_sedesalud_seq")
	@Column(name = "srl_id_sedesalud")
	private Integer srlIdSedesalud;
	
	@Column(name = "var_nombre")
	private String strNombre;
	
	@Column(name = "var_direccion")
	private String strDireccion;
	
	@Column(name = "var_telefono")
	private String strTelefono;
	
	@Column(name = "var_celular")
	private String strCelular;
	
	@Column(name = "var_ubicacion")
	private String strUbicacion;
	
	@Column(name = "int_zoom")
	private Integer intZoom;
	
	public SedeSalud() {}
	
	public SedeSalud(int srlIdSedesalud) {
		this.srlIdSedesalud		= srlIdSedesalud;
	}
	
	public SedeSalud(int srlIdSedesalud, String strNombre, String strDireccion, String strTelefono, String strCelular, String strUbicacion, int intZoom) {
		this.srlIdSedesalud		= srlIdSedesalud;
		this.strNombre		= strNombre;
		this.strDireccion		= strDireccion;
		this.strTelefono		= strTelefono;
		this.strCelular		= strCelular;
		this.strUbicacion		= strUbicacion;
		this.intZoom		= intZoom;
	}
	
	public Integer getSrlIdSedesalud() {
		return srlIdSedesalud;
	}
	public SedeSalud setSrlIdSedesalud(Integer srlIdSedesalud) {
		this.srlIdSedesalud = srlIdSedesalud;
		return this;
	}
	public String getStrNombre() {
		return strNombre;
	}
	public SedeSalud setStrNombre(String strNombre) {
		this.strNombre = strNombre;
		return this;
	}
	public String getStrDireccion() {
		return strDireccion;
	}
	public SedeSalud setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
		return this;
	}
	public String getStrTelefono() {
		return strTelefono;
	}
	public SedeSalud setStrTelefono(String strTelefono) {
		this.strTelefono = strTelefono;
		return this;
	}
	public String getStrCelular() {
		return strCelular;
	}
	public SedeSalud setStrCelular(String strCelular) {
		this.strCelular = strCelular;
		return this;
	}
	public String getStrUbicacion() {
		return strUbicacion;
	}
	public SedeSalud setStrUbicacion(String strUbicacion) {
		this.strUbicacion = strUbicacion;
		return this;
	}
	public Integer getIntZoom() {
		return intZoom;
	}
	public SedeSalud setIntZoom(Integer intZoom) {
		this.intZoom = intZoom;
		return this;
	}
	
	}
