package pe.edu.upc.quyawar.core.service;

import java.util.List;
import pe.edu.upc.quyawar.core.model.entity.SedeSalud;
import pe.edu.upc.quyawar.common.PaginacionDto;


public interface SedeSaludService {
	
	public List<SedeSalud> buscar(SedeSalud sedeSalud, PaginacionDto paginacionDto) throws Exception;
	public SedeSalud buscarById(SedeSalud sedeSalud) throws Exception;
	public void guardar(SedeSalud sedeSalud) throws Exception;
	public void eliminar(SedeSalud sedeSalud) throws Exception;
		
}
