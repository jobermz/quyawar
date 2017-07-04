package pe.edu.upc.quyawar.core.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pe.edu.upc.quyawar.core.model.entity.Usuario;
import pe.edu.upc.quyawar.core.service.UsuarioService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Usuario
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/usuario/", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listAllUsuarios() throws Exception {
		List<Usuario> usuarios = usuarioService.buscar(new Usuario(), null);
		if (usuarios.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Usuario with id " + id);
		Usuario usuario = usuarioService.buscarById(new Usuario(id));
		if (usuario == null) {
			System.out.println("Usuario with id " + id + " not found");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUsuario(@RequestBody Usuario usuario, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Usuario " + usuario.getStrNombre());
		if (usuarioService.buscarById(usuario) != null) {
			//System.out.println("A Usuario with name " + usuario.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		usuarioService.guardar(usuario);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(usuario.getSrlIdUsuario()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) throws Exception {
		System.out.println("Updating Usuario " + id);

		Usuario currentUsuario = usuarioService.buscarById(new Usuario(id));

		if (currentUsuario == null) {
			System.out.println("Usuario with id " + id + " not found");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}

		usuarioService.guardar(usuario);
		return new ResponseEntity<Usuario>(currentUsuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Usuario with id " + id);

		Usuario usuario = usuarioService.buscarById(new Usuario(id));
		if (usuario == null) {
			System.out.println("Unable to delete. Usuario with id " + id + " not found");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}

		usuarioService.eliminar(new Usuario(id));
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}
	
}