package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.TipoCatalogo;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface TipoCatalogoDao {
	
	public List<TipoCatalogo> buscar(TipoCatalogo tipoCatalogo, PaginacionDto paginacionDto) throws Exception;
	public TipoCatalogo buscarById(TipoCatalogo tipoCatalogo) throws Exception;
	public void guardar(TipoCatalogo tipoCatalogo) throws Exception;
	public void eliminar(TipoCatalogo tipoCatalogo) throws Exception;
		
}
