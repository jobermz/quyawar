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
import pe.edu.upc.quyawar.core.model.entity.Perfil;
import pe.edu.upc.quyawar.core.dao.PerfilDao;

@Repository
public class PerfilDaoImpl implements PerfilDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Perfil> buscar(Perfil perfil, PaginacionDto paginacionDto) throws Exception {
		List<Perfil> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Perfil ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(perfil.getSrlIdPerfil()) != null) {
				sbHql.append("AND srlIdPerfil = :srlIdPerfil ");
			}
			if(CadenaUtil.getStrNull(perfil.getStrPerfil()) != null) {
				sbHql.append("AND strPerfil like :strPerfil ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(perfil.getSrlIdPerfil()) != null) {
				query.setParameter("srlIdPerfil", perfil.getSrlIdPerfil());
			}
			if(CadenaUtil.getStrNull(perfil.getStrPerfil()) != null) {
				query.setParameter("strPerfil", perfil.getStrPerfil());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Perfil>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Perfil buscarById(Perfil perfil) throws Exception {
		Perfil entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Perfil.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdPerfil", perfil.getSrlIdPerfil()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Perfil)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Perfil perfil) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(perfil);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Perfil perfil) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(perfil);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
