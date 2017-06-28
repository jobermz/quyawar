package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.Campania;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface CampaniaDao {
	
	public List<Campania> buscar(Campania campania, PaginacionDto paginacionDto) throws Exception;
	public Campania buscarById(Campania campania) throws Exception;
	public void guardar(Campania campania) throws Exception;
	public void eliminar(Campania campania) throws Exception;
		
}
