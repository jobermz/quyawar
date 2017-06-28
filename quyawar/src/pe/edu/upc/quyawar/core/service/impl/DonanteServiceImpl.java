package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.Donante;
import pe.edu.upc.quyawar.core.dao.DonanteDao;
import pe.edu.upc.quyawar.core.service.DonanteService;

@Service
@EnableTransactionManagement
@Transactional
public class DonanteServiceImpl implements DonanteService {
	
	@Autowired
	private DonanteDao donanteDao;
	
	public List<Donante> buscar(Donante donante, PaginacionDto paginacionDto) throws Exception {
		try {
			return donanteDao.buscar(donante, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Donante buscarById(Donante donante) throws Exception {
		try {
			return donanteDao.buscarById(donante);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Donante donante) throws Exception {
		try {
			donanteDao.guardar(donante);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Donante donante) throws Exception {
		try {
			donanteDao.eliminar(donante);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
