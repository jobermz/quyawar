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
import pe.edu.upc.quyawar.core.model.entity.Ubigeo;
import pe.edu.upc.quyawar.core.dao.UbigeoDao;

@Repository
public class UbigeoDaoImpl implements UbigeoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Ubigeo> buscar(Ubigeo ubigeo, PaginacionDto paginacionDto) throws Exception {
		List<Ubigeo> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Ubigeo ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(ubigeo.getSrlIdUbigeo()) != null) {
				sbHql.append("AND srlIdUbigeo = :srlIdUbigeo ");
			}
			if(CadenaUtil.getInteNull(ubigeo.getIntIdDepartamento()) != null) {
				sbHql.append("AND intIdDepartamento = :intIdDepartamento ");
			}
			if(CadenaUtil.getInteNull(ubigeo.getIntIdProvincia()) != null) {
				sbHql.append("AND intIdProvincia = :intIdProvincia ");
			}
			if(CadenaUtil.getInteNull(ubigeo.getIntIdDistrito()) != null) {
				sbHql.append("AND intIdDistrito = :intIdDistrito ");
			}
			if(CadenaUtil.getStrNull(ubigeo.getStrUbigeo()) != null) {
				if(ubigeo.getStrUbigeo().indexOf("-") == 0) {
					sbHql.append("AND strUbigeo <> :strUbigeo ");
				} else {
					sbHql.append("AND strUbigeo like :strUbigeo ");
				}
			}
			
			Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(ubigeo.getSrlIdUbigeo()) != null) {
				query.setParameter("srlIdUbigeo", ubigeo.getSrlIdUbigeo());
			}
			if(CadenaUtil.getInteNull(ubigeo.getIntIdDepartamento()) != null) {
				query.setParameter("intIdDepartamento", ubigeo.getIntIdDepartamento());
			}
			if(CadenaUtil.getInteNull(ubigeo.getIntIdProvincia()) != null) {
				query.setParameter("intIdProvincia", ubigeo.getIntIdProvincia());
			}
			if(CadenaUtil.getInteNull(ubigeo.getIntIdDistrito()) != null) {
				query.setParameter("intIdDistrito", ubigeo.getIntIdDistrito());
			}
			if(CadenaUtil.getStrNull(ubigeo.getStrUbigeo()) != null) {
				if(ubigeo.getStrUbigeo().indexOf("-") == 0) {
					query.setParameter("strUbigeo", ubigeo.getStrUbigeo().substring(1));
				} else {
					query.setParameter("strUbigeo", ubigeo.getStrUbigeo());
				}
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Ubigeo>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Ubigeo buscarById(Ubigeo ubigeo) throws Exception {
		Ubigeo entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Ubigeo.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdUbigeo", ubigeo.getSrlIdUbigeo()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Ubigeo)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Ubigeo ubigeo) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(ubigeo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Ubigeo ubigeo) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(ubigeo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
