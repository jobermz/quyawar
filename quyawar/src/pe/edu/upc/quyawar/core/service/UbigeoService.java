package pe.edu.upc.quyawar.core.service;

import java.util.List;
import pe.edu.upc.quyawar.core.model.entity.Ubigeo;
import pe.edu.upc.quyawar.common.PaginacionDto;


public interface UbigeoService {
	
	public List<Ubigeo> buscar(Ubigeo ubigeo, PaginacionDto paginacionDto) throws Exception;
	public Ubigeo buscarById(Ubigeo ubigeo) throws Exception;
	public void guardar(Ubigeo ubigeo) throws Exception;
	public void eliminar(Ubigeo ubigeo) throws Exception;
		
}
