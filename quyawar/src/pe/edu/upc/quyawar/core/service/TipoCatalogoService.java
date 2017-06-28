package pe.edu.upc.quyawar.core.service;

import java.util.List;
import pe.edu.upc.quyawar.core.model.entity.TipoCatalogo;
import pe.edu.upc.quyawar.common.PaginacionDto;


public interface TipoCatalogoService {
	
	public List<TipoCatalogo> buscar(TipoCatalogo tipoCatalogo, PaginacionDto paginacionDto) throws Exception;
	public TipoCatalogo buscarById(TipoCatalogo tipoCatalogo) throws Exception;
	public void guardar(TipoCatalogo tipoCatalogo) throws Exception;
	public void eliminar(TipoCatalogo tipoCatalogo) throws Exception;
		
}
