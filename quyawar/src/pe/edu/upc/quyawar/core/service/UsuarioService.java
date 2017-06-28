package pe.edu.upc.quyawar.core.service;

import java.util.List;
import pe.edu.upc.quyawar.core.model.entity.Usuario;
import pe.edu.upc.quyawar.common.PaginacionDto;


public interface UsuarioService {
	
	public List<Usuario> buscar(Usuario usuario, PaginacionDto paginacionDto) throws Exception;
	public Usuario buscarById(Usuario usuario) throws Exception;
	public void guardar(Usuario usuario) throws Exception;
	public void eliminar(Usuario usuario) throws Exception;
		
}
