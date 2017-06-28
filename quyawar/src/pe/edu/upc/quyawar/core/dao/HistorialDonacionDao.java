package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.HistorialDonacion;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface HistorialDonacionDao {
	
	public List<HistorialDonacion> buscar(HistorialDonacion historialDonacion, PaginacionDto paginacionDto) throws Exception;
	public HistorialDonacion buscarById(HistorialDonacion historialDonacion) throws Exception;
	public void guardar(HistorialDonacion historialDonacion) throws Exception;
	public void eliminar(HistorialDonacion historialDonacion) throws Exception;
		
}
