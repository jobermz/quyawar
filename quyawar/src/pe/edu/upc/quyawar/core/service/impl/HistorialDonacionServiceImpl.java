package pe.edu.upc.quyawar.core.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.quyawar.common.PaginacionDto;
import pe.edu.upc.quyawar.common.CadenaUtil;
import pe.edu.upc.quyawar.core.model.entity.HistorialDonacion;
import pe.edu.upc.quyawar.core.dao.HistorialDonacionDao;
import pe.edu.upc.quyawar.core.service.HistorialDonacionService;

@Service
@EnableTransactionManagement
@Transactional
public class HistorialDonacionServiceImpl implements HistorialDonacionService {
	
	@Autowired
	private HistorialDonacionDao historialDonacionDao;
	
	public List<HistorialDonacion> buscar(HistorialDonacion historialDonacion, PaginacionDto paginacionDto) throws Exception {
		try {
			return historialDonacionDao.buscar(historialDonacion, paginacionDto);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public HistorialDonacion buscarById(HistorialDonacion historialDonacion) throws Exception {
		try {
			return historialDonacionDao.buscarById(historialDonacion);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void guardar(HistorialDonacion historialDonacion) throws Exception {
		try {
			historialDonacionDao.guardar(historialDonacion);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	@Transactional
	public void eliminar(HistorialDonacion historialDonacion) throws Exception {
		try {
			historialDonacionDao.eliminar(historialDonacion);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
