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

import pe.edu.upc.quyawar.core.model.entity.Perfil;
import pe.edu.upc.quyawar.core.service.PerfilService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Perfil
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class PerfilRestController {
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(value = "/perfil/", method = RequestMethod.GET)
	public ResponseEntity<List<Perfil>> listAllPerfils() throws Exception {
		List<Perfil> perfils = perfilService.buscar(new Perfil(), null);
		if (perfils.isEmpty()) {
			return new ResponseEntity<List<Perfil>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Perfil>>(perfils, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil> getPerfil(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Perfil with id " + id);
		Perfil perfil = perfilService.buscarById(new Perfil(id));
		if (perfil == null) {
			System.out.println("Perfil with id " + id + " not found");
			return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/perfil/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPerfil(@RequestBody Perfil perfil, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Perfil " + perfil.getStrNombre());
		if (perfilService.buscarById(perfil) != null) {
			//System.out.println("A Perfil with name " + perfil.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		perfilService.guardar(perfil);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/perfil/{id}").buildAndExpand(perfil.getSrlIdPerfil()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Perfil> updatePerfil(@PathVariable("id") Integer id, @RequestBody Perfil perfil) throws Exception {
		System.out.println("Updating Perfil " + id);

		Perfil currentPerfil = perfilService.buscarById(new Perfil(id));

		if (currentPerfil == null) {
			System.out.println("Perfil with id " + id + " not found");
			return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
		}

		perfilService.guardar(perfil);
		return new ResponseEntity<Perfil>(currentPerfil, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Perfil> deletePerfil(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Perfil with id " + id);

		Perfil perfil = perfilService.buscarById(new Perfil(id));
		if (perfil == null) {
			System.out.println("Unable to delete. Perfil with id " + id + " not found");
			return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
		}

		perfilService.eliminar(new Perfil(id));
		return new ResponseEntity<Perfil>(HttpStatus.NO_CONTENT);
	}
	
}