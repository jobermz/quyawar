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

import pe.edu.upc.quyawar.core.model.entity.Usuario;
import pe.edu.upc.quyawar.core.model.entity.Catalogo;
import pe.edu.upc.quyawar.core.model.entity.Catalogo;
import pe.edu.upc.quyawar.core.model.entity.Ubigeo;
	

@Entity
@Table(name = "t_donante", schema="quyawar")
public class Donante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_donante_srl_id_donante_seq")
	@SequenceGenerator(name="t_donante_srl_id_donante_seq", sequenceName="quyawar.t_donante_srl_id_donante_seq")
	@Column(name = "srl_id_donante")
	private Integer srlIdDonante;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "srl_id_usuario")
	private Usuario idUsuario;
	
	@Column(name = "var_num_dni")
	private String strNumDni;
	
	@Column(name = "var_nombre")
	private String strNombre;
	
	@Column(name = "var_appaterno")
	private String strAppaterno;
	
	@Column(name = "var_apmaterno")
	private String strApmaterno;
	
	@Column(name = "dte_fecha_nacimiento")
	private Date dteFechaNacimiento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_estadocivil")
	private Catalogo idEstadocivil;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_sexo")
	private Catalogo idSexo;
	
	@Column(name = "var_celular")
	private String strCelular;
	
	@Column(name = "var_celular2")
	private String strCelular2;
	
	@Column(name = "var_telefono")
	private String strTelefono;
	
	@Column(name = "var_correo")
	private String strCorreo;
	
	@Column(name = "var_direccion")
	private String strDireccion;
	
	@Column(name = "ind_tipo")
	private Integer intIndTipo;
	
	@Column(name = "int_zoom")
	private Integer intZoom;
	
	@Column(name = "int_ubicacion")
	private String strUbicacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_ubigeo")
	private Ubigeo idUbigeo;
	
	public Donante() {}
	
	public Donante(int srlIdDonante) {
		this.srlIdDonante		= srlIdDonante;
	}
	
	public Donante(int srlIdDonante, Usuario idUsuario, String strNumDni, String strNombre, String strAppaterno, String strApmaterno, Date dteFechaNacimiento, Catalogo idEstadocivil, Catalogo idSexo, String strCelular, String strCelular2, String strTelefono, String strCorreo, String strDireccion, int intIndTipo, int intZoom, String strUbicacion, Ubigeo idUbigeo) {
		this.srlIdDonante		= srlIdDonante;
		this.idUsuario		= idUsuario;
		this.strNumDni		= strNumDni;
		this.strNombre		= strNombre;
		this.strAppaterno		= strAppaterno;
		this.strApmaterno		= strApmaterno;
		this.dteFechaNacimiento		= dteFechaNacimiento;
		this.idEstadocivil		= idEstadocivil;
		this.idSexo		= idSexo;
		this.strCelular		= strCelular;
		this.strCelular2		= strCelular2;
		this.strTelefono		= strTelefono;
		this.strCorreo		= strCorreo;
		this.strDireccion		= strDireccion;
		this.intIndTipo		= intIndTipo;
		this.intZoom		= intZoom;
		this.strUbicacion		= strUbicacion;
		this.idUbigeo		= idUbigeo;
	}
	
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public Donante setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}
	public String getDteFechaNacimientoFecha() {
		return CadenaUtil.getStrDate(dteFechaNacimiento);
	}
	public Donante setDteFechaNacimientoFecha(String dteFechaNacimiento) {
		this.dteFechaNacimiento = CadenaUtil.getDateFromStr(dteFechaNacimiento);
		return this;
	}
	public Catalogo getIdEstadocivil() {
		return idEstadocivil;
	}
	public Donante setIdEstadocivil(Catalogo idEstadocivil) {
		this.idEstadocivil = idEstadocivil;
		return this;
	}
	public Catalogo getIdSexo() {
		return idSexo;
	}
	public Donante setIdSexo(Catalogo idSexo) {
		this.idSexo = idSexo;
		return this;
	}
	public Ubigeo getIdUbigeo() {
		return idUbigeo;
	}
	public Donante setIdUbigeo(Ubigeo idUbigeo) {
		this.idUbigeo = idUbigeo;
		return this;
	}
	public Integer getSrlIdDonante() {
		return srlIdDonante;
	}
	public Donante setSrlIdDonante(Integer srlIdDonante) {
		this.srlIdDonante = srlIdDonante;
		return this;
	}
	public String getStrNumDni() {
		return strNumDni;
	}
	public Donante setStrNumDni(String strNumDni) {
		this.strNumDni = strNumDni;
		return this;
	}
	public String getStrNombre() {
		return strNombre;
	}
	public Donante setStrNombre(String strNombre) {
		this.strNombre = strNombre;
		return this;
	}
	public String getStrAppaterno() {
		return strAppaterno;
	}
	public Donante setStrAppaterno(String strAppaterno) {
		this.strAppaterno = strAppaterno;
		return this;
	}
	public String getStrApmaterno() {
		return strApmaterno;
	}
	public Donante setStrApmaterno(String strApmaterno) {
		this.strApmaterno = strApmaterno;
		return this;
	}
	public Date getDteFechaNacimiento() {
		return dteFechaNacimiento;
	}
	public Donante setDteFechaNacimiento(Date dteFechaNacimiento) {
		this.dteFechaNacimiento = dteFechaNacimiento;
		return this;
	}
	public String getStrCelular() {
		return strCelular;
	}
	public Donante setStrCelular(String strCelular) {
		this.strCelular = strCelular;
		return this;
	}
	public String getStrCelular2() {
		return strCelular2;
	}
	public Donante setStrCelular2(String strCelular2) {
		this.strCelular2 = strCelular2;
		return this;
	}
	public String getStrTelefono() {
		return strTelefono;
	}
	public Donante setStrTelefono(String strTelefono) {
		this.strTelefono = strTelefono;
		return this;
	}
	public String getStrCorreo() {
		return strCorreo;
	}
	public Donante setStrCorreo(String strCorreo) {
		this.strCorreo = strCorreo;
		return this;
	}
	public String getStrDireccion() {
		return strDireccion;
	}
	public Donante setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
		return this;
	}
	public Integer getIntIndTipo() {
		return intIndTipo;
	}
	public Donante setIntIndTipo(Integer intIndTipo) {
		this.intIndTipo = intIndTipo;
		return this;
	}
	public Integer getIntZoom() {
		return intZoom;
	}
	public Donante setIntZoom(Integer intZoom) {
		this.intZoom = intZoom;
		return this;
	}
	public String getStrUbicacion() {
		return strUbicacion;
	}
	public Donante setStrUbicacion(String strUbicacion) {
		this.strUbicacion = strUbicacion;
		return this;
	}
	
	}
