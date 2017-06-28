package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.Ubigeo;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface UbigeoDao {
	
	public List<Ubigeo> buscar(Ubigeo ubigeo, PaginacionDto paginacionDto) throws Exception;
	public Ubigeo buscarById(Ubigeo ubigeo) throws Exception;
	public void guardar(Ubigeo ubigeo) throws Exception;
	public void eliminar(Ubigeo ubigeo) throws Exception;
		
}
