package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.Catalogo;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface CatalogoDao {
	
	public List<Catalogo> buscar(Catalogo catalogo, PaginacionDto paginacionDto) throws Exception;
	public Catalogo buscarById(Catalogo catalogo) throws Exception;
	public void guardar(Catalogo catalogo) throws Exception;
	public void eliminar(Catalogo catalogo) throws Exception;
		
}
