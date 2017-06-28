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
import pe.edu.upc.quyawar.core.model.entity.SedeSalud;
import pe.edu.upc.quyawar.core.dao.SedeSaludDao;

@Repository
public class SedeSaludDaoImpl implements SedeSaludDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<SedeSalud> buscar(SedeSalud sedeSalud, PaginacionDto paginacionDto) throws Exception {
		List<SedeSalud> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM SedeSalud ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(sedeSalud.getSrlIdSedesalud()) != null) {
				sbHql.append("AND srlIdSedesalud = :srlIdSedesalud ");
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrNombre()) != null) {
				sbHql.append("AND strNombre like :strNombre ");
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrDireccion()) != null) {
				sbHql.append("AND strDireccion like :strDireccion ");
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrTelefono()) != null) {
				sbHql.append("AND strTelefono like :strTelefono ");
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrCelular()) != null) {
				sbHql.append("AND strCelular like :strCelular ");
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrUbicacion()) != null) {
				sbHql.append("AND strUbicacion like :strUbicacion ");
			}
			if(CadenaUtil.getInteNull(sedeSalud.getIntZoom()) != null) {
				sbHql.append("AND intZoom = :intZoom ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(sedeSalud.getSrlIdSedesalud()) != null) {
				query.setParameter("srlIdSedesalud", sedeSalud.getSrlIdSedesalud());
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrNombre()) != null) {
				query.setParameter("strNombre", sedeSalud.getStrNombre());
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrDireccion()) != null) {
				query.setParameter("strDireccion", sedeSalud.getStrDireccion());
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrTelefono()) != null) {
				query.setParameter("strTelefono", sedeSalud.getStrTelefono());
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrCelular()) != null) {
				query.setParameter("strCelular", sedeSalud.getStrCelular());
			}
			if(CadenaUtil.getStrNull(sedeSalud.getStrUbicacion()) != null) {
				query.setParameter("strUbicacion", sedeSalud.getStrUbicacion());
			}
			if(CadenaUtil.getInteNull(sedeSalud.getIntZoom()) != null) {
				query.setParameter("intZoom", sedeSalud.getIntZoom());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<SedeSalud>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public SedeSalud buscarById(SedeSalud sedeSalud) throws Exception {
		SedeSalud entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(SedeSalud.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdSedesalud", sedeSalud.getSrlIdSedesalud()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (SedeSalud)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(SedeSalud sedeSalud) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(sedeSalud);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(SedeSalud sedeSalud) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(sedeSalud);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
