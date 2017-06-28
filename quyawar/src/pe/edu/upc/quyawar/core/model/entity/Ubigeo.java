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
@Table(name = "t_ubigeo", schema="quyawar")
public class Ubigeo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_ubigeo_int_id_ubigeo_seq")
	@SequenceGenerator(name="t_ubigeo_int_id_ubigeo_seq", sequenceName="quyawar.t_ubigeo_int_id_ubigeo_seq")
	@Column(name = "int_id_ubigeo")
	private Integer srlIdUbigeo;
	
	@Column(name = "int_id_departamento")
	private Integer intIdDepartamento;
	
	@Column(name = "int_id_provincia")
	private Integer intIdProvincia;
	
	@Column(name = "int_id_distrito")
	private Integer intIdDistrito;
	
	@Column(name = "var_ubigeo")
	private String strUbigeo;
	
	public Ubigeo() {}
	
	public Ubigeo(int srlIdUbigeo) {
		this.srlIdUbigeo		= srlIdUbigeo;
	}
	
	public Ubigeo(int srlIdUbigeo, int intIdDepartamento, int intIdProvincia, int intIdDistrito, String strUbigeo) {
		this.srlIdUbigeo		= srlIdUbigeo;
		this.intIdDepartamento		= intIdDepartamento;
		this.intIdProvincia		= intIdProvincia;
		this.intIdDistrito		= intIdDistrito;
		this.strUbigeo		= strUbigeo;
	}
	
	public Integer getSrlIdUbigeo() {
		return srlIdUbigeo;
	}
	public Ubigeo setSrlIdUbigeo(Integer srlIdUbigeo) {
		this.srlIdUbigeo = srlIdUbigeo;
		return this;
	}
	public Integer getIntIdDepartamento() {
		return intIdDepartamento;
	}
	public Ubigeo setIntIdDepartamento(Integer intIdDepartamento) {
		this.intIdDepartamento = intIdDepartamento;
		return this;
	}
	public Integer getIntIdProvincia() {
		return intIdProvincia;
	}
	public Ubigeo setIntIdProvincia(Integer intIdProvincia) {
		this.intIdProvincia = intIdProvincia;
		return this;
	}
	public Integer getIntIdDistrito() {
		return intIdDistrito;
	}
	public Ubigeo setIntIdDistrito(Integer intIdDistrito) {
		this.intIdDistrito = intIdDistrito;
		return this;
	}
	public String getStrUbigeo() {
		return strUbigeo;
	}
	public Ubigeo setStrUbigeo(String strUbigeo) {
		this.strUbigeo = strUbigeo;
		return this;
	}
	
	}
