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

import pe.edu.upc.quyawar.core.model.entity.Perfil;
import pe.edu.upc.quyawar.core.model.entity.SedeSalud;

@Entity
@Table(name = "t_usuario", schema="quyawar")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_usuario_id_usuario_seq")
	@SequenceGenerator(name="t_usuario_id_usuario_seq", sequenceName="quyawar.t_usuario_id_usuario_seq")
	@Column(name = "id_usuario")
	private Integer srlIdUsuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil")
	private Perfil idPerfil;
	
	@Column(name = "usuario")
	private String strUsuario;
	
	@Column(name = "clave_usuario")
	private String strClaveUsuario;
	
	@Column(name = "nombre_responsable")
	private String strNombreResponsable;
	
	@Column(name = "appaterno")
	private String strAppaterno;
	
	@Column(name = "apmaterno")
	private String strApmaterno;
	
	@Column(name = "telefono")
	private String strTelefono;
	
	@Column(name = "correo")
	private String strCorreo;
	
	@Column(name = "celular")
	private String strCelular;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sedesalud")
	private SedeSalud idSedesalud;
	
	public Usuario() {}
	
	public Usuario(int srlIdUsuario) {
		this.srlIdUsuario		= srlIdUsuario;
	}
	
	public Usuario(int srlIdUsuario, Perfil idPerfil, String strUsuario, String strClaveUsuario, String strNombreResponsable, String strAppaterno, String strApmaterno, String strTelefono, String strCorreo, String strCelular, SedeSalud idSedesalud) {
		this.srlIdUsuario		= srlIdUsuario;
		this.idPerfil		= idPerfil;
		this.strUsuario		= strUsuario;
		this.strClaveUsuario		= strClaveUsuario;
		this.strNombreResponsable		= strNombreResponsable;
		this.strAppaterno		= strAppaterno;
		this.strApmaterno		= strApmaterno;
		this.strTelefono		= strTelefono;
		this.strCorreo		= strCorreo;
		this.strCelular		= strCelular;
		this.idSedesalud		= idSedesalud;
	}
	
	public Perfil getIdPerfil() {
		return idPerfil;
	}
	public Usuario setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
		return this;
	}
	public SedeSalud getIdSedesalud() {
		return idSedesalud;
	}
	public Usuario setIdSedesalud(SedeSalud idSedesalud) {
		this.idSedesalud = idSedesalud;
		return this;
	}
	public Integer getSrlIdUsuario() {
		return srlIdUsuario;
	}
	public Usuario setSrlIdUsuario(Integer srlIdUsuario) {
		this.srlIdUsuario = srlIdUsuario;
		return this;
	}
	public String getStrUsuario() {
		return strUsuario;
	}
	public Usuario setStrUsuario(String strUsuario) {
		this.strUsuario = strUsuario;
		return this;
	}
	public String getStrClaveUsuario() {
		return strClaveUsuario;
	}
	public Usuario setStrClaveUsuario(String strClaveUsuario) {
		this.strClaveUsuario = strClaveUsuario;
		return this;
	}
	public String getStrNombreResponsable() {
		return strNombreResponsable;
	}
	public Usuario setStrNombreResponsable(String strNombreResponsable) {
		this.strNombreResponsable = strNombreResponsable;
		return this;
	}
	public String getStrAppaterno() {
		return strAppaterno;
	}
	public Usuario setStrAppaterno(String strAppaterno) {
		this.strAppaterno = strAppaterno;
		return this;
	}
	public String getStrApmaterno() {
		return strApmaterno;
	}
	public Usuario setStrApmaterno(String strApmaterno) {
		this.strApmaterno = strApmaterno;
		return this;
	}
	public String getStrTelefono() {
		return strTelefono;
	}
	public Usuario setStrTelefono(String strTelefono) {
		this.strTelefono = strTelefono;
		return this;
	}
	public String getStrCorreo() {
		return strCorreo;
	}
	public Usuario setStrCorreo(String strCorreo) {
		this.strCorreo = strCorreo;
		return this;
	}
	public String getStrCelular() {
		return strCelular;
	}
	public Usuario setStrCelular(String strCelular) {
		this.strCelular = strCelular;
		return this;
	}
	
	}
