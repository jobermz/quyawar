package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.Usuario;
import pe.edu.upc.quyawar.core.dao.UsuarioDao;
import pe.edu.upc.quyawar.core.service.UsuarioService;

@Service
@EnableTransactionManagement
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	public List<Usuario> buscar(Usuario usuario, PaginacionDto paginacionDto) throws Exception {
		try {
			return usuarioDao.buscar(usuario, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Usuario buscarById(Usuario usuario) throws Exception {
		try {
			return usuarioDao.buscarById(usuario);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Usuario usuario) throws Exception {
		try {
			usuarioDao.guardar(usuario);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Usuario usuario) throws Exception {
		try {
			usuarioDao.eliminar(usuario);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
