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

import pe.edu.upc.quyawar.core.model.entity.Donante;
	

@Entity
@Table(name = "t_historial_donacion", schema="quyawar")
public class HistorialDonacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="t_historial_donacion_srl_id_historialdonacion_seq")
	@SequenceGenerator(name="t_historial_donacion_srl_id_historialdonacion_seq", sequenceName="quyawar.t_historial_donacion_srl_id_historialdonacion_seq")
	@Column(name = "srl_id_historialdonacion")
	private Integer srlIdHistorialdonacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_donante")
	private Donante idDonante;
	
	@Column(name = "int_unidades")
	private Integer intUnidades;
	
	@Column(name = "dte_fecha_donacion")
	private Date dteFechaDonacion;
	
	public HistorialDonacion() {}
	
	public HistorialDonacion(int srlIdHistorialdonacion) {
		this.srlIdHistorialdonacion		= srlIdHistorialdonacion;
	}
	
	public HistorialDonacion(int srlIdHistorialdonacion, Donante idDonante, int intUnidades, Date dteFechaDonacion) {
		this.srlIdHistorialdonacion		= srlIdHistorialdonacion;
		this.idDonante		= idDonante;
		this.intUnidades		= intUnidades;
		this.dteFechaDonacion		= dteFechaDonacion;
	}
	
	public Donante getIdDonante() {
		return idDonante;
	}
	public HistorialDonacion setIdDonante(Donante idDonante) {
		this.idDonante = idDonante;
		return this;
	}
	public String getDteFechaDonacionFecha() {
		return CadenaUtil.getStrDate(dteFechaDonacion);
	}
	public HistorialDonacion setDteFechaDonacionFecha(String dteFechaDonacion) {
		this.dteFechaDonacion = CadenaUtil.getDateFromStr(dteFechaDonacion);
		return this;
	}
	public Integer getSrlIdHistorialdonacion() {
		return srlIdHistorialdonacion;
	}
	public HistorialDonacion setSrlIdHistorialdonacion(Integer srlIdHistorialdonacion) {
		this.srlIdHistorialdonacion = srlIdHistorialdonacion;
		return this;
	}
	public Integer getIntUnidades() {
		return intUnidades;
	}
	public HistorialDonacion setIntUnidades(Integer intUnidades) {
		this.intUnidades = intUnidades;
		return this;
	}
	public Date getDteFechaDonacion() {
		return dteFechaDonacion;
	}
	public HistorialDonacion setDteFechaDonacion(Date dteFechaDonacion) {
		this.dteFechaDonacion = dteFechaDonacion;
		return this;
	}
	
	}
