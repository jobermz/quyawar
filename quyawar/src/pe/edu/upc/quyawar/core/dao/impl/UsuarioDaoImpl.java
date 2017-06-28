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
import pe.edu.upc.quyawar.core.model.entity.Usuario;
import pe.edu.upc.quyawar.core.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Usuario> buscar(Usuario usuario, PaginacionDto paginacionDto) throws Exception {
		List<Usuario> list	= null;
		Session session						= null;
		StringBuffer sbHql					= new StringBuffer();
		try {
			session			= this.sessionFactory.getCurrentSession();
			sbHql.append("FROM Usuario ");
			sbHql.append("WHERE 1 = 1");
			
			if(CadenaUtil.getInteNull(usuario.getSrlIdUsuario()) != null) {
				sbHql.append("AND srlIdUsuario = :srlIdUsuario ");
			}
			if(usuario.getIdPerfil() != null) {
				sbHql.append("AND idPerfil = :idPerfil ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrUsuario()) != null) {
				sbHql.append("AND strUsuario like :strUsuario ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrClaveUsuario()) != null) {
				sbHql.append("AND strClaveUsuario like :strClaveUsuario ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrNombreResponsable()) != null) {
				sbHql.append("AND strNombreResponsable like :strNombreResponsable ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrAppaterno()) != null) {
				sbHql.append("AND strAppaterno like :strAppaterno ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrApmaterno()) != null) {
				sbHql.append("AND strApmaterno like :strApmaterno ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrTelefono()) != null) {
				sbHql.append("AND strTelefono like :strTelefono ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrCorreo()) != null) {
				sbHql.append("AND strCorreo like :strCorreo ");
			}
			if(CadenaUtil.getStrNull(usuario.getStrCelular()) != null) {
				sbHql.append("AND strCelular like :strCelular ");
			}
			if(usuario.getIdSedesalud() != null) {
				sbHql.append("AND idSedesalud = :idSedesalud ");
			}
						Query query		= session.createQuery(sbHql.toString());
			if(CadenaUtil.getInteNull(usuario.getSrlIdUsuario()) != null) {
				query.setParameter("srlIdUsuario", usuario.getSrlIdUsuario());
			}
			if(usuario.getIdPerfil() != null) {
				query.setParameter("idPerfil", usuario.getIdPerfil());
			}
			if(CadenaUtil.getStrNull(usuario.getStrUsuario()) != null) {
				query.setParameter("strUsuario", usuario.getStrUsuario());
			}
			if(CadenaUtil.getStrNull(usuario.getStrClaveUsuario()) != null) {
				query.setParameter("strClaveUsuario", usuario.getStrClaveUsuario());
			}
			if(CadenaUtil.getStrNull(usuario.getStrNombreResponsable()) != null) {
				query.setParameter("strNombreResponsable", usuario.getStrNombreResponsable());
			}
			if(CadenaUtil.getStrNull(usuario.getStrAppaterno()) != null) {
				query.setParameter("strAppaterno", usuario.getStrAppaterno());
			}
			if(CadenaUtil.getStrNull(usuario.getStrApmaterno()) != null) {
				query.setParameter("strApmaterno", usuario.getStrApmaterno());
			}
			if(CadenaUtil.getStrNull(usuario.getStrTelefono()) != null) {
				query.setParameter("strTelefono", usuario.getStrTelefono());
			}
			if(CadenaUtil.getStrNull(usuario.getStrCorreo()) != null) {
				query.setParameter("strCorreo", usuario.getStrCorreo());
			}
			if(CadenaUtil.getStrNull(usuario.getStrCelular()) != null) {
				query.setParameter("strCelular", usuario.getStrCelular());
			}
			if(usuario.getIdSedesalud() != null) {
				query.setParameter("idSedesalud", usuario.getIdSedesalud());
			}
			if (!query.list().isEmpty()) {
				list	= query.list();
			} else {
				list	= new ArrayList<Usuario>();
			}
		} catch (Exception ex) {
			throw ex;
		}
		return list;
	}
	
	public Usuario buscarById(Usuario usuario) throws Exception {
		Usuario entity	= null;
		Session session		= null;
		try {
			session				= this.sessionFactory.getCurrentSession();
			Criteria criteria	= session.createCriteria(Usuario.class);
			Criterion criterion	= Restrictions.conjunction()
						.add(Restrictions.eq("srlIdUsuario", usuario.getSrlIdUsuario()));
			List query		= criteria.add(criterion).list();
			if (!query.isEmpty()) {
				entity		= (Usuario)query.get(0);
			} else {
				entity		= null;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return entity;
	}
	
	@Transactional
	public void guardar(Usuario usuario) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(usuario);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Usuario usuario) throws Exception {
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.delete(usuario);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
