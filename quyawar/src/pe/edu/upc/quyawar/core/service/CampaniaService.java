package pe.edu.upc.quyawar.core.service;

import java.util.List;
import pe.edu.upc.quyawar.core.model.entity.Campania;
import pe.edu.upc.quyawar.common.PaginacionDto;


public interface CampaniaService {
	
	public List<Campania> buscar(Campania campania, PaginacionDto paginacionDto) throws Exception;
	public Campania buscarById(Campania campania) throws Exception;
	public void guardar(Campania campania) throws Exception;
	public void eliminar(Campania campania) throws Exception;
		
}
