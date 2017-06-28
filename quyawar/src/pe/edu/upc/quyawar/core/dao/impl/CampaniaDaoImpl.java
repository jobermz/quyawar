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
import pe.edu.upc.quyawar.core.model.entity.Campania;
import pe.edu.upc.quyawar.core.dao.CampaniaDao;

@Repository
public class CampaniaDaoImpl implements CampaniaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Campania> buscar(Campania campania, PaginacionDto paginacionDto) throws Exception {
		List<Campania> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Campania ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(campania.getSrlIdCampania()) != null) {
				sbHql.append("AND srlIdCampania = :srlIdCampania ");
			}
			if(CadenaUtil.getStrNull(campania.getStrDescripcion()) != null) {
				sbHql.append("AND strDescripcion like :strDescripcion ");
			}
			if(campania.getIdTipoSangre() != null) {
				sbHql.append("AND idTipoSangre = :idTipoSangre ");
			}
			if(CadenaUtil.getStrNull(campania.getStrUbicacion()) != null) {
				sbHql.append("AND strUbicacion like :strUbicacion ");
			}
			if(CadenaUtil.getInteNull(campania.getIntZool()) != null) {
				sbHql.append("AND intZool = :intZool ");
			}
			if(CadenaUtil.getStrNull(campania.getStrImagen()) != null) {
				sbHql.append("AND strImagen like :strImagen ");
			}
			if(campania.getIdUbigeo() != null) {
				sbHql.append("AND idUbigeo = :idUbigeo ");
			}
			if(campania.getIdSedesalud() != null) {
				sbHql.append("AND idSedesalud = :idSedesalud ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(campania.getSrlIdCampania()) != null) {
				query.setParameter("srlIdCampania", campania.getSrlIdCampania());
			}
			if(CadenaUtil.getStrNull(campania.getStrDescripcion()) != null) {
				query.setParameter("strDescripcion", campania.getStrDescripcion());
			}
			if(campania.getIdTipoSangre() != null) {
				query.setParameter("idTipoSangre", campania.getIdTipoSangre());
			}
			if(CadenaUtil.getStrNull(campania.getStrUbicacion()) != null) {
				query.setParameter("strUbicacion", campania.getStrUbicacion());
			}
			if(CadenaUtil.getInteNull(campania.getIntZool()) != null) {
				query.setParameter("intZool", campania.getIntZool());
			}
			if(CadenaUtil.getStrNull(campania.getStrImagen()) != null) {
				query.setParameter("strImagen", campania.getStrImagen());
			}
			if(campania.getIdUbigeo() != null) {
				query.setParameter("idUbigeo", campania.getIdUbigeo());
			}
			if(campania.getIdSedesalud() != null) {
				query.setParameter("idSedesalud", campania.getIdSedesalud());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Campania>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Campania buscarById(Campania campania) throws Exception {
		Campania entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Campania.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdCampania", campania.getSrlIdCampania()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Campania)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Campania campania) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(campania);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Campania campania) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(campania);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
