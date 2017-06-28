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
import pe.edu.upc.quyawar.core.model.entity.TipoCatalogo;
import pe.edu.upc.quyawar.core.dao.TipoCatalogoDao;

@Repository
public class TipoCatalogoDaoImpl implements TipoCatalogoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<TipoCatalogo> buscar(TipoCatalogo tipoCatalogo, PaginacionDto paginacionDto) throws Exception {
		List<TipoCatalogo> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM TipoCatalogo ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(tipoCatalogo.getSrlIdCatalogo()) != null) {
				sbHql.append("AND srlIdCatalogo = :srlIdCatalogo ");
			}
			if(CadenaUtil.getStrNull(tipoCatalogo.getStrDescripcion()) != null) {
				sbHql.append("AND strDescripcion like :strDescripcion ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(tipoCatalogo.getSrlIdCatalogo()) != null) {
				query.setParameter("srlIdCatalogo", tipoCatalogo.getSrlIdCatalogo());
			}
			if(CadenaUtil.getStrNull(tipoCatalogo.getStrDescripcion()) != null) {
				query.setParameter("strDescripcion", tipoCatalogo.getStrDescripcion());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<TipoCatalogo>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public TipoCatalogo buscarById(TipoCatalogo tipoCatalogo) throws Exception {
		TipoCatalogo entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(TipoCatalogo.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdCatalogo", tipoCatalogo.getSrlIdCatalogo()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (TipoCatalogo)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(TipoCatalogo tipoCatalogo) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(tipoCatalogo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(TipoCatalogo tipoCatalogo) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(tipoCatalogo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
