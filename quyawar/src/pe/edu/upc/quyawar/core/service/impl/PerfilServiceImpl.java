package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.Perfil;
import pe.edu.upc.quyawar.core.dao.PerfilDao;
import pe.edu.upc.quyawar.core.service.PerfilService;

@Service
@EnableTransactionManagement
@Transactional
public class PerfilServiceImpl implements PerfilService {
	
	@Autowired
	private PerfilDao perfilDao;
	
	public List<Perfil> buscar(Perfil perfil, PaginacionDto paginacionDto) throws Exception {
		try {
			return perfilDao.buscar(perfil, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Perfil buscarById(Perfil perfil) throws Exception {
		try {
			return perfilDao.buscarById(perfil);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Perfil perfil) throws Exception {
		try {
			perfilDao.guardar(perfil);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Perfil perfil) throws Exception {
		try {
			perfilDao.eliminar(perfil);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
