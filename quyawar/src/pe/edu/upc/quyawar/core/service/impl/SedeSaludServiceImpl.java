package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.SedeSalud;
import pe.edu.upc.quyawar.core.dao.SedeSaludDao;
import pe.edu.upc.quyawar.core.service.SedeSaludService;

@Service
@EnableTransactionManagement
@Transactional
public class SedeSaludServiceImpl implements SedeSaludService {
	
	@Autowired
	private SedeSaludDao sedeSaludDao;
	
	public List<SedeSalud> buscar(SedeSalud sedeSalud, PaginacionDto paginacionDto) throws Exception {
		try {
			return sedeSaludDao.buscar(sedeSalud, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public SedeSalud buscarById(SedeSalud sedeSalud) throws Exception {
		try {
			return sedeSaludDao.buscarById(sedeSalud);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(SedeSalud sedeSalud) throws Exception {
		try {
			sedeSaludDao.guardar(sedeSalud);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(SedeSalud sedeSalud) throws Exception {
		try {
			sedeSaludDao.eliminar(sedeSalud);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
