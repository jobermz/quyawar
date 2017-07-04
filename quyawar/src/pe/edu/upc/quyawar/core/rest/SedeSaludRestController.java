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

import pe.edu.upc.quyawar.core.model.entity.SedeSalud;
import pe.edu.upc.quyawar.core.service.SedeSaludService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Sede Salud
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class SedeSaludRestController {
	
	@Autowired
	private SedeSaludService sedeSaludService;
	
	@RequestMapping(value = "/sedeSalud/", method = RequestMethod.GET)
	public ResponseEntity<List<SedeSalud>> listAllSedeSaluds() throws Exception {
		List<SedeSalud> sedeSaluds = sedeSaludService.buscar(new SedeSalud(), null);
		if (sedeSaluds.isEmpty()) {
			return new ResponseEntity<List<SedeSalud>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SedeSalud>>(sedeSaluds, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sedeSalud/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SedeSalud> getSedeSalud(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching SedeSalud with id " + id);
		SedeSalud sedeSalud = sedeSaludService.buscarById(new SedeSalud(id));
		if (sedeSalud == null) {
			System.out.println("SedeSalud with id " + id + " not found");
			return new ResponseEntity<SedeSalud>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SedeSalud>(sedeSalud, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sedeSalud/", method = RequestMethod.POST)
	public ResponseEntity<Void> createSedeSalud(@RequestBody SedeSalud sedeSalud, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating SedeSalud " + sedeSalud.getStrNombre());
		if (sedeSaludService.buscarById(sedeSalud) != null) {
			//System.out.println("A SedeSalud with name " + sedeSalud.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		sedeSaludService.guardar(sedeSalud);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/sedeSalud/{id}").buildAndExpand(sedeSalud.getSrlIdSedesalud()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/sedeSalud/{id}", method = RequestMethod.PUT)
	public ResponseEntity<SedeSalud> updateSedeSalud(@PathVariable("id") Integer id, @RequestBody SedeSalud sedeSalud) throws Exception {
		System.out.println("Updating SedeSalud " + id);

		SedeSalud currentSedeSalud = sedeSaludService.buscarById(new SedeSalud(id));

		if (currentSedeSalud == null) {
			System.out.println("SedeSalud with id " + id + " not found");
			return new ResponseEntity<SedeSalud>(HttpStatus.NOT_FOUND);
		}

		sedeSaludService.guardar(sedeSalud);
		return new ResponseEntity<SedeSalud>(currentSedeSalud, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sedeSalud/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<SedeSalud> deleteSedeSalud(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting SedeSalud with id " + id);

		SedeSalud sedeSalud = sedeSaludService.buscarById(new SedeSalud(id));
		if (sedeSalud == null) {
			System.out.println("Unable to delete. SedeSalud with id " + id + " not found");
			return new ResponseEntity<SedeSalud>(HttpStatus.NOT_FOUND);
		}

		sedeSaludService.eliminar(new SedeSalud(id));
		return new ResponseEntity<SedeSalud>(HttpStatus.NO_CONTENT);
	}
	
}