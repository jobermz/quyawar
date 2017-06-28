package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.Catalogo;
import pe.edu.upc.quyawar.core.dao.CatalogoDao;
import pe.edu.upc.quyawar.core.service.CatalogoService;

@Service
@EnableTransactionManagement
@Transactional
public class CatalogoServiceImpl implements CatalogoService {
	
	@Autowired
	private CatalogoDao catalogoDao;
	
	public List<Catalogo> buscar(Catalogo catalogo, PaginacionDto paginacionDto) throws Exception {
		try {
			return catalogoDao.buscar(catalogo, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Catalogo buscarById(Catalogo catalogo) throws Exception {
		try {
			return catalogoDao.buscarById(catalogo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Catalogo catalogo) throws Exception {
		try {
			catalogoDao.guardar(catalogo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Catalogo catalogo) throws Exception {
		try {
			catalogoDao.eliminar(catalogo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
