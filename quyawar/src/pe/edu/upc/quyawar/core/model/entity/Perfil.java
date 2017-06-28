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
@Table(name = "t_perfil", schema="quyawar")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_perfil_srl_id_perfil_seq")
	@SequenceGenerator(name="t_perfil_srl_id_perfil_seq", sequenceName="quyawar.t_perfil_srl_id_perfil_seq")
	@Column(name = "srl_id_perfil")
	private Integer srlIdPerfil;
	
	@Column(name = "var_perfil")
	private String strPerfil;
	
	public Perfil() {}
	
	public Perfil(int srlIdPerfil) {
		this.srlIdPerfil		= srlIdPerfil;
	}
	
	public Perfil(int srlIdPerfil, String strPerfil) {
		this.srlIdPerfil		= srlIdPerfil;
		this.strPerfil		= strPerfil;
	}
	
	public Integer getSrlIdPerfil() {
		return srlIdPerfil;
	}
	public Perfil setSrlIdPerfil(Integer srlIdPerfil) {
		this.srlIdPerfil = srlIdPerfil;
		return this;
	}
	public String getStrPerfil() {
		return strPerfil;
	}
	public Perfil setStrPerfil(String strPerfil) {
		this.strPerfil = strPerfil;
		return this;
	}
	
	}
