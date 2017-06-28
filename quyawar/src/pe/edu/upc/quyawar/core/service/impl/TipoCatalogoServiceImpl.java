package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.TipoCatalogo;
import pe.edu.upc.quyawar.core.dao.TipoCatalogoDao;
import pe.edu.upc.quyawar.core.service.TipoCatalogoService;

@Service
@EnableTransactionManagement
@Transactional
public class TipoCatalogoServiceImpl implements TipoCatalogoService {
	
	@Autowired
	private TipoCatalogoDao tipoCatalogoDao;
	
	public List<TipoCatalogo> buscar(TipoCatalogo tipoCatalogo, PaginacionDto paginacionDto) throws Exception {
		try {
			return tipoCatalogoDao.buscar(tipoCatalogo, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public TipoCatalogo buscarById(TipoCatalogo tipoCatalogo) throws Exception {
		try {
			return tipoCatalogoDao.buscarById(tipoCatalogo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(TipoCatalogo tipoCatalogo) throws Exception {
		try {
			tipoCatalogoDao.guardar(tipoCatalogo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(TipoCatalogo tipoCatalogo) throws Exception {
		try {
			tipoCatalogoDao.eliminar(tipoCatalogo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
