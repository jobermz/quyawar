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
import pe.edu.upc.quyawar.core.model.entity.Catalogo;
import pe.edu.upc.quyawar.core.dao.CatalogoDao;

@Repository
public class CatalogoDaoImpl implements CatalogoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Catalogo> buscar(Catalogo catalogo, PaginacionDto paginacionDto) throws Exception {
		List<Catalogo> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Catalogo ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(catalogo.getSrlIdCatalogo()) != null) {
				sbHql.append("AND srlIdCatalogo = :srlIdCatalogo ");
			}
			if(catalogo.getIdTipoCatalogo() != null) {
				sbHql.append("AND idTipoCatalogo = :idTipoCatalogo ");
			}
			if(CadenaUtil.getStrNull(catalogo.getStrDescripcion()) != null) {
				sbHql.append("AND strDescripcion like :strDescripcion ");
			}
			if(CadenaUtil.getStrNull(catalogo.getStrAbreviatura()) != null) {
				sbHql.append("AND strAbreviatura like :strAbreviatura ");
			}
			if(CadenaUtil.getInteNull(catalogo.getIntValor()) != null) {
				sbHql.append("AND intValor = :intValor ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(catalogo.getSrlIdCatalogo()) != null) {
				query.setParameter("srlIdCatalogo", catalogo.getSrlIdCatalogo());
			}
			if(catalogo.getIdTipoCatalogo() != null) {
				query.setParameter("idTipoCatalogo", catalogo.getIdTipoCatalogo());
			}
			if(CadenaUtil.getStrNull(catalogo.getStrDescripcion()) != null) {
				query.setParameter("strDescripcion", catalogo.getStrDescripcion());
			}
			if(CadenaUtil.getStrNull(catalogo.getStrAbreviatura()) != null) {
				query.setParameter("strAbreviatura", catalogo.getStrAbreviatura());
			}
			if(CadenaUtil.getInteNull(catalogo.getIntValor()) != null) {
				query.setParameter("intValor", catalogo.getIntValor());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Catalogo>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Catalogo buscarById(Catalogo catalogo) throws Exception {
		Catalogo entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Catalogo.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdCatalogo", catalogo.getSrlIdCatalogo()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Catalogo)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Catalogo catalogo) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(catalogo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Catalogo catalogo) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(catalogo);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
