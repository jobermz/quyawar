package pe.edu.upc.quyawar.core.service;

import java.util.List;
import pe.edu.upc.quyawar.core.model.entity.Donante;
import pe.edu.upc.quyawar.common.PaginacionDto;


public interface DonanteService {
	
	public List<Donante> buscar(Donante donante, PaginacionDto paginacionDto) throws Exception;
	public Donante buscarById(Donante donante) throws Exception;
	public void guardar(Donante donante) throws Exception;
	public void eliminar(Donante donante) throws Exception;
		
}
