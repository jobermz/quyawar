package pe.edu.upc.quyawar.core.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upc.quyawar.core.model.entity.Usuario;
import pe.edu.upc.quyawar.common.PaginacionDto;

@Service
public interface UsuarioDao {
	
	public List<Usuario> buscar(Usuario usuario, PaginacionDto paginacionDto) throws Exception;
	public Usuario buscarById(Usuario usuario) throws Exception;
	public void guardar(Usuario usuario) throws Exception;
	public void eliminar(Usuario usuario) throws Exception;
		
}
