package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.SedeSalud;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface SedeSaludDao {
	
	public List<SedeSalud> buscar(SedeSalud sedeSalud, PaginacionDto paginacionDto) throws Exception;
	public SedeSalud buscarById(SedeSalud sedeSalud) throws Exception;
	public void guardar(SedeSalud sedeSalud) throws Exception;
	public void eliminar(SedeSalud sedeSalud) throws Exception;
		
}
