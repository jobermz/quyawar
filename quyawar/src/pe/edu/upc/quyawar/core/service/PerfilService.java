package pe.edu.upc.quyawar.core.service;

import java.util.List;
import pe.edu.upc.quyawar.core.model.entity.Perfil;
import pe.edu.upc.quyawar.common.PaginacionDto;


public interface PerfilService {
	
	public List<Perfil> buscar(Perfil perfil, PaginacionDto paginacionDto) throws Exception;
	public Perfil buscarById(Perfil perfil) throws Exception;
	public void guardar(Perfil perfil) throws Exception;
	public void eliminar(Perfil perfil) throws Exception;
		
}
