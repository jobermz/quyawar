package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.Donante;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface DonanteDao {
	
	public List<Donante> buscar(Donante donante, PaginacionDto paginacionDto) throws Exception;
	public Donante buscarById(Donante donante) throws Exception;
	public void guardar(Donante donante) throws Exception;
	public void eliminar(Donante donante) throws Exception;
		
}
