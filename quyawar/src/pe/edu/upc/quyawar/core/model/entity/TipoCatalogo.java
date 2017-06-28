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
@Table(name = "t_tipo_catalogo", schema="quyawar")
public class TipoCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_tipo_catalogo_int_id_catalogo_seq")
	@SequenceGenerator(name="t_tipo_catalogo_int_id_catalogo_seq", sequenceName="quyawar.t_tipo_catalogo_int_id_catalogo_seq")
	@Column(name = "int_id_catalogo")
	private Integer srlIdCatalogo;
	
	@Column(name = "var_descripcion")
	private String strDescripcion;
	
	public TipoCatalogo() {}
	
	public TipoCatalogo(int srlIdCatalogo) {
		this.srlIdCatalogo		= srlIdCatalogo;
	}
	
	public TipoCatalogo(int srlIdCatalogo, String strDescripcion) {
		this.srlIdCatalogo		= srlIdCatalogo;
		this.strDescripcion		= strDescripcion;
	}
	
	public Integer getSrlIdCatalogo() {
		return srlIdCatalogo;
	}
	public TipoCatalogo setSrlIdCatalogo(Integer srlIdCatalogo) {
		this.srlIdCatalogo = srlIdCatalogo;
		return this;
	}
	public String getStrDescripcion() {
		return strDescripcion;
	}
	public TipoCatalogo setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
		return this;
	}
	
	}
