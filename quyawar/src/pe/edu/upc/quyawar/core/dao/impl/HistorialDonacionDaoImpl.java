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
import pe.edu.upc.quyawar.core.model.entity.HistorialDonacion;
import pe.edu.upc.quyawar.core.dao.HistorialDonacionDao;

@Repository
public class HistorialDonacionDaoImpl implements HistorialDonacionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<HistorialDonacion> buscar(HistorialDonacion historialDonacion, PaginacionDto paginacionDto) throws Exception {
		List<HistorialDonacion> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM HistorialDonacion ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(historialDonacion.getSrlIdHistorialdonacion()) != null) {
				sbHql.append("AND srlIdHistorialdonacion = :srlIdHistorialdonacion ");
			}
			if(historialDonacion.getIdDonante() != null) {
				sbHql.append("AND idDonante = :idDonante ");
			}
			if(CadenaUtil.getInteNull(historialDonacion.getIntUnidades()) != null) {
				sbHql.append("AND intUnidades = :intUnidades ");
			}
			if(historialDonacion.getDteFechaDonacion() != null) {
				sbHql.append("AND dteFechaDonacion = :dteFechaDonacion ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(historialDonacion.getSrlIdHistorialdonacion()) != null) {
				query.setParameter("srlIdHistorialdonacion", historialDonacion.getSrlIdHistorialdonacion());
			}
			if(historialDonacion.getIdDonante() != null) {
				query.setParameter("idDonante", historialDonacion.getIdDonante());
			}
			if(CadenaUtil.getInteNull(historialDonacion.getIntUnidades()) != null) {
				query.setParameter("intUnidades", historialDonacion.getIntUnidades());
			}
			if(historialDonacion.getDteFechaDonacion() != null) {
				query.setParameter("dteFechaDonacion", historialDonacion.getDteFechaDonacion());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<HistorialDonacion>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public HistorialDonacion buscarById(HistorialDonacion historialDonacion) throws Exception {
		HistorialDonacion entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(HistorialDonacion.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdHistorialdonacion", historialDonacion.getSrlIdHistorialdonacion()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (HistorialDonacion)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(HistorialDonacion historialDonacion) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(historialDonacion);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(HistorialDonacion historialDonacion) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(historialDonacion);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
