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

import pe.edu.upc.quyawar.core.model.entity.Campania;
import pe.edu.upc.quyawar.core.service.CampaniaService;

/**
 * Clase Controller que da soporte para las solicitudes de manteniento de Campania
 * 
 * @author Jober Mena
 * 
 */

@RestController
public class CampaniaRestController {
	
	@Autowired
	private CampaniaService campaniaService;
	
	@RequestMapping(value = "/campania/", method = RequestMethod.GET)
	public ResponseEntity<List<Campania>> listAllCampanias() throws Exception {
		List<Campania> campanias = campaniaService.buscar(new Campania(), null);
		if (campanias.isEmpty()) {
			return new ResponseEntity<List<Campania>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Campania>>(campanias, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/campania/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campania> getCampania(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching Campania with id " + id);
		Campania campania = campaniaService.buscarById(new Campania(id));
		if (campania == null) {
			System.out.println("Campania with id " + id + " not found");
			return new ResponseEntity<Campania>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Campania>(campania, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/campania/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCampania(@RequestBody Campania campania, UriComponentsBuilder ucBuilder) throws Exception {
		///System.out.println("Creating Campania " + campania.getStrNombre());
		if (campaniaService.buscarById(campania) != null) {
			//System.out.println("A Campania with name " + campania.getStrNombre() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		campaniaService.guardar(campania);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(ucBuilder.path("/campania/{id}").buildAndExpand(campania.getSrlIdCampania()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/campania/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Campania> updateCampania(@PathVariable("id") Integer id, @RequestBody Campania campania) throws Exception {
		System.out.println("Updating Campania " + id);

		Campania currentCampania = campaniaService.buscarById(new Campania(id));

		if (currentCampania == null) {
			System.out.println("Campania with id " + id + " not found");
			return new ResponseEntity<Campania>(HttpStatus.NOT_FOUND);
		}

		campaniaService.guardar(campania);
		return new ResponseEntity<Campania>(currentCampania, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/campania/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Campania> deleteCampania(@PathVariable("id") Integer id) throws Exception {
		System.out.println("Fetching & Deleting Campania with id " + id);

		Campania campania = campaniaService.buscarById(new Campania(id));
		if (campania == null) {
			System.out.println("Unable to delete. Campania with id " + id + " not found");
			return new ResponseEntity<Campania>(HttpStatus.NOT_FOUND);
		}

		campaniaService.eliminar(new Campania(id));
		return new ResponseEntity<Campania>(HttpStatus.NO_CONTENT);
	}
	
}