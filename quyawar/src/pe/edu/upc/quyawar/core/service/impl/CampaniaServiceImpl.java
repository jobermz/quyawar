package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.Campania;
import pe.edu.upc.quyawar.core.dao.CampaniaDao;
import pe.edu.upc.quyawar.core.service.CampaniaService;

@Service
@EnableTransactionManagement
@Transactional
public class CampaniaServiceImpl implements CampaniaService {
	
	@Autowired
	private CampaniaDao campaniaDao;
	
	public List<Campania> buscar(Campania campania, PaginacionDto paginacionDto) throws Exception {
		try {
			return campaniaDao.buscar(campania, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public Campania buscarById(Campania campania) throws Exception {
		try {
			return campaniaDao.buscarById(campania);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(Campania campania) throws Exception {
		try {
			campaniaDao.guardar(campania);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(Campania campania) throws Exception {
		try {
			campaniaDao.eliminar(campania);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
