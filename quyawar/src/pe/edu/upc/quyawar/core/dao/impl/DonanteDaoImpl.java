package pe.edu.upc.quyawar.core.dao.impl;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.Donante;
import pe.edu.upc.quyawar.core.dao.DonanteDao;

@Repository
public class DonanteDaoImpl implements DonanteDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Donante> buscar(Donante donante, PaginacionDto paginacionDto) throws Exception {
		List<Donante> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Donante ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(donante.getSrlIdDonante()) != null) {
				sbHql.append("AND srlIdDonante = :srlIdDonante ");
			}
			if(donante.getIdUsuario() != null) {
				sbHql.append("AND idUsuario = :idUsuario ");
			}
			if(CadenaUtil.getStrNull(donante.getStrNumDni()) != null) {
				sbHql.append("AND strNumDni like :strNumDni ");
			}
			if(CadenaUtil.getStrNull(donante.getStrNombre()) != null) {
				sbHql.append("AND strNombre like :strNombre ");
			}
			if(CadenaUtil.getStrNull(donante.getStrAppaterno()) != null) {
				sbHql.append("AND strAppaterno like :strAppaterno ");
			}
			if(CadenaUtil.getStrNull(donante.getStrApmaterno()) != null) {
				sbHql.append("AND strApmaterno like :strApmaterno ");
			}
			if(donante.getDteFechaNacimiento() != null) {
				sbHql.append("AND dteFechaNacimiento = :dteFechaNacimiento ");
			}
			if(donante.getIdEstadocivil() != null) {
				sbHql.append("AND idEstadocivil = :idEstadocivil ");
			}
			if(donante.getIdSexo() != null) {
				sbHql.append("AND idSexo = :idSexo ");
			}
			if(CadenaUtil.getStrNull(donante.getStrCelular()) != null) {
				sbHql.append("AND strCelular like :strCelular ");
			}
			if(CadenaUtil.getStrNull(donante.getStrCelular2()) != null) {
				sbHql.append("AND strCelular2 like :strCelular2 ");
			}
			if(CadenaUtil.getStrNull(donante.getStrTelefono()) != null) {
				sbHql.append("AND strTelefono like :strTelefono ");
			}
			if(CadenaUtil.getStrNull(donante.getStrCorreo()) != null) {
				sbHql.append("AND strCorreo like :strCorreo ");
			}
			if(CadenaUtil.getStrNull(donante.getStrDireccion()) != null) {
				sbHql.append("AND strDireccion like :strDireccion ");
			}
			if(CadenaUtil.getInteNull(donante.getIntIndTipo()) != null) {
				sbHql.append("AND intIndTipo = :intIndTipo ");
			}
			if(CadenaUtil.getInteNull(donante.getIntZoom()) != null) {
				sbHql.append("AND intZoom = :intZoom ");
			}
			if(CadenaUtil.getStrNull(donante.getStrUbicacion()) != null) {
				sbHql.append("AND strUbicacion like :strUbicacion ");
			}
			if(donante.getIdUbigeo() != null) {
				sbHql.append("AND idUbigeo = :idUbigeo ");
			}
			if(CadenaUtil.getStrNull(donante.getStrClaveUsuario()) != null) {
				sbHql.append("AND strClaveUsuario like :strClaveUsuario ");
			}
			
			Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(donante.getSrlIdDonante()) != null) {
				query.setParameter("srlIdDonante", donante.getSrlIdDonante());
			}
			if(donante.getIdUsuario() != null) {
				query.setParameter("idUsuario", donante.getIdUsuario());
			}
			if(CadenaUtil.getStrNull(donante.getStrNumDni()) != null) {
				query.setParameter("strNumDni", donante.getStrNumDni());
			}
			if(CadenaUtil.getStrNull(donante.getStrNombre()) != null) {
				query.setParameter("strNombre", donante.getStrNombre());
			}
			if(CadenaUtil.getStrNull(donante.getStrAppaterno()) != null) {
				query.setParameter("strAppaterno", donante.getStrAppaterno());
			}
			if(CadenaUtil.getStrNull(donante.getStrApmaterno()) != null) {
				query.setParameter("strApmaterno", donante.getStrApmaterno());
			}
			if(donante.getDteFechaNacimiento() != null) {
				query.setParameter("dteFechaNacimiento", donante.getDteFechaNacimiento());
			}
			if(donante.getIdEstadocivil() != null) {
				query.setParameter("idEstadocivil", donante.getIdEstadocivil());
			}
			if(donante.getIdSexo() != null) {
				query.setParameter("idSexo", donante.getIdSexo());
			}
			if(CadenaUtil.getStrNull(donante.getStrCelular()) != null) {
				query.setParameter("strCelular", donante.getStrCelular());
			}
			if(CadenaUtil.getStrNull(donante.getStrCelular2()) != null) {
				query.setParameter("strCelular2", donante.getStrCelular2());
			}
			if(CadenaUtil.getStrNull(donante.getStrTelefono()) != null) {
				query.setParameter("strTelefono", donante.getStrTelefono());
			}
			if(CadenaUtil.getStrNull(donante.getStrCorreo()) != null) {
				query.setParameter("strCorreo", donante.getStrCorreo());
			}
			if(CadenaUtil.getStrNull(donante.getStrDireccion()) != null) {
				query.setParameter("strDireccion", donante.getStrDireccion());
			}
			if(CadenaUtil.getInteNull(donante.getIntIndTipo()) != null) {
				query.setParameter("intIndTipo", donante.getIntIndTipo());
			}
			if(CadenaUtil.getInteNull(donante.getIntZoom()) != null) {
				query.setParameter("intZoom", donante.getIntZoom());
			}
			if(CadenaUtil.getStrNull(donante.getStrUbicacion()) != null) {
				query.setParameter("strUbicacion", donante.getStrUbicacion());
			}
			if(donante.getIdUbigeo() != null) {
				query.setParameter("idUbigeo", donante.getIdUbigeo());
			}
			if(CadenaUtil.getStrNull(donante.getStrClaveUsuario()) != null) {
				query.setParameter("strClaveUsuario", donante.getStrClaveUsuario());
			}
			
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Donante>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Donante buscarById(Donante donante) throws Exception {
		Donante entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Donante.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdDonante", donante.getSrlIdDonante()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Donante)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Donante donante) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(donante);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Donante donante) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(donante);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
