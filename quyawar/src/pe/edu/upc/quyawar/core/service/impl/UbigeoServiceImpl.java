package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.Ubigeo;
import pe.edu.upc.quyawar.core.dao.UbigeoDao;
import pe.edu.upc.quyawar.core.service.UbigeoService;

@Service
@EnableTransactionManagement
@Transactional
public class UbigeoServiceImpl implements UbigeoService {
	
	@Autowired
	private UbigeoDao ubigeoDao;
	
	public List<Ubigeo> buscar(Ubigeo ubigeo, PaginacionDto paginacionDto) throws Exception {
		try {
			return ubigeoDao.buscar(ubigeo, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Ubigeo buscarById(Ubigeo ubigeo) throws Exception {
		try {
			return ubigeoDao.buscarById(ubigeo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Ubigeo ubigeo) throws Exception {
		try {
			ubigeoDao.guardar(ubigeo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Ubigeo ubigeo) throws Exception {
		try {
			ubigeoDao.eliminar(ubigeo);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
