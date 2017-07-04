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

import pe.edu.upc.quyawar.core.model.entity.Donante;
import pe.edu.upc.quyawar.core.service.DonanteService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Donante
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class DonanteRestController {
	
	@Autowired
	private DonanteService donanteService;
	
	@RequestMapping(value = "/donante/", method = RequestMethod.GET)
	public ResponseEntity<List<Donante>> listAllDonantes() throws Exception {
		List<Donante> donantes = donanteService.buscar(new Donante(), null);
		if (donantes.isEmpty()) {
			return new ResponseEntity<List<Donante>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Donante>>(donantes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/donante/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Donante> getDonante(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Donante with id " + id);
		Donante donante = donanteService.buscarById(new Donante(id));
		if (donante == null) {
			System.out.println("Donante with id " + id + " not found");
			return new ResponseEntity<Donante>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Donante>(donante, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/donante/", method = RequestMethod.POST)
	public ResponseEntity<Void> createDonante(@RequestBody Donante donante, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Donante " + donante.getStrNombre());
		if (donanteService.buscarById(donante) != null) {
			//System.out.println("A Donante with name " + donante.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		donanteService.guardar(donante);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/donante/{id}").buildAndExpand(donante.getSrlIdDonante()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/donante/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Donante> updateDonante(@PathVariable("id") Integer id, @RequestBody Donante donante) throws Exception {
		System.out.println("Updating Donante " + id);

		Donante currentDonante = donanteService.buscarById(new Donante(id));

		if (currentDonante == null) {
			System.out.println("Donante with id " + id + " not found");
			return new ResponseEntity<Donante>(HttpStatus.NOT_FOUND);
		}

		donanteService.guardar(donante);
		return new ResponseEntity<Donante>(currentDonante, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/donante/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Donante> deleteDonante(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Donante with id " + id);

		Donante donante = donanteService.buscarById(new Donante(id));
		if (donante == null) {
			System.out.println("Unable to delete. Donante with id " + id + " not found");
			return new ResponseEntity<Donante>(HttpStatus.NOT_FOUND);
		}

		donanteService.eliminar(new Donante(id));
		return new ResponseEntity<Donante>(HttpStatus.NO_CONTENT);
	}
	
}