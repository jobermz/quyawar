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

import pe.edu.upc.quyawar.core.model.entity.TipoCatalogo;

@Entity
@Table(name = "t_catalogo", schema="quyawar")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_catalogo_int_id_catalogo_seq")
	@SequenceGenerator(name="t_catalogo_int_id_catalogo_seq", sequenceName="quyawar.t_catalogo_int_id_catalogo_seq")
	@Column(name = "id_catalogo")
	private Integer srlIdCatalogo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_catalogo")
	private TipoCatalogo idTipoCatalogo;
	
	@Column(name = "descripcion")
	private String strDescripcion;
	
	@Column(name = "abreviatura")
	private String strAbreviatura;
	
	@Column(name = "valor")
	private Integer intValor;
	
	public Catalogo() {}
	
	public Catalogo(int srlIdCatalogo) {
		this.srlIdCatalogo		= srlIdCatalogo;
	}
	
	public Catalogo(int srlIdCatalogo, TipoCatalogo idTipoCatalogo, String strDescripcion, String strAbreviatura, int intValor) {
		this.srlIdCatalogo		= srlIdCatalogo;
		this.idTipoCatalogo		= idTipoCatalogo;
		this.strDescripcion		= strDescripcion;
		this.strAbreviatura		= strAbreviatura;
		this.intValor		= intValor;
	}
	
	public TipoCatalogo getIdTipoCatalogo() {
		return idTipoCatalogo;
	}
	public Catalogo setIdTipoCatalogo(TipoCatalogo idTipoCatalogo) {
		this.idTipoCatalogo = idTipoCatalogo;
		return this;
	}
	public Integer getSrlIdCatalogo() {
		return srlIdCatalogo;
	}
	public Catalogo setSrlIdCatalogo(Integer srlIdCatalogo) {
		this.srlIdCatalogo = srlIdCatalogo;
		return this;
	}
	public String getStrDescripcion() {
		return strDescripcion;
	}
	public Catalogo setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
		return this;
	}
	public String getStrAbreviatura() {
		return strAbreviatura;
	}
	public Catalogo setStrAbreviatura(String strAbreviatura) {
		this.strAbreviatura = strAbreviatura;
		return this;
	}
	public Integer getIntValor() {
		return intValor;
	}
	public Catalogo setIntValor(Integer intValor) {
		this.intValor = intValor;
		return this;
	}
	
	}
